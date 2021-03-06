SGE.TabelaItensCompra = (function() {

	function TabelaItensCompra(autocomplete) {
		this.autocomplete = autocomplete;
		this.tabelaProdutosContainer = $('.js-tabela-produtos-container');
		this.uuid = $('#uuid').val();
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	}

	TabelaItensCompra.prototype.iniciar = function() {
		this.autocomplete.on('item-selecionado', onItemSelecionado.bind(this));

		bindQuantidade.call(this);
		bindTabelaItem.call(this);
	}

	TabelaItensCompra.prototype.valorTotal = function() {
		return this.tabelaProdutosContainer.data('valor');
		
	}
	
	function onItemSelecionado(evento, item) {
		var resposta = $.ajax({
			url : 'itemCompra',
			method : 'POST',
			data : {
				codigoProduto : item.codigo,
				uuid : this.uuid
			}
		});

		resposta.done(onItemAtualizadoNoServidor.bind(this));
	}

	function onItemAtualizadoNoServidor(html) {
		this.tabelaProdutosContainer.html(html);

		bindQuantidade.call(this);

		var tabelaItemCompra = bindTabelaItem.call(this);
		this.emitter.trigger('tabela-itens-atualizada', tabelaItemCompra.data('valor-total'));

	}

	function onQuantidadeItemAlterado(evento) {
		var input = $(evento.target);
		var quantidade = input.val();

		if (quantidade <= 0) {
			input.val(1);
			quantidade = 1;
		}

		var codigoProduto = input.data('codigo-produto');

		var resposta = $.ajax({
			url : 'itemCompra/' + codigoProduto,
			method : 'PUT',
			data : {
				quantidade : quantidade,
				uuid : this.uuid
			}
		});

		resposta.done(onItemAtualizadoNoServidor.bind(this));
	}

	function onDoubleClick(evento) {
		$(this).toggleClass('solicitando-exclusao');
	}

	function onExclusaoItemClick(evento) {
		var codigoProduto = $(evento.target).data('codigo-produto');
		var resposta = $.ajax({
			url : 'itemCompra/' + this.uuid + '/' + codigoProduto,
			method : 'DELETE'
		});

		resposta.done(onItemAtualizadoNoServidor.bind(this));
	}

	function bindQuantidade() {
		var quantidadeItemInput = $('.js-tabela-produto-quantidade-item');
		quantidadeItemInput.on('change', onQuantidadeItemAlterado.bind(this));
		quantidadeItemInput.maskMoney({
			precision : 0,
			thousands : ''
		});
	}
	function bindTabelaItem() {
		var tabelaItemCompra = $('.js-tabela-item');
		tabelaItemCompra.on('dblclick', onDoubleClick);
		$('.js-exclusao-item-btn').on('click', onExclusaoItemClick.bind(this));
		return tabelaItemCompra;
	}

	return TabelaItensCompra;

}());
