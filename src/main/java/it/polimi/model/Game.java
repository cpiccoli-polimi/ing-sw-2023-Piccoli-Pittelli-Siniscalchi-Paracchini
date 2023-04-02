package it.polimi.model;

import java.util.Observable;

public class Game extends Observable{

    private int id;
    private boolean done;
    private int endGamePoints;
    private int playersNumber;
    private int commonGoalsNumber;
    private Player[] table;
    private LivingRoomBoard board;
    private CardsBag bag;
    private PersonalGoalCard[] personalGoalsDeck;
    private CommonGoalCard[] commonGoalsDeck;
    private int currentPlayer;
    private Player[] leaderboard;

    public Game(int playersNumber, int commonGoalsNumber){    }
    public int getId(){
        return id;
    }
    public boolean getDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    public int getEndGamePoints() {
        return endGamePoints;
    }
    public int getPlayersNumber(){
        return playersNumber;
    }
    public int getCommonGoalsNumber(){
        return commonGoalsNumber;
    }
    public Player[] getTable() {
        return table;
    }
    public void setTable(Player table, int position) {
        this.table = table;
    }
    public LivingRoomBoard getBoard() {
        return board;
    }
    public CardsBag getBag() {
        return bag;
    }
    public PersonalGoalCard[] getPersonalGoalsDeck() {
        return personalGoalsDeck;
    }
    public CommonGoalCard[] getCommonGoalsDeck() {
        return commonGoalsDeck;
    }
    public int getCurrentPlayer(){
        return currentPlayer;
    }
    public void setCurrentPlayer(int position) {
        this.currentPlayer = position;
    }
    public Player[] getLeaderboard(){
        return leaderboard;
    }
    public void setLeaderboard(Player player, int position) {
        this.leaderboard = leaderboard;
    }
    public void nextTurn(){    }
    public void updateCommonGoals(CommonGoalCard commonGoal){    }
    public void updateBoard(){    }
}
