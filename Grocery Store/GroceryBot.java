/**
 * GroceryBot is the driver program that allows a buyer
 * to purchase and check out items from an online store.
 *
 * @author Jayden Gardiner
 * @version 1.0 3/11/2014
 */

import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.text.NumberFormat;

public class GroceryBot {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        Buyable apple = new ProduceItem("Red Apples", 2.00);
        Buyable cereal = new BoxedGood("Admiral Crunch Cereal", 4.00);
        Buyable soup = new CannedGood("Some Soup", 5.00);
        Buyable[] buyableArray = {apple, cereal, soup};
        ShoppingCart cart = new ShoppingCart();

        System.out.println("Welcome to the Grocery Store valued customer!");

        System.out.println("\nWhat would you like to do?\n1: "
            + "Add item to cart\n2: Remove item from cart\n"
            + "3: List cart contents\n4: Checkout and Exit\n"
            + "Enter option number: ");

        int input = keyboard.nextInt();

        while (input != 4) {
            if (input == 1) {
                System.out.println("\nWe carry the following products.");
                for (int x = 1; x <= buyableArray.length; x++) {
                    System.out.println(x + ": " + buyableArray[x - 1]);
                }
                System.out.println("Enter the number of the product "
                    + "you'd like to add: ");
                int productNumber = keyboard.nextInt();
                //type -1 to cancel
                if (productNumber == -1) {
                    System.out.println("\nWhat would you like to do?\n"
                        + "1: Add item to cart\n2: Remove item from cart\n"
                        + "3: List cart contents\n4: Checkout and Exit\n"
                        + "Enter option number: ");
                    input = keyboard.nextInt();
                }
                System.out.println("\n"
                    + buyableArray[productNumber - 1].getQuantityQuery());
                int quantity = keyboard.nextInt();

                ShoppingCartItem item = new
                    ShoppingCartItem(buyableArray[productNumber - 1], quantity);
                cart.add(item);

                System.out.println("Added item:\n" + item.toString());
                System.out.println("\nWhat would you like to do?\n"
                    + "1: Add item to cart\n2: Remove item from cart\n"
                    + "3: List cart contents\n4: Checkout and Exit\n"
                    + "Enter option number: ");
                input = keyboard.nextInt();
            }
            if (input == 2) {
                System.out.println("\nHere are your cart contents:\n"
                    + cart.toString());
                System.out.println("\nEnter the name of the product "
                    + "you want to remove:");
                keyboard.nextLine();
                String itemName = keyboard.nextLine();
                System.out.println("\nEnter the quantity you want "
                    + "to remove:");
                int quantity =  Integer.parseInt(keyboard.nextLine());

                Buyable buyableItem = new ProduceItem(itemName, 0.00);

                ShoppingCartItem item = new
                    ShoppingCartItem(buyableItem, quantity);

                try {
                    cart.remove(item);
                    System.out.println("\nHere are your cart contents:\n"
                    + cart.toString());
                } catch (Exception e) {
                    System.out.println("\nI'm sorry, I'm afraid "
                        + "I can't do that.");
                }

                System.out.println("\nWhat would you like to do?\n"
                    + "1: Add item to cart\n2: Remove item from cart\n"
                    + "3: List cart contents\n4: Checkout and Exit\n"
                    + "Enter option number: ");
                input = keyboard.nextInt();
            }

            if (input == 3) {
                System.out.println("\nHere are your cart contents:\n"
                    + cart.toString());
                System.out.println("What would you like to do?\n"
                    + "1: Add item to cart\n2: Remove item from cart\n"
                    + "3: List cart contents\n4: Checkout and Exit\n"
                    + "Enter option number: ");
                input = keyboard.nextInt();
            }

            if (input != 0 && input != 1 && input != 2
                && input != 3 && input != 4) {
                System.out.println("\nWhat would you like to do?\n"
                    + "1: Add item to cart\n2: Remove item from cart\n"
                    + "3: List cart contents\n4: Checkout and Exit\n"
                    + "Enter option number: ");
                input = keyboard.nextInt();
            }
        }

        System.out.println("\nThank you! Please take your receipt "
            + "(see Receipt.txt)");

        try {

            NumberFormat us = NumberFormat.getCurrencyInstance();
            String theReceipt = "Grocery Store Receipt\n\n"
                + "Here are your purchases:\n" + cart.toString()
                + "\nTotal = " + us.format(cart.calculateTotal())
                + "\n\nThank you!";

            File file = new File("Receipt.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(theReceipt);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}