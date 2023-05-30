package it.polimi.model;

import it.polimi.model.CommonGoalCards.*;
import it.polimi.model.exception.AllCommonGoalsCompletedException;
import it.polimi.model.exception.CommonGoalAlreadyCompletedException;
import it.polimi.model.exception.CommonGoalsNumberException;
import it.polimi.model.exception.PlayersNumberException;

import java.io.FileNotFoundException;
import java.sql.Array;
import it.polimi.observer.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Collections.shuffle;

public class Game extends Observable<GameView>{
    public enum Event{
        GAME_START,
        DUPLICATE_USERNAME,
        SHOW_GAME, //(board, tutte le librerie, i common goal, e il proprio personal goal)
        TILE_ERROR,
        COLUMN_ERROR,
        FINAL_LEADERBOARD
    }

    private int id;
    private boolean done;
    private int endGamePoints;
    private int playersNumber;
    private int commonGoalsNumber;
    private Player[] table;
    private LivingRoomBoard board;
    private CardsBag bag;
    private List<PersonalGoalCard> personalGoalsDeck;
    private List<CommonGoalCard> commonGoalsDeck;
    private int currentPlayer;
    private Player[] leaderboard;

    public Game(int playersNumber, int commonGoalsNumber) throws PlayersNumberException, CommonGoalsNumberException, FileNotFoundException {
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
        if(playersNumber > 0 && playersNumber <= 4){
            this.playersNumber = playersNumber;
        }
        else{
            throw new PlayersNumberException("Wrong players number");
        }
        if(commonGoalsNumber == 1 || commonGoalsNumber == 2){
            this.commonGoalsNumber = commonGoalsNumber;
        }
        else{
            throw new CommonGoalsNumberException("Wrong common goals number");
        }
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
        this.personalGoalsDeck = new ArrayList<PersonalGoalCard>();
        for(int i = 0; i < 12; i++){
            personalGoalsDeck.add(new PersonalGoalCard(list.get(i)));
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
        this.commonGoalsDeck = new ArrayList<CommonGoalCard>();
        int i = 0;
        for(int j = 0; j < 12; j++){
            switch(list.get(j)){
                case 1:
                    commonGoalsDeck.add(i, new CommonGoalCard1(playersNumber));
                    break;
                case 2:
                    commonGoalsDeck.add(i, new CommonGoalCard2(playersNumber));
                    break;
                case 3:
                    commonGoalsDeck.add(i, new CommonGoalCard3(playersNumber));
                    break;
                case 4:
                    commonGoalsDeck.add(i, new CommonGoalCard4(playersNumber));
                    break;
                case 5:
                    commonGoalsDeck.add(i, new CommonGoalCard5(playersNumber));
                    break;
                case 6:
                    commonGoalsDeck.add(i, new CommonGoalCard6(playersNumber));
                    break;
                case 7:
                    commonGoalsDeck.add(i, new CommonGoalCard7(playersNumber));
                    break;
                case 8:
                    commonGoalsDeck.add(i, new CommonGoalCard8(playersNumber));
                    break;
                case 9:
                    commonGoalsDeck.add(i, new CommonGoalCard9(playersNumber));
                    break;
                case 10:
                    commonGoalsDeck.add(i, new CommonGoalCard10(playersNumber));
                    break;
                case 11:
                    commonGoalsDeck.add(i, new CommonGoalCard11(playersNumber));
                    break;
                case 12:
                    commonGoalsDeck.add(i, new CommonGoalCard12(playersNumber));
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
                if(playersNumber >= tiles[i][j].getMinPlayers() && tiles[i][j].getObject() == null){
                    cardId = bag.getCard();
                    ObjectCard drawnCard = new ObjectCard( cardId, i, j);
                    board.placeObject(drawnCard, drawnCard.getXCoordinate(), drawnCard.getYCoordinate());
                }
            }
        }

        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                if(playersNumber >= tiles[i][j].getMinPlayers()){
                    freeSidesCounter = 4;
                    if(i != tiles.length - 1){
                        if(tiles[i+1][j].getObject()!=null){
                            freeSidesCounter -= 1;
                        }
                    }
                    else{
                        freeSidesCounter = freeSidesCounter;
                    }
                    if(i != 0){
                        if(tiles[i-1][j].getObject()!=null){
                            freeSidesCounter -= 1;
                        }
                    }
                    else{
                        freeSidesCounter = freeSidesCounter;
                    }
                    if(j != tiles[i].length - 1){
                        if(tiles[i][j+1].getObject()!=null) {
                            freeSidesCounter -= 1;
                        }
                    }
                    else{
                        freeSidesCounter = freeSidesCounter;
                    }
                    if(j != 0){
                        if(tiles[i][j-1].getObject()!=null) {
                            freeSidesCounter -= 1;
                        }
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
            drawnCommonGoals[i] = commonGoalsDeck.remove(0);

            List<PointCard> pointsDeck = new ArrayList<PointCard>();
            switch(playersNumber){
                case 2:
                    if(i == 0){
                        pointsDeck.add(new PointCard(Value.eight, RomanNumeral.I));
                        pointsDeck.add(new PointCard(Value.four, RomanNumeral.I));
                    }
                    else{
                        pointsDeck.add(new PointCard(Value.eight, RomanNumeral.II));
                        pointsDeck.add(new PointCard(Value.four, RomanNumeral.II));
                    }
                    break;
                case 3:
                    if(i == 0){
                        pointsDeck.add(new PointCard(Value.eight, RomanNumeral.I));
                        pointsDeck.add(new PointCard(Value.six, RomanNumeral.I));
                        pointsDeck.add(new PointCard(Value.four, RomanNumeral.I));
                    }
                    else{
                        pointsDeck.add(new PointCard(Value.eight, RomanNumeral.II));
                        pointsDeck.add(new PointCard(Value.six, RomanNumeral.II));
                        pointsDeck.add(new PointCard(Value.four, RomanNumeral.II));
                    }
                    break;
                case 4:
                    if(i == 0){
                        pointsDeck.add(new PointCard(Value.eight, RomanNumeral.I));
                        pointsDeck.add(new PointCard(Value.six, RomanNumeral.I));
                        pointsDeck.add(new PointCard(Value.four, RomanNumeral.I));
                        pointsDeck.add(new PointCard(Value.two, RomanNumeral.I));
                    }
                    else{
                        pointsDeck.add(new PointCard(Value.eight, RomanNumeral.II));
                        pointsDeck.add(new PointCard(Value.six, RomanNumeral.II));
                        pointsDeck.add(new PointCard(Value.four, RomanNumeral.II));
                        pointsDeck.add(new PointCard(Value.two, RomanNumeral.II));
                    }
                    break;
            }
            drawnCommonGoals[i].setPoints(pointsDeck);
        }

        board.setCommonGoals(drawnCommonGoals);
    }
    public void setupPersonalGoals(){
        for(int i = 0; i < playersNumber; i++){
            table[i].setPersonalGoal(personalGoalsDeck.remove(0));
        }
    }
    public void setupFirstPlayer(){
        LocalTime clock = LocalTime.now();
        int hours = clock.getHour();
        int minutes = clock.getMinute();
        int seconds = clock.getSecond();
        int nanoseconds = clock.getNano();
        String clockString = new String();
        clockString += hours;
        clockString += minutes;
        clockString += seconds;
        clockString += nanoseconds;
        long seed = parseLong(clockString);
        Random generator = new Random(seed);
        int firstPlayerIndex = generator.nextInt(playersNumber);

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
    public List<PersonalGoalCard> getPersonalGoalsDeck() {
        return personalGoalsDeck;
    }
    public List<CommonGoalCard> getCommonGoalsDeck() {
        return commonGoalsDeck;
    }
    public int getCurrentPlayer(){return currentPlayer;}
    public void setCurrentPlayer(int array_position) {
        this.currentPlayer = array_position;
    }
    public Player[] getLeaderboard(){
        return leaderboard;
    }
    public void setLeaderboard(Player player, int position) {
        this.leaderboard[position] = player;
    }
    public void nextTurn(){
        int i = 0;
        while(this.table[i].getPosition() != this.currentPlayer){
            i += 1;
        }
        if(this.table[i].getPosition() == playersNumber - 1){
            this.currentPlayer = 0;
        }
        else{
            this.currentPlayer += 1;
        }
    }
    public void updateCommonGoals(CommonGoalCard commonGoal){
        int i = 0;
        int points;
        while(this.table[i].getPosition() != this.currentPlayer){
            i += 1;
        }
        if(commonGoal.getPoints().isEmpty() == false){
            points = this.table[i].getPoints();
            points += commonGoal.getPoints().remove(0).getValue().i;
            this.table[i].setPoints(points);
        }
    }
    /*public void updateBoard(){
        setupBoardObjects();
    }*/

    public void handleTurn(String turnPlayerMessage, String otherPlayersMessage) {
        notify(new GameView(this, turnPlayerMessage, otherPlayersMessage));

    }
    public void insertInOrder(int [] order){
        int i = 0;
        while(this.table[i].getPosition() != this.currentPlayer){
            i += 1;
        }
        Player currentPlayer = this.table[i];
        ObjectCard [] objectCard = currentPlayer.getChosenObjects();
        ObjectCard [] objectCardsOrdered=new ObjectCard[order.length];
        int column = currentPlayer.getChosenColumn();
        Bookshelf bookshelf = currentPlayer.getBookshelf();
        for(int j=0;j<order.length;j++){
            objectCardsOrdered[order[j]-1]=objectCard[j];
        }
        for(int j=0;j< order.length;j++){
            bookshelf.setShelf(objectCardsOrdered[j],column);
        }
        bookshelf.updateMaxDrawableObjects();

    }

    public void endTurnChecks()  {
        int i = 0;
        while(this.table[i].getPosition() != this.currentPlayer){
            i += 1;
        }
        Player currentPlayer = this.table[i];
        boolean b=true;
        Bookshelf bookshelf = currentPlayer.getBookshelf();
        if(bookshelf.isFull()==true){
            this.setDone(true);
        }
        updateBoard();
        CommonGoalCard [] commonGoalCard= board.getCommonGoals();
        for(i=0;i<commonGoalCard.length;i++) {
            for (int j = 0; j < commonGoalCard.length; j++) {
                if (currentPlayer.getCommonGoalsCompleted()[j] == commonGoalCard[i].getGoalID()) {
                    b = false;
                }
            }
            if (b && commonGoalCard[i].check(bookshelf.getShelf()) == true) {
                try {
                    currentPlayer.setCommonGoalsCompleted(currentPlayer.getCommonGoalsCompleted(), commonGoalCard[i].getGoalID());
                } catch (CommonGoalAlreadyCompletedException e) {
                    throw new RuntimeException(e);
                } catch (AllCommonGoalsCompletedException e) {
                    throw new RuntimeException(e);
                }

                updateCommonGoals(commonGoalCard[i]);
            }
        }
        nextTurn();
        i = 0;
        while(this.table[i].getPosition() != this.currentPlayer){
            i += 1;
        }
        currentPlayer = this.table[i];
        String turnPlayerMessage = "Choose up to 3 object cards from the board that you want to put in a column of your own library";;
        String otherPlayersMessage = "Now it's " + currentPlayer.getNickname() + "'s turn. Wait your turn";
        handleTurn(turnPlayerMessage, otherPlayersMessage);
    }

    /*public void updateTurn(){
        if(getCurrentPlayer()==playersNumber-1){
            setCurrentPlayer(0);
        }
        else setCurrentPlayer(getCurrentPlayer()+1);
    }*/
    private void updateBoard() {
        LivingRoomBoard board = this.getBoard();
        Tile[][] tiles = board.getTiles();
        boolean free = true;

        // Check if each tile has 4 free sides
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                if(this.getPlayersNumber() >= tiles[i][j].getMinPlayers()){
                    if (tiles[i][j].getFreeSides() != 4) {
                        free = false;
                    }
                }
            }
        }
        // Repopulate the board
        if (free == true) {
            CardsBag bag = this.getBag();
            int cardId;

            for(int i = 0; i < tiles.length; i++){
                for(int j = 0; j < tiles[i].length; j++){
                    if(tiles[i][j].getMinPlayers() <= this.getPlayersNumber() && tiles[i][j] != null){
                        cardId = bag.getCard();
                        ObjectCard drawnCard = new ObjectCard(cardId, i, j);
                        board.placeObject(drawnCard,i,j);
                    }
                }
            }
        }
    }
    public void DeclareWinner() {
        Player[] table = getTable();
        for(int i=0; i< table.length;i++){
            table[i].countPersonalGoalsPoints();
            table[i].countAdjacentItemsPoints();
        }
        // *** CREATE LEADERBOARD ***
        // Create support int array to check points
        // It contains [points][playerNumberInArray]
        int[][] points = new int[table.length][2];
        for(int i=0;i< table.length;i++){
            points[i][0] = table[i].getPoints();
            points[i][1] = i;
        }
        // Reorder array
        for (int k = 0; k < points.length; k++) {
            for (int i= 0; i < points[k].length; i++) {
                for (int j = 0; j < points[k].length; j++) {
                    if (points[k][i] < points[k][j]) {
                        int temp = points[k][i];
                        points[k][i] = points[k][j];
                        points[k][j] = temp;
                    }
                }
            }
        }
        // Copy in order into leaderboard
        for (int i = 0; i < table.length; i++) {
            setLeaderboard(table[points[i][1]],i);
        }
        handleTurn("");
        //TextualUI.showLeaderboard(model.getLeaderboard());
    }

}
