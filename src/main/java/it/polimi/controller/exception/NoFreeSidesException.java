package it.polimi.controller.exception;

public class NoFreeSidesException extends Exception{
    public NoFreeSidesException(){super("All the tiles you choose must have at least one side free (not touching directly any other tile)");}
}
