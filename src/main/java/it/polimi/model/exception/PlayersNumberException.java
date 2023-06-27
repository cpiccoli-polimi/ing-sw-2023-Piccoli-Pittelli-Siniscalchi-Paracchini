package it.polimi.model.exception;

public class PlayersNumberException extends Exception{
    public PlayersNumberException() {
        super("Wrong players number");
    }
}
