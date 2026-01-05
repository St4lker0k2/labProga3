package Characters;

import Locations.Location;
import Locations.Mood;

public abstract class Human {
    private final String familyConnect;
    private final String name;
    private final Mood mood;
    private Location location;
    protected Human(String name, Location location, String familyConnect, Mood mood){
        this.familyConnect = familyConnect;
        this.name = name;
        this.location = location;
        this.mood = mood;
    }

    public Location getLocation() {return location;}

    public void setLocation(Location location) {this.location = location;}

    public String getName(){return name;}

    public String getFamilyConnect() {
        return familyConnect;
    }
    public Mood getMood(){
        return mood;
    }
}
