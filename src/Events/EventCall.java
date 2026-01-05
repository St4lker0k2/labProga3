package Events;

import Characters.FrekenBok;
import Characters.Human;
import Characters.Uncle;
import Dialogues.Dialogue;
import Locations.Mood;

import java.util.HashMap;
import java.util.function.Consumer;

public class EventCall extends Event{
    private final HashMap<Class, Consumer<Human>> actions = new HashMap<>();

    public EventCall(Human actor) {
        super(actor, EventType.CALL);
        actions.put(Uncle.class, this::reactUncleCall);
        actions.put(FrekenBok.class, this::reactCaretakerCall);
    }

    private void reactUncleCall(Human speaker){
        System.out.printf("%s: Кажется, мама пригласила домой %s %s. %s\n", speaker.getName(), getActor().getFamilyConnect(), getActor().getName(),
                (getActor().getMood() == Mood.GOOD?"Я так рад его приезду. Он такой добрый и весёлый"
                        :"Снова придётся терпеть его ворчание и крики"));
    }

    private void reactCaretakerCall(Human speaker){
        System.out.printf("%s: Послушай, %s, моя мама вызвала новую присмотрщицу - %s. %s\n"
                , speaker.getName(), Dialogue.getInterlocutor(speaker).getName(), getActor().getName(), (speaker.getMood() == Mood.GOOD?"Жду не дождусь встречи с ней! Уверен, мы подружимся"
                        :"Я так не хочу, чтобы она приезжала. Мне кажется, что она нехороший человек"));
        EventBus.publish(new EventTalk(getActor(), speaker.getMood()));
    }

    private void reactDefault(Human speaker){
        System.out.printf("%s: Мама позвала к себе %s %s", speaker.getName(), getActor().getFamilyConnect(), getActor().getName());
    }

    @Override
    public void reactEvent(Human speaker) {
        Consumer<Human> action = actions.getOrDefault(getActor().getClass(), this::reactDefault);
        action.accept(speaker);
    }
}
