package Script;

import Characters.*;

public record Scene(Mother mother, Uncle uncle, FrekenBok frekenBok, Betan betan, Bosse bosse) {
    public void scenario() { //Сценарные методы
        mother.decidePlans();
        bosse.decidePlans();
        betan.decidePlans();
        mother.call(uncle);
        mother.call(frekenBok);
    }
}