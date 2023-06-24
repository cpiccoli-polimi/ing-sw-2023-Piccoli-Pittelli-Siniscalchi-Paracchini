package it.polimi.model.CommonGoalCards;

import it.polimi.model.PublicObjectCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard8Test {
    @Test
    void CommonGoal8SatisfiedTest() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard8 cm8=new CommonGoalCard8(4);
        // -- 2 rows of 5 tiles each of a different type --
        //ROW 1
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[0][1]=new PublicObjectCard(23,0,1);
        bookshelf[0][2]=new PublicObjectCard(46,0,2);
        bookshelf[0][3]=new PublicObjectCard(68,0,3);
        bookshelf[0][4]=new PublicObjectCard(90,0,4);

        //ROW 2
        bookshelf[3][0]=new PublicObjectCard(1,3,0);
        bookshelf[3][1]=new PublicObjectCard(23,3,1);
        bookshelf[3][2]=new PublicObjectCard(68,3,2);
        bookshelf[3][3]=new PublicObjectCard(90,3,3);
        bookshelf[3][4]=new PublicObjectCard(112,3,4);

        assertTrue(cm8.check(bookshelf));
    }

    @Test
    void CommonGoal8NotSatisfiedTest() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard8 cm8bis=new CommonGoalCard8(4);
        // -- 2 rows of 5 tiles each of a different type --
        //ROW 1
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[0][1]=new PublicObjectCard(23,0,1);
        bookshelf[0][2]=new PublicObjectCard(46,0,2);
        bookshelf[0][3]=new PublicObjectCard(68,0,3);
        bookshelf[0][4]=new PublicObjectCard(90,0,4);

        //ROW 2
        bookshelf[3][0]=new PublicObjectCard(1,3,0);
        bookshelf[3][1]=new PublicObjectCard(1,3,1);
        bookshelf[3][2]=new PublicObjectCard(1,3,2);
        bookshelf[3][3]=new PublicObjectCard(1,3,3);
        bookshelf[3][4]=new PublicObjectCard(1,3,4);

        assertFalse(cm8bis.check(bookshelf));
    }

    @Test
    void CommonGoal8EmptyTest() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard7 cm8tris=new CommonGoalCard7(4);

        assertFalse(cm8tris.check(bookshelf));
    }
}