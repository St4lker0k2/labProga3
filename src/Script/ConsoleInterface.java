package Script;

import java.util.List;
import java.util.Scanner;

public record ConsoleInterface(Scanner scanner, CommandProcessor commandProcessor) {

    public void run(List<Runnable> steps, GameState state) {
        for (Runnable step : steps) {
            System.out.println("Введите команды или 'continue'");
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
