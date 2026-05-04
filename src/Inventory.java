// MARIAM
import java.util.ArrayList;

// MARIAM
public class Inventory {

    // MARIAM
    private ArrayList<Item> items = new ArrayList<>();

    // MARIAM
    public void addItem(Item item) {
        items.add(item);
    }

    // MARIAM
    public Item searchById(int id) {
        for (int i = 0; i < items.size(); i++) {
            // Updated to use getId() from ABANOB
            if (items.get(i).getId() == id) {
                return items.get(i);
            }
        }
        return null;
    }

    // MARIAM
    public Item searchByName(String name) {
        for (int i = 0; i < items.size(); i++) {
            // Updated to use getName() from ABANOB
            if (items.get(i).getName().equalsIgnoreCase(name)) {
                return items.get(i);
            }
        }
        return null;
    }

    // MARIAM
    public void restockItem(int id, int quantity) {
        Item item = searchById(id);

        if (item != null) {
            // Updated to use setQuantity/getQuantity from ABANOB
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            System.out.println("Item not found!");
        }
    }
    // MARIAM
    public ArrayList<Item> getAllItems() {
        return items;
    }
}
