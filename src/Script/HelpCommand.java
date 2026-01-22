package Script;

import java.util.Map;

public final class HelpCommand implements Command{
    private final Map<String, Command> commandMemory;
    public HelpCommand(Map<String, Command> commands) {
        this.commandMemory = commands;
    }

    @Override
    public String execute(String[] args, GameState state) {
        StringBuilder text = new StringBuilder();
        if (args.length == 1){
            text.append("Список доступных команд:\n");
            for (Map.Entry<String, Command> entry : commandMemory.entrySet()){
                text.append(String.format("%s: %s\n", entry.getKey(), entry.getValue().describe()));
            }
            return text.toString();
        }
        if (args.length == 2){
            if (commandMemory.get(args[1]) == null){
                return errorName();
            }
            text.append(commandMemory.get(args[1]).describe());
        }else {
            text.append(errorName());
        }
        return text.toString();
    }

    @Override
    public String describe() {
        return "Вид команды: help <название команды>\nОписание: выведет описание введённой команды";
    }
}
