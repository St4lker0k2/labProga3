package Events;

import Characters.Human;

public abstract class Event {
    private final Human actor;
    private final EventType eventType;

    protected Event(Human actor, EventType eventType) {
        this.actor = actor;
        this.eventType = eventType;}

    public abstract void reactEvent(Human speaker);

    public EventType getEventType() {
        return eventType;}

    public Human getActor() {
        return actor;}
}