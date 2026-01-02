import java.util.*;

/**
 * Main driver class for the takeaway order system.
 *
 * Handles customer orders, delivery choices, and student discount eligibility.
 *
 * Validates all user input to ensure robust operation.
 *
 * Author: Reyan
 * Version: 1.0
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        OrderManager manager = new OrderManager();
        boolean running = true;

        while (running)
        {
            //Display the main menu
            System.out.println("\n--- Menu ---");
            System.out.println("1. Enter new order");
            System.out.println("2. Deliver next order");
            System.out.println("3. View all orders");
            System.out.println("4. Exit");
            System.out.print("Select: ");

            int choice = getValidatedIntInput(scanner, 1, 4);

            switch (choice)
            {
                case 1:
                    Order order = buildOrder(scanner);
                    manager.addOrder(order);
                    System.out.println("Order added successfully!");
                    break;

                case 2:
                    Order nextOrder = manager.deliverOrder();
                    if (nextOrder != null)
                    {
                        //Delivery method selection
                        System.out.println("Select delivery method:");
                        System.out.println("1. Door Delivery ($5 Charge)");
                        System.out.println("2. Pickup");
                        System.out.print("Choose: ");
                        int methodChoice = getValidatedIntInput(scanner, 1, 2);
                        DeliveryMethod method = (methodChoice == 1) ? DeliveryMethod.DOOR_DELIVERY : DeliveryMethod.PICKUP;
                        nextOrder.setDeliveryMethod(method);

                        //Student discount eligibility
                        System.out.print("Are you a student? (yes/no): ");
                        String studentAnswer = scanner.nextLine().trim().toLowerCase();

                        if (studentAnswer.equals("yes"))
                        {
                            while (true)
                            {
                                System.out.print("Enter your university (or type 'N/A' to skip): ");
                                String uni = scanner.nextLine().trim();

                                if (uni.equalsIgnoreCase("n/a"))
                                {
                                    System.out.println("Skipping student discount.");
                                    break;
                                }

                                System.out.print("Enter your student ID (or type 'N/A' to skip): ");
                                String sid = scanner.nextLine().trim();

                                if (sid.equalsIgnoreCase("n/a"))
                                {
                                    System.out.println("Skipping student discount.");
                                    break;
                                }

                                if (!uni.isEmpty() && !sid.isEmpty())
                                {
                                    StudentInfo studentInfo = new StudentInfo(uni, sid);
                                    nextOrder.setStudentInfo(studentInfo);
                                    break;
                                }
                                else
                                {
                                    System.out.println("Both university and student ID are required or type 'N/A' to skip.");
                                }
                            }
                        }

                        //Show the final delivered order with summary
                        System.out.println("Delivered order:\n" + nextOrder);
                    }
                    else
                    {
                        System.out.println("No orders to deliver.");
                    }
                    break;

                case 3:
                    manager.viewOrders();
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Builds an order by collecting customer info and food item choices.
     *
     * Validates name, contact number, and address.
     *
     * @param scanner Scanner object for input
     *
     * @return completed Order object
     */
    public static Order buildOrder(Scanner scanner)
    {
        System.out.println("\n--- Enter Customer Details ---");

        //The Name validation
        String name = "";
        while (true)
        {
            System.out.print("Customer name: ");
            name = scanner.nextLine().trim();
            if (!name.isEmpty()) break;
            System.out.println("Name cannot be empty. Please enter a valid name.");
        }

        //Contact number validation should be exactly 10 digits
        String number = "";
        while (true)
        {
            System.out.print("Contact number (10 digits): ");
            number = scanner.nextLine().trim();
            if (number.matches("\\d{10}")) break;
            System.out.println("Invalid number. Must be exactly 10 digits.");
        }

        //Address validation
        String address = "";
        while (true)
        {
            System.out.print("Delivery address: ");
            address = scanner.nextLine().trim();
            if (!address.isEmpty()) break;
            System.out.println("Address cannot be empty. Please enter a valid address.");
        }

        Customer customer = new Customer(name, number, address);
        List<FoodItem> foodItems = new ArrayList<>();

        //Food item selection loop
        boolean addingFood = true;

        while (addingFood)
        {
            System.out.println("\nAdd food item:");
            System.out.println("1. Pizza");
            System.out.println("2. Pasta");
            System.out.println("3. Done");
            System.out.print("Choose: ");

            int foodChoice = getValidatedIntInput(scanner, 1, 3);

            switch (foodChoice)
            {
                case 1:
                    //Adding the Pizza with toppings
                    List<Topping> toppings = new ArrayList<>();
                    System.out.println("Enter toppings (ham, cheese, pineapple, mushrooms, tomato, seafood)");
                    System.out.println("Hit enter immediately to skip (vegan). Type 'done' when finished.");

                    while (true)
                    {
                        System.out.print("Topping: ");
                        String toppingName = scanner.nextLine().toLowerCase().trim();

                        if (toppingName.equals("") || toppingName.equals("done")) break;

                        Topping topping = createPizzaTopping(toppingName);
                        if (topping != null)
                        {
                            toppings.add(topping);
                        }
                        else
                        {
                            System.out.println("Invalid topping.");
                        }
                    }

                    foodItems.add(new Pizza(toppings));
                    break;

                case 2:
                    //Adding the Pasta
                    System.out.println("Choose pasta topping (bolognese, marinara, primavera, tomato)");
                    System.out.println("Type 'none' to skip (vegan): ");
                    String pastaToppingName = scanner.nextLine().toLowerCase().trim();

                    if (pastaToppingName.equals("none"))
                    {
                        Topping emptyTopping = new Topping("No topping", 0.00, MealType.VEGAN);
                        foodItems.add(new Pasta(emptyTopping));
                    }
                    else
                    {
                        Topping pastaTopping = createPastaTopping(pastaToppingName);
                        if (pastaTopping != null)
                        {
                            foodItems.add(new Pasta(pastaTopping));
                        }
                        else
                        {
                            System.out.println("Invalid pasta topping.");
                        }
                    }
                    break;

                case 3:
                    addingFood = false;
                    break;
            }
        }

        return new Order(foodItems, customer);
    }

    /**
     *Creates a pizza topping object from a topping name.
     *
     * @param name Topping name input by user
     * @return Topping object or null if invalid
     */
    public static Topping createPizzaTopping(String name)
    {
        switch (name)
        {
            case "ham": return new Topping("Ham", 2.00, MealType.MEAT);
            case "cheese": return new Topping("Cheese", 2.00, MealType.VEGETARIAN);
            case "pineapple": return new Topping("Pineapple", 2.50, MealType.VEGETARIAN);
            case "mushrooms": return new Topping("Mushrooms", 2.00, MealType.VEGETARIAN);
            case "tomato": return new Topping("Tomato", 2.00, MealType.VEGAN);
            case "seafood": return new Topping("Seafood", 3.50, MealType.MEAT);
            default: return null;
        }
    }

    /**
     * Creates a pasta topping object from a topping name.
     *
     * @param name Topping name input by user
     * @return Topping object or null if invalid
     */
    public static Topping createPastaTopping(String name)
    {
        switch (name)
        {
            case "bolognese": return new Topping("Bolognese", 5.20, MealType.MEAT);
            case "marinara": return new Topping("Marinara", 6.80, MealType.MEAT);
            case "primavera": return new Topping("Primavera", 5.20, MealType.VEGETARIAN);
            case "tomato": return new Topping("Tomato", 4.00, MealType.VEGAN);
            default: return null;
        }
    }

    /**
     * Validates and returns an integer input from the user within a range.
     *
     * @param scanner Scanner object for input
     * @param min Minimum valid value
     * @param max Maximum valid value
     * @return Validated integer input
     */
    public static int getValidatedIntInput(Scanner scanner, int min, int max)
    {
        while (true)
        {
            try
            {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= min && choice <= max)
                {
                    return choice;
                }
                System.out.print("Enter a number between " + min + " and " + max + ": ");
            }
            catch (NumberFormatException e)
            {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }
}
