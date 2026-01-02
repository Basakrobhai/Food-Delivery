/**
 * Represents a customer who places an order.
 * Stores the customer's name, contact number, and delivery address.
 *
 * Author: Reyan
 * Version: 1.0
 */
public class Customer
{
    /** The customer's full name */
    private String name;

    /** The customer's contact phone number */
    private String contactNumber;

    /** The customer's delivery address */
    private String address;

    /**
     * Constructs a Customer object with the given name, contact number, and address.
     *
     * @param name the customer's name
     * @param contactNumber the customer's contact number (must be 10 digits)
     * @param address the customer's delivery address
     */
    public Customer(String name, String contactNumber, String address)
    {
        //Set the customer fields
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    /**
     * Returns the customer's name.
     *
     * @return the name of the customer
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the customer's contact number.
     *
     * @return the contact phone number
     */
    public String getContactNumber()
    {
        return contactNumber;
    }

    /**
     * Returns the customer's delivery address.
     *
     * @return the address where the order should be delivered
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Returns a string representation of the customer.
     *
     * @return formatted string showing name, contact number, and address
     */
    @Override
    public String toString()
    {
        return name + " (" + contactNumber + ") - " + address;
    }
}
