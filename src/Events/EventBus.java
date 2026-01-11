package Events;

import Dialogues.Reactor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {
    private static final List<Event> events = new ArrayList<>();
    private static final Map<EventType, ArrayList<Reactor>> subs = new HashMap<>();

    public static void addReactor(EventType eventType, Reactor... reactors) {
        for (Reactor reactor : reactors) {
            subs.computeIfAbsent(eventType, e -> new ArrayList<>()).add(reactor);}
    }
    public static void publish(Event event){
        events.add(event);
        var list = subs.get(event.getEventType());
        if (list == null) return;
        for (var reactor : list) reactor.react(event);}

    public static ArrayList<Event> getEvents(){
        return new ArrayList<>(events);
    }
}