package org.agaafar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Date future = new GregorianCalendar(2025, Calendar.DECEMBER, 1).getTime();
        ExpiringShippableProduct cheese = new ExpiringShippableProduct("Cheese", 100, 5, future, 0.2);
        ExpiringShippableProduct biscuits = new ExpiringShippableProduct("Biscuits", 150, 5, future, 0.7);
        ShippableProduct tv = new ShippableProduct("TV", 1000, 3, 5);
        NonExpiringNonShippableProduct scratchCard = new NonExpiringNonShippableProduct("Scratch Card", 50, 10);

        Customer customer = new Customer("Ahmed", 1000);
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        Checkout.process(customer, cart);
    }
}