import javax.swing.*;
import java.awt.*;

public class SupermarketGUI extends JFrame {
    private SystemController controller;
    private JTextArea displayArea;

    public SupermarketGUI(SystemController controller) {
        this.controller = controller;
        
        // Window Setup
        setTitle("Supermarket System");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 1. Title
        JLabel titleLabel = new JLabel("Supermarket POS", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titleLabel, BorderLayout.NORTH);

        // 2. Display Area (Simplified)
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        displayArea.setBackground(new Color(245, 245, 245));
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // 3. Buttons Panel (Grid layout for simplicity)
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create buttons
        JButton btnInventory = new JButton("1. View Inventory");
        JButton btnAddItem = new JButton("2. Add/Restock Item");
        JButton btnAddCart = new JButton("3. Add to Cart");
        JButton btnCheckout = new JButton("4. Checkout");
        JButton btnSales = new JButton("5. Daily Sales");
        JButton btnExit = new JButton("6. Exit");

        // Action: View Inventory
        btnInventory.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("--- CURRENT INVENTORY ---\n");
            for (Item item : controller.getAllInventoryItems()) {
                sb.append(item.toString()).append("\n");
            }
            displayArea.setText(sb.toString());
        });

        // Action: Add/Restock
        btnAddItem.addActionListener(e -> {
            try {
                String idStr = JOptionPane.showInputDialog("Enter Item ID:");
                if (idStr == null) return;
                int id = Integer.parseInt(idStr);
                
                Item existing = controller.searchItem(id);
                if (existing != null) {
                    String qtyStr = JOptionPane.showInputDialog("Item exists. Enter quantity to add:");
                    controller.restockItem(id, Integer.parseInt(qtyStr));
                } else {
                    String name = JOptionPane.showInputDialog("Enter Name:");
                    String cat = JOptionPane.showInputDialog("Enter Category:");
                    double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Price:"));
                    int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity:"));
                    controller.addItemToInventory(id, name, cat, price, qty);
                }
                btnInventory.doClick(); // Refresh view
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input!");
            }
        });

        // Action: Add to Cart
        btnAddCart.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Item ID to buy:"));
                int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity:"));
                controller.addItemToCart(id, qty);
                
                displayArea.setText("--- CURRENT CART ---\n");
                controller.displayCart(); // This prints to console, let's update display area instead
                
                StringBuilder sb = new StringBuilder("--- CURRENT CART ---\n");
                for (CartItem ci : controller.getCartItems()) {
                    sb.append(ci.getItem().getName()).append(" x").append(ci.getQuantity())
                      .append(" ($").append(ci.getItem().getPrice() * ci.getQuantity()).append(")\n");
                }
                sb.append("\nTotal: $").append(controller.getCartTotal());
                displayArea.setText(sb.toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error adding to cart!");
            }
        });

        // Action: Checkout
        btnCheckout.addActionListener(e -> {
            String receipt = controller.processCheckout();
            displayArea.setText(receipt);
            JOptionPane.showMessageDialog(this, "Checkout Complete!");
        });

        // Action: View Sales
        btnSales.addActionListener(e -> {
            String salesInfo = String.format("--- DAILY SALES ---\nTotal Revenue: $%.2f\nItems Sold: %d",
                controller.getTotalSales(), controller.getTotalItemsSold());
            displayArea.setText(salesInfo);
        });

        // Action: Exit
        btnExit.addActionListener(e -> System.exit(0));

        // Add buttons to panel
        buttonPanel.add(btnInventory);
        buttonPanel.add(btnAddItem);
        buttonPanel.add(btnAddCart);
        buttonPanel.add(btnCheckout);
        buttonPanel.add(btnSales);
        buttonPanel.add(btnExit);

        add(buttonPanel, BorderLayout.SOUTH);

        // Show welcome message
        displayArea.setText("Welcome to Supermarket POS\nClick 'View Inventory' to start.");
    }
}
