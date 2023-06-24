package it.polimi.model;

import it.polimi.model.exception.CommonGoalsNumberException;
import it.polimi.model.exception.PlayersNumberException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class GameViewTest {

    @Test
    void getTurnPlayerMessage() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        Game game = new Game(2,1);
        String turnPlayerMessage = "message";
        String otherPlayersMessage = "otherMessage";
        GameView gameview = new GameView(game,turnPlayerMessage,otherPlayersMessage);
        assertEquals("message", gameview.getTurnPlayerMessage());
    }

    @Test
    void getOtherPlayersMessage() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        Game game = new Game(2,1);
        String turnPlayerMessage = "message";
        String otherPlayersMessage = "otherMessage";
        GameView gameview = new GameView(game,turnPlayerMessage,otherPlayersMessage);
        assertEquals("otherMessage", gameview.getOtherPlayersMessage());
    }

    @Test
    void getTable() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        Game game = new Game(2,1);
        String message1 = "message1";
        String message2 = "message2";
        GameView gameview = new GameView(game,message1,message2);
        assertEquals(game.getTable(),gameview.getTable());
    }

    @Test
    void getLeaderboard() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        Game game = new Game(2,1);
        String message1 = "message1";
        String message2 = "message2";
        GameView gameview = new GameView(game,message1,message2);
        assertEquals(game.getLeaderboard(),gameview.getLeaderboard());
    }

    @Test
    void getBoard() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        Game game = new Game(2,1);
        String message1 = "message1";
        String message2 = "message2";
        GameView gameview = new GameView(game,message1,message2);
        assertEquals(game.getBoard(),gameview.getBoard());
    }

    @Test
    void getCurrPlayer() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        Game game = new Game(2,1);
        String message1 = "message1";
        String message2 = "message2";
        GameView gameview = new GameView(game,message1,message2);
        assertEquals(game.getCurrentPlayer(),gameview.getCurrPlayer());
    }
}