package Dialogues;

import Characters.Human;

public final class Dialogue {
    private static Human firstInterlocutor;
    private static Human secondInterlocutor;

    public static String setInterlocutors(Human interlocutor1, Human interlocutor2){
        if (interlocutor1.getLocation() == interlocutor2.getLocation()) {
            if (interlocutor1 != interlocutor2) {
                if (interlocutor1.canReact() && interlocutor2.canReact()) {
                    firstInterlocutor = interlocutor1;
                    secondInterlocutor = interlocutor2;
                    return String.format("%s и %s начали диалог\n", interlocutor1.getName(), interlocutor2.getName());
                } else {
                    return ("Один из персонажей не сможет отрегировать на слова другого персонажа");
                }
            }else {
                return ("Персонаж не будет разговаривать сам с собой");}
        }
        else{
            return ("Эти два персонажа не могут вести диалог, так как находятся в разных локациях");}
    }

    public static Human getInterlocutor(Human interlocutor){
        if (firstInterlocutor == interlocutor){
            return secondInterlocutor;
        }else {return firstInterlocutor;}
    }

    public static void disconnect(){
        firstInterlocutor = null;
        secondInterlocutor = null;
        System.out.println("Персонажи больше не смогут слушать друг друга");
    }
}
