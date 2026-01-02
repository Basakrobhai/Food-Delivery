/**
 * Abstract base class for all food items (e.g., pizza, pasta).
 * <p>
 * Defines a common base price and enforces implementation of
 * price calculation and meal type identification in subclasses.
 * </p>
 *
 * Author: Reyan
 * Version: 1.0
 */
public abstract class FoodItem
{
    /** Shared base price for all food items (e.g., starting price) */
    protected static final double BASE_PRICE = 11.50;

    /**
     * Calculates the total price of the food item.
     * Implemented by each subclass based on its own logic.
     *
     * @return the total price of the item
     */
    public abstract double getPrice();

    /**
     * Determines the overall meal classification for the item
     * (e.g., MEAT, VEGETARIAN, VEGAN).
     *
     * @return the meal type for this food item
     */
    public abstract MealType getMealType();

    /**
     * Returns a human-readable string describing the food item.
     *
     * @return the description of the item
     */
    @Override
    public abstract String toString();
}
