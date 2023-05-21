package it.polimi.model;

public class GameView {
    private long serialVersionUID;
    private Player[] table;
    private Player[] leaderboard;
    private LivingRoomBoard board;

    public GameView(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public void PlayerChoice(Game game){
        this.table = game.getTable();
        this.leaderboard = game.getLeaderboard();
        this.board = game.getBoard();
    }
    public Player[] getTable(){return table;}
    public Player[] getLeaderboard(){return leaderboard;}
    public LivingRoomBoard getBoard(){return board;}

}
