import java.util.*;

class Reservation {
    String guestName;
    int priority;

    Reservation(String guestName, int priority) {
        this.guestName = guestName;
        this.priority = priority;
    }
}

public class UseCase11PriorityBooking {

    public static void main(String[] args) {

        PriorityQueue<Reservation> pq = new PriorityQueue<>(
                (a, b) -> b.priority - a.priority
        );

        pq.add(new Reservation("Rahul", 1));
        pq.add(new Reservation("VIP Guest", 5));
        pq.add(new Reservation("Ananya", 2));

        while (!pq.isEmpty()) {
            System.out.println("Processing: " + pq.poll().guestName);
        }
    }
}