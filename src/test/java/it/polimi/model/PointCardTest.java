package it.polimi.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PointCardTest {
    @Test
    public void testGetValue() {
        PointCard card = new PointCard(Value.four, RomanNumeral.II);
        assertEquals(Value.four, card.getValue());
    }
    @Test
    public void testGetBackNumber() {
        PointCard card = new PointCard(Value.six, RomanNumeral.I);
        assertEquals(RomanNumeral.I, card.getBackNumber());
    }
    @Test
    public void testConstructor() {
        PointCard card = new PointCard(Value.two, RomanNumeral.I);
        assertEquals(Value.two, card.getValue());
        assertEquals(RomanNumeral.I, card.getBackNumber());
    }

}
