package it.polimi.controller.exception;

public class NotYourTurnException extends Exception{
    public NotYourTurnException(){super("Now it's not your turn\nPlease wait your turn");}
}
