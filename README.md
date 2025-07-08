# Fawry-Internship-Challenge

A simple e-commerce  simulation built in Java, supporting:

✅ Products and inventory management  
✅ Customer accounts and balance handling  
✅ Shopping cart functionality  
✅ Shipping calculation based on weight  
✅ Checkout with receipt printing and expired product handling

---

## 📦 Features

### Products
- Represented by the `Product` class
- Properties:
  - name
  - price
  - quantity
  - weight (optional if product is Shippable, in grams)
  - expiry date (optional)
- Implements `Shippable` interface for shipping calculations
- Supports:
  - Checking expiry
  - Adjusting stock levels
  - Equality check based on name

### Customers
- Represented by the `Customer` class
- Properties:
  - name
  - balance
- Supports:
  - Checking if the customer can pay
  - Performing payment transactions

### Cart
- Manages products added by the customer
- Validates stock availability
- Supports:
  - Adding products
  - Clearing the cart
  - Returning products to stock if checkout fails

### Shipping
- Implemented by `ShippingService`
- Calculates shipping fees based on total weight (kg)
- Fee: **27.00 per kg** (my Assumption)
- Prints shipment notice

### Checkout
- Managed by `CheckoutService`
- Supports:
  - Removing expired products before purchase
  - Calculating subtotal
  - Calculating shipping fees
  - Processing payment
  - Printing a receipt

---
![image](https://github.com/user-attachments/assets/09b7d78e-b3be-4ca0-9aee-4735824578d6)

---
