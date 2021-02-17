package com.ailtonluiz.sgs.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "stock")
@Getter
@Setter
public class Stock {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    @Column(name = "stock_pending_quantity")
    private Integer stockPendingQuantity;

    @Column(name = "stock_minimum")
    private Integer stockMinimum;

    @Column(name = "box_quantity")
    private Integer boxQuantity;

    @Column(name = "packing_quantity")
    private Double packingQuantity;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Column(name = "cost_price")
    private BigDecimal costPrice;

    @ManyToOne
    @JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "fk_company_stock"))
    private Company company;

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_product_stock"))
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 10)
    private Status status;


}
