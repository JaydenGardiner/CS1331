/**
 * A ShoppingCartItem represents a grocery item that
 * has been added to a shopping cart in some quantity.
 *
 * @author Jayden Gardiner
 * @version 1.0 3/11/2014
 */

import java.text.NumberFormat;

public class ShoppingCartItem {

    private int quantity;
    private Buyable buyable;
    private int value;

    /**
     * Creates a ShoppingCartItem from a buyable object to a quantity
     *
     * @param buyable   buyable object such as a GroceryItem
     * @param quantity  the quantity of the object
     */
    public ShoppingCartItem(Buyable buyable, int quantity) {
        this.buyable = buyable;
        this.quantity = quantity;
    }

    /**
     * Sets the quantity of the ShoppingCartItem
     *
     * @param value   the number of the quantity
     */
    public void setQuantity(int value) {
        value = quantity;
    }

    /**
     * Calculates the cost of this ShoppingCartItem at the given quantity
     *
     * @param quantity  the quantity
     * @return  the cost
     */
    public double calculateCost() {
        return buyable.getCostOf(quantity);
    }

    /**
     * Returns a string representation of the ShoppingCartItem
     *
     * @return string of the buyable object and its cost
     */
    public String toString() {
        NumberFormat us = NumberFormat.getCurrencyInstance();
        return buyable.toString() + "\n\tx" + quantity
        + " = " + us.format(calculateCost());
    }

    /**
     * Checks for equality between ShoppingCartItems
     *
     * @param other   An object passed into the method for equality checking
     * @return boolean of whether the objects are equal
     */
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShoppingCartItem)) {
            return false;
        }
        ShoppingCartItem that = (ShoppingCartItem) other;
        return this.buyable.equals(that.buyable)
        && (this.quantity - (that.quantity) == 0);
    }

    /**
     * Corresponding hashCode to the equals method.
     *
     * @return  the hashCode method
     */
    public int hashCode() {
        return hashCode();
    }

}