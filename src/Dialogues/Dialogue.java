package Dialogues;

import Characters.Human;

public abstract class Dialogue {
    private static Human firstInterlocutor;
    private static Human secondInterlocutor;

    public static void setInterlocutors(Human interlocutor1, Human interlocutor2){
        if (interlocutor1.getLocation() == interlocutor2.getLocation()) {
            if (interlocutor1 instanceof DialogueReactor || interlocutor2 instanceof DialogueReactor) {
                firstInterlocutor = interlocutor1;
                secondInterlocutor = interlocutor2;
            }else {
                System.out.println("Один из персонажей не сможет отрегировать на слова другого персонажа");
            }
        }
        else{
            System.out.println("Эти два персонажа не могут вести диалог, так как находятся в разных локациях");
        }
    }
    public static Human getInterlocutor(Human interlocutor){
        if (firstInterlocutor == interlocutor){
            return secondInterlocutor;
        }else {return firstInterlocutor;}
    }

    public static void disconnect(Human interlocutor){
        if (interlocutor == firstInterlocutor){
            firstInterlocutor = null;
        }else {
            secondInterlocutor = null;
        }
    }
}
