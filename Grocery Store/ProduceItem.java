/**
 * A ProduceItem is an item as stocked on the grocery store shelves.
 * It is an item priced per pound (fruits, vegetables, and such).
 *
 * @author Jayden Gardiner
 * @version 1.0 3/11/2014
 */

import java.text.NumberFormat;

public class ProduceItem extends GroceryItem {

    /**
     * Creates a ProduceItem with the given name and price
     *
     * @param name  the name of this ProduceItem
     * @param price the price of this ProduceItem
     */
    public ProduceItem(String name, double price) {
        super(name, price);
    }

    /**
     * Changes the String representation of this ProduceItem
     *
     * @return  the String representation of this ProduceItem
     */
    public String toString() {
        NumberFormat us = NumberFormat.getCurrencyInstance();
        return super.getName() + " @ " + us.format(super.getPrice())
        + " per pound";
    }

    /**
     * Gives a String asking for a quantity in the ProduceItem's units pounds
     *
     * @return  the quantity query String
     */
    public String getQuantityQuery() {
        return "How many pounds of " + super.getName() + " would you like?";
    }

     /**
     * Calculates the cost of this ProduceItem at the given quantity
     *
     * @param quantity  the quantity
     * @return  the cost
     */
    public double getCostOf(int quantity) {
        return super.getPrice() * quantity;
    }

}