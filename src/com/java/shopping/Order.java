package com.java.shopping;

public class Order {
    private Customer customer;
    private ShoppingCard shoppingCard;
    private Payment payment;

    public Order(Customer customer, ShoppingCard shoppingCard, Payment payment) {
        this.customer = customer;
        this.shoppingCard = shoppingCard;
        this.payment = payment;
    }

    public ShoppingCard getShoppingCard() {
        return this.shoppingCard;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", shoppingCard=" + shoppingCard +
                ", payment=" + payment +
                '}';
    }
}
