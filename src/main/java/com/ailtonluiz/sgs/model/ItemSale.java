package com.ailtonluiz.sgs.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item_sale")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemSale {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private Integer quantity;

    private BigDecimal unityValue;

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_product_item_sale"))
    private Product product;

    @ManyToOne
    @JoinColumn(name = "sale_id", foreignKey = @ForeignKey(name = "fk_sale_item_sale"))
    private Sale sale;


}
