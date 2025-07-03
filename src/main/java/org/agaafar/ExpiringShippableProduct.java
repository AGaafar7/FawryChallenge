package org.agaafar;

import java.util.Date;

class ExpiringShippableProduct extends ExpiringProduct implements Shippable {
    private double weight;

    public ExpiringShippableProduct(String name, double price, int quantity, Date expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
