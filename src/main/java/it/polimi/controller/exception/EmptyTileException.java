package it.polimi.controller.exception;

public class EmptyTileException extends NullPointerException {
    public EmptyTileException(){
        super("You have selected a board tile that doesn't contain any object card");

    }
}
