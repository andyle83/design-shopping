package com.java;

import com.java.shopping.*;

import java.util.Iterator;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        ShoppingCard shoppingCard = new ShoppingCard();

        // Catalogue simulate database access
        Product toothbrush = Catalogue.getProduct("Electric Toothbrush");
        Product babyAlarm = Catalogue.getProduct("Baby Alarm");

        shoppingCard.addLineItem(toothbrush, 2);
        shoppingCard.addLineItem(babyAlarm, 3);

        Customer customer = new Customer("Andy Le", 777888999L);
        Optional<Order> order = customer.checkout(shoppingCard);

        System.out.println(order);

        order.ifPresent(Main::fulfil);

        System.out.println(order);
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
