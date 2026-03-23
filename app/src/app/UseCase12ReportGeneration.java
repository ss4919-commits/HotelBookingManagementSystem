import java.util.*;

public class UseCase12ReportGeneration {

    private static Map<String, Set<String>> roomAllocations = new HashMap<>();

    public static void generateReport() {
        System.out.println("---- Booking Report ----");

        for (String type : roomAllocations.keySet()) {
            Set<String> rooms = roomAllocations.get(type);
            System.out.println(type + " Rooms Booked: " + rooms.size());
        }
    }

    public static void main(String[] args) {

        Set<String> single = new HashSet<>();
        single.add("SI101");
        single.add("SI102");

        Set<String> deluxe = new HashSet<>();
        deluxe.add("DE201");

        roomAllocations.put("Single", single);
        roomAllocations.put("Deluxe", deluxe);

        generateReport();
    }
}
