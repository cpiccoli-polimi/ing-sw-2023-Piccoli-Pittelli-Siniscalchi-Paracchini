package it.polimi.model;

public class GameView {
    private long serialVersionUID;

    public GameView(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public void PlayerChoice(Game game){};
    public Player[] getTable(){};
    public Player[] getLeaderboard(){};
    public LivingRoomBoard getBoard(){};


}
