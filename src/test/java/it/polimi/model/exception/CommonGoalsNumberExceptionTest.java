package it.polimi.model.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommonGoalsNumberExceptionTest {

    @Test
    public void testDefaultConstructor() {
        CommonGoalsNumberException exception = new CommonGoalsNumberException();
        assertNull(exception.getMessage());
    }

    @Test
    public void testMessageConstructor() {
        String errorMessage = "Test String";
        CommonGoalsNumberException exception = new CommonGoalsNumberException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}
