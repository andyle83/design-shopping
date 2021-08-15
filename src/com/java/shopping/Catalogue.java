package com.java.shopping;

import java.util.Map;

public class Catalogue {
    public final static int SHIPPING_RATE = 5;

    private static Map<String, Product> productMap = Map.of(
            "Electric Toothbrush", new Product("Electric Toothbrush", 3550, ProductType.PHYSICAL, 10),
            "Baby Alarm", new Product("Baby Alarm", 499, ProductType.PHYSICAL, 20)
    );

    public static Product getProduct(String productName) {
        return productMap.get(productName);
    }
}
