package app;

import service.RoomInventory;

/**
 * =========================================================
 * MAIN CLASS - UseCase3InventorySetup
 * =========================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * This class demonstrates how room availability
 * is managed using a centralized HashMap.
 *
 * @author Developer
 * @version 3.0
 */

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        System.out.println("\nChecking availability for Single Room:");
        System.out.println("Available: " + inventory.getAvailability("Single Room"));

        // Update availability
        System.out.println("\nUpdating availability for Single Room...");
        inventory.updateAvailability("Single Room", 4);

        // Display updated inventory
        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();
    }
}