package com.ailtonluiz.sgs.model;

import lombok.Getter;

public enum Status {

    ACTIVE("Active"),
    INACTIVE("Inactive");

    @Getter
    private String description;

    Status(String description) {
        this.description = description;
    }


}
