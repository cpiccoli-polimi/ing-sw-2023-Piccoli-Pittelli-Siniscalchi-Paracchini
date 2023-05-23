package it.polimi.model;

public class GameView {
    private final String message;
    private final Player[] table;
    private final Player[] leaderboard;
    private final LivingRoomBoard board;
    private final int currPlayer;
    public GameView(Game game, String message) {
        this.table=game.getTable();
        this.message = message;
        this.board=game.getBoard();
        this.currPlayer=game.getCurrentPlayer();
        this.leaderboard=game.getLeaderboard();
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