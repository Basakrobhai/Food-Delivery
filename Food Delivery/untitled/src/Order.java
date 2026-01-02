import java.util.List;

/**
 * Represents a customer's order which includes food items, delivery method,
 * customer details, and optional student discount information.
 *
 * Calculates total cost based on items, delivery fee, and applicable discount.
 * Determines the overall meal classification (MEAT, VEGETARIAN, or VEGAN).
 *
 * Author: Reyan
 * Version: 1.0
 */
public class Order
{
    /** List of food items in the order */
    private List<FoodItem> foodItems;

    /** Customer who placed the order */
    private Customer customer;

    /** Selected delivery method */
    private DeliveryMethod deliveryMethod;

    /** Student discount details */
    private StudentInfo studentInfo;

    /** Fixed fee applied for door delivery option */
    private static final double DOOR_DELIVERY_FEE = 5.00;

    /**
     * Constructs an Order object with food items and customer details.
     *
     * @param foodItems list of food items ordered
     * @param customer customer who placed the order
     */
    public Order(List<FoodItem> foodItems, Customer customer)
    {
        this.foodItems = foodItems;
        this.customer = customer;
    }

    /**
     * Sets the delivery method for this order.
     *
     * @param deliveryMethod the chosen delivery method
     */
    public void setDeliveryMethod(DeliveryMethod deliveryMethod)
    {
        this.deliveryMethod = deliveryMethod;
    }

    /**
     * Sets the student information to determine eligibility for discount.
     *
     * @param studentInfo student credentials (university and ID)
     */
    public void setStudentInfo(StudentInfo studentInfo)
    {
        this.studentInfo = studentInfo;
    }

    /**
     * Calculates the total cost of the order.
     * Includes delivery fee if applicable and applies 20% student discount if eligible.
     *
     * @return final total cost after fees and discounts
     */
    public double calculateTotalCost()
    {
        double total = 0.0;

        //Add the prices of all the food items
        for (FoodItem item : foodItems)
        {
            total += item.getPrice();
        }

        // Apply the delivery fee ($5) if Door Delivery was selected
        if (deliveryMethod == DeliveryMethod.DOOR_DELIVERY)
        {
            total += DOOR_DELIVERY_FEE;
        }

        //Apply the 20% discount if valid student info is provided
        if (studentInfo != null && studentInfo.isValid())
        {
            total *= 0.8;
        }

        return total;
    }

    /**
     * Determines the overall meal type of the order.
     * Priority: MEAT > VEGETARIAN > VEGAN
     *
     * @return the meal type classification
     */
    public MealType calculateMealType()
    {
        boolean hasMeat = false;
        boolean hasVeg = false;

        // Check meal types of each item in the order
        for (FoodItem item : foodItems)
        {
            MealType type = item.getMealType();
            if (type == MealType.MEAT)
            {
                hasMeat = true;
            }
            else if (type == MealType.VEGETARIAN)
            {
                hasVeg = true;
            }
        }

        //Classify based on the meal content
        if (hasMeat)
        {
            return MealType.MEAT;
        }
        else if (hasVeg)
        {
            return MealType.VEGETARIAN;
        }
        else
        {
            return MealType.VEGAN;
        }
    }

    /**
     * Returns a full formatted string describing the order.
     *
     * @return string containing customer info, delivery, meal type, and total cost
     */
    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();

        //Append the customer details
        output.append(customer.toString());

        //Append the delivery method
        if (deliveryMethod != null)
        {
            output.append("\nDelivery: ");
            if (deliveryMethod == DeliveryMethod.DOOR_DELIVERY)
            {
                output.append("Door Delivery ($5 Charge)");
            }
            else
            {
                output.append("Pickup");
            }
        }

        //Append the student discount info if applicable
        if (studentInfo != null && studentInfo.isValid())
        {
            output.append("\nStudent: ").append(studentInfo.toString()).append(" (20% discount applied)");
        }

        //Append the meal classification and item list
        output.append("\nMeal type: ").append(calculateMealType());
        output.append("\nItems: ").append(foodItems.toString());

        //Append the total cost
        output.append("\nTotal: $").append(String.format("%.2f", calculateTotalCost()));

        return output.toString();
    }
}
