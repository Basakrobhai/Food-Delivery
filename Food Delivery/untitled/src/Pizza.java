import java.util.List;

/**
 * Represents a Pizza food item with one or more toppings.
 *
 * Calculates total price based on the base price plus the cost of each topping.
 * Determines the meal classification based on the topping types.
 *
 * Author: Reyan
 * Version: 1.0
 */
public class Pizza extends FoodItem
{
    /** List of toppings selected for this pizza */
    private List<Topping> toppings;

    /**
     * Constructs a Pizza with the given list of toppings.
     *
     * @param toppings a list of Topping objects added to the pizza
     */
    public Pizza(List<Topping> toppings)
    {
        this.toppings = toppings;
    }

    /**
     * Calculates the price of the pizza.
     * Includes the base price plus the price of all toppings.
     *
     * @return the total price of the pizza
     */
    @Override
    public double getPrice()
    {
        double total = BASE_PRICE;

        //Add the price of each topping to the base price
        for (Topping topping : toppings)
        {
            total += topping.getPrice();
        }

        return total;
    }

    /**
     * Determines the meal classification of the pizza.
     * <p>
     * Priority: MEAT > VEGETARIAN > VEGAN
     * </p>
     *
     * @return the overall meal type of the pizza
     */
    @Override
    public MealType getMealType()
    {
        boolean hasMeat = false;
        boolean hasVeg = false;

        //Scan the toppings to determine meal type
        for (Topping topping : toppings)
        {
            if (topping.getType() == MealType.MEAT)
            {
                hasMeat = true;
            }
            else if (topping.getType() == MealType.VEGETARIAN)
            {
                hasVeg = true;
            }
        }

        //Return the meal type based on topping content
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
     * Returns a string representation of the pizza and its toppings.
     *
     * @return a string listing the pizza and its toppings
     */
    @Override
    public String toString()
    {
        return "Pizza with toppings: " + toppings.toString();
    }
}
