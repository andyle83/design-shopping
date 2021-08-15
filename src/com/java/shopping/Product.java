package com.java.shopping;

public class Product {
    private final String name;
    private int price;
    private int discount;
    private int weight;
    private ProductType producType;

    public Product(String name, int price, ProductType productType, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.producType = productType;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getPrice() {
        int shippingCost = producType.getShippingCost(weight);
        int priceWithDiscount = (int) (price * (100 - discount) / 100.0);
        return priceWithDiscount + shippingCost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
