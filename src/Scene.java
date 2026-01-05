import Characters.*;
import Events.EventBus;
import Events.EventType;
import Dialogues.Dialogue;
import Locations.Location;
import Locations.Mood;

public class Scene {
    private final Mother mother;
    private final FrekenBok frekenBok;
    private final Father father;
    private final Bosse bosse;
    private final Betan betan;
    private final Uncle uncle;

    public static void main(String[] args) {
        Scene scene = new Scene();
        scene.scenario();}

    public void scenario(){ //Сценарные методы
        mother.decidePlans();
        bosse.decidePlans();
        betan.decidePlans();
        mother.call(father);
        mother.call(uncle);
        mother.call(frekenBok);
    }
    public Scene(){
        Malysh malysh = new Malysh("Малыш", Location.MALYSHS_ROOM, "", Mood.BAD);
        this.mother = new Mother("мама", Location.MALYSHS_ROOM, "", null);
        this.father = new Father("папа", Location.KITCHEN, "", null);
        Carlson carlson = new Carlson("Карлсон", Location.MALYSHS_ROOM, "друг", Mood.BAD);
        this.uncle = new Uncle("Юлиус", null, "дядя", Mood.BAD);
        this.frekenBok = new FrekenBok("Фрэкен Бок", null, "присмотрщица", null);
        this.betan = new Betan("Бетан", Location.LIVING_ROOM, "брат", null);
        this.bosse = new Bosse("Боссе", Location.LIVING_ROOM, "сестра", null);

        Dialogue.setInterlocutors(malysh, carlson);
        EventBus.addReactor(EventType.CALL, malysh);
        EventBus.addReactor(EventType.PLANS, malysh);
        EventBus.addReactor(EventType.TALK, carlson);
        EventBus.addReactor(EventType.ESCAPE, malysh, carlson);
    }
}