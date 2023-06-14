package it.polimi.controller.exception;

public class OutOfBookshelfException extends IndexOutOfBoundsException {
    @Override
    public String getMessage(){
        return "In which bookshelf column do you want to insert those cards?";
    }
}
