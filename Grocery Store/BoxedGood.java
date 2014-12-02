/**
 * A BoxedGood is a type of BoxedGood which is an item priced per unit.
 *
 * @author Jayden Gardiner
 * @version 1.0 3/11/2014
 */

import java.text.NumberFormat;

public class BoxedGood extends DryGood {

    /**
     * Creates a BoxedGood with the given name and price
     *
     * @param name  the name of this BoxedGood
     * @param price the price of this BoxedGood
     */
    public BoxedGood(String name, double price) {
        super(name, price);
    }

    /**
     * Changes the String representation of this BoxedGood
     *
     * @return  the String representation of this BoxedGood
     */
    public String toString() {
        NumberFormat us = NumberFormat.getCurrencyInstance();
        return super.getName() + " @ " + us.format(super.getPrice())
        + " per box";
    }

    /**
     * Gives a String asking for a quantity in the BoxedGood's units pounds
     *
     * @return  the quantity query String
     */
    public String getQuantityQuery() {
        return "How many boxes of " + super.getName()
        + " would you like?";
    }

    /**
     * Calculates the cost of this BoxedGood at the given quantity
     *
     * @param quantity  the quantity
     * @return  the cost
     */
    public double getCostOf(int quantity) {
        return super.getPrice() * quantity;
    }

}