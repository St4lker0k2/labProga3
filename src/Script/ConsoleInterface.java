package Script;

import java.util.List;
import java.util.Scanner;

public record ConsoleInterface(Scanner scanner, CommandProcessor commandProcessor) {

    public void run(List<Runnable> steps, GameState state) {
        for (Runnable step : steps) {
            System.out.println("\nВведите команды (воспользуйтесь командой help для вывода списка доступных команд)\nили введите 'continue' для продолжения сюжета");
            while (true) {
                System.out.println("> ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("continue")) {
                    break;
                }
                System.out.println(commandProcessor.process(input, state));
            }
            step.run();
        }
    }
}
