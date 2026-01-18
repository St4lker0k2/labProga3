package Script;

import Characters.Human;

import java.util.HashMap;
import java.util.Map;

public class GameState {
    private final Map<String, Human> characters = new HashMap<>();
    public void addCharacter(Human person){
        characters.put(person.getName().toLowerCase(), person);}

    public Human getCharacter(String name){
        return characters.get(name.toLowerCase());
    }
}
