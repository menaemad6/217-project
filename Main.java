// ABANOB

import java.util.ArrayList;

// ================== Item Class ==================
class Item {
    private int id;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Item(int id, String name, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// ================== CartItem Class ==================
class CartItem {
    private Item item;
    private int quantity;

    public CartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// ================== Cart Class ==================
class Cart {

    private ArrayList<CartItem> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    // Add item to cart
    public void addToCart(Item item, int quantity) {

        if (item.getQuantity() < quantity) {
            System.out.println("Not enough stock!");
            return;
        }

        // If item already exists in cart → increase quantity
        for (CartItem ci : cartItems) {
            if (ci.getItem().getId() == item.getId()) {
                ci.setQuantity(ci.getQuantity() + quantity);
                item.setQuantity(item.getQuantity() - quantity);
                return;
            }
        }

        // New item
        cartItems.add(new CartItem(item, quantity));
        item.setQuantity(item.getQuantity() - quantity);
    }

    // Remove item from cart
    public void removeFromCart(int id) {
        for (CartItem ci : cartItems) {
            if (ci.getItem().getId() == id) {

                // Return quantity back to stock
                ci.getItem().setQuantity(
                    ci.getItem().getQuantity() + ci.getQuantity()
                );

                cartItems.remove(ci);
                System.out.println("Item removed from cart.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    // Calculate total price
    public double calculateTotal() {
        double total = 0;

        for (CartItem ci : cartItems) {
            total += ci.getItem().getPrice() * ci.getQuantity();
        }

        return total;
    }

    // Calculate total with tax
    public double calculateTotalWithTax(double taxRate) {
        double total = calculateTotal();
        return total + (total * taxRate);
    }

    // Clear cart (without returning stock after purchase)
    public void clearCart() {
        cartItems.clear();
    }

    // Display cart items
    public void displayCart() {
        System.out.println("\n===== CART =====");

        for (CartItem ci : cartItems) {
            System.out.println(
                "ID: " + ci.getItem().getId() +
                " | Name: " + ci.getItem().getName() +
                " | Qty: " + ci.getQuantity() +
                " | Price: " + ci.getItem().getPrice()
            );
        }
    }
}

// ================== Main Class ==================
public class Main {
    public static void main(String[] args) {

        // Sample inventory items
        Item item1 = new Item(1, "Milk", "Food", 20.0, 10);
        Item item2 = new Item(2, "Headphones", "Electronics", 300.0, 5);

        Cart cart = new Cart();

        // Add items
        cart.addToCart(item1, 2);
        cart.addToCart(item2, 1);

        // Display cart
        cart.displayCart();

        // Show total
        double total = cart.calculateTotal();
        System.out.println("\nTotal: " + total);

        // Show total with tax (10%)
        double totalWithTax = cart.calculateTotalWithTax(0.10);
        System.out.println("Total with Tax: " + totalWithTax);

        // Remove item
        cart.removeFromCart(1);

        cart.displayCart();

        // Checkout
        System.out.println("\nCheckout completed.");
        cart.clearCart();
    }
}