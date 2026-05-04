// JULIANO
public class SalesTracker {

    // JULIANO
    private double totalSales;
    // JULIANO
    private int totalItemsSold;

    // JULIANO
    public SalesTracker() {
        totalSales = 0;
        totalItemsSold = 0;
    }

    // JULIANO
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

    // JULIANO
    public double getTotalSales() {
        return totalSales;
    }

    // JULIANO
    public int getTotalItemsSold() {
        return totalItemsSold;
    }

    // MINA - Added for Data Persistence
    public void setSalesData(double totalSales, int totalItemsSold) {
        this.totalSales = totalSales;
        this.totalItemsSold = totalItemsSold;
    }
}