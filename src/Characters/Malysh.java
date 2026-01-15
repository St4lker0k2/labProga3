package Characters;

import Dialogues.Dialogue;
import Dialogues.Reactor;
import Events.Event;
import Locations.Location;

public final class Malysh extends Human implements Reactor {
    public Malysh(String name, Location location, String familyConnect, Mood mood) {
        super(name, location, familyConnect, mood);
    }

    @Override
    public boolean canReact() {
        return true;}

    @Override
    public void react(Event event) {
        if (Dialogue.getInterlocutor(this) != null)
            event.reactEvent(this);
        else{
            System.out.printf("%s: Мне не с кем обсудить новость!\n", this.getName());}
    }}
