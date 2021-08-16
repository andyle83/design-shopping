package com.java.shopping.product;

import com.java.shopping.Catalogue;
import com.java.shopping.product.Product;

public class PhysicalProduct extends Product {
    private int weight;

    public PhysicalProduct(String productName, int price, int weight) {
        super(productName, price);
        this.weight = weight;
    }

    @Override
    public int calculateShippingCost() {
        return weight * Catalogue.SHIPPING_RATE;
    }
}
