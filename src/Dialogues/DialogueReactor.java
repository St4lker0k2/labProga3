package Dialogues;

import Events.Event;

public interface DialogueReactor extends Reactor {
    void react(Event event);
}
