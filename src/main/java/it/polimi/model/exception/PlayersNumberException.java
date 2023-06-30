package it.polimi.model.exception;

/**
 * Exception if PlayersNumber is wrong
 *
 * @author Nicola Siniscalchi
 */
public class PlayersNumberException extends Exception{
    public PlayersNumberException() {
        super("Wrong players number");
    }
}
