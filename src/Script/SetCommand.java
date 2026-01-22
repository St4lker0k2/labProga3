package Script;

import Characters.Human;
import Characters.Mood;
import Locations.Location;

public final class SetCommand implements Command{
    @Override
    public String execute(String[] args, GameState state) {
        if (args.length != 4){
            return("Команда распознана, но принимает недостаточное кол-во параметров");
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
                default -> {return ("Команда распознана, персонаж найден, но введённое поле у персонажа не обнаружено или не может быть изменено");}}
        }catch (IllegalArgumentException e){
            return ("Несуществующее значение");
        }
    }

    @Override
    public String describe() {
        return "Вид команды: set <name> <field> <value>\nОписание: заменит поле field у персонажа name на значение value";
    }
}
