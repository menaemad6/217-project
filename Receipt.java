// MAVIE

import java.util.ArrayList;

public class Receipt {

    private ArrayList<CartItem> items;
    private double totalBeforeTax;       //sum of all items
    private double taxValue;
    private double finalTotal;

    public void generateReceipt(Cart cart) {
        items = cart.getCartItems();
        totalBeforeTax = 0;

        for (CartItem ci : items) {
            totalBeforeTax += ci.getItem().getPrice() * ci.getQuantity();
        }

        taxValue = calculateTax(totalBeforeTax);
        finalTotal = totalBeforeTax + taxValue;
    }

    public double calculateTax(double total) {
        return total * 0.14;
    }

    public void printReceipt() {

        System.out.println("\n===== RECEIPT =====");

        for (CartItem ci : items) {
            System.out.println(
                "Item: " + ci.getItem().getName() +
                " | Quantity: " + ci.getQuantity() +
                " | Price: " + ci.getItem().getPrice()
            );
        }

       
        System.out.println("Total before tax: " + totalBeforeTax);
        System.out.println("Tax value: " + taxValue);
        System.out.println("Final total: " + finalTotal);
    }
}


public class Main {
    public static void main(String[] args) {
        
        //Mavie
        Item item1 = new Item(1, "Milk", "Food", 20.0, 10);
        Item item2 = new Item(2, "Airpods", "Electronics", 300.0, 5);

        Cart cart = new Cart();

        cart.addToCart(item1, 2);
        cart.addToCart(item2, 1);

        Receipt receipt = new Receipt();
        receipt.generateReceipt(cart);
        receipt.printReceipt();
    }
}

public ArrayList<CartItem> getCartItems() {
    return cartItems;
}