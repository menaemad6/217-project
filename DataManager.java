
// MINA 
import java.io.*;
import java.util.ArrayList;

public class DataManager {
    // MINA
    private static final String INVENTORY_FILE = "inventory.csv";
    private static final String SALES_FILE = "sales.csv";

    // MINA
    public void saveInventory(ArrayList<Item> items) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(INVENTORY_FILE))) {
            for (Item item : items) {
                writer.println(item.getId() + "," + item.getName() + "," +
                        item.getCategory() + "," + item.getPrice() + "," +
                        item.getQuantity());
            }
        } catch (IOException e) {
            System.err.println("Error saving inventory: " + e.getMessage());
        }
    }

    // MINA
    public ArrayList<Item> loadInventory() {
        ArrayList<Item> items = new ArrayList<>();
        File file = new File(INVENTORY_FILE);
        if (!file.exists())
            return items;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    items.add(new Item(
                            Integer.parseInt(parts[0]),
                            parts[1],
                            parts[2],
                            Double.parseDouble(parts[3]),
                            Integer.parseInt(parts[4])));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading inventory: " + e.getMessage());
        }
        return items;
    }

    // MINA
    public void saveSales(double totalSales, int itemsSold) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SALES_FILE))) {
            writer.println(totalSales + "," + itemsSold);
        } catch (IOException e) {
            System.err.println("Error saving sales: " + e.getMessage());
        }
    }

    // MINA
    public double[] loadSales() {
        File file = new File(SALES_FILE);
        if (!file.exists())
            return new double[] { 0, 0 };

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.split(",");
                return new double[] { Double.parseDouble(parts[0]), Double.parseDouble(parts[1]) };
            }
        } catch (IOException e) {
            System.err.println("Error loading sales: " + e.getMessage());
        }
        return new double[] { 0, 0 };
    }
}
