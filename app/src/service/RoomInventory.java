package service;

import java.util.HashMap;
import java.util.Map;

/**
 * RoomInventory class manages centralized room availability.
 *
 * This class replaces scattered variables with a single
 * HashMap to maintain consistency and scalability.
 *
 * @author Developer
 * @version 3.0
 */
public class RoomInventory {

    private Map<String, Integer> inventory;

    // Constructor to initialize inventory
    public RoomInventory() {
        inventory = new HashMap<>();

        // Initialize room availability
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Display full inventory
    public void displayInventory() {
        System.out.println("===== Room Inventory =====");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " → Available: " + entry.getValue());
        }
    }
}