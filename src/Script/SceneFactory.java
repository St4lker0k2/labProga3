package Script;

import Characters.*;
import Dialogues.Dialogue;
import Events.EventBus;
import Events.EventType;
import Locations.Location;
import Characters.Mood;

import java.util.ArrayList;
import java.util.List;

public final class SceneFactory {

    public static Scene create(GameState gameState){
        List<Human> listCharacters = new ArrayList<>();
        Mother mother = new Mother("мама", Location.MALYSHS_ROOM, "", Mood.GOOD);
        Father father = new Father("папа", Location.KITCHEN, "", Mood.GOOD);
        Malysh malysh = new Malysh("Малыш", Location.MALYSHS_ROOM, "меня", Mood.BAD);
        Carlson carlson = new Carlson("Карлсон", Location.MALYSHS_ROOM, "друг", Mood.BAD);
        Uncle uncle = new Uncle("Юлиус", null, "дядя", Mood.GOOD);
        FrekenBok frekenBok = new FrekenBok("Фрэкен Бок", Location.STREET, "присмотрщица", Mood.GOOD);
        Betan betan = new Betan("Бетан", Location.LIVING_ROOM, "брат", Mood.BAD);
        Bosse bosse = new Bosse("Боссе", Location.LIVING_ROOM, "сестра", Mood.GOOD);

        listCharacters.add(mother);
        listCharacters.add(father);
        listCharacters.add(malysh);
        listCharacters.add(carlson);
        listCharacters.add(uncle);
        listCharacters.add(betan);
        listCharacters.add(bosse);
        listCharacters.add(frekenBok);

        for (Human character : listCharacters){
            gameState.addCharacter(character);
        }

        System.out.println(Dialogue.setInterlocutors(malysh, carlson));
        EventBus.addReactor(EventType.CALL, malysh);
        EventBus.addReactor(EventType.PLANS, malysh);
        EventBus.addReactor(EventType.TALK, carlson);
        EventBus.addReactor(EventType.ESCAPE, malysh);

        return new Scene(mother, uncle, frekenBok, betan, bosse);
    }
}
