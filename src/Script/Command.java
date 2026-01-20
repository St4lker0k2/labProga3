package Script;

public interface Command {
    String execute(String[] args, GameState state);
    String describe();
    default String errorName(){
        return "Нераспознана команда: неправильно введено название команды | команда отсутствует\nВоспользуйтесь командой help";}
}
