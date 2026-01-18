package Events;

import Characters.Human;
import Dialogues.Dialogue;
import Locations.Location;

public final class EventEscape extends Event{
    EventEscape(Human actor) {
        super(actor, EventType.ESCAPE);
    }

    @Override
    public void reactEvent(Human speaker) {
        if (Math.random()<0.35) {
            speaker.setLocation(Location.STREET);
            Dialogue.getInterlocutor(speaker).setLocation(Location.STREET);
            System.out.printf("""
                    %s: Хорошо, %s, я согласен. Давай сбежим
                    *Малыш и Карлсон вылетели через окно на улицу и отправились \
                    куда глаза глядят
                    """, speaker.getName(), Dialogue.getInterlocutor(speaker).getName());
        }else {
            System.out.printf("%s: Нет, это неправильно! Я останусь дома и встречу новую домохозяйку\n", speaker.getName());}
    }
}
