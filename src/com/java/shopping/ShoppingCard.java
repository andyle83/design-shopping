package com.java.shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCard {
    private List<LineItem> lineItems = new ArrayList<>();

    private void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }

    public void addLineItem(Product product, int quantity) {
        this.addLineItem(new LineItem(product, quantity));
    }

    public int getTotalCost() {
        return lineItems.stream()
                .mapToInt(LineItem::getPrice)
                .sum();
    }

    public List<LineItem> getLineItems() {
        return lineItems.stream().map(LineItem::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "ShoppingCard{" +
                "lineItems=" + lineItems +
                '}';
    }
}
