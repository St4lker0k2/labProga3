package Events;

import Dialogues.Reactor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class EventBus {
    private static final Map<EventType, ArrayList<Reactor>> subs = new HashMap<>();

    public static void addReactor(EventType eventType, Reactor... reactors) {
        for (Reactor reactor : reactors) {
            subs.computeIfAbsent(eventType, e -> new ArrayList<>()).add(reactor);}
    }
    public static void publish(Event event){
        EventLog.addEvent(event);
        List<Reactor> list = subs.get(event.getEventType());
        if (list == null) return;
        for (Reactor reactor : list) reactor.react(event);}

        //Промпт: Привет! Помоги реализовать на языке Java методу класса EventBus, который будет
        // принимать созданные в программе события типа Event, сохранять их в список, затем вызывать
        // реакцию у тех объектов, которые на него "подписаны", т.е. могут и должны на него реагировать

        //ChatGPT:
        /* Публикация события
        public void publish(Event event) {
            // сохраняем событие
            eventHistory.add(event);

            // уведомляем подписчиков
            List<EventListener<? extends Event>> eventListeners =
                    listeners.get(event.getClass());

            if (eventListeners != null) {
                for (EventListener listener : eventListeners) {
                    // безопасное приведение
                    listener.onEvent(event);
                }
            }

        DeepSeek:
        public void publish(Event event) {
        // Сохраняем событие в историю
        eventHistory.add(event);

        // Получаем тип события
        Class<? extends Event> eventType = event.getClass();

        // Находим всех подписчиков для этого типа события
        List<EventListener<?>> listeners = subscribers.get(eventType);

        if (listeners != null && !listeners.isEmpty()) {
            // Вызываем обработчики у всех подписчиков
            for (EventListener<?> listener : listeners) {
                // Безопасный вызов благодаря проверке типов при подписке
                @SuppressWarnings("unchecked")
                EventListener<Event> typedListener = (EventListener<Event>) listener;
                typedListener.handle(event);
            }
        } else {
            System.out.println("Нет подписчиков для события типа: " + eventType.getSimpleName());
        }
    }*/
}