package Characters;

import Dialogues.DialogueReactor;
import Events.Event;
import Locations.Location;
import Locations.Mood;

public final class Carlson extends Human implements DialogueReactor {
    public Carlson(String name, Location location, String familyConnect, Mood mood) {
        super(name, location, familyConnect, mood);
    }

    @Override
    public void react(Event event) {
        if (event.getActor() instanceof FrekenBok){
            event.reactEvent(this);}
    }
}
