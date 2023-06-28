package it.polimi.model.CommonGoalCards;

import it.polimi.model.PublicObjectCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard3Test {
    @Test
    void EmptyBookshelf(){
        PublicObjectCard [][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard2 cm2=new CommonGoalCard2(4);
        assertFalse(cm2.check(bookshelf));
    }
    @Test
    void CommonGoal3SatisfiedTest(){
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard3 cm3=new CommonGoalCard3(4);
        //Same type card on the four corners
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[5][0]=new PublicObjectCard(1,5,0);
        bookshelf[5][4]=new PublicObjectCard(1,5,4);
        bookshelf[0][4]=new PublicObjectCard(1,0,4);

        assertTrue(cm3.check(bookshelf));
    }

    @Test
    void DifferentLowerRightCorner(){
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard3 cm3=new CommonGoalCard3(4);
        //Same type card on the four corners
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[5][0]=new PublicObjectCard(1,5,0);
        bookshelf[5][4]=new PublicObjectCard(25,5,4);
        bookshelf[0][4]=new PublicObjectCard(1,0,4);

        assertFalse(cm3.check(bookshelf));
    }
}