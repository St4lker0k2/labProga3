package Script;

import Characters.*;
import Locations.PlanLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public record Scene(Mother mother, Uncle uncle, FrekenBok frekenBok, Betan betan, Bosse bosse) {

    public void scenario(GameState gameState) { //Сценарные методы
        List<Runnable> listActions = new ArrayList<>();
        try {
            listActions.add(() -> mother.decidePlans(PlanLocation.STEAMBOAT));
            listActions.add(() -> bosse.decidePlans(PlanLocation.CHILDCAMP));
            listActions.add(() -> betan.decidePlans(PlanLocation.HOME));
            listActions.add(() -> mother.call(uncle));
            listActions.add(() -> mother.call(frekenBok));

            CommandProcessor commandProcessor = new CommandProcessor();
            ConsoleInterface consoleInterface = new ConsoleInterface(new Scanner(System.in), commandProcessor);
            consoleInterface.run(listActions, gameState);

        }catch (NullPointerException e){
            System.out.println("Параметры не могут принимать значение null");
        }
    }
}