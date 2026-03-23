import java.util.*;

// Reservation class (same as UC5)
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
}

// Main Allocation System
public class UseCase6RoomAllocationService {

    // Queue from Use Case 5 (FIFO)
    private static Queue<Reservation> bookingQueue = new LinkedList<>();

    // Inventory (room type -> available count)
    private static Map<String, Integer> inventory = new HashMap<>();

    // Allocated room IDs (to prevent duplicates)
    private static Set<String> allocatedRoomIds = new HashSet<>();

    // Mapping room type -> allocated room IDs
    private static Map<String, Set<String>> roomAllocations = new HashMap<>();

    // Generate unique room ID
    private static String generateRoomId(String roomType) {
        return roomType.substring(0, 2).toUpperCase() + UUID.randomUUID().toString().substring(0, 5);
    }

    // Process booking requests
    public static void processBookings() {
        while (!bookingQueue.isEmpty()) {
            Reservation r = bookingQueue.poll(); // FIFO

            String type = r.getRoomType();
            int requested = r.getNumberOfRooms();

            int available = inventory.getOrDefault(type, 0);

            System.out.println("\nProcessing booking for: " + r.getGuestName());

            if (available >= requested) {
                Set<String> assignedRooms = roomAllocations.getOrDefault(type, new HashSet<>());

                for (int i = 0; i < requested; i++) {
                    String roomId;

                    // Ensure unique ID
                    do {
                        roomId = generateRoomId(type);
                    } while (allocatedRoomIds.contains(roomId));

                    allocatedRoomIds.add(roomId);
                    assignedRooms.add(roomId);

                    System.out.println("Allocated Room ID: " + roomId);
                }

                // Update structures
                roomAllocations.put(type, assignedRooms);
                inventory.put(type, available - requested);

                System.out.println("Booking CONFIRMED for " + r.getGuestName());
            } else {
                System.out.println("Booking FAILED for " + r.getGuestName() + " (Not enough rooms)");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize inventory
        inventory.put("Single", 3);
        inventory.put("Double", 2);
        inventory.put("Deluxe", 2);

        // Sample queue (simulate UC5 output)
        bookingQueue.add(new Reservation("Rahul", "Single", 2));
        bookingQueue.add(new Reservation("Ananya", "Double", 1));
        bookingQueue.add(new Reservation("Kiran", "Single", 2)); // will fail partially

        // Process bookings
        processBookings();

        sc.close();
    }
}