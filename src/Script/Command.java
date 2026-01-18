package Script;

public interface Command {
    String execute(String[] args, GameState state);
}
