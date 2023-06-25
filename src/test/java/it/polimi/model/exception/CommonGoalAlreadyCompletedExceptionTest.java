package it.polimi.model.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommonGoalAlreadyCompletedExceptionTest {

    @Test
    public void testDefaultConstructor() {
        CommonGoalAlreadyCompletedException exception = new CommonGoalAlreadyCompletedException();
        assertNull(exception.getMessage());
    }

    @Test
    public void testMessageConstructor() {
        String errorMessage = "Test String";
        CommonGoalAlreadyCompletedException exception = new CommonGoalAlreadyCompletedException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}
