import java.util.*;

public class RestManager {
    private List<Table> tables;
    private Queue<Integer> waitingQueue;

    public RestManager() {
        tables = new ArrayList<>();
        waitingQueue = new LinkedList<>();

        // Initialize tables with different sizes
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(4));
        tables.add(new Table(5));
        tables.add(new Table(6));
    }

    public void arrive(int groupSize) {
        System.out.println("Group of " + groupSize + " arrived.");
        
        for (Table table : tables) {
            if (table.getAvailableSeats() == table.getSize() && table.getSize() >= groupSize) {
                table.seatGroup(groupSize);
                System.out.println("Seated at " + table);
                return;
            }
        }

        waitingQueue.add(groupSize);
        System.out.println("No table available. Added to waiting queue.");
    }

    public void leave() {
        if (waitingQueue.isEmpty()) {
            System.out.println("No group is waiting.");
            return;
        }

        int groupSize = waitingQueue.poll();
        System.out.println("Group of " + groupSize + " left the queue.");
    }

    public void displayStatus() {
        System.out.println("\nCurrent Table Status:");
        for (Table table : tables) {
            System.out.println(table);
        }

        System.out.println("\nWaiting Queue: " + waitingQueue);
    }
}
