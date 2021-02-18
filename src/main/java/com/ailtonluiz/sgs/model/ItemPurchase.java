package com.ailtonluiz.sgs.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item_purchase")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemPurchase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private Integer quantity;

    private BigDecimal unityValue;

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_product_item_purchase"))
    private Product product;

    @ManyToOne
    @JoinColumn(name = "purchase_id", foreignKey = @ForeignKey(name = "fk_purchase_item_purchase"))
    private Purchase purchase;


}
