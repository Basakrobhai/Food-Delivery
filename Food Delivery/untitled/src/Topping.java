/**
 * Represents a topping that can be added to a pizza or pasta.
 *
 * Each topping has a name, price, and a meal type classification
 * (e.g., MEAT, VEGETARIAN, VEGAN).
 *
 * Author: Reyan
 * Version: 1.0
 */
public class Topping
{
    /** Name of the topping (e.g., ham, cheese, mushroom) */
    private String name;

    /** Price added by this topping */
    private double price;

    /** Meal type classification of the topping (MEAT, VEGETARIAN, VEGAN) */
    private MealType type;

    /**
     * Constructs a Topping object with specified name, price, and type.
     *
     * @param name the name of the topping
     * @param price the additional cost of this topping
     * @param type the meal type classification for this topping
     */
    public Topping(String name, double price, MealType type)
    {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    /**
     * Gets the name of the topping.
     *
     * @return the topping name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the price of the topping.
     *
     * @return the price as a double
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Gets the meal type classification of the topping.
     *
     * @return the MealType enum value
     */
    public MealType getType()
    {
        return type;
    }

    /**
     * Returns a string representation of the topping.
     *
     * @return formatted string including name and price
     */
    @Override
    public String toString()
    {
        return name + " ($" + price + ")";
    }
}
