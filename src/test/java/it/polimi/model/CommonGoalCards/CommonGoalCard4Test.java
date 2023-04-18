package it.polimi.model.CommonGoalCards;

import it.polimi.model.PublicObjectCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard4Test {
    @Test
    void CommonGoal4SatisfiedTest(){
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard4 cm4=new CommonGoalCard4(4);
        //Same type card on the four corners
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[5][0]=new PublicObjectCard(1,5,0);
        bookshelf[5][4]=new PublicObjectCard(1,5,4);
        bookshelf[0][4]=new PublicObjectCard(1,0,4);

        assertTrue(cm4.check(bookshelf));
    }
}