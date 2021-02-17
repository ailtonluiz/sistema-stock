package com.ailtonluiz.sgs.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "product_subgroup")
public class ProductSubgroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "description", length = 60)
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_group_id", foreignKey = @ForeignKey(name = "fk_product_group_product_subgroup"))
    private ProductGroup productGroup;
}
