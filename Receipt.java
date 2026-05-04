// MAVIE
import java.util.ArrayList;

// MAVIE
public class Receipt {

    // MAVIE
    private ArrayList<CartItem> items;
    // MAVIE
    private double totalBeforeTax;
    // MAVIE
    private double taxValue;
    // MAVIE
    private double finalTotal;

    // MAVIE
    public void generateReceipt(Cart cart) {
        items = cart.getCartItems();
        totalBeforeTax = 0;

        for (CartItem ci : items) {
            totalBeforeTax += ci.getItem().getPrice() * ci.getQuantity();
        }

        taxValue = calculateTax(totalBeforeTax);
        finalTotal = totalBeforeTax + taxValue;
    }

    // MAVIE
    public double calculateTax(double total) {
        return total * 0.14;
    }

    // MAVIE
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