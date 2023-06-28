package it.polimi.model.CommonGoalCards;

import it.polimi.model.PublicObjectCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard5Test {
    @Test
    void CommonGoal5SatisfiedTestRows(){
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard5 cm5=new CommonGoalCard5(4);

        //4 rows of 4 cards with the same type
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[0][1]=new PublicObjectCard(1,0,1);
        bookshelf[0][2]=new PublicObjectCard(1,0,2);
        bookshelf[0][3]=new PublicObjectCard(1,0,3);

        bookshelf[1][1]=new PublicObjectCard(23,1,1);
        bookshelf[1][2]=new PublicObjectCard(23,1,2);
        bookshelf[1][3]=new PublicObjectCard(23,1,3);
        bookshelf[1][4]=new PublicObjectCard(23,1,4);

        bookshelf[1][0]=new PublicObjectCard(68,1,0);
        bookshelf[2][0]=new PublicObjectCard(68,2,0);
        bookshelf[3][0]=new PublicObjectCard(68,3,0);
        bookshelf[4][0]=new PublicObjectCard(68,4,0);

        bookshelf[4][1]=new PublicObjectCard(23,4,1);
        bookshelf[4][2]=new PublicObjectCard(23,4,2);
        bookshelf[4][3]=new PublicObjectCard(23,4,3);
        bookshelf[4][4]=new PublicObjectCard(23,4,4);

        assertTrue(cm5.check(bookshelf));
    }

    @Test
    void emptyBookshelfTest(){
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard5 cm5=new CommonGoalCard5(4);
        assertFalse(cm5.check(bookshelf));
    }

    @Test
    void oneMissingGroup(){
        PublicObjectCard[][] bookshelf;
        CommonGoalCard5 cm5=new CommonGoalCard5(4);
        bookshelf= new PublicObjectCard[6][5];
        //3 groups of 4 cards with the same type in line
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[0][1]=new PublicObjectCard(2,0,1);
        bookshelf[0][2]=new PublicObjectCard(3,0,2);
        bookshelf[0][3]=new PublicObjectCard(4,0,3);

        bookshelf[1][1]=new PublicObjectCard(1,1,1);
        bookshelf[1][2]=new PublicObjectCard(1,1,2);
        bookshelf[1][3]=new PublicObjectCard(1,1,3);
        bookshelf[1][4]=new PublicObjectCard(1,1,4);

        bookshelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf[2][0]=new PublicObjectCard(25,2,0);
        bookshelf[3][0]=new PublicObjectCard(50,3,0);
        bookshelf[4][0]=new PublicObjectCard(100,4,0);

        bookshelf[4][1]=new PublicObjectCard(1,4,1);
        bookshelf[4][2]=new PublicObjectCard(1,4,2);
        bookshelf[4][3]=new PublicObjectCard(1,4,3);
        bookshelf[4][4]=new PublicObjectCard(1,4,4);

        assertFalse(cm5.check(bookshelf));
    }

    @Test
    void oneMissingCard(){
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard5 cm5=new CommonGoalCard5(4);
        bookshelf= new PublicObjectCard[6][5];
        //3 groups of 4 cards with the same type in line, and 1 group of 3 cards with the same type in line

        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[0][2]=new PublicObjectCard(1,0,2);
        bookshelf[0][3]=new PublicObjectCard(1,0,3);

        bookshelf[1][1]=new PublicObjectCard(1,1,1);
        bookshelf[1][2]=new PublicObjectCard(1,1,2);
        bookshelf[1][3]=new PublicObjectCard(1,1,3);
        bookshelf[1][4]=new PublicObjectCard(1,1,4);

        bookshelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf[2][0]=new PublicObjectCard(2,2,0);
        bookshelf[3][0]=new PublicObjectCard(3,3,0);
        bookshelf[4][0]=new PublicObjectCard(4,4,0);

        bookshelf[4][1]=new PublicObjectCard(1,4,1);
        bookshelf[4][2]=new PublicObjectCard(1,4,2);
        bookshelf[4][3]=new PublicObjectCard(1,4,3);
        bookshelf[4][4]=new PublicObjectCard(1,4,4);

        assertFalse(cm5.check(bookshelf));
    }
    @Test
    void CommonGoal5SatisfiedTestColumns(){
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard5 cm5=new CommonGoalCard5(4);
        //4 columns of 4 cards with the same type
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf[2][0]=new PublicObjectCard(1,2,0);
        bookshelf[3][0]=new PublicObjectCard(1,3,0);

        bookshelf[0][1]=new PublicObjectCard(23,0,1);
        bookshelf[1][1]=new PublicObjectCard(23,1,1);
        bookshelf[2][1]=new PublicObjectCard(23,2,1);
        bookshelf[3][1]=new PublicObjectCard(23,3,1);

        bookshelf[1][2]=new PublicObjectCard(1,1,2);
        bookshelf[2][2]=new PublicObjectCard(1,2,2);
        bookshelf[3][2]=new PublicObjectCard(1,3,2);
        bookshelf[4][2]=new PublicObjectCard(1,4,2);

        bookshelf[2][4]=new PublicObjectCard(112,2,4);
        bookshelf[3][4]=new PublicObjectCard(112,3,4);
        bookshelf[4][4]=new PublicObjectCard(112,4,4);
        bookshelf[5][4]=new PublicObjectCard(112,5,4);

        assertTrue(cm5.check(bookshelf));
    }
    @Test
    void CommonGoal5SatisfiedTestSquares(){
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard5 cm5=new CommonGoalCard5(4);
        //4 columns of 4 cards with the same type
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf[1][1]=new PublicObjectCard(1,1,1);
        bookshelf[0][1]=new PublicObjectCard(1,0,1);

        bookshelf[0][3]=new PublicObjectCard(1,0,3);
        bookshelf[0][4]=new PublicObjectCard(1,0,4);
        bookshelf[1][3]=new PublicObjectCard(1,1,3);
        bookshelf[1][4]=new PublicObjectCard(1,1,4);

        bookshelf[3][3]=new PublicObjectCard(1,3,3);
        bookshelf[3][4]=new PublicObjectCard(2,3,4);
        bookshelf[4][3]=new PublicObjectCard(3,4,3);
        bookshelf[4][4]=new PublicObjectCard(4,4,4);

        bookshelf[4][0]=new PublicObjectCard(1,4,0);
        bookshelf[4][1]=new PublicObjectCard(1,4,1);
        bookshelf[5][0]=new PublicObjectCard(1,5,0);
        bookshelf[5][1]=new PublicObjectCard(1,5,1);

        assertTrue(cm5.check(bookshelf));
    }
}