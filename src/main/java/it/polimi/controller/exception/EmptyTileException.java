package it.polimi.controller.exception;

public class EmptyTileException extends NullPointerException {
    @Override
    public String getMessage(){
        return "Choose another tile";

    }
}
