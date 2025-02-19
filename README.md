# 🍽️ Simple Restaurant Seating System

Welcome! This is a **simple Java program** that simulates how a restaurant assigns tables to customers. It follows **real-world rules** like seating groups together, managing waiting lines, and prioritizing smaller groups when possible.

---

## ✅ What This Program Does

- The restaurant has **tables of different sizes** (2, 3, 4, 5, or 6 seats).
- Customers **arrive alone or in groups** (up to 6 people).
- If a suitable table is available, the group is **seated immediately**.
- If no table is available, the group **waits in line** (queue).
- **Smaller groups** can be seated before larger waiting groups **if space allows**.
- Once seated, **a group cannot switch tables**.
- If a group waits too long, they may **leave the queue** without being served.

---

## 📂 How This Program is Organized

This project contains **three main Java files**:

### **1️⃣ Table.java** – Represents each table in the restaurant.
- Stores the **table size** and **occupied seats**.
- Checks if a group can be seated.
- Updates seating when a group arrives or leaves.

### **2️⃣ RestManager.java** – Manages tables and the waiting queue.
- Keeps track of **all tables** in the restaurant.
- Decides where to **seat new groups**.
- Manages the **waiting list** if no tables are available.
- Makes sure seating rules are followed.

### **3️⃣ RestaurantSimulation.java** – Runs the program.
- Accepts **user input** (new customers arriving, groups leaving, etc.).
- Calls `RestManager` to **process seating and queue**.
- Displays **the current status of tables**.

---

## 🚀 How to Run This Program

### **Option 1: Run in an IDE (IntelliJ, Eclipse, VS Code, Notepad++)**
1. Download and install **Java SE** if you don’t have it.
2. Clone this GitHub repository:
   ```sh
   git clone https://github.com/yourusername/restaurant-simulation.git
   ```
3. Open the project in your **Java IDE**.
4. Navigate to **RestaurantSimulation.java**.
5. Click the **Run** button (or use `Shift + F10` in IntelliJ).

### **Option 2: Run in Command Line (Terminal)**
1. Open a terminal in the project folder.
2. Compile all Java files:
   ```sh
   javac *.java
   ```
3. Run the program:
   ```sh
   java RestaurantSimulation
   ```

---

## 🖥️ Example Usage (How It Works)

After running the program, you'll see a prompt where you can **enter commands**:

```
Welcome to the Restaurant Seating System!
Enter a command (arrive X / leave Y / exit):
```



---

## 🔧 Features to Add in the Future
This is a simple version, but we can improve it by adding:
- **Time-based system** (so groups leave if they wait too long).
- **Graphical User Interface (GUI)** (so it's easier to use).
- **Better table management** (to reduce waiting time).

---




