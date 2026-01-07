package Characters;

import Events.EventBus;
import Events.EventPlans;
import Locations.Location;
import Locations.Mood;
import Locations.PlanLocation;

public final class Betan extends Human {
    private final PlanLocation planLocation;
    public Betan(String name, Location location, String familyConnect, Mood mood, PlanLocation planLocation) {
        super(name, location, familyConnect, mood);
        this.planLocation = planLocation;
    }

    public void decidePlans(){
        EventBus.publish(new EventPlans(this, planLocation));
    }
}
