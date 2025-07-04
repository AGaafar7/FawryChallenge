# 🛒 E-Commerce System (Java)

This project is a console-based e-commerce system developed for the **Fawry Quantum Internship Challenge**. It demonstrates object-oriented design by modeling a simplified e-commerce workflow, including product types, shopping cart functionality, checkout logic, and a basic shipping service.

---

## ✨ Features

- ✅ Define products with name, price, and quantity.
- 🧀 Handle expirable products (e.g. Cheese, Biscuits).
- 📦 Handle shippable products with weights (e.g. TV, Cheese).
- 🛍️ Add items to a cart with respect to available stock.
- 💰 Checkout system:
  - Calculates subtotal, shipping fees, and final amount.
  - Validates expired items, out-of-stock, and customer balance.
  - Simulates shipping for shippable products.
- 🖨️ Prints shipping notice and detailed checkout receipt to console.

---

## 📁 Project Structure

```text
src/
├── Main.java                   # Entry point with working demo
├── Product.java                # Abstract base class
├── ExpiringProduct.java        # Product with expiry
├── ShippableProduct.java       # Product with weight (shippable)
├── ExpiringShippableProduct.java
├── NonExpiringNonShippableProduct.java
├── Cart.java                   # Cart class to add/remove items
├── CartItem.java               # Wrapper for product + quantity
├── Customer.java               # Customer with balance
├── Checkout.java               # Handles checkout logic
├── ShippingService.java        # Ships products implementing Shippable interface
```

🛠️ How to Run
Clone this repository:

```bash
git clone https://github.com/yourusername/ecommerce-system-java.git
cd ecommerce-system-java
```

Compile and run using any Java IDE or from the terminal:
```bash
javac Main.java
java Main
```
