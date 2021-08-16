package com.java.shopping.payment;

import java.util.Optional;
import java.util.UUID;

public class BankAccount implements PaymentMethod {
    public BankAccount(int sortCode, long banksAccountNumber) {
    }

    @Override
    public Optional<Payment> mkPayment(int value) {
        if (Math.random() > 0.3) {
            return Optional.of(new Payment(this, value, UUID.randomUUID()));
        } else {
            return Optional.empty();
        }
    }
}
