package it.polimi.controller.exception;

public class EmptyMessageException extends Exception{
    public EmptyMessageException() {
        super("You can't send an empty message");
    }
}
