package Characters;
import Events.EventBus;
import Events.EventCall;
import Events.EventPlans;
import Locations.Location;
import Locations.Mood;
import Locations.PlanLocation;

public final class Mother extends Human {
    private final PlanLocation planLocation;
    public Mother(String name, Location location, String familyConnect, Mood mood, PlanLocation planLocation){
        super(name, location, familyConnect, mood);
        this.planLocation = planLocation;
    }

    public void decidePlans(){
        EventBus.publish(new EventPlans(this, planLocation));
    }

    public void call(Human person){
        person.setLocation(this.getLocation());
        EventBus.publish(new EventCall(person));
    }
}