package it.polimi.model;

import it.polimi.view.View;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerChoiceTest {
    String message = "message";
    Player player = new Player(message,2);
    private View view;


    @Test
    void getMessage() {
        PlayerChoice playerChoice = new PlayerChoice(player,message,view);
        assertEquals("message", playerChoice.getMessage());
    }

    @Test
    void getPlayer() {
        PlayerChoice playerChoice = new PlayerChoice(player,message,view);
        assertEquals(player, playerChoice.getPlayer());
    }

    @Test
    void getView() {
        PlayerChoice playerChoice = new PlayerChoice(player,message,view);
        assertEquals(view, playerChoice.getView());
    }
}