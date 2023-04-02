package it.polimi.model;

import it.polimi.model.CommonGoalCards.*;

import java.util.Observable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Collections.shuffle;

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

    public Game(int playersNumber, int commonGoalsNumber){
        LocalTime clock = LocalTime.now();
        int hours = clock.getHour();
        int minutes = clock.getMinute();
        int seconds = clock.getSecond();
        String clockString = new String();
        clockString += hours;
        clockString += minutes;
        clockString += seconds;
        this.id = parseInt(clockString);

        this.done = false;
        this.endGamePoints = 1;
        this.playersNumber = playersNumber;
        this.commonGoalsNumber = commonGoalsNumber;
        this.table = new Player[playersNumber];
        this.board = new Board(commonGoalsNumber);
        this.bag = new CardsBard();

        clock = LocalTime.now();
        hours = clock.getHour();
        minutes = clock.getMinute();
        seconds = clock.getSecond();
        clockString = new String();
        clockString += hours;
        clockString += minutes;
        clockString += seconds;
        long seed = parseLong(clockString);
        Random generator = new Random(seed);
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<12; i++){
            list.add(i+1);
        }
        shuffle(list, generator);
        this.personalGoalsDeck = new PersonalGoalCard[12];
        for(int i = 0; i < 12; i++){
            personalGoalsDeck[i] = new PersonalGoalCard(list.get(i));
        }

        this.commonGoalsDeck = new CommonGoalCard[12];
        commonGoalsDeck[0] = new CommonGoalCard1(playersNumber);
        commonGoalsDeck[1] = new CommonGoalCard2(playersNumber);
        commonGoalsDeck[2] = new CommonGoalCard3(playersNumber);
        commonGoalsDeck[3] = new CommonGoalCard4(playersNumber);
        commonGoalsDeck[4] = new CommonGoalCard5(playersNumber);
        commonGoalsDeck[5] = new CommonGoalCard6(playersNumber);
        commonGoalsDeck[6] = new CommonGoalCard7(playersNumber);
        commonGoalsDeck[7] = new CommonGoalCard8(playersNumber);
        commonGoalsDeck[8] = new CommonGoalCard9(playersNumber);
        commonGoalsDeck[9] = new CommonGoalCard10(playersNumber);
        commonGoalsDeck[10] = new CommonGoalCard11(playersNumber);
        commonGoalsDeck[11] = new CommonGoalCard12(playersNumber);

        this.currentPlayer = 0;
        this.leaderboard = new Player[playersNumber];
    }
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
