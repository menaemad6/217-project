# 📖 Supermarket POS Technical Documentation

This document serves as the official technical reference for the Supermarket Point-of-Sale (POS) System. It provides a detailed breakdown of the codebase, class structures, and functional APIs.

---

## 🏛️ System Architecture
The project follows a **Layered Architecture** with a central **Facade** (SystemController) to manage communication.

- **Data Model Layer**: POJOs (Plain Old Java Objects) representing system entities.
- **Logic Layer**: Business rules for inventory management, shopping carts, and tax calculations.
- **Persistence Layer**: CSV-based data storage handlers.
- **Presentation Layer**: Java Swing-based GUI.

---

## 📂 Class Reference

### 1. `Item.java`
The core entity representing a product in the supermarket.
- **Attributes**: `id` (int), `name` (String), `category` (String), `price` (double), `quantity` (int).
- **Key Methods**: Standard getters and setters for all attributes.

### 2. `CartItem.java`
A wrapper class used within the shopping cart to link an `Item` with a specific purchase quantity.
- **Attributes**: `item` (Item), `quantity` (int).

### 3. `Inventory.java`
Manages the collection of items available in the store.
- **`addItem(Item item)`**: Adds a new item object to the inventory list.
- **`searchById(int id)`**: Returns an `Item` if found, else returns `null`.
- **`searchByName(String name)`**: Case-insensitive search for items by name.
- **`restockItem(int id, int quantity)`**: Increments the quantity of an existing item.
- **`getAllItems()`**: Returns the full `ArrayList<Item>`.

### 4. `Cart.java`
Handles the temporary storage of items during a customer session.
- **`addToCart(Item item, int quantity)`**: Adds an item to the cart and **deducts** the quantity from the main stock immediately.
- **`removeFromCart(int id)`**: Removes an item and **returns** the quantity to the main stock.
- **`calculateTotal()`**: Returns the subtotal of all items in the cart.
- **`calculateTotalWithTax(double rate)`**: Calculates subtotal + tax.
- **`clearCart()`**: Empties the cart items.

### 5. `Receipt.java`
Handles formatting and fiscal logic for the final bill.
- **`generateReceipt(Cart cart)`**: Processes a cart to calculate taxes and totals.
- **`calculateTax(double subtotal)`**: Returns tax (fixed at 14%).
- **`getReceiptText()`**: Returns a professionally formatted multiline string for display.

### 6. `SalesTracker.java`
Tracks cumulative statistics across multiple checkouts.
- **`recordSale(Cart cart)`**: Extracts data from a finalized cart and adds it to the totals.
- **`getTotalSales()` / `getTotalItemsSold()`**: Accessors for session stats.
- **`setSalesData(...)`**: Used by the persistence layer to load previous session totals.

### 7. `DataManager.java`
The persistence engine handling all File I/O operations.
- **`saveInventory(ArrayList<Item> items)`**: Serializes the inventory list into `inventory.csv`.
- **`loadInventory()`**: Reads `inventory.csv` and reconstructs the `Item` objects.
- **`saveSales(double total, int count)`**: Saves revenue data to `sales.csv`.
- **`loadSales()`**: Reads revenue data back into the system.

### 8. `SystemController.java`
The central hub (Facade) that connects all the classes above. **All GUI actions should call methods in this class.**
- **`addItemToInventory(...)`**: Combined method to create an item and save to disk.
- **`processCheckout()`**: The primary transaction method. It reduces stock, records sales, saves to disk, and returns the receipt text.

---

## 🖥️ Graphical User Interface (`SupermarketGUI.java`)
Built using **Java Swing** with a `BorderLayout` and `GridLayout`.
- **Display Area**: `JTextArea` inside a `JScrollPane` for receipt and inventory visualization.
- **Input Handling**: Uses `JOptionPane.showInputDialog` for capturing user data (IDs, Names, etc.).
- **Event Handling**: ActionListeners are attached to buttons to trigger the corresponding `SystemController` methods.

---

## 📊 Data Persistence (CSV Schema)
The system uses a flat-file database approach.

| File | Column Structure |
| :--- | :--- |
| **`inventory.csv`** | `ID,Name,Category,Price,Quantity` |
| **`sales.csv`** | `TotalRevenue,TotalItemsSold` |

---

## ⚙️ Compilation & Setup
1.  **Environment**: Requires JDK 17+.
2.  **Compilation**:
    ```bash
    javac -d out src/*.java
    ```
3.  **Execution**:
    ```bash
    java -cp out Main
    ```

---
*Documentation Version 1.0 | 2026*
