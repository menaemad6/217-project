
// MINA 
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // JULIANO
        SystemController controller = new SystemController();

        // Sample data only if inventory is empty (first time run)
        if (controller.getAllInventoryItems().isEmpty()) {
            controller.addItemToInventory(1, "Milk", "Food", 20.0, 10);
            controller.addItemToInventory(2, "Bread", "Food", 5.0, 30);
            controller.addItemToInventory(3, "Headphones", "Electronics", 300.0, 5);
        }

        // MINA
        SwingUtilities.invokeLater(() -> {
            new SupermarketGUI(controller).setVisible(true);
        });

        System.out.println("Supermarket System GUI launched with Data Persistence.");
    }
}