package Events;

import Characters.Human;
import Dialogues.Dialogue;
import Locations.Mood;
import Locations.PlanLocation;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class EventPlans extends Event {
    private final Map<KeysPlans, Supplier<String>> reacts = new HashMap<>();
    private final PlanLocation planLocation;

    public EventPlans(Human actor, PlanLocation planLocation){
        super(actor, EventType.PLANS);
        this.planLocation = planLocation;
        reacts.put(new KeysPlans(PlanLocation.HOME, Mood.GOOD), this::enjoyStayHome);
        reacts.put(new KeysPlans(PlanLocation.HOME, Mood.BAD), this::sadStayHome);
    }

    @Override
    public void reactEvent(Human speaker) {
        Supplier<String> action = reacts.getOrDefault(new KeysPlans(planLocation, getActor().getMood()), this::reactCounty);
        System.out.printf("%s: %s, %s\n", speaker.getName(), Dialogue.getInterlocutor(speaker).getName(), action.get());
    }
    private String sadStayHome(){
        return String.format("к сожалению, %s %s этим летом останется дома. Я так расстроен :(", getActor().getFamilyConnect(), getActor().getName());}

    private String enjoyStayHome(){
        return String.format("у меня хорошая новость: мой(моя) любимый(ая) %s %s останется этим летом дома! Мы будем все вместе играть!", getActor().getFamilyConnect(), getActor().getName());
    }
    private String reactCounty(){
        return String.format("кажется, мой(моя) %s %s планирует уехать в(на) %s. ", getActor().getFamilyConnect(), getActor().getName(), planLocation.getNameLocation())
                + switch (getActor().getMood()){
            case Mood.GOOD -> "Это так печально. Я бы хотел провести больше времени с ним(ней)";
            case Mood.BAD -> "Наконец-то я смогу от него(неё) отдохнуть. Ура!";};
    }
}