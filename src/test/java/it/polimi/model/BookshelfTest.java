package it.polimi.model;

import org.junit.jupiter.api.Test;

import java.awt.print.Book;

import static org.junit.jupiter.api.Assertions.*;

class BookshelfTest {
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