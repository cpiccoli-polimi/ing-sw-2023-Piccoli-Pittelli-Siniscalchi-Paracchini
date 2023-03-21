package it.polimi.model;

import java.util.Observable;

public class Game extends Observable{

    private int id;
    private boolean done;
    private int playersNumber;
    private int commonGoalsNumber;
    private Player[] table;
    private LivingRoomBoard board;
    private CardsBag bag;
    private PersonalGoalCard[] personalGoalsDeck;
    private commonGoalCard[] commonGoalsDeck;
    private PointCard[] pointsDeck;
    private int currentPlayer;
    private Player[] leaderboard;

    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getPlayersNumber(){
        return playersNumber;
    }

    public void setPlayersNumber(int playersNumber) {
        this.playersNumber = playersNumber;
    }

    public int getCommonGoalsNumber(){
        return commonGoalsNumber;
    }
    public void setCommonGoalsNumber(int commonGoalsNumber) {
        this.commonGoalsNumber = commonGoalsNumber;
    }

    public Player[] getTable() {
        return table;
    }

    public void setTable(Player[] table) {
        this.table = table;
    }

    public LivingRoomBoard getBoard() {
        return board;
    }

    public void setBoard(LivingRoomBoard board) {
        this.board = board;
    }

    public CardsBag getBag() {
        return bag;
    }

    public void setBag(CardsBag bag) {
        this.bag = bag;
    }

    public PersonalGoalCard[] getPersonalGoalsDeck() {
        return personalGoalsDeck;
    }

    public void setPersonalGoalsDeck(PersonalGoalCard[] personalGoalsDeck) {
        this.personalGoalsDeck = personalGoalsDeck;
    }

    public commonGoalCard[] getCommonGoalsDeck() {
        return commonGoalsDeck;
    }

    public void setCommonGoalsDeck(commonGoalCard[] commonGoalsDeck) {
        this.commonGoalsDeck = commonGoalsDeck;
    }

    public PointCard[] getPointsDeck() {
        return pointsDeck;
    }

    public void setPointsDeck(PointCard[] pointsDeck) {
        this.pointsDeck = pointsDeck;
    }

    public int getCurrentPlayer(){
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player[] getLeaderboard(){
        return leaderboard;
    }

    public void setLeaderboard(Player[] leaderboard) {
        this.leaderboard = leaderboard;
    }

}
