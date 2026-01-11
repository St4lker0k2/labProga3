package Exceptions;

public class NullMoodException extends RuntimeException {
    public NullMoodException(String name) {
        super("Ошибка: персонаж "+name+" не может иметь mood=null");
    }
}
