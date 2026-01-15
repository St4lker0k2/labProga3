package Characters;

import Dialogues.Reactor;
import Events.Event;
import Locations.Location;

public final class Carlson extends Human implements Reactor {
    public Carlson(String name, Location location, String familyConnect, Mood mood) {
        super(name, location, familyConnect, mood);
    }

    @Override
    public boolean canReact() {
        return true;
    }

    @Override
    public void react(Event event) {
        event.reactEvent(this);
    }
}
