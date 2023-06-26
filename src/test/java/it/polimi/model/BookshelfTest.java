package it.polimi.model;

import org.junit.jupiter.api.Test;

import java.awt.print.Book;

import static org.junit.jupiter.api.Assertions.*;

class BookshelfTest {
    @Test
    void updateMaxDrawableObjectsTest() {
        Bookshelf bookshelf = new Bookshelf();
        PublicObjectCard [][] shelf;
        shelf= new PublicObjectCard[6][5];
        for(int i=5;i>1;i--) {
            shelf[i][0] = new PublicObjectCard(1, i, 0);
            bookshelf.setShelf(shelf[i][0]);
            shelf[i][1] = new PublicObjectCard(1, i, 1);
            bookshelf.setShelf(shelf[i][1]);
            shelf[i][2] = new PublicObjectCard(1, i, 2);
            bookshelf.setShelf(shelf[i][2]);
            shelf[i][3] = new PublicObjectCard(1, i, 3);
            bookshelf.setShelf(shelf[i][3]);
            shelf[i][4] = new PublicObjectCard(1, i, 4);
            bookshelf.setShelf(shelf[i][4]);
        }
        bookshelf.updateMaxDrawableObjects();
        assertEquals(2,bookshelf.getMaxDrawableObjects());
    }
    @Test
    void getMaxDrawableObjects() {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.setMaxDrawableObjects(1);
        assertEquals(1,bookshelf.getMaxDrawableObjects());
    }

    @Test
    void isFull() {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.setMaxDrawableObjects(0);
        assertEquals(true,bookshelf.isFull());
    }
}