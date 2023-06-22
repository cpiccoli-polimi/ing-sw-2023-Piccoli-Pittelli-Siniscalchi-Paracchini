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
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[1][1]=new PublicObjectCard(1,1,1);
        bookshelf[2][2]=new PublicObjectCard(1,2,2);
        bookshelf[3][3]=new PublicObjectCard(1,3,3);
        bookshelf[4][4]=new PublicObjectCard(1,4,4);

        assertTrue(cm2.check(bookshelf));

        CommonGoalCard2 cm2bis=new CommonGoalCard2(4);
        //Card in diagonal from second row bottom left to top right
        bookshelf[4][0]=new PublicObjectCard(1,0,0);
        bookshelf[3][1]=new PublicObjectCard(1,1,1);
        bookshelf[2][2]=new PublicObjectCard(1,2,2);
        bookshelf[1][3]=new PublicObjectCard(1,3,3);
        bookshelf[0][4]=new PublicObjectCard(1,4,4);

        assertTrue(cm2bis.check(bookshelf));
    }
}