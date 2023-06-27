package it.polimi.model.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommonGoalsNumberExceptionTest {

    @Test
    public void testDefaultConstructor() {
        String errorMessage = "Wrong common goals number";
        CommonGoalsNumberException exception = new CommonGoalsNumberException();
        assertEquals(errorMessage, exception.getMessage());
    }
}
