/**
 * A CannedItem is an item as stocked on the grocery store shelves.
 * It is an item priced per pound (fruits, vegetables, and such).
 *
 * @author Jayden Gardiner
 * @version 1.0 3/11/2014
 */

import java.text.NumberFormat;

public class CannedGood extends GroceryItem {

    private String name;
    private double price;

    /**
     * Creates a CannedGood with the given name and price
     *
     * @param name  the name of this CannedGood
     * @param price the price of this CannedGood
     */
    public CannedGood(String name, double price) {
        super(name, price);
    }

    /**
     * Changes the String representation of this CannedGood
     *
     * @return  the String representation of this CannedGood
     */
    public String toString() {
        NumberFormat us = NumberFormat.getCurrencyInstance();
        return super.getName() + " @ " + us.format(super.getPrice())
        + " per can, buy 2 get 1 free";
    }

    /**
     * Gives a String asking for a quantity in the CannedGood's units pounds
     *
     * @return  the quantity query String
     */
    public String getQuantityQuery() {
        return "How many cans of " + super.getName() + " would you like?";
    }

    /**
     * Calculates the cost of this CannedGood at the given quantity
     *
     * @param quantity  the quantity
     * @return  the cost
     */
    public double getCostOf(int quantity) {
        if (quantity % 3 == 0) {
            return (super.getPrice() * quantity * (2.0 / 3.0));
        }
        return super.getPrice() * quantity;
    }


}