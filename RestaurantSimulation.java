import java.util.Scanner;

public class RestaurantSimulation {
    public static void main(String[] args) {
        RestManager restManager = new RestManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Group arrives");
            System.out.println("2. Group leaves the queue");
            System.out.println("3. Display restaurant status");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            if (option == 1) {
                System.out.print("Enter group size (1-6): ");
                int groupSize = scanner.nextInt();
                restManager.arrive(groupSize);
            } else if (option == 2) {
                restManager.leave();
            } else if (option == 3) {
                restManager.displayStatus();
            } else if (option == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option! Try again.");
            }
        }

        scanner.close();
    }
}
