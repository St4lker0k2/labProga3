package Events;
import Characters.Human;
import Dialogues.Dialogue;
import Locations.PlanLocation;

public final class EventPlans extends Event {
    private final PlanLocation planLocation;

    public EventPlans(Human actor, PlanLocation planLocation){
        super(actor, EventType.PLANS);
        this.planLocation = planLocation;}

    @Override
    public void reactEvent(Human speaker) {
        if (planLocation == PlanLocation.HOME) {
            System.out.printf("%s: %s, мой(моя) %s %s решил(а) остаться дома\n", speaker.getName(), Dialogue.getInterlocutor(speaker).getName(), getActor().getFamilyConnect(), getActor().getName());
        }else {
            System.out.printf("%s: Послушай, %s, мой(моя) %s %s уезжает в(на) %s\n", speaker.getName(), Dialogue.getInterlocutor(speaker).getName(), getActor().getFamilyConnect(), getActor().getName(), this.planLocation.getNameLocation());
        }}
}