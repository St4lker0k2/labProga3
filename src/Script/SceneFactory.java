package Script;

import Characters.*;
import Dialogues.Dialogue;
import Events.EventBus;
import Events.EventType;
import Locations.Location;
import Characters.Mood;

public final class SceneFactory {
    public static Scene create(){
        Mother mother = new Mother("мама", Location.MALYSHS_ROOM, "", Mood.GOOD);
        Father father = new Father("папа", Location.KITCHEN, "", Mood.GOOD);
        Malysh malysh = new Malysh("Малыш", Location.MALYSHS_ROOM, "меня", Mood.GOOD);
        Carlson carlson = new Carlson("Карлсон", Location.MALYSHS_ROOM, "друг", Mood.BAD);
        Uncle uncle = new Uncle("Юлиус", Location.UNCLE_HOUSE, "дядя", Mood.GOOD);
        FrekenBok frekenBok = new FrekenBok("Фрэкен Бок", Location.STREET, "присмотрщица", Mood.GOOD);
        Betan betan = new Betan("Бетан", Location.LIVING_ROOM, "брат", Mood.BAD);
        Bosse bosse = new Bosse("Боссе", Location.LIVING_ROOM, "сестра", Mood.GOOD);

        System.out.println(Dialogue.setInterlocutors(malysh, carlson));
        EventBus.addReactor(EventType.CALL, malysh);
        EventBus.addReactor(EventType.PLANS, malysh);
        EventBus.addReactor(EventType.TALK, carlson);
        EventBus.addReactor(EventType.ESCAPE, malysh, carlson);

        return new Scene(mother, uncle, frekenBok, betan, bosse);
    }
}
