package it.polimi.model.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AllCommonGoalsCompletedExceptionTest {

    @Test
    public void testDefaultConstructor() {
        AllCommonGoalsCompletedException exception = new AllCommonGoalsCompletedException();
        assertNull(exception.getMessage());
    }

    @Test
    public void testMessageConstructor() {
        String errorMessage = "Test String";
        AllCommonGoalsCompletedException exception = new AllCommonGoalsCompletedException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}
