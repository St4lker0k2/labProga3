package Events;

import java.util.ArrayList;
import java.util.List;

public final class EventLog {
    private static final List<Event> events = new ArrayList<>();

    public static void addEvent(Event event){
        events.add(event);
    }
    public static List<Event> getEvents(){
        return List.copyOf(events);
    }
}
