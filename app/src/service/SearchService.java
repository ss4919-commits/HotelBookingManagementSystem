package service;

import model.*;

/**
 * SearchService handles read-only room search operations.
 *
 * It retrieves data from inventory and displays only
 * available room types without modifying system state.
 *
 * @author Developer
 * @version 4.0
 */
public class SearchService {

    private RoomInventory inventory;

    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    // Search and display available rooms
    public void searchAvailableRooms() {

        System.out.println("===== Available Rooms =====");

        // Create room objects (domain model)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Check availability and display only available ones
        if (inventory.getAvailability("Single Room") > 0) {
            single.displayDetails();
            System.out.println("Available: " + inventory.getAvailability("Single Room"));
            System.out.println();
        }

        if (inventory.getAvailability("Double Room") > 0) {
            doubleRoom.displayDetails();
            System.out.println("Available: " + inventory.getAvailability("Double Room"));
            System.out.println();
        }

        if (inventory.getAvailability("Suite Room") > 0) {
            suite.displayDetails();
            System.out.println("Available: " + inventory.getAvailability("Suite Room"));
            System.out.println();
        }
    }
}