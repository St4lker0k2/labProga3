package Dialogues;

import Events.Event;

public interface EventReactor extends Reactor {
    void react(Event event);
}
