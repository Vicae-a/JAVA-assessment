public class Table {
    private int size;
    private int availableSeats;

    public Table(int size) {
        this.size = size;
        this.availableSeats = size;
    }

    public int getSize() {
        return size;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean canAccommodate(int groupSize) {
        return availableSeats >= groupSize;
    }

    public void seatGroup(int groupSize) {
        if (canAccommodate(groupSize)) {
            availableSeats -= groupSize;
        }
    }

    public void clearTable() {
        availableSeats = size;
    }

    @Override
    public String toString() {
        return "Table (Size: " + size + ", Available Seats: " + availableSeats + ")";
    }
}
