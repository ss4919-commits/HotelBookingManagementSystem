import java.util.*;

// Reservation class (represents booking intent)
class Reservation {
    private String guestName;
    private String roomType;
    private int numberOfRooms;

    public Reservation(String guestName, String roomType, int numberOfRooms) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.numberOfRooms = numberOfRooms;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName +
                ", Room Type: " + roomType +
                ", Rooms: " + numberOfRooms;
    }
}

// Booking Request Queue System
public class UseCase5BookingRequestQueue {

    // Queue to maintain FIFO order
    private static Queue<Reservation> bookingQueue = new LinkedList<>();

    // Method to add booking request
    public static void addBookingRequest(Reservation reservation) {
        bookingQueue.add(reservation);
        System.out.println("Booking request added: " + reservation.getGuestName());
    }

    // Method to display all requests
    public static void displayQueue() {
        System.out.println("\n--- Booking Request Queue (FIFO Order) ---");

        if (bookingQueue.isEmpty()) {
            System.out.println("No booking requests in queue.");
            return;
        }

        for (Reservation r : bookingQueue) {
            System.out.println(r);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of booking requests: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Request " + (i + 1));

            System.out.print("Guest Name: ");
            String name = sc.nextLine();

            System.out.print("Room Type (Single/Double/Deluxe): ");
            String roomType = sc.nextLine();

            System.out.print("Number of Rooms: ");
            int rooms = sc.nextInt();
            sc.nextLine(); // consume newline

            Reservation reservation = new Reservation(name, roomType, rooms);
            addBookingRequest(reservation);
        }

        // Display queue (FIFO maintained)
        displayQueue();

        sc.close();
    }
}