package Characters;

import Exceptions.InvalidNameException;
import Exceptions.NullLocationException;
import Exceptions.NullMoodException;
import Locations.Location;
import Locations.Mood;

public abstract class Human {
    private final String familyConnect;
    private final String name;
    private final Mood mood;
    private Location location;
    Human(String name, Location location, String familyConnect, Mood mood) throws InvalidNameException, NullMoodException, NullLocationException {

        if (!validateName(name)){
            throw new InvalidNameException(name);
        }
        this.name = name;
        this.familyConnect = familyConnect;
        if (location == null){
            throw new NullLocationException(name);
        }
        this.location = location;
        if (mood == null){
            throw new NullMoodException(name);
        }
        this.mood = mood;
    }

    public Location getLocation() {return location;}

    public void setLocation(Location location) {this.location = location;}

    public String getName(){return name;}

    public abstract boolean canReact();

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
