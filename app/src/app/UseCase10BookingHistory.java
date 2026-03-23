import java.util.*;

class Booking {
    String guestName;
    String roomType;

    Booking(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

public class UseCase10BookingHistory {

    private static List<Booking> history = new ArrayList<>();

    public static void addBooking(String name, String type) {
        history.add(new Booking(name, type));
    }

    public static void showHistory() {
        for (Booking b : history) {
            System.out.println(b.guestName + " booked " + b.roomType);
        }
    }

    public static void main(String[] args) {

        addBooking("Rahul", "Single");
        addBooking("Ananya", "Deluxe");

        showHistory();
    }
}