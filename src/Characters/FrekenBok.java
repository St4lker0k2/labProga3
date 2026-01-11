package Characters;

import Locations.Location;
import Locations.Mood;

public final class FrekenBok extends Human {
    public FrekenBok(String name, Location location, String familyConnect, Mood mood) {
        super(name, location, familyConnect, mood);
    }

    @Override
    public boolean canReact() {
        return false;
    }
}
