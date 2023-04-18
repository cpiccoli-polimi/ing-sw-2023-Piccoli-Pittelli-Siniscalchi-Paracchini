package it.polimi.model;

import it.polimi.model.CommonGoalCards.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCardTest {
    @Test
    void EmptyBookshelf(){
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard1 cm1 = new CommonGoalCard1(4);
        assertFalse(cm1.check(bookshelf));
        CommonGoalCard2 cm2 = new CommonGoalCard2(4);
        assertFalse(cm2.check(bookshelf));
        CommonGoalCard3 cm3 = new CommonGoalCard3(4);
        assertFalse(cm3.check(bookshelf));
        CommonGoalCard4 cm4 = new CommonGoalCard4(4);
        assertFalse(cm4.check(bookshelf));
        CommonGoalCard5 cm5 = new CommonGoalCard5(4);
        assertFalse(cm5.check(bookshelf));
        CommonGoalCard6 cm6 = new CommonGoalCard6(4);
        assertFalse(cm6.check(bookshelf));
        CommonGoalCard7 cm7 = new CommonGoalCard7(4);
        assertFalse(cm7.check(bookshelf));
        CommonGoalCard8 cm8 = new CommonGoalCard8(4);
        assertFalse(cm8.check(bookshelf));
        CommonGoalCard9 cm9 = new CommonGoalCard9(4);
        assertFalse(cm9.check(bookshelf));
        CommonGoalCard10 cm10 = new CommonGoalCard10(4);
        assertFalse(cm10.check(bookshelf));
        CommonGoalCard11 cm11 = new CommonGoalCard11(4);
        assertFalse(cm11.check(bookshelf));
        CommonGoalCard12 cm12 = new CommonGoalCard12(4);
        assertFalse(cm12.check(bookshelf));
    }
}