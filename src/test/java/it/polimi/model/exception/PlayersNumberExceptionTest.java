package it.polimi.model.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayersNumberExceptionTest {

    @Test
    public void testDefaultConstructor() {
        PlayersNumberException exception = new PlayersNumberException();
        assertNull(exception.getMessage());
    }

    @Test
    public void testMessageConstructor() {
        String errorMessage = "Test String";
        PlayersNumberException exception = new PlayersNumberException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}
