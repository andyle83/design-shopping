package com.java.shopping.customer;

import com.java.shopping.customer.Customer;

public class BusinessCustomer extends Customer {

    public enum BusinessSize { SMALL, MEDIUM, LARGE }

    private BusinessSize businessSize;

    public BusinessCustomer(String name, BusinessSize businessSize) {
        super(name);
        this.businessSize = businessSize;
    }

    @Override
    public int calculateDiscount() {
        return switch (businessSize) {
            case SMALL -> 5;
            case MEDIUM -> 10;
            case LARGE -> 20;
            default -> throw new AssertionError("Unknown size type " + this);
        };
    }
}
