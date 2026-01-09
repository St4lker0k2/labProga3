package Characters;

import Exceptions.InvalidNameException;
import Locations.Location;
import Locations.Mood;

public abstract class Human {
    private final String familyConnect;
    private final String name;
    private final Mood mood;
    private Location location;
    protected Human(String name, Location location, String familyConnect, Mood mood) throws InvalidNameException {
        this.familyConnect = familyConnect;
        if (validateName(name)){
            this.name = name;}
        else {
            throw new InvalidNameException(name);
        }
        this.location = location;
        this.mood = mood;
    }

    public Location getLocation() {return location;}

    public void setLocation(Location location) {this.location = location;}

    public String getName(){return name;}

    private boolean validateName(String name){
        return name.matches("[А-Яа-я]+(([-| ])[А-Яа-я]+)*");
    }

    @Override
    public String toString() {
        return "Character " + getName();
    }

    @Override
    public int hashCode() {return getName().hashCode();}

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Human human))
            return false;
        return this.getName().equals(human.getName());
    }

    public String getFamilyConnect() {
        return familyConnect;
    }
    public Mood getMood(){
        return mood;
    }
}
