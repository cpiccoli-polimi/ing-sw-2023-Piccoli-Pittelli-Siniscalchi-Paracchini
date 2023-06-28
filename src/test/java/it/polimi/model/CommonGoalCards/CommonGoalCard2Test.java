package it.polimi.model.CommonGoalCards;

import it.polimi.model.PublicObjectCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard2Test {

    @Test
    void CommonGoal2SatisfiedTest(){
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];

        CommonGoalCard2 cm2=new CommonGoalCard2(4);
        //Card in diagonal from top left to bottom right
        bookshelf= new PublicObjectCard[6][5];
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[1][1]=new PublicObjectCard(1,1,1);
        bookshelf[2][2]=new PublicObjectCard(1,2,2);
        bookshelf[3][3]=new PublicObjectCard(1,3,3);
        bookshelf[4][4]=new PublicObjectCard(1,4,4);

        assertTrue(cm2.check(bookshelf));

        //Card in diagonal from second row top left to bottom right
        bookshelf= new PublicObjectCard[6][5];
        bookshelf[1][0]=new PublicObjectCard(1,0,0);
        bookshelf[2][1]=new PublicObjectCard(1,1,1);
        bookshelf[3][2]=new PublicObjectCard(1,2,2);
        bookshelf[4][3]=new PublicObjectCard(1,3,3);
        bookshelf[5][4]=new PublicObjectCard(1,4,4);

        assertTrue(cm2.check(bookshelf));

        //Card in diagonal from row bottom left to second row top right
        bookshelf= new PublicObjectCard[6][5];
        bookshelf[5][0]=new PublicObjectCard(1,0,0);
        bookshelf[4][1]=new PublicObjectCard(1,1,1);
        bookshelf[3][2]=new PublicObjectCard(1,2,2);
        bookshelf[2][3]=new PublicObjectCard(1,3,3);
        bookshelf[1][4]=new PublicObjectCard(1,4,4);

        assertTrue(cm2.check(bookshelf));

        //Card in diagonal from second row bottom left to top right
        bookshelf= new PublicObjectCard[6][5];
        bookshelf[4][0]=new PublicObjectCard(1,0,0);
        bookshelf[3][1]=new PublicObjectCard(1,1,1);
        bookshelf[2][2]=new PublicObjectCard(1,2,2);
        bookshelf[1][3]=new PublicObjectCard(1,3,3);
        bookshelf[0][4]=new PublicObjectCard(1,4,4);

        assertTrue(cm2.check(bookshelf));

    }

    @Test
    void emptyBookshelfTest() {
        PublicObjectCard[][] bookshelf;
        bookshelf = new PublicObjectCard[6][5];

        CommonGoalCard2 cm2 = new CommonGoalCard2(4);

        assertFalse(cm2.check(bookshelf));
    }

    @Test
    void differentCardTEst(){
        PublicObjectCard[][] bookshelf;
        bookshelf = new PublicObjectCard[6][5];

        CommonGoalCard2 cm2 = new CommonGoalCard2(4);
        //Different card in diagonal from top left to bottom right
        bookshelf= new PublicObjectCard[6][5];
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[1][1]=new PublicObjectCard(1,1,1);
        bookshelf[2][2]=new PublicObjectCard(50,2,2);
        bookshelf[3][3]=new PublicObjectCard(1,3,3);
        bookshelf[4][4]=new PublicObjectCard(1,4,4);

        assertFalse(cm2.check(bookshelf));

        //Different card in diagonal from second row top left to bottom right
        bookshelf= new PublicObjectCard[6][5];
        bookshelf[1][0]=new PublicObjectCard(50,0,0);
        bookshelf[2][1]=new PublicObjectCard(1,1,1);
        bookshelf[3][2]=new PublicObjectCard(1,2,2);
        bookshelf[4][3]=new PublicObjectCard(1,3,3);
        bookshelf[5][4]=new PublicObjectCard(1,4,4);

        assertFalse(cm2.check(bookshelf));

        //Different card in diagonal from row bottom left to second row top right
        bookshelf= new PublicObjectCard[6][5];
        bookshelf[5][0]=new PublicObjectCard(1,0,0);
        bookshelf[4][1]=new PublicObjectCard(1,1,1);
        bookshelf[3][2]=new PublicObjectCard(1,2,2);
        bookshelf[2][3]=new PublicObjectCard(1,3,3);
        bookshelf[1][4]=new PublicObjectCard(50,4,4);

        assertFalse(cm2.check(bookshelf));

        //Different card in diagonal from second row bottom left to top right
        bookshelf= new PublicObjectCard[6][5];
        bookshelf[4][0]=new PublicObjectCard(1,0,0);
        bookshelf[3][1]=new PublicObjectCard(50,1,1);
        bookshelf[2][2]=new PublicObjectCard(1,2,2);
        bookshelf[1][3]=new PublicObjectCard(1,3,3);
        bookshelf[0][4]=new PublicObjectCard(1,4,4);

        assertFalse(cm2.check(bookshelf));
    }
    @Test
    void missingCardTest(){
        PublicObjectCard[][] bookshelf;
        bookshelf = new PublicObjectCard[6][5];

        CommonGoalCard2 cm2 = new CommonGoalCard2(4);
        //Missing card in diagonal from top left to bottom right
        bookshelf= new PublicObjectCard[6][5];
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[2][2]=new PublicObjectCard(1,2,2);
        bookshelf[3][3]=new PublicObjectCard(1,3,3);
        bookshelf[4][4]=new PublicObjectCard(1,4,4);

        assertFalse(cm2.check(bookshelf));

        //Missing card in diagonal from second row top left to bottom right
        bookshelf= new PublicObjectCard[6][5];
        bookshelf[1][0]=new PublicObjectCard(1,0,0);
        bookshelf[2][1]=new PublicObjectCard(1,1,1);
        bookshelf[3][2]=new PublicObjectCard(1,2,2);
        bookshelf[4][3]=new PublicObjectCard(1,3,3);

        assertFalse(cm2.check(bookshelf));

        //Missing card in diagonal from row bottom left to second row top right
        bookshelf= new PublicObjectCard[6][5];
        bookshelf[5][0]=new PublicObjectCard(1,0,0);
        bookshelf[4][1]=new PublicObjectCard(1,1,1);
        bookshelf[3][2]=new PublicObjectCard(1,2,2);
        bookshelf[1][4]=new PublicObjectCard(1,4,4);

        assertFalse(cm2.check(bookshelf));

        //Missing card in diagonal from second row bottom left to top right
        bookshelf= new PublicObjectCard[6][5];
        bookshelf[4][0]=new PublicObjectCard(1,0,0);
        bookshelf[3][1]=new PublicObjectCard(1,1,1);
        bookshelf[1][3]=new PublicObjectCard(1,3,3);
        bookshelf[0][4]=new PublicObjectCard(1,4,4);

        assertFalse(cm2.check(bookshelf));
    }
}