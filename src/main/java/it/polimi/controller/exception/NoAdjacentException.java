package it.polimi.controller.exception;

public class NoAdjacentException extends Exception {
    public NoAdjacentException(){super("The object cards you chose aren't adjacent to each other");}
}
