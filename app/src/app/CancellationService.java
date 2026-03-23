import java.util.*;

public class UseCase7CancellationService {

    private static Map<String, Set<String>> roomAllocations = new HashMap<>();
    private static Map<String, Integer> inventory = new HashMap<>();

    public static void cancelBooking(String roomType, String roomId) {
        Set<String> rooms = roomAllocations.get(roomType);

        if (rooms != null && rooms.contains(roomId)) {
            rooms.remove(roomId);
            inventory.put(roomType, inventory.getOrDefault(roomType, 0) + 1);

            System.out.println("Booking cancelled for Room ID: " + roomId);
        } else {
            System.out.println("Invalid cancellation request");
        }
    }

    public static void main(String[] args) {

        inventory.put("Single", 1);

        Set<String> singleRooms = new HashSet<>();
        singleRooms.add("SI123");
        roomAllocations.put("Single", singleRooms);

        cancelBooking("Single", "SI123");
    }
}