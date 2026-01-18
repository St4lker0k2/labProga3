package Script;

import Characters.Human;
import Characters.Mood;
import Locations.Location;

public class SetCommand implements Command{
    @Override
    public String execute(String[] args, GameState state) {
        if (args.length < 4){
            return("Использование команды: set <name> <field> <value>");
        }
        Human character = state.getCharacter(args[1]);
        if (character == null){
            return("Персонаж не найден");
        }
        String field = args[2];
        String value = args[3];
        try {
            switch (field) {
                case "mood" -> {
                    character.setMood(Mood.valueOf(value.toUpperCase()));
                    return String.format("Настроение %s успешно изменено на %s", character.getName(), value);
                }
                case "location" -> {
                    character.setLocation(Location.valueOf(value.toUpperCase()));
                    return String.format("Позиция %s успешно изменено на %s", character.getName(), value);
                }
                default -> {return ("Нераспознанная команда");}}
        }catch (IllegalArgumentException e){
            return ("Несуществующее значение");
        }
    }
}
