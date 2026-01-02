/**
 * Represents a Pasta dish with a single topping.
 *
 * Calculates total price using the base price and the topping price.
 * Meal classification is determined entirely by the topping type.
 *
 * Author: Reyan
 * Version: 1.0
 */
public class Pasta extends FoodItem
{
    /** The only topping allowed on this pasta */
    private Topping topping;

    /**
     * Constructs a Pasta object with a given topping.
     *
     * @param topping the Topping object to be added to the pasta
     */
    public Pasta(Topping topping)
    {
        this.topping = topping;
    }

    /**
     * Calculates the total price of the pasta.
     * Adds topping price to the base food price.
     *
     * @return the total cost of the pasta
     */
    @Override
    public double getPrice()
    {
        return BASE_PRICE + topping.getPrice();
    }

    /**
     * Returns the meal type of the pasta based on its topping.
     *
     * @return the meal classification (MEAT, VEGETARIAN, VEGAN)
     */
    @Override
    public MealType getMealType()
    {
        return topping.getType();
    }

    /**
     * Returns a string description of the pasta.
     *
     * @return string including topping information
     */
    @Override
    public String toString()
    {
        return "Pasta with topping: " + topping.toString();
    }
}
