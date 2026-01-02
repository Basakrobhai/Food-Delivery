import java.util.LinkedList;
import java.util.Queue;

/**
 * Manages the queue of orders for a takeaway system.
 *
 * Provides functionality to add orders, deliver the next order in FIFO order,
 * and display all currently pending orders.
 *
 * Author: Reyan
 * Version: 1.0
 */
public class OrderManager
{
    /** A queue to store orders in FIFO (first-in, first-out) order */
    private Queue<Order> orderQueue;

    /** Constructs an OrderManager and initializes the order queue */
    public OrderManager()
    {
        //Initialize the queue using LinkedList implementation
        orderQueue = new LinkedList<Order>();
    }

    /**
     * Adds a new order to the end of the queue.
     *
     * @param order the Order object to add
     */
    public void addOrder(Order order)
    {
        //Add the order to the queue
        orderQueue.add(order);
    }

    /**
     * Delivers (removes and returns) the next order in the queue.
     *
     * @return the next Order if available, or null if the queue is empty
     */
    public Order deliverOrder()
    {
        //Remove and return the order at the front of the queue
        return orderQueue.poll();
    }

    /**
     * Displays all current orders in the queue.
     * Prints a message if there are no orders to show.
     */
    public void viewOrders()
    {
        //If no orders are in the queue notify the user
        if (orderQueue.isEmpty())
        {
            System.out.println("No orders to display.");
        }
        else
        {
            //Print each order in the queue with a separator
            for (Order order : orderQueue)
            {
                System.out.println("--------");
                System.out.println(order.toString());
            }
        }
    }
}
