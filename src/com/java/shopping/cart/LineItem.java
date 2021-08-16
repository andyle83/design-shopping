package com.java.shopping.cart;

import com.java.shopping.product.Product;

public class LineItem {
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public LineItem(LineItem lineItem) {
        this.product = lineItem.getProduct();
        this.quantity = lineItem.getPrice();
    }

    public Product getProduct() {
        return this.product;
    }

    @Override
    public String toString() {
        return "\n - LineItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    public int getPrice() {
        return product.getPrice() * quantity;
    }
}
