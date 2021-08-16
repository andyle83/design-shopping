package com.java.shopping.customer;

import com.java.shopping.customer.Customer;

public class NonProfitCustomer extends Customer {

    private final int NON_PROFIT_DISCOUNT = 15;

    public NonProfitCustomer(String name) {
        super(name);
    }

    @Override
    public int calculateDiscount() {
        return NON_PROFIT_DISCOUNT;
    }
}
