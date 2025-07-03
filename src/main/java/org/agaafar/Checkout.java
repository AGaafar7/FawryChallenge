package org.agaafar;

import java.util.*;

class Checkout {
    public static void process(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }

        double subtotal = 0;
        List<Shippable> toShip = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product p = item.product;
            if (p.isExpired()) {
                throw new IllegalArgumentException(p.getName() + " is expired");
            }
            if (item.quantity > p.getQuantity()) {
                throw new IllegalArgumentException(p.getName() + " is out of stock");
            }
            subtotal += item.quantity * p.getPrice();
            if (p instanceof Shippable) {
                for (int i = 0; i < item.quantity; i++) {
                    toShip.add((Shippable) p);
                }
            }
        }

        double shippingFee = toShip.isEmpty() ? 0 : 30;
        double total = subtotal + shippingFee;

        if (customer.getBalance() < total) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        customer.deduct(total);
        for (CartItem item : cart.getItems()) {
            item.product.reduceQuantity(item.quantity);
        }

        if (!toShip.isEmpty()) {
            ShippingService.ship(toShip);
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s\t%.2f\n", item.quantity, item.product.getName(), item.quantity * item.product.getPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.2f\n", subtotal);
        System.out.printf("Shipping\t%.2f\n", shippingFee);
        System.out.printf("Amount\t%.2f\n", total);
        System.out.printf("Balance\t%.2f\n", customer.getBalance());
    }
}
