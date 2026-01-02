/**
 * Enumeration to represent the available delivery methods for an order.
 *
 * DOOR_DELIVERY: Order will be delivered to the customer's address (may incur a fee).<br>
 *
 * PICKUP: Customer will collect the order themselves from the store.
 *
 * Author: Reyan
 * Version: 1.0
 */
public enum DeliveryMethod
{
    /** Indicates the order will be delivered to the customer's address */
    DOOR_DELIVERY,

    /** Indicates the customer will pick up the order themselves */
    PICKUP
}
