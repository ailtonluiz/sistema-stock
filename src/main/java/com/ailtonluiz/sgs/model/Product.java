package com.ailtonluiz.sgs.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.EAN;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "reference", length = 10)
    private String reference;

    @Column(name = "bar_code")
    @EAN(type = EAN.Type.EAN13)
    private String barCode;


    @Transient
    private ProductGroup productGroup;

    @ManyToOne
    @JoinColumn(name = "brand_id", foreignKey = @ForeignKey(name = "fk_brand_product"))
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "unity_id", foreignKey = @ForeignKey(name = "fk_unity_product"))
    private Unity unity;

    @ManyToOne
    @JoinColumn(name = "product_subgroup_id", foreignKey = @ForeignKey(name = "fk_product_subgroup_product"))
    private ProductSubgroup productSubgroup;



}
