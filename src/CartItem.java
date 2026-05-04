// ABANOB
public class CartItem {
    // ABANOB
    private Item item;
    // ABANOB
    private int quantity;

    // ABANOB
    public CartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    // ABANOB
    public Item getItem() {
        return item;
    }

    // ABANOB
    public int getQuantity() {
        return quantity;
    }

    // ABANOB
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
