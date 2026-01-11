package Dialogues;

import Characters.Human;

public final class Dialogue {
    private static Human firstInterlocutor;
    private static Human secondInterlocutor;

    public static void setInterlocutors(Human interlocutor1, Human interlocutor2){
        if (interlocutor1.getLocation() == interlocutor2.getLocation()) {
            if (interlocutor1 != interlocutor2) {
                if (interlocutor1.canReact() && interlocutor2.canReact()) {
                    firstInterlocutor = interlocutor1;
                    secondInterlocutor = interlocutor2;
                } else {
                    System.out.println("Один из персонажей не сможет отрегировать на слова другого персонажа");
                }
            }else {
                System.out.println("Персонаж не будет разговаривать сам с собой");}
        }
        else{
            System.out.println("Эти два персонажа не могут вести диалог, так как находятся в разных локациях");}
    }

    public static Human getInterlocutor(Human interlocutor){
        if (firstInterlocutor == interlocutor){
            return secondInterlocutor;
        }else {return firstInterlocutor;}
    }

    public static void disconnect(){
        firstInterlocutor = null;
        secondInterlocutor = null;
    }
}
