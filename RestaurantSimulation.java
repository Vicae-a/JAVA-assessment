import java.util.*;

class Table {
    private final int id;
    private final int capacity;
    private boolean occupied;

    public Table(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.occupied = false;
    }

    public int getId() { return id; }
    public int getCapacity() { return capacity; }
    public boolean isOccupied() { return occupied; }
    public void occupy() { this.occupied = true; }
    public void vacate() { this.occupied = false; }
}

class Group {
    private final int id;
    private final int size;

    public Group(int id, int size) {
        this.id = id;
        this.size = size;
    }

    public int getId() { return id; }
    public int getSize() { return size; }
}

class RestManager {
    private final List<Table> tables = new ArrayList<>();
    private final Queue<Group> queue = new LinkedList<>();
    private int groupCounter = 1;

    public RestManager() {
        tables.add(new Table(1, 2));
        tables.add(new Table(2, 3));
        tables.add(new Table(3, 4));
        tables.add(new Table(4, 5));
        tables.add(new Table(5, 6));
    }

    public void addGroup(int size) {
        if (size < 1 || size > 6) {
            System.out.println("Invalid group size. Must be between 1 and 6.");
            return;
        }
        Group newGroup = new Group(groupCounter++, size);
        boolean seated = false;
        for (Table table : tables) {
            if (!table.isOccupied() && table.getCapacity() >= size) {
                table.occupy();
                System.out.println("Group " + newGroup.getId() + " (Size: " + size + ") seated at Table " + table.getId());
                seated = true;
                break;
            }
        }
        if (!seated) {
            queue.add(newGroup);
            System.out.println("Group " + newGroup.getId() + " added to queue.");
        }
    }

    public void removeGroup(int tableId) {
        for (Table table : tables) {
            if (table.getId() == tableId && table.isOccupied()) {
                table.vacate();
                System.out.println("Table " + tableId + " is now free.");
                checkQueue();
                return;
            }
        }
        System.out.println("Table " + tableId + " is already empty.");
    }

    private void checkQueue() {
        if (queue.isEmpty()) return;
        Group firstGroup = queue.peek();
        for (Table table : tables) {
            if (!table.isOccupied() && table.getCapacity() >= firstGroup.getSize()) {
                table.occupy();
                System.out.println("Group " + firstGroup.getId() + " seated at Table " + table.getId());
                queue.poll();
                break;
            }
        }
    }

    public void printStatus() {
        System.out.println("\nTable Status:");
        for (Table table : tables) {
            System.out.println("Table " + table.getId() + " (Capacity: " + table.getCapacity() + ", Occupied: " + table.isOccupied() + ")");
        }
        System.out.println("\nQueue Status:");
        if (queue.isEmpty()) {
            System.out.println("No waiting groups.");
        } else {
            for (Group group : queue) {
                System.out.println("Group " + group.getId() + " (Size: " + group.getSize() + ") waiting");
            }
        }
    }
}

public class RestaurantSimulation {
    public static void main(String[] args) {
        RestManager manager = new RestManager();
        manager.addGroup(3);
        manager.addGroup(5);
        manager.addGroup(2);
        manager.printStatus();
        manager.removeGroup(2);
        manager.printStatus();
    }
}
