package Script;

import Exceptions.InvalidNameException;
import Exceptions.NullLocationException;
import Exceptions.NullMoodException;

public final class App {
    public static void main(String[] args) {
        try {
            GameState gameState = new GameState();
            Scene scene = SceneFactory.create(gameState);
            scene.scenario(gameState);
        } catch (InvalidNameException | NullLocationException | NullMoodException e) {
            System.out.println("Ошибка при создании персонажа: ");
            System.out.println(e.getMessage());
        }
    }
}