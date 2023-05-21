package it.polimi.model;

public class GameView {
    private final String message;

    private final long serialVersionUID;
    private final Player[] table;
    private final Player[] leaderboard;
    private final LivingRoomBoard board;
    private final int currPlayer;
    public GameView(long serialVersionUID,Player[] table,Player[] leaderboard,LivingRoomBoard board,String message, int currPlayer ) {
        this.serialVersionUID=serialVersionUID;
        this.table=table;
        this.message = message;
        this.board=board;
        this.currPlayer=currPlayer;
        this.leaderboard=leaderboard;
    }

    public String getMessage() {
        return message;
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