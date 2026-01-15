package Events;

import Characters.Human;
import Dialogues.Dialogue;
import Locations.Location;
import Characters.Mood;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public final class EventTalk extends Event {
    private final Map<KeysTalk, Consumer<Human>> actions = new HashMap<>();
    private final Mood reactSpeaker;

    public EventTalk(Human actor, Mood reactSpeaker) {
        super(actor, EventType.TALK);
        this.reactSpeaker = reactSpeaker;
        actions.put(new KeysTalk(Mood.GOOD, Mood.GOOD), this::rejoice);
        actions.put(new KeysTalk(Mood.BAD, Mood.GOOD), this::cheerUp);
        actions.put(new KeysTalk(Mood.GOOD, Mood.BAD), this::flyAway);
        actions.put(new KeysTalk(Mood.BAD, Mood.BAD), this::escape);
    }

    @Override
    public void reactEvent(Human speaker) {
        Consumer<Human> actoin = actions.getOrDefault(new KeysTalk(reactSpeaker, speaker.getMood()), null);
        actoin.accept(speaker);
    }

    private void flyAway(Human speaker){
        System.out.printf("%s: ЧТО!? Вы хотите меня заменить новой присмотрщицей? Так ты ещё" +
                " и радуешься этому! Нашей дружбе конец! Если мне тут не рады, я улетаю. Прощайте!\n", speaker.getName());
        System.out.printf("*%s вылетел в окно и умчался прочь*\n", speaker.getName());
        speaker.setLocation(Location.ROOF);
        Dialogue.disconnect();
    }

    private void cheerUp(Human speaker) {
        System.out.printf("%s: Ну-ну, %s, не переживай. Уверен, новая присмотрщица - " +
                "хороший и добрый человек. Мы с ней обязательно подружимся\n", speaker.getName(), Dialogue.getInterlocutor(speaker).getName());
    }

    private void escape(Human speaker){
        System.out.printf("%s: Послушай, %s. Если всё так плохо, мы можем улететь с тобой из дома, " +
                "отправиться на поиски приключений, путешествовать по всему миру\n", speaker.getName(), Dialogue.getInterlocutor(speaker).getName());
        EventBus.publish(new EventEscape(null));
    }

    private void rejoice(Human speaker) {
        System.out.printf("%s: Ого! Как это классно! Я тоже рад приезду новой присмотрщицы. Вместе мы будем веселиться и играть день и ночи " +
                "Какая это хорошая новость, мой друг", speaker.getName());
    }
}
