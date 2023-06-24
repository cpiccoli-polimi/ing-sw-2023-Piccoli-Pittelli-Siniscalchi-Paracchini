package it.polimi.model.CommonGoalCards;

import it.polimi.model.PublicObjectCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard7Test {

    @Test
    void CommonGoal7SatisfiedTest() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard7 cm7=new CommonGoalCard7(4);
        // -- 2 squares of 4 tiles with same type --
        //SQUARE 1
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf[0][1]=new PublicObjectCard(1,0,1);
        bookshelf[1][1]=new PublicObjectCard(1,1,1);

        //SQUARE 2
        bookshelf[3][2]=new PublicObjectCard(1,3,2);
        bookshelf[3][3]=new PublicObjectCard(1,3,3);
        bookshelf[4][2]=new PublicObjectCard(1,4,2);
        bookshelf[4][3]=new PublicObjectCard(1,4,3);

        assertTrue(cm7.check(bookshelf));
    }

    @Test
    void CommonGoal7NotSatisfiedTest() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard7 cm7bis=new CommonGoalCard7(4);
        // -- 2 squares of 4 tiles with different types --
        //SQUARE 1
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf[0][1]=new PublicObjectCard(1,0,1);
        bookshelf[1][1]=new PublicObjectCard(1,1,1);

        //SQUARE 2
        bookshelf[3][2]=new PublicObjectCard(46,3,2);
        bookshelf[3][3]=new PublicObjectCard(46,3,3);
        bookshelf[4][2]=new PublicObjectCard(46,4,2);
        bookshelf[4][3]=new PublicObjectCard(46,4,3);

        assertFalse(cm7bis.check(bookshelf));
    }

    @Test
    void CommonGoal7EmptyTest() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard7 cm7tris=new CommonGoalCard7(4);

        assertFalse(cm7tris.check(bookshelf));
    }
}