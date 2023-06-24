package it.polimi.model.CommonGoalCards;

import it.polimi.model.PublicObjectCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard12Test {
    @Test
    void CommonGoal12SatisfiedTestLeftToRight() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard12 cm12=new CommonGoalCard12(4);

        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[1][0]=new PublicObjectCard(23,1,0);
        bookshelf[2][0]=new PublicObjectCard(23,2,0);
        bookshelf[3][0]=new PublicObjectCard(90,3,0);
        bookshelf[4][0]=new PublicObjectCard(90,4,0);
        bookshelf[5][0]=new PublicObjectCard(1,5,0);

        bookshelf[1][1]=new PublicObjectCard(1,1,1);
        bookshelf[2][1]=new PublicObjectCard(23,2,1);
        bookshelf[3][1]=new PublicObjectCard(23,3,1);
        bookshelf[4][1]=new PublicObjectCard(1,4,1);
        bookshelf[5][1]=new PublicObjectCard(112,5,1);

        bookshelf[2][2]=new PublicObjectCard(112,2,2);
        bookshelf[3][2]=new PublicObjectCard(1,3,2);
        bookshelf[4][2]=new PublicObjectCard(90,4,2);
        bookshelf[5][2]=new PublicObjectCard(1,5,2);

        bookshelf[3][3]=new PublicObjectCard(68,3,3);
        bookshelf[4][3]=new PublicObjectCard(46,4,3);
        bookshelf[5][3]=new PublicObjectCard(1,5,3);

        bookshelf[4][4]=new PublicObjectCard(23,4,4);
        bookshelf[5][4]=new PublicObjectCard(1,5,4);

        assertTrue(cm12.check(bookshelf));
    }

    @Test
    void CommonGoal12SatisfiedTestLeftToRightLower() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard12 cm12bis=new CommonGoalCard12(4);

        bookshelf[1][0]=new PublicObjectCard(23,1,0);
        bookshelf[2][0]=new PublicObjectCard(23,2,0);
        bookshelf[3][0]=new PublicObjectCard(90,3,0);
        bookshelf[4][0]=new PublicObjectCard(90,4,0);
        bookshelf[5][0]=new PublicObjectCard(1,5,0);

        bookshelf[2][1]=new PublicObjectCard(23,2,1);
        bookshelf[3][1]=new PublicObjectCard(23,3,1);
        bookshelf[4][1]=new PublicObjectCard(1,4,1);
        bookshelf[5][1]=new PublicObjectCard(112,5,1);

        bookshelf[3][2]=new PublicObjectCard(1,3,2);
        bookshelf[4][2]=new PublicObjectCard(90,4,2);
        bookshelf[5][2]=new PublicObjectCard(1,5,2);

        bookshelf[4][3]=new PublicObjectCard(46,4,3);
        bookshelf[5][3]=new PublicObjectCard(1,5,3);

        bookshelf[5][4]=new PublicObjectCard(1,5,4);

        assertTrue(cm12bis.check(bookshelf));
    }

    @Test
    void CommonGoal12SatisfiedTestRightToLeft() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard12 cm12tris=new CommonGoalCard12(4);

        bookshelf[4][0]=new PublicObjectCard(23,4,0);
        bookshelf[5][0]=new PublicObjectCard(1,5,0);

        bookshelf[3][1]=new PublicObjectCard(68,3,1);
        bookshelf[4][1]=new PublicObjectCard(46,4,1);
        bookshelf[5][1]=new PublicObjectCard(1,5,1);

        bookshelf[2][2]=new PublicObjectCard(112,2,2);
        bookshelf[3][2]=new PublicObjectCard(1,3,2);
        bookshelf[4][2]=new PublicObjectCard(90,4,2);
        bookshelf[5][2]=new PublicObjectCard(1,5,2);

        bookshelf[1][3]=new PublicObjectCard(1,1,3);
        bookshelf[2][3]=new PublicObjectCard(23,2,3);
        bookshelf[3][3]=new PublicObjectCard(23,3,3);
        bookshelf[4][3]=new PublicObjectCard(1,4,3);
        bookshelf[5][3]=new PublicObjectCard(112,5,3);

        bookshelf[0][4]=new PublicObjectCard(1,0,4);
        bookshelf[1][4]=new PublicObjectCard(23,1,4);
        bookshelf[2][4]=new PublicObjectCard(23,2,4);
        bookshelf[3][4]=new PublicObjectCard(90,3,4);
        bookshelf[4][4]=new PublicObjectCard(90,4,4);
        bookshelf[5][4]=new PublicObjectCard(1,5,4);

        assertTrue(cm12tris.check(bookshelf));
    }
}