package it.polimi.model;

import java.io.Serializable;

public class GameView implements Serializable{
    private final String turnPlayerMessage;
    private final String otherPlayersMessage;
    private final Player[] table;
    private final Player[] leaderboard;
    private final LivingRoomBoard board;
    private final int currPlayer;
    public GameView(Game game, String turnPlayerMessage, String otherPlayersMessage) {
        this.table=game.getTable();
        this.turnPlayerMessage = turnPlayerMessage;
        this.otherPlayersMessage = otherPlayersMessage;
        this.board=game.getBoard();
        this.currPlayer=game.getCurrentPlayer();
        this.leaderboard=game.getLeaderboard();
    }

    public String getTurnPlayerMessage() {
        return this.turnPlayerMessage;
    }
    public String getOtherPlayersMessage(){
        return this.otherPlayersMessage;
    }

    public Player[] getTable () {
        return table;
    }

    public Player[] getLeaderboard(){
        return leaderboard;
    }

    public LivingRoomBoard getBoard(){
        return board;
    }
    public int getCurrPlayer(){
        return currPlayer;
    }


}