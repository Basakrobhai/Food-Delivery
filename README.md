# Food Delivery System (Java)

## Overview

This project is a console-based takeaway order management system developed in Java. It simulates a real-world food delivery workflow where customers can place orders, choose delivery methods, and receive discounts based on eligibility.

The system is designed using object-oriented programming principles including abstraction, inheritance, encapsulation, and polymorphism.

## Features

- Create and manage customer orders
- Support for multiple food types such as pizza and pasta
- Dynamic price calculation based on item configuration
- Meal classification system (Meat, Vegetarian, Vegan)
- Delivery options including pickup and door delivery
- Student discount eligibility system
- FIFO order delivery handling
- Input validation for reliable user interaction

## Project Structure

```
src/
│
├── Main.java              # Entry point and user interface
├── OrderManager.java     # Handles order queue and delivery logic
├── Order.java            # Represents a customer order
├── Customer.java         # Stores customer details
├── StudentInfo.java      # Handles student discount validation
│
├── FoodItem.java         # Abstract base class for all food items
├── Pizza.java            # Pizza implementation
├── Pasta.java            # Pasta implementation
├── Topping.java          # Topping definitions
│
├── MealType.java         # Enum for meal classification
├── DeliveryMethod.java   # Enum for delivery types
├── Utils.java            # Utility/helper functions
```

## Object-Oriented Design

### Abstraction
`FoodItem` is an abstract class that defines shared behavior such as pricing and meal type classification.

### Inheritance
`Pizza` and `Pasta` extend `FoodItem` and implement their own pricing logic.

### Encapsulation
Each class manages its own data and exposes controlled methods.

### Polymorphism
Different food items implement methods like `getPrice()` and `getMealType()` in their own way.

## How It Works

1. The user is presented with a menu:
   - Enter new order
   - Deliver next order
   - View all orders
   - Exit

2. When creating an order:
   - Customer details are entered
   - Food items are selected and customized
   - Delivery method is chosen
   - Student discount is applied if eligible

3. Orders are stored in a queue:
   - First In First Out delivery system

4. The system calculates:
   - Total price
   - Discounts
   - Meal classification

## Pricing Logic

- Base price is defined in `FoodItem`
- Additional costs are added based on:
  - Toppings for pizza
  - Customizations for pasta
- Discounts are applied after total calculation

## Input Validation

The system ensures:
- Valid numeric inputs within range
- Non-empty strings for required fields
- Controlled menu navigation

## How to Run

1. Clone the repository:
```
git clone https://github.com/your-username/food-delivery-system.git
```

2. Navigate into the project folder:
```
cd food-delivery-system
```

3. Compile the program:
```
javac src/*.java
```

4. Run the program:
```
java src/Main
```

## Requirements

- Java JDK 8 or higher
- Any Java IDE or terminal

## Example Use Case

- A customer places an order for a pizza with toppings
- Selects door delivery
- Provides student details
- The system validates eligibility and applies discount
- The order is queued and later delivered in order

## Future Improvements

- Graphical user interface
- Database integration for persistent storage
- Online ordering system
- Payment gateway integration
- Admin dashboard for order tracking

## Author

Muhammad Reyan Shafqat
