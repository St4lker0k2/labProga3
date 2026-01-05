package Events;

import Dialogues.Reactor;
import java.util.ArrayList;
import java.util.HashMap;

public class EventBus {
    private static final ArrayList<Event> events = new ArrayList<>();
    private static final HashMap<EventType, ArrayList<Reactor>> subs = new HashMap<>();

    public static void addReactor(EventType eventType, Reactor... reactors){
        for (Reactor reactor:reactors){
            subs.computeIfAbsent(eventType, e -> new ArrayList<>()).add(reactor);}}

    public static void publish(Event event){
        events.add(event);
        for (Reactor reactor: subs.get(event.getEventType())) {
            reactor.react(event);}}

    public static ArrayList<Event> getEvents(){
        return events;
    }
}

