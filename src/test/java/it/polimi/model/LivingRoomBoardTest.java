package it.polimi.model;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class LivingRoomBoardTest {

    @Test
    void removeObject() throws FileNotFoundException {
        LivingRoomBoard livingRoomBoard = new LivingRoomBoard(1);
        Tile tile[][] = livingRoomBoard.getTiles();
        //Check it was not null before removal
        assertNotEquals(null,tile[1][1]);
        //Check the tile was effectively removed
        assertEquals(null,livingRoomBoard.removeObject(1,1));
    }

    @Test
    void updateFreeSidesTest() throws FileNotFoundException {
        LivingRoomBoard livingRoomBoard = new LivingRoomBoard(1);
        Tile tile[][] = livingRoomBoard.getTiles();
        //Check it was not null before removal
        Tile[][] tile1 = livingRoomBoard.getTiles();
        ObjectCard[] pickedObject = new ObjectCard[1];
        ObjectCard objectCard = new ObjectCard(1,5,5);
        tile1[5][5].setObject(objectCard);
        pickedObject[0] = tile1[5][5].getObject();
        assertEquals(0,tile[5][5].getFreeSides());
        //Remove the tile
        livingRoomBoard.removeObject(1,1);
        livingRoomBoard.updateFreeSides(pickedObject);
        //Check the tiles around have now 1 free side
        assertEquals(1,tile[5][4].getFreeSides());
        assertEquals(1,tile[5][6].getFreeSides());
        assertEquals(1,tile[4][5].getFreeSides());
        assertEquals(1,tile[6][5].getFreeSides());
    }
}