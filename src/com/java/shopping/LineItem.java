package com.java.shopping;

public class LineItem {
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
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
