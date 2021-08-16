package com.java.shopping.payment;

import java.util.Optional;

public interface PaymentMethod {
    public Optional<Payment> mkPayment(int amount);
}
