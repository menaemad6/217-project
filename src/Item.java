// MARIAM
public class Item {
    // MARIAM
    private int id;
    // MARIAM
    private String name;
    // MARIAM
    private String category;
    // MARIAM
    private double price;
    // MARIAM
    private int quantity;

    // MARIAM
    public Item(int id, String name, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // ABANOB
    public int getId() {
        return id;
    }

    // ABANOB
    public String getName() {
        return name;
    }

    // ABANOB
    public String getCategory() {
        return category;
    }

    // ABANOB
    public double getPrice() {
        return price;
    }

    // ABANOB
    public int getQuantity() {
        return quantity;
    }

    // ABANOB
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // MARIAM
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Category: " + category +
               ", Price: " + price + ", Quantity: " + quantity;
    }
}