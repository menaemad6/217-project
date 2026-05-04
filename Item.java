// MARIAM

public class Item {
    int id;
    String name;
    String category;
    double price;
    int quantity;

    public Item(int id, String name, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Category: " + category +
               ", Price: " + price + ", Quantity: " + quantity;
    }
}

import java.util.ArrayList;

public class Inventory {

    ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item searchById(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).id == id) {
                return items.get(i);
            }
        }
        return null;
    }

    public Item searchByName(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).name.equalsIgnoreCase(name)) {
                return items.get(i);
            }
        }
        return null;
    }

    public void restockItem(int id, int quantity) {
        Item item = searchById(id);

        if (item != null) {
            item.quantity += quantity;
        } else {
            System.out.println("Item not found!");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Item item1 = new Item(1, "Milk", "Dairy", 20.0, 10);
        Item item2 = new Item(2, "Bread", "Bakery", 5.0, 30);

        inventory.addItem(item1);
        inventory.addItem(item2);

        System.out.println(inventory.searchById(1));
        System.out.println(inventory.searchByName("bread"));

        inventory.restockItem(1, 5);
        System.out.println(inventory.searchById(1));
    }
}