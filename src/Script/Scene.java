package Script;

import Characters.*;
import Locations.PlanLocation;

public record Scene(Mother mother, Uncle uncle, FrekenBok frekenBok, Betan betan, Bosse bosse) {
    public void scenario() { //Сценарные методы
        try {
            mother.decidePlans(PlanLocation.STEAMBOAT);
            bosse.decidePlans(PlanLocation.CHILDCAMP);
            betan.decidePlans(null);
            mother.call(uncle);
            mother.call(frekenBok);
        }catch (NullPointerException e){
            System.out.println("Параметры не могут принимать значение null");
        }
    }
}