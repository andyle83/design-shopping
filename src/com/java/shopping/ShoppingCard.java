package com.java.shopping;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCard {
    private List<LineItem> lineItems = new ArrayList<>();

    public void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }

    public int getTotalCost() {
        return lineItems.stream()
                .mapToInt(LineItem::getPrice)
                .sum();
    }

    public List<LineItem> getLineItems() {
        return this.lineItems;
    }

    @Override
    public String toString() {
        return "ShoppingCard{" +
                "lineItems=" + lineItems +
                '}';
    }
}
