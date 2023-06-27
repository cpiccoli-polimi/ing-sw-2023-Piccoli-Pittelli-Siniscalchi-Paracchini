package it.polimi.controller.exception;

public class AlreadyPickedException extends Exception{
    public AlreadyPickedException(){super("You have chosen the same object tile more than once");}
}
