package Characters;

import Locations.Location;

public final class Father extends Human {
    public Father(String name, Location location, String familyConnect, Mood mood) {
        super(name, location, familyConnect, mood);
    }

    @Override
    public boolean canReact() {
        return true;
    }
}
