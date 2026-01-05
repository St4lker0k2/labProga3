package Events;

import Characters.Human;
import Dialogues.Dialogue;
import Locations.Location;

public class EventEscape extends Event{
    protected EventEscape(Human actor) {
        super(actor, EventType.ESCAPE);
    }

    @Override
    public void reactEvent(Human speaker) {
        if (Math.random()<0.35) {
            System.out.printf("%s: Хорошо, %s, я согласен. Давай сбежим\n", speaker.getName(), Dialogue.getInterlocutor(speaker).getName());
            speaker.setLocation(Location.STREET);
            Dialogue.getInterlocutor(speaker).setLocation(Location.STREET);
            System.out.println("*Малыш и Карлсон вылетели через окно на улицу и отправились куда глаза глядят");
        }else {
            System.out.printf("%s: Нет, это неправильно! Я останусь дома и встречу новую домохоязйку\n", speaker.getName());
        }
    }
}
