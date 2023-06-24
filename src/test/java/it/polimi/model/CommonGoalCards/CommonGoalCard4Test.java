package it.polimi.model.CommonGoalCards;

import it.polimi.model.PublicObjectCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard4Test {

    @Test
    void CommonGoal4SatisfiedTestSameType() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard4 cm4=new CommonGoalCard4(4);
        // -- 4 rows of 5 cards each, all same type --
        //ROW 1
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[0][1]=new PublicObjectCard(1,0,1);
        bookshelf[0][2]=new PublicObjectCard(1,0,2);
        bookshelf[0][3]=new PublicObjectCard(1,0,3);
        bookshelf[0][4]=new PublicObjectCard(1,0,4);

        //ROW 2
        bookshelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf[1][1]=new PublicObjectCard(1,1,1);
        bookshelf[1][2]=new PublicObjectCard(1,1,2);
        bookshelf[1][3]=new PublicObjectCard(1,1,3);
        bookshelf[1][4]=new PublicObjectCard(1,1,4);

        //ROW 3
        bookshelf[3][0]=new PublicObjectCard(1,3,0);
        bookshelf[3][1]=new PublicObjectCard(1,3,1);
        bookshelf[3][2]=new PublicObjectCard(1,3,2);
        bookshelf[3][3]=new PublicObjectCard(1,3,3);
        bookshelf[3][4]=new PublicObjectCard(1,3,4);

        //ROW 4
        bookshelf[4][0]=new PublicObjectCard(1,4,0);
        bookshelf[4][1]=new PublicObjectCard(1,4,1);
        bookshelf[4][2]=new PublicObjectCard(1,4,2);
        bookshelf[4][3]=new PublicObjectCard(1,4,3);
        bookshelf[4][4]=new PublicObjectCard(1,4,4);

        assertTrue(cm4.check(bookshelf));
    }

    @Test
    void CommonGoal4NotSatisfiedTest() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard4 cm4=new CommonGoalCard4(4);
        // -- 4 rows of 5 cards each, all different type --
        //ROW 1
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[0][1]=new PublicObjectCard(23,0,1);
        bookshelf[0][2]=new PublicObjectCard(46,0,2);
        bookshelf[0][3]=new PublicObjectCard(68,0,3);
        bookshelf[0][4]=new PublicObjectCard(68,0,4);

        //ROW 2
        bookshelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf[1][1]=new PublicObjectCard(43,1,1);
        bookshelf[1][2]=new PublicObjectCard(43,1,2);
        bookshelf[1][3]=new PublicObjectCard(68,1,3);
        bookshelf[1][4]=new PublicObjectCard(68,1,4);

        //ROW 3
        bookshelf[3][0]=new PublicObjectCard(43,3,0);
        bookshelf[3][1]=new PublicObjectCard(43,3,1);
        bookshelf[3][2]=new PublicObjectCard(43,3,2);
        bookshelf[3][3]=new PublicObjectCard(43,3,3);
        bookshelf[3][4]=new PublicObjectCard(68,3,4);

        //ROW 4
        bookshelf[4][0]=new PublicObjectCard(1,4,0);
        bookshelf[4][1]=new PublicObjectCard(1,4,1);
        bookshelf[4][2]=new PublicObjectCard(1,4,2);
        bookshelf[4][3]=new PublicObjectCard(1,4,3);
        bookshelf[4][4]=new PublicObjectCard(1,4,4);

        assertFalse(cm4.check(bookshelf));
    }
}