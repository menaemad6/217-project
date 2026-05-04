# 🛒 Supermarket POS & Billing System

A modern, robust, and persistent Point-of-Sale (POS) system built with **Java**. This project simulates a real-world supermarket checkout experience, featuring inventory management, customer cart processing, automated receipt generation, and daily sales tracking.

---

## 🚀 Key Features

- **📦 Inventory Management**: Add, search, and restock items with real-time stock updates.
- **🛒 Interactive POS**: Simplified cart system to process customer purchases efficiently.
- **🧾 Automated Receipts**: Professional receipt generation including tax calculations (14%).
- **📈 Sales Tracking**: Track total daily revenue and the number of items sold.
- **💾 Data Persistence**: All data is automatically saved to and loaded from CSV files, ensuring zero data loss between sessions.
- **🖥️ Modern GUI**: A clean, single-window dashboard interface for ease of use.

---

## 🛠️ Technology Stack

- **Language**: Java 17+
- **GUI Framework**: Java Swing (with Nimbus Look & Feel)
- **Data Format**: CSV (Comma Separated Values) for persistent storage
- **Architecture**: Controller-based integration (MVC pattern)

---

## 📂 Project Structure

```text
├── src/                # Java source files
│   ├── Item.java             # Core data model
│   ├── Inventory.java        # Inventory logic
│   ├── Cart.java             # Shopping cart logic
│   ├── CartItem.java         # Cart entry model
│   ├── Receipt.java          # Billing & Tax logic
│   ├── SalesTracker.java     # Sales analytics
│   ├── DataManager.java      # CSV Persistence Service
│   ├── SystemController.java # Central Logic Bridge
│   ├── SupermarketGUI.java   # UI Implementation
│   └── Main.java             # Application Entry Point
├── out/                # Compiled class files (Generated)
├── inventory.csv       # Persistent inventory data
├── sales.csv           # Persistent sales data
├── run.bat             # Windows Batch script to Compile & Run
└── README.md           # Project documentation
```

---

## 👥 Team & Contributions

This project was a collaborative effort by Team 5:

- **Mariam**: Designed the `Item` structure and `Inventory` management logic.
- **Abanob**: Developed the `Cart` system and `Item` robust accessors.
- **Mavie**: Implemented the `Receipt` generation and Tax calculation logic.
- **Juliano**: Built the `SalesTracker` and the `SystemController` integration.
- **Mina (ME)**: Architected the **Modern GUI**, implemented the **Data Persistence (DB) Service**, and handled the final **System Integration**.

---

## ⚙️ How to Run

### Option 1: Quick Start (Windows)
Simply double-click the `run.bat` file in the root directory. It will automatically compile the code and launch the GUI.

### Option 2: Manual (Terminal)
1. **Compile**:
   ```powershell
   javac -d out src/*.java
   ```
2. **Run**:
   ```powershell
   java -cp out Main
   ```

---

## 📊 Data Management
The system utilizes a lightweight CSV-based database for persistence.
- Items are stored in `inventory.csv`.
- Daily totals are stored in `sales.csv`.
- *Note: To reset the system data, simply delete these two files.*

---

## 📝 License
This project was developed for the [Enter Semester Name] Semester Project. All rights reserved.
