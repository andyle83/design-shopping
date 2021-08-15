package com.java;

import com.java.shopping.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ShoppingCard shoppingCard = new ShoppingCard();

        // simulate database access
        Product toothbrush = Catalogue.getProduct("Electric Toothbrush");
        Product babyAlarm = Catalogue.getProduct("Baby Alarm");

        shoppingCard.addLineItem(toothbrush, 2);
        shoppingCard.addLineItem(babyAlarm, 3);

        // single responsibility
        Customer customer = new Customer("Andy Le", 777888999L);
        Optional<Order> order = customer.checkout(shoppingCard);

        // demo for defensive by encapsulation
        System.out.println(order);
        order.ifPresent(Main::fulfil);
        System.out.println(order);

        // demo for inheritance with stream
        Customer janeDoe = new Customer("Jane Doe", 7838686812313L);
        Customer acme = new BusinessCustomer("Acme Products", 688363863183618L, BusinessCustomer.BusinessSize.LARGE);
        Customer globex = new BusinessCustomer("Globex Corp", 73917139739173L, BusinessCustomer.BusinessSize.LARGE);
        Customer saveTheWorld = new NonProfitCustomer("Save the World", 98371971973L);

        // count how many customer are one each discount rate
        // with function style - declarative style
        List<Customer> customers = List.of(janeDoe, acme, globex, saveTheWorld);
        Map<Integer, Long> discountMap = customers.stream()
                .collect(Collectors.groupingBy(Customer::calculateDiscount, Collectors.counting()));
        System.out.println(discountMap);

        // alternative way
        discountMap = new HashMap<>();
        for (Customer c : customers) {
            discountMap.merge(c.calculateDiscount(), 1L, Long::sum);
        }
    }

    public static void fulfil(Order order) {
        ShoppingCard shoppingCard = order.getShoppingCard();
        boolean shippingUnfinished;

        // simulate fulfil process ( take item out of stock )
        do {
            shippingUnfinished = false;
            // using iterator since it allows us to remove item inside the loop
            for(Iterator<LineItem> it = shoppingCard.getLineItems().iterator(); it.hasNext();) {
                LineItem lineItem = it.next();

                if (Math.random() > 0.7) {
                    shippingUnfinished = true;
                    System.out.println(lineItem.getProduct() + " is out of stock");
                } else {
                    // fulfil and remove
                    it.remove();
                }
            }
        } while (shippingUnfinished);
    }
}
