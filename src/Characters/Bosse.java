package Characters;
import Events.EventBus;
import Events.EventPlans;
import Locations.Location;
import Locations.PlanLocation;

public final class Bosse extends Human {
    public Bosse(String name, Location location, String familyConnect, Mood mood) {
        super(name, location, familyConnect, mood);}

    public void decidePlans(PlanLocation planLocation){
        EventBus.publish(new EventPlans(this, planLocation));}

    @Override
    public boolean canReact() {
        return false;
    }
}
