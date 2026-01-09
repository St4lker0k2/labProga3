package Exceptions;

public class InvalidNameException extends RuntimeException {
    private final String name;
    public InvalidNameException(String name) {
        this.name = name;
    }
    @Override
    public String getMessage(){
        return "Имя объекта содержит не только буквы: "+name;
    }
}
