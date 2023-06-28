package it.polimi.controller.exception;

public class NoStraightLineException extends Exception {
    public NoStraightLineException(){super("The object cards you chose don't form a straight line");}

}
