package it.polimi.model.CommonGoalCards;

import it.polimi.model.PublicObjectCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard1Test {
    @Test
    void EmptyBookshelf(){
        PublicObjectCard [][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard1 cm1=new CommonGoalCard1(4);
        assertFalse(cm1.check(bookshelf));
    }
    @Test
    void CommonGoal1SatisfiedTest(){
        PublicObjectCard [][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard1 cm1=new CommonGoalCard1(4);
        //Six example couples with same type
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[0][1]=new PublicObjectCard(2,0,1);

        bookshelf[1][0]=new PublicObjectCard(24,1,0);
        bookshelf[1][1]=new PublicObjectCard(25,1,1);

        bookshelf[5][0]=new PublicObjectCard(46,5,0);
        bookshelf[4][0]=new PublicObjectCard(47,4,0);

        bookshelf[5][3]=new PublicObjectCard(3,5,3);
        bookshelf[5][4]=new PublicObjectCard(4,5,4);

        bookshelf[3][3]=new PublicObjectCard(70,3,3);
        bookshelf[3][4]=new PublicObjectCard(71,3,4);

        bookshelf[4][4]=new PublicObjectCard(101,4,4);
        bookshelf[4][3]=new PublicObjectCard(102,4,3);

        assertTrue(cm1.check(bookshelf));
    }

    @Test
    void CommonGoal1SatisfiedBoardRepopulatedTest(){
        PublicObjectCard [][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard1 cm1=new CommonGoalCard1(4);
        //Six example couples with same type
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[0][1]=new PublicObjectCard(5,0,0);

        bookshelf[1][0]=new PublicObjectCard(23,0,0);
        bookshelf[1][1]=new PublicObjectCard(24,0,0);

        bookshelf[5][0]=new PublicObjectCard(45,0,0);
        bookshelf[4][0]=new PublicObjectCard(44,0,0);

        bookshelf[5][3]=new PublicObjectCard(2,0,0);
        bookshelf[5][4]=new PublicObjectCard(3,0,0);

        bookshelf[3][3]=new PublicObjectCard(66,0,3);
        bookshelf[3][4]=new PublicObjectCard(67,0,4);

        bookshelf[4][4]=new PublicObjectCard(101,0,0);
        bookshelf[4][3]=new PublicObjectCard(100,0,0);

        assertTrue(cm1.check(bookshelf));
    }

    @Test
    void empyBookshelfTest(){

        PublicObjectCard [][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard1 cm1=new CommonGoalCard1(4);
        assertFalse(cm1.check(bookshelf));
    }

    @Test
    void missingCardTest(){

        PublicObjectCard [][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard1 cm1=new CommonGoalCard1(4);

        bookshelf[0][0]=new PublicObjectCard(1,0,0);

        bookshelf[1][0]=new PublicObjectCard(23,1,0);
        bookshelf[1][1]=new PublicObjectCard(23,1,1);

        bookshelf[5][0]=new PublicObjectCard(45,5,0);
        bookshelf[4][0]=new PublicObjectCard(45,4,0);

        bookshelf[5][3]=new PublicObjectCard(1,5,3);
        bookshelf[5][4]=new PublicObjectCard(1,5,4);

        bookshelf[3][3]=new PublicObjectCard(67,3,3);
        bookshelf[3][4]=new PublicObjectCard(67,3,4);

        bookshelf[4][4]=new PublicObjectCard(101,4,4);
        bookshelf[5][4]=new PublicObjectCard(101,5,4);

        assertFalse(cm1.check(bookshelf));
    }

    @Test
    void CommonGoal1SatisfiedDifferentShapeTest(){
        PublicObjectCard [][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard1 cm1=new CommonGoalCard1(4);
        //Six example couples with same type
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[0][1]=new PublicObjectCard(2,0,0);
        bookshelf[0][2]=new PublicObjectCard(3,0,0);
        bookshelf[0][3]=new PublicObjectCard(4,0,0);

        bookshelf[0][4]=new PublicObjectCard(24,0,0);
        bookshelf[1][4]=new PublicObjectCard(25,0,0);
        bookshelf[1][3]=new PublicObjectCard(26,0,0);
        bookshelf[1][2]=new PublicObjectCard(27,0,0);
        bookshelf[2][2]=new PublicObjectCard(28,0,0);
        bookshelf[3][2]=new PublicObjectCard(29,0,0);
        bookshelf[3][3]=new PublicObjectCard(30,0,0);
        bookshelf[3][4]=new PublicObjectCard(31,0,0);

        bookshelf[2][3]=new PublicObjectCard(46,0,0);
        bookshelf[2][4]=new PublicObjectCard(47,0,0);

        bookshelf[1][0]=new PublicObjectCard(49,0,0);
        bookshelf[1][1]=new PublicObjectCard(48,0,0);

        bookshelf[2][0]=new PublicObjectCard(67,0,3);
        bookshelf[2][1]=new PublicObjectCard(68,0,4);

        bookshelf[5][4]=new PublicObjectCard(101,0,0);
        bookshelf[5][3]=new PublicObjectCard(100,0,0);

        assertTrue(cm1.check(bookshelf));
    }
}