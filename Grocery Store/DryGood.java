/**
 * A DryGood an item priced per unit.
 *
 * @author Jayden Gardiner
 * @version 1.0 3/11/2014
 */

import java.text.NumberFormat;

public class DryGood extends GroceryItem {

    /**
     * Creates a DryGood with the given name and price
     *
     * @param name  the name of this DryGood
     * @param price the price of this DryGood
     */
    public DryGood(String name, double price) {
        super(name, price);
    }

    /**
     * Changes the String representation of this DryGood
     *
     * @return  the String representation of this DryGood
     */
    public String toString() {
        NumberFormat us = NumberFormat.getCurrencyInstance();
        return super.getName() + " @ " + us.format(super.getPrice())
        + " per unit";
    }

    /**
     * Gives a String asking for a quantity in the DryGood's units pounds
     *
     * @return  the quantity query String
     */
    public String getQuantityQuery() {
        return "How many units of " + super.getName() + " would you like?";
    }

    /**
     * Calculates the cost of this DryGood at the given quantity
     *
     * @param quantity  the quantity
     * @return  the cost
     */
    public double getCostOf(int quantity) {
        return super.getPrice() * quantity;
    }


}