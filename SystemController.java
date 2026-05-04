// JULIANO
public class SystemController {

    // JULIANO
    private Inventory inventory;
    // JULIANO
    private Cart cart;
    // JULIANO
    private SalesTracker salesTracker;

    // JULIANO
    public SystemController() {
        inventory = new Inventory();
        cart = new Cart();
        salesTracker = new SalesTracker();
    }

    // JULIANO
    public void addItemToInventory(int id, String name, String category, double price, int quantity) {
        Item item = new Item(id, name, category, price, quantity);
        inventory.addItem(item);
    }

    // JULIANO
    public Item searchItem(int id) {
        return inventory.searchById(id);
    }

    // JULIANO
    public Item searchItem(String name) {
        return inventory.searchByName(name);
    }

    // JULIANO
    public void addItemToCart(int id, int quantity) {
        Item item = inventory.searchById(id);
        if (item != null) {
            cart.addToCart(item, quantity);
        } else {
            System.out.println("Item not found!");
        }
    }

    // JULIANO
    public void checkout() {
        if (cart.getCartItems().isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            // MAVIE
            Receipt receipt = new Receipt();
            // MAVIE
            receipt.generateReceipt(cart);
            // MAVIE
            receipt.printReceipt();

            // JULIANO
            salesTracker.recordSale(cart);
            // ABANOB
            cart.clearCart(); 

            System.out.println("Checkout completed successfully.");
        }
    }

    // JULIANO
    public double getTotalSales() {
        return salesTracker.getTotalSales();
    }

    // JULIANO
    public int getTotalItemsSold() {
        return salesTracker.getTotalItemsSold();
    }
    
    // MARIAM
    public void restockItem(int id, int quantity) {
        inventory.restockItem(id, quantity);
    }
    
    // ABANOB
    public void displayCart() {
        cart.displayCart();
    }
}
