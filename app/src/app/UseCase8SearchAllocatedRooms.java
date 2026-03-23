import java.util.*;

public class UseCase8SearchAllocatedRooms {

    private static Map<String, Set<String>> roomAllocations = new HashMap<>();

    public static void searchRooms(String roomType) {
        Set<String> rooms = roomAllocations.get(roomType);

        if (rooms == null || rooms.isEmpty()) {
            System.out.println("No rooms allocated for " + roomType);
        } else {
            System.out.println("Allocated rooms for " + roomType + ": " + rooms);
        }
    }

    public static void main(String[] args) {

        Set<String> deluxeRooms = new HashSet<>();
        deluxeRooms.add("DE101");
        deluxeRooms.add("DE102");

        roomAllocations.put("Deluxe", deluxeRooms);

        searchRooms("Deluxe");
    }
}