package org.agaafar;

import java.util.Date;

class ExpiringProduct extends Product {
    private Date expiryDate;

    public ExpiringProduct(String name, double price, int quantity, Date expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.before(new Date());
    }
}