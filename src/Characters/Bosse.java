package Characters;
import Events.EventBus;
import Events.EventPlans;
import Locations.Location;
import Locations.Mood;
import Locations.PlanLocation;

public final class Bosse extends Human {
    public Bosse(String name, Location location, String familyConnect, Mood mood) {
        super(name, location, familyConnect, mood);
    }
    public void decidePlans(){
        EventBus.publish(new EventPlans(this, PlanLocation.CHILDCAMP,Math.random()<0.2));}
}
