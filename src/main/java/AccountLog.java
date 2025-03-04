import java.util.ArrayList;
import java.util.List;

class AccountLog {
    private final List<Event> events = new ArrayList<>();

    public synchronized void append(Event event) {
        events.add(event);
        System.out.println("Event appended: " + event);
    }

    public synchronized List<Event> getEvents() {
        return new ArrayList<>(events);
    }
}