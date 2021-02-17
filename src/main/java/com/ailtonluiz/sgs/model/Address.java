package com.ailtonluiz.sgs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Embeddable
public class Address {

    @Column(name = "street", length = 80)
    private String street;

    @Column(name = "number", length = 10)
    private String number;

    @Column(name = "district", length = 50)
    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Transient
    private State state;

    @Transient
    private Country country;





}
