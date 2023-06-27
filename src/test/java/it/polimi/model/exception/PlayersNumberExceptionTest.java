package it.polimi.model.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayersNumberExceptionTest {

    @Test
    public void testDefaultConstructor() {
        String errorMessage = "Wrong players number";
        PlayersNumberException exception = new PlayersNumberException();
        assertEquals(errorMessage, exception.getMessage());
    }
}
