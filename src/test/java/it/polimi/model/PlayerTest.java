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
}