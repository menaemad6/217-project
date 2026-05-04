// JULIANO

public class SalesTracker {

    double totalSales;
    int totalItemsSold;

    public SalesTracker() {
        totalSales = 0;
        totalItemsSold = 0;
    }

    public void recordSale(Cart cart) {

        double saleTotal = 0;
        int itemsSold = 0;

        for (CartItem cartItem : cart.getCartItems()) {

            double itemTotal = cartItem.getItem().getPrice() * cartItem.getQuantity();

            saleTotal = saleTotal + itemTotal;
            itemsSold = itemsSold + cartItem.getQuantity();
        }

        totalSales = totalSales + saleTotal;
        totalItemsSold = totalItemsSold + itemsSold;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public int getTotalItemsSold() {
        return totalItemsSold;
    }
}


public class SystemController {

    Inventory inventory;
    Cart cart;
    SalesTracker salesTracker;

    public SystemController() {
        inventory = new Inventory();
        cart = new Cart();
        salesTracker = new SalesTracker();
    }

    public void addItemToInventory(int id, String name, String category, double price, int quantity) {

        Item item = new Item(id, name, category, price, quantity);

        inventory.addItem(item);
    }

    public Item searchItem(int id) {

        Item item = inventory.searchById(id);

        return item;
    }

    public Item searchItem(String name) {

        Item item = inventory.searchByName(name);

        return item;
    }

    public void addItemToCart(int id, int quantity) {

        Item item = inventory.searchById(id);

        if (item != null) {
            cart.addToCart(item, quantity);
        } else {
            System.out.println("Item not found!");
        }
    }

    public void checkout() {

        if (cart.getCartItems().isEmpty()) {
            System.out.println("Cart is empty.");
        } else {

            Receipt receipt = new Receipt();

            receipt.generateReceipt(cart);
            receipt.printReceipt();

            salesTracker.recordSale(cart);

            cart.getCartItems().clear();

            System.out.println("Checkout completed successfully.");
        }
    }

    public double getTotalSales() {
        return salesTracker.getTotalSales();
    }

    public int getTotalItemsSold() {
        return salesTracker.getTotalItemsSold();
    }
}