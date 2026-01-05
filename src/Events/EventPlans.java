package Events;
import Characters.Human;
import Locations.PlanLocation;

public class EventPlans extends Event {
    private final boolean solution;
    private final PlanLocation planLocation;

    public EventPlans(Human actor, PlanLocation planLocation,boolean solution){
        super(actor, EventType.PLANS);
        this.solution = solution;
        this.planLocation = planLocation;}

    @Override
    public void reactEvent(Human speaker) {
        if (isSolution()) {
            System.out.printf("мой(моя) %s %s уезжает в(на) %s\n",getActor().getFamilyConnect(), getActor().getName(), this.planLocation.getNameLocation());
        }else {
            System.out.printf("мой(моя) %s %s решил(а) остаться дома\n", getActor().getFamilyConnect(), getActor().getName());
        }}

    public boolean isSolution() {
        return solution;}
}

