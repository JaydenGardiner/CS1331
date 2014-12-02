/**
 * A ShoppingCart is a wrapper for a resizable array that
 * holds the customer’s selected ShoppingCartItems.
 *
 * @author Jayden Gardiner
 * @version 1.0 3/11/2014
 */

public class ShoppingCart {

    private ShoppingCartItem[] cart = new ShoppingCartItem[10];
    private ShoppingCartItem[] newArray;

    /**
     * Adds a ShoppingCartItem to the ShoppingCart
     *
     * @param ShoppingCartItem the item to be added
     */
    public void add(ShoppingCartItem addThisItem) {
        // add item to array

        boolean isFull = false;
        for (int x = 0; x < cart.length; x++) {
            if (null != cart[x]) {
                isFull = true;
            }
        }

        if (isFull) {
            int i = 0;
            ShoppingCartItem[] newArray = new ShoppingCartItem[2 * cart.length];
            for (ShoppingCartItem item: cart) {
                newArray[i] = item;
                i++;
            }
            cart = newArray;
            isFull = false;
        }
        int i = 0;
        boolean itemInserted = false;
        while (!itemInserted) {
            if (cart[i] == null) {
                cart[i] = addThisItem;
                itemInserted = true;
            }
            i++;
        }
    }

    /**
     * Removes a ShoppingCartItem from the ShoppingCart
     *
     * @param ShoppingCartItem the item to be removed
     * @return the removed object or null if not removed
     */
    public ShoppingCartItem remove(ShoppingCartItem removeThisItem) {
        //remove from array

        for (int x = 0; x < cart.length; x++) {
            if (cart[x].equals(removeThisItem)) {
                ShoppingCartItem removedEntry = cart[x];
                cart[x] = null;
                return removedEntry;
            }
        }
        return null;
    }

    /**
     * Returns a string representation of the ShoppingCart
     *
     * @return String representation of the ShoppingCart
     */
    public String toString() {
        String theCart = "";
        for (int x = 0; x < cart.length; x++) {
            if (null != cart[x]) {
                theCart = theCart + (cart[x].toString()) + "\n";
            }
        }
        return theCart;
    }

    /**
     * Calculates the total cost of the ShoppingCart
     *
     * @return  the total cost
     */
    public double calculateTotal() {
        double total = 0.00;
        for (int x = 0; x < cart.length; x++) {
            if (null != cart[x]) {
                total = total + cart[x].calculateCost();
            }
        }
        return total;
    }

}