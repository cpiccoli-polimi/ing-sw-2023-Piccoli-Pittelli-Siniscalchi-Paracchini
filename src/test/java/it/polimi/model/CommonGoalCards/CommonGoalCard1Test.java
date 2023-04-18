package it.polimi.model.CommonGoalCards;

import it.polimi.model.PublicObjectCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard1Test {
    @Test
    void EmptyBookshelf(){
        PublicObjectCard[][] bookshelf;
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
        bookshelf[0][1]=new PublicObjectCard(1,0,1);

        bookshelf[1][0]=new PublicObjectCard(23,1,0);
        bookshelf[1][1]=new PublicObjectCard(23,1,1);

        bookshelf[5][0]=new PublicObjectCard(45,5,0);
        bookshelf[4][0]=new PublicObjectCard(45,4,0);

        bookshelf[5][3]=new PublicObjectCard(1,5,3);
        bookshelf[5][4]=new PublicObjectCard(1,5,4);

        bookshelf[3][3]=new PublicObjectCard(67,3,3);
        bookshelf[3][4]=new PublicObjectCard(67,3,4);

        bookshelf[4][5]=new PublicObjectCard(101,4,5);
        bookshelf[5][5]=new PublicObjectCard(101,5,5);

        assertTrue(cm1.check(bookshelf));
    }
}