package it.polimi.model.CommonGoalCards;

import it.polimi.model.PublicObjectCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard9Test {
    @Test
    void CommonGoalCard9SatisfiedThreeColumnsDifferentTypes(){
        PublicObjectCard [][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard9 cm9=new CommonGoalCard9(4);
        //COLUMN 1
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[1][0]=new PublicObjectCard(23,1,0);
        bookshelf[2][0]=new PublicObjectCard(46,2,0);
        bookshelf[3][0]=new PublicObjectCard(1,3,0);
        bookshelf[4][0]=new PublicObjectCard(23,4,0);
        bookshelf[5][0]=new PublicObjectCard(46,5,0);
        //COLUMN 2
        bookshelf[0][3]=new PublicObjectCard(1,0,3);
        bookshelf[1][3]=new PublicObjectCard(23,1,3);
        bookshelf[2][3]=new PublicObjectCard(46,2,3);
        bookshelf[3][3]=new PublicObjectCard(46,3,3);
        bookshelf[4][3]=new PublicObjectCard(23,4,3);
        bookshelf[5][3]=new PublicObjectCard(46,5,3);
        //COLUMN 2
        bookshelf[0][1]=new PublicObjectCard(1,0,1);
        bookshelf[1][1]=new PublicObjectCard(23,1,1);
        bookshelf[2][1]=new PublicObjectCard(23,2,1);
        bookshelf[3][1]=new PublicObjectCard(23,3,1);
        bookshelf[4][1]=new PublicObjectCard(23,4,1);
        bookshelf[5][1]=new PublicObjectCard(46,5,1);

        assertTrue(cm9.check(bookshelf));
    }
    @Test
    void CommonGoalCard9SatisfiedThreeColumnsSameType(){
        PublicObjectCard [][] bookshelf;
        int k=0;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard9 cm9bis=new CommonGoalCard9(4);
        //COLUMN 1
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf[2][0]=new PublicObjectCard(1,2,0);
        bookshelf[3][0]=new PublicObjectCard(1,3,0);
        bookshelf[4][0]=new PublicObjectCard(1,4,0);
        bookshelf[5][0]=new PublicObjectCard(1,5,0);
        //COLUMN 2
        bookshelf[0][3]=new PublicObjectCard(1,0,3);
        bookshelf[1][3]=new PublicObjectCard(1,1,3);
        bookshelf[2][3]=new PublicObjectCard(1,2,3);
        bookshelf[3][3]=new PublicObjectCard(1,3,3);
        bookshelf[4][3]=new PublicObjectCard(1,4,3);
        bookshelf[5][3]=new PublicObjectCard(1,5,3);
        //COLUMN 2
        bookshelf[0][1]=new PublicObjectCard(1,0,1);
        bookshelf[1][1]=new PublicObjectCard(1,1,1);
        bookshelf[2][1]=new PublicObjectCard(1,2,1);
        bookshelf[3][1]=new PublicObjectCard(1,3,1);
        bookshelf[4][1]=new PublicObjectCard(1,4,1);
        bookshelf[5][1]=new PublicObjectCard(1,5,1);

        assertTrue(cm9bis.check(bookshelf));
    }
    @Test
    void CommonGoalCard9SatisfiedTwoColumns(){
        PublicObjectCard [][] bookshelf;
        int k=0;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard9 cm9tris=new CommonGoalCard9(4);
        //COLUMN 1
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf[2][0]=new PublicObjectCard(1,2,0);
        //COLUMN 2
        bookshelf[0][3]=new PublicObjectCard(1,0,3);
        bookshelf[1][3]=new PublicObjectCard(1,1,3);
        bookshelf[2][3]=new PublicObjectCard(1,2,3);

        assertFalse(cm9tris.check(bookshelf));
    }
}