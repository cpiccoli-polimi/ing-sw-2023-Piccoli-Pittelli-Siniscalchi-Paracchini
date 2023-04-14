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
        this.board = new LivingRoomBoard(commonGoalsNumber);
        this.bag = new CardsBag();

        clock = LocalTime.now();
        hours = clock.getHour();
        minutes = clock.getMinute();
        seconds = clock.getSecond();
        int nanoseconds = clock.getNano();
        clockString = new String();
        clockString += hours;
        clockString += minutes;
        clockString += seconds;
        clockString += nanoseconds;
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

        clock = LocalTime.now();
        hours = clock.getHour();
        minutes = clock.getMinute();
        seconds = clock.getSecond();
        nanoseconds = clock.getNano();
        clockString = new String();
        clockString += hours;
        clockString += minutes;
        clockString += seconds;
        clockString += nanoseconds;
        seed = parseLong(clockString);
        generator = new Random(seed);
        shuffle(list, generator);
        this.commonGoalsDeck = new CommonGoalCard[12];
        int i = 0;
        for(int j = 0; j < 12; j++){
            switch(list.get(j)){
                case 1:
                    commonGoalsDeck[i] = new CommonGoalCard1(playersNumber);
                    break;
                case 2:
                    commonGoalsDeck[i] = new CommonGoalCard2(playersNumber);
                    break;
                case 3:
                    commonGoalsDeck[i] = new CommonGoalCard3(playersNumber);
                    break;
                case 4:
                    commonGoalsDeck[i] = new CommonGoalCard4(playersNumber);
                    break;
                case 5:
                    commonGoalsDeck[i] = new CommonGoalCard5(playersNumber);
                    break;
                case 6:
                    commonGoalsDeck[i] = new CommonGoalCard6(playersNumber);
                    break;
                case 7:
                    commonGoalsDeck[i] = new CommonGoalCard7(playersNumber);
                    break;
                case 8:
                    commonGoalsDeck[i] = new CommonGoalCard8(playersNumber);
                    break;
                case 9:
                    commonGoalsDeck[i] = new CommonGoalCard9(playersNumber);
                    break;
                case 10:
                    commonGoalsDeck[i] = new CommonGoalCard10(playersNumber);
                    break;
                case 11:
                    commonGoalsDeck[i] = new CommonGoalCard11(playersNumber);
                    break;
                case 12:
                    commonGoalsDeck[i] = new CommonGoalCard12(playersNumber);
                    break;
            }
            i += 1;
        }

        this.currentPlayer = 0;
        this.leaderboard = new Player[playersNumber];
    }
    public void setupBoardObjects(){
        Tile[][] tiles = board.getTiles();
        int cardId;
        int freeSidesCounter;

        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                if(playersNumber >= tiles[i][j].getMinPlayers()){
                    cardId = bag.getCard();
                    ObjectCard drawnCard = new ObjectCard( cardId, i, j);
                    board.placeObject(drawnCard);
                }
            }
        }

        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                if(playersNumber >= tiles[i][j].getMinPlayers()){
                    freeSidesCounter = 0;
                    if(tiles[i+1][j].getObject()!=null){
                        freeSidesCounter += 1;
                    }
                    else{
                        freeSidesCounter = freeSidesCounter;
                    }
                    if(tiles[i-1][j].getObject()!=null){
                        freeSidesCounter += 1;
                    }
                    else{
                        freeSidesCounter = freeSidesCounter;
                    }
                    if(tiles[i][j+1].getObject()!=null){
                        freeSidesCounter += 1;
                    }
                    else{
                        freeSidesCounter = freeSidesCounter;
                    }
                    if(tiles[i][j-1].getObject()!=null){
                        freeSidesCounter += 1;
                    }
                    else{
                        freeSidesCounter = freeSidesCounter;
                    }
                    tiles[i][j].setFreeSides(freeSidesCounter);
                }
            }
        }
    }
    public void setupCommonGoals(){
        CommonGoalCard[] drawnCommonGoals = new CommonGoalCard[commonGoalsNumber];

        for(int i = 0; i < commonGoalsNumber; i++){
            drawnCommonGoals[i] = commonGoalsDeck[i];

            PointCard[] pointsDeck = new PointCard[playersNumber];
            switch(playersNumber){
                case 2:
                    if(i == 0){
                        pointsDeck[1] = new PointCard(Value.four, RomanNumeral.I);
                        pointsDeck[0] = new PointCard(Value.eight, RomanNumeral.I);
                    }
                    else{
                        pointsDeck[1] = new PointCard(Value.four, RomanNumeral.II);
                        pointsDeck[0] = new PointCard(Value.eight, RomanNumeral.II);
                    }
                case 3:
                    if(i == 0){
                        pointsDeck[2] = new PointCard(Value.four, RomanNumeral.I);
                        pointsDeck[1] = new PointCard(Value.six, RomanNumeral.I);
                        pointsDeck[0] = new PointCard(Value.eight, RomanNumeral.I);
                    }
                    else{
                        pointsDeck[2] = new PointCard(Value.four, RomanNumeral.II);
                        pointsDeck[1] = new PointCard(Value.six, RomanNumeral.II);
                        pointsDeck[0] = new PointCard(Value.eight, RomanNumeral.II);
                    }
                case 4:
                    if(i == 0){
                        pointsDeck[3] = new PointCard(Value.two, RomanNumeral.I);
                        pointsDeck[2] = new PointCard(Value.four, RomanNumeral.I);
                        pointsDeck[1] = new PointCard(Value.six, RomanNumeral.I);
                        pointsDeck[0] = new PointCard(Value.eight, RomanNumeral.I);

                    }
                    else{
                        pointsDeck[3] = new PointCard(Value.two, RomanNumeral.II);
                        pointsDeck[2] = new PointCard(Value.four, RomanNumeral.II);
                        pointsDeck[1] = new PointCard(Value.six, RomanNumeral.II);
                        pointsDeck[0] = new PointCard(Value.eight, RomanNumeral.II);
                    }
            }
            drawnCommonGoals[i].setPoints(pointsDeck);
        }

        board.setCommonGoals(drawnCommonGoals);
    }
    public void setupPersonalGoals(){
        for(int i = 0; i < playersNumber; i++){
            table[i].setPersonalGoal(personalGoalsDeck[i]);
        }
    }
    public void setupFirstPlayer(){
        LocalTime clock = LocalTime.now();
        int hours = clock.getHour();
        int minutes = clock.getMinute();
        int seconds = clock.getSecond();
        String clockString = new String();
        clockString += hours;
        clockString += minutes;
        clockString += seconds;
        long seed = parseLong(clockString);
        Random generator = new Random(seed);
        int firstPlayerIndex = generator.nextInt(0, 4);

        for(int i = 0; i < playersNumber; i++){
            if(i == firstPlayerIndex){
                table[i].setIsFirst(true);
                table[i].setPosition(0);
                setCurrentPlayer(0);
            }
            else{
                table[i].setIsFirst(false);
                if(i - firstPlayerIndex > 0){
                    table[i].setPosition(i - firstPlayerIndex);
                }
                else{
                    table[i].setPosition(table.length - firstPlayerIndex + i);
                }
            }
        }
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
    public void setTable(Player player, int position) {
        this.table[position] = player;
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
        this.leaderboard[position] = player;
    }
    public void nextTurn(){    }
    public void updateCommonGoals(CommonGoalCard commonGoal){    }
    public void updateBoard(){    }
}
