package app;

import model.*;

/**
 * =========================================================
 * MAIN CLASS - UseCase2RoomInitialization
 * =========================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Description:
 * This class initializes different room types and displays
 * their details along with static availability.
 *
 * @author Developer
 * @version 2.0
 */

public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        // Create room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability (NO data structures)
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("===== Room Details & Availability =====");

        single.displayDetails();
        System.out.println("Available: " + singleAvailable);
        System.out.println();

        doubleRoom.displayDetails();
        System.out.println("Available: " + doubleAvailable);
        System.out.println();

        suite.displayDetails();
        System.out.println("Available: " + suiteAvailable);
    }
}