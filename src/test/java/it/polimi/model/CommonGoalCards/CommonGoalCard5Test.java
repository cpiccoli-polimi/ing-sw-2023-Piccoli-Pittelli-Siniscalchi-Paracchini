package it.polimi.model.CommonGoalCards;

import it.polimi.model.PublicObjectCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard5Test {
    @Test
    void CommonGoal5SatisfiedTest(){
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard5 cm5=new CommonGoalCard5(4);

        //4 groups of 4 cards with the same type in line
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[0][1]=new PublicObjectCard(1,0,1);
        bookshelf[0][2]=new PublicObjectCard(1,0,2);
        bookshelf[0][3]=new PublicObjectCard(1,0,3);

        bookshelf[1][1]=new PublicObjectCard(1,1,1);
        bookshelf[1][2]=new PublicObjectCard(1,1,2);
        bookshelf[1][3]=new PublicObjectCard(1,1,3);
        bookshelf[1][4]=new PublicObjectCard(1,1,4);

        bookshelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf[2][0]=new PublicObjectCard(2,1,0);
        bookshelf[3][0]=new PublicObjectCard(3,1,0);
        bookshelf[4][0]=new PublicObjectCard(4,1,0);

        bookshelf[4][1]=new PublicObjectCard(1,4,1);
        bookshelf[4][2]=new PublicObjectCard(1,4,2);
        bookshelf[4][3]=new PublicObjectCard(1,4,3);
        bookshelf[4][4]=new PublicObjectCard(1,4,4);

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
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard5 cm5=new CommonGoalCard5(4);
        bookshelf= new PublicObjectCard[6][5];
        //3 groups of 4 cards with the same type in line

        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[0][1]=new PublicObjectCard(1,0,1);
        bookshelf[0][2]=new PublicObjectCard(1,0,2);
        bookshelf[0][3]=new PublicObjectCard(1,0,3);

        bookshelf[1][1]=new PublicObjectCard(1,1,1);
        bookshelf[1][2]=new PublicObjectCard(1,1,2);
        bookshelf[1][3]=new PublicObjectCard(1,1,3);
        bookshelf[1][4]=new PublicObjectCard(1,1,4);

        bookshelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf[2][0]=new PublicObjectCard(25,1,0);
        bookshelf[3][0]=new PublicObjectCard(50,1,0);
        bookshelf[4][0]=new PublicObjectCard(100,1,0);

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
        //43 groups of 4 cards with the same type in line, and 1 group of 3 cards with the same type in line

        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[0][2]=new PublicObjectCard(1,0,2);
        bookshelf[0][3]=new PublicObjectCard(1,0,3);

        bookshelf[1][1]=new PublicObjectCard(1,1,1);
        bookshelf[1][2]=new PublicObjectCard(1,1,2);
        bookshelf[1][3]=new PublicObjectCard(1,1,3);
        bookshelf[1][4]=new PublicObjectCard(1,1,4);

        bookshelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf[2][0]=new PublicObjectCard(2,1,0);
        bookshelf[3][0]=new PublicObjectCard(3,1,0);
        bookshelf[4][0]=new PublicObjectCard(4,1,0);

        bookshelf[4][1]=new PublicObjectCard(1,4,1);
        bookshelf[4][2]=new PublicObjectCard(1,4,2);
        bookshelf[4][3]=new PublicObjectCard(1,4,3);
        bookshelf[4][4]=new PublicObjectCard(1,4,4);

        assertFalse(cm5.check(bookshelf));
    }
}