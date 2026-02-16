package Script;

import Characters.Human;

public class GetCommand implements Command{
    @Override
    public String execute(String[] args, GameState state) {
        if (args.length != 3){
            return("Команда распознана, но принимает недостаточное кол-во параметров");}
        Human character = state.getCharacter(args[1]);
        if (character == null){
            return("Персонаж не найден");
        }
        String field = args[2];
        switch (field) {
            case "mood" -> {return character.getMood().toString();
            }
            case "location" -> {return character.getLocation().getNameLocation();
            }
            case "familyconnect" -> {return character.getFamilyConnect();}
            case "name" -> {return "вы шутите, да?";}
            default -> {return ("Команда распознана, персонаж найден, но введённое " +
                    "поле у персонажа не обнаружено или не может быть изменено или у вас нет доступа к этому параметру");}}
    }

    @Override
    public String describe() {
        return "Вид команды: get <name> <name field>\nОписание: выведет значение поля у персонажа";
    }
}
