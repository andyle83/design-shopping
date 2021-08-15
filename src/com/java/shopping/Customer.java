package com.java.shopping;

import java.util.Optional;

public class Customer {
    private final String name;
    private CreditCard creditCard;

    public Customer(String name, long ccNumber) {
        this.name = name;
        this.creditCard = new CreditCard(ccNumber);
    }

    public Optional<Order> checkout(ShoppingCard shoppingCard) {
        Optional<Payment> payment = creditCard.mkPayment(shoppingCard.getTotalCost());
        return payment.map(value -> new Order(this, shoppingCard, value));
    }

    public int calculateDiscount() {
        return 0;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", creditCard=" + creditCard +
                '}';
    }
}
