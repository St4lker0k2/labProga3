package Events;

import Characters.FrekenBok;
import Characters.Human;
import Characters.Uncle;
import Dialogues.Dialogue;
import Characters.Mood;

import java.util.HashMap;
import java.util.function.Consumer;

public final class EventCall extends Event{
    private final HashMap<Class<? extends Human>, Consumer<Human>> actions = new HashMap<>();

    public EventCall(Human actor) {
        super(actor, EventType.CALL);
        actions.put(Uncle.class, this::reactUncleCall);
        actions.put(FrekenBok.class, this::reactCaretakerCall);
    }

    private void reactUncleCall(Human speaker){
        String text = String.format("%s: Кажется, мама пригласила домой %s %s. ", speaker.getName(), getActor().getFamilyConnect(), getActor().getName()) + switch (getActor().getMood()){
            case Mood.GOOD -> "Я так рад его приезду. Он такой добрый и весёлый";
            case Mood.BAD -> "Снова придётся терпеть его ворчание и крики";};
        System.out.println(text);
    }

    private void reactCaretakerCall(Human speaker){
        System.out.println(String.format("%s: Послушай, %s, моя мама вызвала новую присмотрщицу - %s. ", speaker.getName(), Dialogue.getInterlocutor(speaker).getName(), getActor().getName())
                + switch (speaker.getMood()){
            case Mood.GOOD -> "Жду не дождусь встречи с ней! Уверен, мы подружимся";
            case Mood.BAD -> "Я так не хочу, чтобы она приезжала. Мне кажется, что она нехороший человек";});

        EventBus.publish(new EventTalk(getActor(), speaker.getMood()));
    }

    private void reactDefault(Human speaker){
        System.out.printf("%s: Мама позвала к себе %s %s\n", speaker.getName(), getActor().getFamilyConnect(), getActor().getName());
    }

    @Override
    public void reactEvent(Human speaker) {
        Consumer<Human> action = actions.getOrDefault(getActor().getClass(), this::reactDefault);
        action.accept(speaker);
    }
}
