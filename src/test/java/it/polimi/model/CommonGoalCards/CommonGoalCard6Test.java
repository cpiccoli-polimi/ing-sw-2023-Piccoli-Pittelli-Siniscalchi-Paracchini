package it.polimi.model.CommonGoalCards;

import it.polimi.model.PublicObjectCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard6Test {

    @Test
    void CommonGoal6SatisfiedTest() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard6 cm6=new CommonGoalCard6(4);
        // -- 2 columns with 6 different types each --
        //COLUMN 1
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[1][0]=new PublicObjectCard(23,1,0);
        bookshelf[2][0]=new PublicObjectCard(46,2,0);
        bookshelf[3][0]=new PublicObjectCard(68,3,0);
        bookshelf[4][0]=new PublicObjectCard(90,4,0);
        bookshelf[5][0]=new PublicObjectCard(112,5,0);

        //COLUMN 2
        bookshelf[0][2]=new PublicObjectCard(1,0,2);
        bookshelf[1][2]=new PublicObjectCard(23,1,2);
        bookshelf[2][2]=new PublicObjectCard(46,2,2);
        bookshelf[3][2]=new PublicObjectCard(68,3,2);
        bookshelf[4][2]=new PublicObjectCard(90,4,2);
        bookshelf[5][2]=new PublicObjectCard(112,5,2);

        assertTrue(cm6.check(bookshelf));
    }

    @Test
    void CommonGoal6NotSatisfiedTest() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard6 cm6bis=new CommonGoalCard6(4);
        // -- 2 columns with 6 different types each --
        //COLUMN 1
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[1][0]=new PublicObjectCard(23,1,0);
        bookshelf[2][0]=new PublicObjectCard(46,2,0);
        bookshelf[3][0]=new PublicObjectCard(68,3,0);
        bookshelf[4][0]=new PublicObjectCard(90,4,0);
        bookshelf[5][0]=new PublicObjectCard(90,5,0);

        //COLUMN 2
        bookshelf[0][2]=new PublicObjectCard(1,0,2);
        bookshelf[1][2]=new PublicObjectCard(23,1,2);
        bookshelf[2][2]=new PublicObjectCard(23,2,2);
        bookshelf[3][2]=new PublicObjectCard(68,3,2);
        bookshelf[4][2]=new PublicObjectCard(90,4,2);
        bookshelf[5][2]=new PublicObjectCard(112,5,2);

        assertFalse(cm6bis.check(bookshelf));
    }

    @Test
    void CommonGoal6EmptyTest() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard6 cm6=new CommonGoalCard6(4);

        assertFalse(cm6.check(bookshelf));
    }
}