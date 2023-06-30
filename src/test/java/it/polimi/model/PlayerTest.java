package it.polimi.model;

import org.junit.jupiter.api.Test;
import it.polimi.model.Player;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void TestAdjacentItemsPoints() {
        Player playerTest = new Player("Gigi",2);
        Bookshelf bookshelf = new Bookshelf();
        playerTest.setBookshelf(bookshelf);
        PublicObjectCard [][] shelf;
        shelf= new PublicObjectCard[6][5];
        //Six cards with same type adjacent -> 8 points
        shelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf.setShelf(shelf[0][0]);
        shelf[0][1]=new PublicObjectCard(1,0,1);
        bookshelf.setShelf(shelf[0][1]);
        shelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf.setShelf(shelf[1][0]);
        shelf[1][1]=new PublicObjectCard(1,1,1);
        bookshelf.setShelf(shelf[1][1]);
        shelf[1][2]=new PublicObjectCard(1,1,2);
        bookshelf.setShelf(shelf[1][2]);
        shelf[1][3]=new PublicObjectCard(1,1,3);
        bookshelf.setShelf(shelf[1][3]);
        playerTest.countAdjacentItemsPoints();
        assertEquals(8, playerTest.getPoints());
    }

    @Test
    public void TestAdjacentItemsPoints2() {
        Player playerTest = new Player("Gigi",2);
        Bookshelf bookshelf = new Bookshelf();
        playerTest.setBookshelf(bookshelf);
        PublicObjectCard [][] shelf;
        shelf= new PublicObjectCard[6][5];
        //Three cards with same type adjacent -> 2 points
        shelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf.setShelf(shelf[1][0]);
        shelf[1][1]=new PublicObjectCard(1,1,1);
        bookshelf.setShelf(shelf[1][1]);
        shelf[1][2]=new PublicObjectCard(1,1,2);
        bookshelf.setShelf(shelf[1][2]);
        playerTest.countAdjacentItemsPoints();
        assertEquals(2, playerTest.getPoints());
    }

    @Test
    public void TestAdjacentItemsPoints3() {
        Player playerTest = new Player("Gigi",2);
        Bookshelf bookshelf = new Bookshelf();
        playerTest.setBookshelf(bookshelf);
        PublicObjectCard [][] shelf;
        shelf= new PublicObjectCard[6][5];
        //Six cards with same type adjacent -> 8 points
        shelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf.setShelf(shelf[0][0]);
        shelf[0][1]=new PublicObjectCard(1,0,1);
        bookshelf.setShelf(shelf[0][1]);
        shelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf.setShelf(shelf[1][0]);
        shelf[1][1]=new PublicObjectCard(1,1,1);
        bookshelf.setShelf(shelf[1][1]);
        shelf[1][2]=new PublicObjectCard(1,1,2);
        bookshelf.setShelf(shelf[1][2]);
        shelf[1][3]=new PublicObjectCard(1,1,3);
        bookshelf.setShelf(shelf[1][3]);

        //Three cards with same type adjacent -> 2 points
        shelf[3][0]=new PublicObjectCard(23,3,0);
        bookshelf.setShelf(shelf[3][0]);
        shelf[3][1]=new PublicObjectCard(23,3,1);
        bookshelf.setShelf(shelf[3][1]);
        shelf[3][2]=new PublicObjectCard(23,3,2);
        bookshelf.setShelf(shelf[3][2]);

        playerTest.countAdjacentItemsPoints();
        assertEquals(10, playerTest.getPoints());
    }

    @Test
    public void TestAdjacentItemsPoints4() {
        Player playerTest = new Player("Gigi",2);
        Bookshelf bookshelf = new Bookshelf();
        playerTest.setBookshelf(bookshelf);
        PublicObjectCard [][] shelf;
        shelf= new PublicObjectCard[6][5];
        //Three cards with same type in diagonal -> 0 points
        shelf[1][0]=new PublicObjectCard(1,1,0);
        bookshelf.setShelf(shelf[1][0]);
        shelf[2][1]=new PublicObjectCard(1,2,1);
        bookshelf.setShelf(shelf[2][1]);
        shelf[3][0]=new PublicObjectCard(1,3,0);
        bookshelf.setShelf(shelf[3][0]);
        playerTest.countAdjacentItemsPoints();
        assertEquals(0, playerTest.getPoints());
    }

    @Test
    public void TestAdjacentItemsPoints5() {
        Player playerTest = new Player("Gigi",2);
        Bookshelf bookshelf = new Bookshelf();
        playerTest.setBookshelf(bookshelf);
        PublicObjectCard [][] shelf;
        shelf= new PublicObjectCard[6][5];
        //Six cards with same type adjacent -> 2 points
        shelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf.setShelf(shelf[0][0]);
        shelf[0][1]=new PublicObjectCard(2,0,1);
        bookshelf.setShelf(shelf[0][1]);
        shelf[1][0]=new PublicObjectCard(3,1,0);
        bookshelf.setShelf(shelf[1][0]);

        //Three cards with same type above adjacent but separated from the previous group -> 2 points
        shelf[3][0]=new PublicObjectCard(4,3,0);
        bookshelf.setShelf(shelf[3][0]);
        shelf[3][1]=new PublicObjectCard(5,3,1);
        bookshelf.setShelf(shelf[3][1]);
        shelf[3][2]=new PublicObjectCard(6,3,2);
        bookshelf.setShelf(shelf[3][2]);

        //Points are counted for each group -> 4 points in total
        playerTest.countAdjacentItemsPoints();
        assertEquals(4, playerTest.getPoints());
    }

    @Test
    public void TestAdjacentItemsPoints6() {
        Player playerTest = new Player("Gigi",2);
        Bookshelf bookshelf = new Bookshelf();
        playerTest.setBookshelf(bookshelf);
        PublicObjectCard [][] shelf;
        shelf= new PublicObjectCard[6][5];
        //Six cards with same type adjacent -> 2 points
        shelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf.setShelf(shelf[0][0]);
        shelf[0][1]=new PublicObjectCard(2,0,1);
        bookshelf.setShelf(shelf[0][1]);
        shelf[1][0]=new PublicObjectCard(3,1,0);
        bookshelf.setShelf(shelf[1][0]);

        //Four cards with same type above adjacent but separated from the previous group -> 3 points
        shelf[3][0]=new PublicObjectCard(4,3,0);
        bookshelf.setShelf(shelf[3][0]);
        shelf[3][1]=new PublicObjectCard(5,3,1);
        bookshelf.setShelf(shelf[3][1]);
        shelf[3][2]=new PublicObjectCard(6,3,2);
        bookshelf.setShelf(shelf[3][2]);
        shelf[4][0]=new PublicObjectCard(7,4,0);
        bookshelf.setShelf(shelf[4][0]);

        //Points are counted for each group -> 5 points in total
        playerTest.countAdjacentItemsPoints();
        assertEquals(5, playerTest.getPoints());
    }
    @Test
    public void TestAdjacentItemsPoints7() {
        Player playerTest = new Player("Gigi",2);
        Bookshelf bookshelf = new Bookshelf();
        playerTest.setBookshelf(bookshelf);
        PublicObjectCard [][] shelf;
        shelf= new PublicObjectCard[6][5];
        //Six cards with same type adjacent -> 2 points
        shelf[0][0]=new PublicObjectCard(1,0,0);
        bookshelf.setShelf(shelf[0][0]);
        shelf[0][1]=new PublicObjectCard(2,0,1);
        bookshelf.setShelf(shelf[0][1]);
        shelf[1][0]=new PublicObjectCard(3,1,0);
        bookshelf.setShelf(shelf[1][0]);

        //Five cards with same type above adjacent but separated from the previous group -> 5 points
        shelf[3][0]=new PublicObjectCard(4,3,0);
        bookshelf.setShelf(shelf[3][0]);
        shelf[3][1]=new PublicObjectCard(5,3,1);
        bookshelf.setShelf(shelf[3][1]);
        shelf[3][2]=new PublicObjectCard(6,3,2);
        bookshelf.setShelf(shelf[3][2]);
        shelf[4][0]=new PublicObjectCard(7,4,0);
        bookshelf.setShelf(shelf[4][0]);
        shelf[5][0]=new PublicObjectCard(8,5,0);
        bookshelf.setShelf(shelf[5][0]);

        //Points are counted for each group -> 7 points in total
        playerTest.countAdjacentItemsPoints();
        assertEquals(7, playerTest.getPoints());
    }

    @Test
    public void CountPersonalGoalPointsNoGoal() {
        Player gigi = new Player("Gigi",2);
        PersonalGoalCard personalGoal = new PersonalGoalCard(1);
        gigi.setPersonalGoal(personalGoal);
        Bookshelf bookshelf = new Bookshelf();
        gigi.setBookshelf(bookshelf);
        PublicObjectCard [][] shelf;
        shelf= new PublicObjectCard[6][5];

        //No PersonalGoal tiles matched
        gigi.countPersonalGoalsPoints();
        assertEquals(0, gigi.getPoints());
    }

    @Test
    public void CountPersonalGoalPointsOneGoal() {
        Player gigi = new Player("Gigi",2);
        PersonalGoalCard personalGoal = new PersonalGoalCard(1);
        gigi.setPersonalGoal(personalGoal);
        Bookshelf bookshelf = new Bookshelf();
        gigi.setBookshelf(bookshelf);
        PublicObjectCard [][] shelf;
        shelf= new PublicObjectCard[6][5];

        //One PersonalGoal tile matched
        shelf[0][0]=new PublicObjectCard(47,0,0);
        gigi.getBookshelf().setShelf(new ObjectCard(47,0,0));
        gigi.countPersonalGoalsPoints();
        assertEquals(1, gigi.getPoints());
    }

    @Test
    public void CountPersonalGoalPointsTwoGoals() {
        Player gigi = new Player("Gigi",2);
        PersonalGoalCard personalGoal = new PersonalGoalCard(1);
        gigi.setPersonalGoal(personalGoal);
        Bookshelf bookshelf = new Bookshelf();
        gigi.setBookshelf(bookshelf);
        PublicObjectCard [][] shelf;
        shelf= new PublicObjectCard[6][5];

        //Two PersonalGoal tiles matched
        shelf[0][0]=new PublicObjectCard(47,0,0);
        gigi.getBookshelf().setShelf(new ObjectCard(47,0,0));
        shelf[0][2]=new PublicObjectCard(90,0,2);
        gigi.getBookshelf().setShelf(new ObjectCard(90,0,2));
        gigi.countPersonalGoalsPoints();
        assertEquals(2, gigi.getPoints());
    }

    @Test
    public void CountPersonalGoalPointsThreeGoals() {
        Player gigi = new Player("Gigi",2);
        PersonalGoalCard personalGoal = new PersonalGoalCard(1);
        gigi.setPersonalGoal(personalGoal);
        Bookshelf bookshelf = new Bookshelf();
        gigi.setBookshelf(bookshelf);
        PublicObjectCard [][] shelf;
        shelf= new PublicObjectCard[6][5];

        //Three Personal Goal tiles matched
        shelf[0][0]=new PublicObjectCard(47,0,0);
        gigi.getBookshelf().setShelf(new ObjectCard(47,0,0));
        shelf[0][2]=new PublicObjectCard(90,0,2);
        gigi.getBookshelf().setShelf(new ObjectCard(90,0,2));
        shelf[1][4]=new PublicObjectCard(1,1,4);
        gigi.getBookshelf().setShelf(new ObjectCard(1,1,4));
        gigi.countPersonalGoalsPoints();
        assertEquals(4, gigi.getPoints());
    }

    @Test
    public void CountPersonalGoalPointsFourGoals() {
        Player gigi = new Player("Gigi",2);
        PersonalGoalCard personalGoal = new PersonalGoalCard(1);
        gigi.setPersonalGoal(personalGoal);
        Bookshelf bookshelf = new Bookshelf();
        gigi.setBookshelf(bookshelf);
        PublicObjectCard [][] shelf;
        shelf= new PublicObjectCard[6][5];

        //Four PersonalGoal tiles matched
        shelf[0][0]=new PublicObjectCard(47,0,0);
        gigi.getBookshelf().setShelf(new ObjectCard(47,0,0));
        shelf[0][2]=new PublicObjectCard(90,0,2);
        gigi.getBookshelf().setShelf(new ObjectCard(90,0,2));
        shelf[1][4]=new PublicObjectCard(1,1,4);
        gigi.getBookshelf().setShelf(new ObjectCard(1,1,4));
        shelf[2][3]=new PublicObjectCard(68,2,3);
        gigi.getBookshelf().setShelf(new ObjectCard(69,2,3));
        gigi.countPersonalGoalsPoints();
        assertEquals(6, gigi.getPoints());
    }

    @Test
    public void CountPersonalGoalPointsFiveGoals() {
        Player gigi = new Player("Gigi",2);
        PersonalGoalCard personalGoal = new PersonalGoalCard(1);
        gigi.setPersonalGoal(personalGoal);
        Bookshelf bookshelf = new Bookshelf();
        gigi.setBookshelf(bookshelf);
        PublicObjectCard [][] shelf;
        shelf= new PublicObjectCard[6][5];

        //Five PersonalGoal tiles matched
        shelf[0][0]=new PublicObjectCard(47,0,0);
        gigi.getBookshelf().setShelf(new ObjectCard(47,0,0));
        shelf[0][2]=new PublicObjectCard(90,0,2);
        gigi.getBookshelf().setShelf(new ObjectCard(90,0,2));
        shelf[1][4]=new PublicObjectCard(1,1,4);
        gigi.getBookshelf().setShelf(new ObjectCard(1,1,4));
        shelf[2][3]=new PublicObjectCard(68,2,3);
        gigi.getBookshelf().setShelf(new ObjectCard(69,2,3));
        shelf[3][1]=new PublicObjectCard(112,3,1);
        gigi.getBookshelf().setShelf(new ObjectCard(112,3,1));
        gigi.countPersonalGoalsPoints();
        assertEquals(9, gigi.getPoints());
    }

    @Test
    public void CountPersonalGoalPointsSixGoals() {
        Player gigi = new Player("Gigi",2);
        PersonalGoalCard personalGoal = new PersonalGoalCard(1);
        gigi.setPersonalGoal(personalGoal);
        Bookshelf bookshelf = new Bookshelf();
        gigi.setBookshelf(bookshelf);
        PublicObjectCard [][] shelf;
        shelf= new PublicObjectCard[6][5];

        //Six PersonalGoal tiles matched
        shelf[0][0]=new PublicObjectCard(47,0,0);
        gigi.getBookshelf().setShelf(new ObjectCard(47,0,0));
        shelf[0][2]=new PublicObjectCard(90,0,2);
        gigi.getBookshelf().setShelf(new ObjectCard(90,0,2));
        shelf[1][4]=new PublicObjectCard(1,1,4);
        gigi.getBookshelf().setShelf(new ObjectCard(1,1,4));
        shelf[2][3]=new PublicObjectCard(68,2,3);
        gigi.getBookshelf().setShelf(new ObjectCard(69,2,3));
        shelf[3][1]=new PublicObjectCard(112,3,1);
        gigi.getBookshelf().setShelf(new ObjectCard(112,3,1));
        shelf[5][2]=new PublicObjectCard(23,5,2);
        gigi.getBookshelf().setShelf(new ObjectCard(23,5,2));
        gigi.countPersonalGoalsPoints();
        assertEquals(12, gigi.getPoints());
    }

    @Test
    public void TestSetPersonalGoal() {
        Player gigi = new Player("Gigi",2);
        PersonalGoalCard personalGoal = new PersonalGoalCard(2);
        gigi.setPersonalGoal(personalGoal);
        assertEquals(personalGoal, gigi.getPersonalGoal());
    }
}