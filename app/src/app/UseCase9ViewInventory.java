import java.util.*;

public class UseCase9ViewInventory {

    private static Map<String, Integer> inventory = new HashMap<>();

    public static void viewInventory() {
        System.out.println("Current Inventory:");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        inventory.put("Single", 2);
        inventory.put("Double", 1);
        inventory.put("Deluxe", 0);

        viewInventory();
    }
}