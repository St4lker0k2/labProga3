package Events;
import Characters.Human;
import Locations.PlanLocation;

public class EventPlans extends Event {
    private final PlanLocation planLocation;

    public EventPlans(Human actor, PlanLocation planLocation){
        super(actor, EventType.PLANS);
        this.planLocation = planLocation;}

    @Override
    public void reactEvent(Human speaker) {
        if (planLocation == PlanLocation.HOME) {
            System.out.printf("%s: Мой(моя) %s %s решил(а) остаться дома\n", speaker.getName(), getActor().getFamilyConnect(), getActor().getName());
        }else {
            System.out.printf("%s: Мой(моя) %s %s уезжает в(на) %s\n", speaker.getName(), getActor().getFamilyConnect(), getActor().getName(), this.planLocation.getNameLocation());
        }}
}

