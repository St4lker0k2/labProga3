package Characters;
import Events.EventBus;
import Events.EventPlans;
import Locations.Location;
import Locations.Mood;
import Locations.PlanLocation;

public final class Bosse extends Human {
    private final PlanLocation planLocation;
    public Bosse(String name, Location location, String familyConnect, Mood mood, PlanLocation planLocation) {
        super(name, location, familyConnect, mood);
        this.planLocation = planLocation;
    }
    public void decidePlans(){
        EventBus.publish(new EventPlans(this, planLocation));}

    @Override
    public boolean canReact() {
        return false;
    }
}
