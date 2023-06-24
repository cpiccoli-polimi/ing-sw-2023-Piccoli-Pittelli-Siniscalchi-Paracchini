package it.polimi.model.CommonGoalCards;

import it.polimi.model.PublicObjectCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard10Test {
    @Test
    void CommonGoal10SatisfiedTest() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard10 cm10=new CommonGoalCard10(4);
        // Cross of 5 tiles
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[1][1]=new PublicObjectCard(1,1,1);
        bookshelf[0][2]=new PublicObjectCard(1,0,2);
        bookshelf[2][0]=new PublicObjectCard(1,2,0);
        bookshelf[2][2]=new PublicObjectCard(1,2,2);

        assertTrue(cm10.check(bookshelf));
    }

    @Test
    void CommonGoal10SatisfiedTest2() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard10 cm10bis=new CommonGoalCard10(4);
        // Cross of 5 tiles
        bookshelf[0][2]=new PublicObjectCard(1,0,2);
        bookshelf[1][3]=new PublicObjectCard(1,1,3);
        bookshelf[0][4]=new PublicObjectCard(1,0,4);
        bookshelf[2][2]=new PublicObjectCard(1,2,2);
        bookshelf[2][4]=new PublicObjectCard(1,2,4);

        assertTrue(cm10bis.check(bookshelf));
    }
}