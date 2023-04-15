package com.cars.dto;

import javax.persistence.criteria.CriteriaBuilder;

public enum Role {
    CUSTOMER(1, "Customer"),
    SELLER(2, "Seller");

    private String role;
    private Integer number;
    Role(Integer number, String role){
        this.number = number;
        this.role = role;
    };

    public String getRole(){return role;}
    public Integer getNumber(){return number;}
}
