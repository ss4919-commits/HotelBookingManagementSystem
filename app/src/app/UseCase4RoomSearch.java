package app;

import service.*;

/**
 * =========================================================
 * MAIN CLASS - UseCase4RoomSearch
 * =========================================================
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Description:
 * This class demonstrates read-only search functionality.
 * It displays only available rooms without modifying inventory.
 *
 * @author Developer
 * @version 4.0
 */

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Initialize inventory (from UC3)
        RoomInventory inventory = new RoomInventory();

        // Create search service
        SearchService searchService = new SearchService(inventory);

        // Perform search
        searchService.searchAvailableRooms();
    }
}