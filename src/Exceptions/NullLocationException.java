package Exceptions;

public class NullLocationException extends RuntimeException {
    public NullLocationException(String name) {
        super("Локация персонажа "+name+" не может быть null");}
}
