package it.polimi.controller.exception;

public class DifferentLengthException extends Exception {
    public DifferentLengthException(){super("You have to order haven't ordered all the object cards you chose");}
}
