package it.polimi.model;

import java.io.Serializable;

/**
 * GameView class is meant to copy necessary attributes from
 * game class and make it final, to pass through the network
 * only "final" attributes and serialize them
 *
 * @see java.io.Serializable
 * @author Lorenzo Pittelli
 * @author Nicola Siniscalchi
 */
public class GameView implements Serializable{
    static final long serialVersionUID = 1L;
    private final String turnPlayerMessage;
    private final String otherPlayersMessage;
    private final Player[] table;
    private final Player[] leaderboard;
    private final LivingRoomBoard board;
    private final int currPlayer;
    /**
     * Builds GameView copying attributes from Game
     *
     * @param game the Game that needs to be serialized
     * @param turnPlayerMessage the string to show to the current player
     * @param otherPlayersMessage the string to show to the other players
     */
    public GameView(Game game, String turnPlayerMessage, String otherPlayersMessage) {
        this.table=game.getTable();
        this.turnPlayerMessage = turnPlayerMessage;
        this.otherPlayersMessage = otherPlayersMessage;
        this.board=game.getBoard();
        this.currPlayer=game.getCurrentPlayer();
        this.leaderboard=game.getLeaderboard();
    }

    /**
     * @return the string shown to the current player
     */
    public String getTurnPlayerMessage() {
        return this.turnPlayerMessage;
    }
    /**
     * @return the string shown to the other players
     */
    public String getOtherPlayersMessage(){
        return this.otherPlayersMessage;
    }
    /**
     * @return the table containing the players
     *         participating in this game
     */
    public Player[] getTable () {
        return table;
    }
    /**
     * @return the leaderboard
     */
    public Player[] getLeaderboard(){
        return leaderboard;
    }
    /**
     * @return the board
     */
    public LivingRoomBoard getBoard(){
        return board;
    }
    /**
     * @return the current player
     */
    public int getCurrPlayer(){
        return currPlayer;
    }


}