package it.polimi.model.exception;

/**
 * Exception if CommonGoalsNumber is wrong
 *
 * @author Nicola Siniscalchi
 */
public class CommonGoalsNumberException extends Exception{
    public CommonGoalsNumberException() {
        super("Wrong common goals number");
    }
}
