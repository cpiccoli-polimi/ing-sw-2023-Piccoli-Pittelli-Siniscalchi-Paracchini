package it.polimi.model.CommonGoalCards;

import it.polimi.model.PublicObjectCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard7Test {

    @Test
    void CommonGoal7SatisfiedTest() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard7 cm7=new CommonGoalCard7(4);
        // -- 2 squares of 4 tiles with same type --
        //SQUARE 1
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf[0][1]=new PublicObjectCard(1,0,1);
        bookshelf[1][1]=new PublicObjectCard(1,1,1);

        //SQUARE 2
        bookshelf[3][2]=new PublicObjectCard(1,3,2);
        bookshelf[3][3]=new PublicObjectCard(1,3,3);
        bookshelf[4][2]=new PublicObjectCard(1,4,2);
        bookshelf[4][3]=new PublicObjectCard(1,4,3);

        //Tiles around with different types
        bookshelf[2][0]=new PublicObjectCard(45,2,0);
        bookshelf[2][1]=new PublicObjectCard(45,2,1);
        bookshelf[2][2]=new PublicObjectCard(45,2,2);
        bookshelf[2][3]=new PublicObjectCard(45,2,3);
        bookshelf[0][2]=new PublicObjectCard(45,0,2);
        bookshelf[1][2]=new PublicObjectCard(45,1,2);
        bookshelf[3][1]=new PublicObjectCard(45,3,1);
        bookshelf[4][1]=new PublicObjectCard(45,4,1);
        bookshelf[5][2]=new PublicObjectCard(45,5,2);
        bookshelf[5][3]=new PublicObjectCard(45,5,3);
        bookshelf[3][4]=new PublicObjectCard(45,3,4);
        bookshelf[4][4]=new PublicObjectCard(45,4,4);
        assertTrue(cm7.check(bookshelf));
    }
    @Test
    void CommonGoal7SatisfiedTest2() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard7 cm7bis=new CommonGoalCard7(4);
        // -- 2 squares of 4 tiles with different types --
        //SQUARE 1
        bookshelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf[0][1]=new PublicObjectCard(1,0,1);
        bookshelf[1][1]=new PublicObjectCard(1,1,1);

        //SQUARE 2
        bookshelf[3][2]=new PublicObjectCard(46,3,2);
        bookshelf[3][3]=new PublicObjectCard(46,3,3);
        bookshelf[4][2]=new PublicObjectCard(46,4,2);
        bookshelf[4][3]=new PublicObjectCard(46,4,3);

        for(int i=0;i< bookshelf.length;i++){
            for(int j=0;j<bookshelf[0].length;j++){
                if(bookshelf[i][j]==null){
                    bookshelf[i][j]=new PublicObjectCard(95,i,j);
                }
            }
        }

        assertTrue(cm7bis.check(bookshelf));
    }
    @Test
    void CommonGoal7SatisfiedTest3() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard7 cm7=new CommonGoalCard7(4);
        for(int i=0;i<bookshelf.length;i++){
            for(int j=0;j<bookshelf[0].length;j++){
                bookshelf[i][j]=new PublicObjectCard(1,i,j);
            }
        }

        bookshelf[0][1]=new PublicObjectCard(46,0,1);
        bookshelf[0][2]=new PublicObjectCard(49,0,2);
        bookshelf[1][1]=new PublicObjectCard(47,1,1);
        bookshelf[1][2]=new PublicObjectCard(48,1,2);

        bookshelf[4][2]=new PublicObjectCard(100,3,3);
        bookshelf[4][3]=new PublicObjectCard(100,3,4);
        bookshelf[5][2]=new PublicObjectCard(100,4,3);
        bookshelf[5][3]=new PublicObjectCard(100,4,4);
        assertTrue(cm7.check(bookshelf));
    }

    @Test
    void CommonGoal7SatisfiedTest4() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard7 cm7=new CommonGoalCard7(4);
        for(int i=0;i<bookshelf.length;i++){
            for(int j=0;j<bookshelf[0].length;j++){
                bookshelf[i][j]=new PublicObjectCard(1,i,j);
            }
        }

        bookshelf[0][1]=new PublicObjectCard(46,0,1);
        bookshelf[0][2]=new PublicObjectCard(49,0,2);
        bookshelf[1][1]=new PublicObjectCard(47,1,1);
        bookshelf[1][2]=new PublicObjectCard(48,1,2);

        bookshelf[4][3]=new PublicObjectCard(100,3,3);
        bookshelf[4][4]=new PublicObjectCard(100,3,4);
        bookshelf[5][3]=new PublicObjectCard(100,4,3);
        bookshelf[5][4]=new PublicObjectCard(100,4,4);
        assertTrue(cm7.check(bookshelf));
    }
    @Test
    void CommonGoal7SatisfiedTest5() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard7 cm7=new CommonGoalCard7(4);
        for(int i=0;i<bookshelf.length;i++){
            for(int j=0;j<bookshelf[0].length;j++){
                bookshelf[i][j]=new PublicObjectCard(1,i,j);
            }
        }

        bookshelf[1][0]=new PublicObjectCard(46,0,1);
        bookshelf[1][1]=new PublicObjectCard(49,0,2);
        bookshelf[2][0]=new PublicObjectCard(47,1,1);
        bookshelf[2][1]=new PublicObjectCard(48,1,2);

        bookshelf[2][3]=new PublicObjectCard(100,3,3);
        bookshelf[2][4]=new PublicObjectCard(100,3,4);
        bookshelf[3][3]=new PublicObjectCard(100,4,3);
        bookshelf[3][4]=new PublicObjectCard(100,4,4);
        assertTrue(cm7.check(bookshelf));
    }
    @Test
    void CommonGoal7SatisfiedTest6() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard7 cm7=new CommonGoalCard7(4);
        for(int i=0;i<bookshelf.length;i++){
            for(int j=0;j<bookshelf[0].length;j++){
                bookshelf[i][j]=new PublicObjectCard(1,i,j);
            }
        }

        bookshelf[0][3]=new PublicObjectCard(46,0,1);
        bookshelf[0][4]=new PublicObjectCard(49,0,2);
        bookshelf[1][3]=new PublicObjectCard(47,1,1);
        bookshelf[1][4]=new PublicObjectCard(48,1,2);

        bookshelf[4][0]=new PublicObjectCard(100,3,3);
        bookshelf[4][1]=new PublicObjectCard(100,3,4);
        bookshelf[5][0]=new PublicObjectCard(100,4,3);
        bookshelf[5][1]=new PublicObjectCard(100,4,4);
        assertTrue(cm7.check(bookshelf));
    }


    @Test
    void CommonGoal7EmptyTest() {
        PublicObjectCard[][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard7 cm7tris=new CommonGoalCard7(4);

        assertFalse(cm7tris.check(bookshelf));
    }
}