package Characters;

import Events.Event;
import Dialogues.Dialogue;
import Dialogues.EventReactor;
import Locations.Location;
import Locations.Mood;

public final class Malysh extends Human implements EventReactor {
    public Malysh(String name, Location location, String familyConnect, Mood mood) {
        super(name, location, familyConnect, mood);
    }
    @Override
    public void react(Event event) {
        if (Dialogue.getInterlocutor(this) != null){
            event.reactEvent(this);
        }else{
            System.out.printf("%s: Мне не с кем разговаривать!\n", this.getName());
        }}
}
