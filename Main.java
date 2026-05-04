public class Main {
    public static void main(String[] args) {
        // JULIANO
        SystemController controller = new SystemController();

        // Adding items to inventory (MARIAM's logic via JULIANO's controller)
        // JULIANO
        controller.addItemToInventory(1, "Milk", "Food", 20.0, 10);
        // JULIANO
        controller.addItemToInventory(2, "Bread", "Food", 5.0, 30);
        // JULIANO
        controller.addItemToInventory(3, "Headphones", "Electronics", 300.0, 5);

        System.out.println("--- Initial Inventory Search ---");
        // MARIAM's search via JULIANO's controller
        // JULIANO
        System.out.println(controller.searchItem(1));
        // JULIANO
        System.out.println(controller.searchItem("Bread"));

        System.out.println("\n--- Processing Purchase ---");
        // ABANOB's cart logic via JULIANO's controller
        // JULIANO
        controller.addItemToCart(1, 2);
        // JULIANO
        controller.addItemToCart(3, 1);
        
        // ABANOB
        controller.displayCart();

        System.out.println("\n--- Checkout ---");
        // Integration of MAVIE (Receipt), ABANOB (Cart), and JULIANO (Sales)
        // JULIANO
        controller.checkout();

        System.out.println("\n--- Daily Sales Report ---");
        // JULIANO
        System.out.println("Total Sales: $" + controller.getTotalSales());
        // JULIANO
        System.out.println("Total Items Sold: " + controller.getTotalItemsSold());

        System.out.println("\n--- Restocking ---");
        // MARIAM
        controller.restockItem(1, 5);
        // JULIANO
        System.out.println("Milk after restock: " + controller.searchItem(1));
    }
}