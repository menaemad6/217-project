// ABANOB
import java.util.ArrayList;

// ABANOB
public class Cart {

    // ABANOB
    private ArrayList<CartItem> cartItems;

    // ABANOB
    public Cart() {
        cartItems = new ArrayList<>();
    }

    // ABANOB
    public void addToCart(Item item, int quantity) {
        if (item.getQuantity() < quantity) {
            System.out.println("Not enough stock!");
            return;
        }

        for (CartItem ci : cartItems) {
            if (ci.getItem().getId() == item.getId()) {
                ci.setQuantity(ci.getQuantity() + quantity);
                item.setQuantity(item.getQuantity() - quantity);
                return;
            }
        }

        cartItems.add(new CartItem(item, quantity));
        item.setQuantity(item.getQuantity() - quantity);
    }

    // ABANOB
    public void removeFromCart(int id) {
        for (CartItem ci : cartItems) {
            if (ci.getItem().getId() == id) {
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

    // ABANOB
    public double calculateTotal() {
        double total = 0;
        for (CartItem ci : cartItems) {
            total += ci.getItem().getPrice() * ci.getQuantity();
        }
        return total;
    }

    // ABANOB
    public double calculateTotalWithTax(double taxRate) {
        double total = calculateTotal();
        return total + (total * taxRate);
    }

    // ABANOB
    public void clearCart() {
        cartItems.clear();
    }

    // ABANOB
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

    // MAVIE (Needed for Receipt)
    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }
}
