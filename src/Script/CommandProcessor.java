package Script;

import java.util.HashMap;
import java.util.Map;

public final class CommandProcessor {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandProcessor(){
        commands.put("set", new SetCommand());
        commands.put("get", new GetCommand());
        commands.put("help", new HelpCommand(commands));
    }
    public String process(String input, GameState state){
        String[] parts = input.split("\\s+");
        Command command = commands.get(parts[0]);
        if (command != null){
            return command.execute(parts, state);
        }else{
            return ("Неизвестная команда");
        }
    }
}
