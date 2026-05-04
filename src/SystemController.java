
// JULIANO
import java.util.ArrayList;

public class SystemController {

    private Inventory inventory;
    private Cart cart;
    private SalesTracker salesTracker;
    // MINA
    private DataManager dataManager;

    public SystemController() {
        inventory = new Inventory();
        cart = new Cart();
        salesTracker = new SalesTracker();
        // MINA
        dataManager = new DataManager();
        // MINA
        loadData();
    }

    // MINA
    private void loadData() {
        ArrayList<Item> savedItems = dataManager.loadInventory();
        for (Item item : savedItems) {
            inventory.addItem(item);
        }
        double[] sales = dataManager.loadSales();
        salesTracker.setSalesData(sales[0], (int) sales[1]);
    }

    // MINA
    private void saveData() {
        dataManager.saveInventory(inventory.getAllItems());
        dataManager.saveSales(salesTracker.getTotalSales(), salesTracker.getTotalItemsSold());
    }

    public void addItemToInventory(int id, String name, String category, double price, int quantity) {
        Item item = new Item(id, name, category, price, quantity);
        inventory.addItem(item);
        // MINA
        saveData();
    }

    public Item searchItem(int id) {
        return inventory.searchById(id);
    }

    public Item searchItem(String name) {
        return inventory.searchByName(name);
    }

    public void restockItem(int id, int quantity) {
        inventory.restockItem(id, quantity);
        // MINA
        saveData();
    }

    public void addItemToCart(int id, int quantity) {
        Item item = inventory.searchById(id);
        if (item != null) {
            cart.addToCart(item, quantity);
            // MINA
            saveData();
        }
    }

    public String processCheckout() {
        if (cart.getCartItems().isEmpty()) {
            return "Cart is empty.";
        } else {
            Receipt receipt = new Receipt();
            receipt.generateReceipt(cart);
            String receiptText = receipt.getReceiptText();
            salesTracker.recordSale(cart);
            cart.clearCart();
            // MINA
            saveData();
            return receiptText;
        }
    }

    public ArrayList<Item> getAllInventoryItems() {
        return inventory.getAllItems();
    }

    public ArrayList<CartItem> getCartItems() {
        return cart.getCartItems();
    }

    public double getCartTotal() {
        return cart.calculateTotal();
    }

    public double getTotalSales() {
        return salesTracker.getTotalSales();
    }

    public int getTotalItemsSold() {
        return salesTracker.getTotalItemsSold();
    }

    public void displayCart() {
        cart.displayCart();
    }
}
