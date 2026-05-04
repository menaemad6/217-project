import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // JULIANO
        SystemController controller = new SystemController();

        // Pre-fill some data (MARIAM's logic via JULIANO's controller)
        // JULIANO
        controller.addItemToInventory(1, "Milk", "Food", 20.0, 10);
        // JULIANO
        controller.addItemToInventory(2, "Bread", "Food", 5.0, 30);
        // JULIANO
        controller.addItemToInventory(3, "Headphones", "Electronics", 300.0, 5);

        // Start the GUI
        SwingUtilities.invokeLater(() -> {
            new SupermarketGUI(controller).setVisible(true);
        });
        
        System.out.println("Supermarket System GUI launched.");
    }
}