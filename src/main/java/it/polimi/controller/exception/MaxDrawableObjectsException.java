package it.polimi.controller.exception;

public class MaxDrawableObjectsException extends Exception{
    public MaxDrawableObjectsException(){super("You don't have enough space in any of your bookshelf's columns to insert all the object cards you chose");}
}
