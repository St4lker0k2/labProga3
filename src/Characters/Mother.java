package Characters;
import Events.EventBus;
import Events.EventCall;
import Events.EventPlans;
import Locations.Location;
import Locations.Mood;
import Locations.PlanLocation;

public final class Mother extends Human {
    public Mother(String name, Location location, String familyConnect, Mood mood){
        super(name, location, familyConnect, mood);
    }

    public void decidePlans(){
        EventBus.publish(new EventPlans(this, PlanLocation.STEAMBOAT,Math.random()<0.3));
    }

    public void call(Human person){
        person.setLocation(this.getLocation());
        EventBus.publish(new EventCall(person));
    }
}