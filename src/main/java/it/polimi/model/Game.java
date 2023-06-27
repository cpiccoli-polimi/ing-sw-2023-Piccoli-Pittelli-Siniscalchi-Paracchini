package it.polimi.model;

import it.polimi.model.CommonGoalCards.*;
import it.polimi.model.exception.CommonGoalsNumberException;
import it.polimi.model.exception.PlayersNumberException;
import it.polimi.observer.Observable;

import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Collections.shuffle;

public class Game extends Observable<GameView>{

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
        String clockString = "";
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
            throw new PlayersNumberException();
        }
        if(commonGoalsNumber == 1 || commonGoalsNumber == 2){
            this.commonGoalsNumber = commonGoalsNumber;
        }
        else{
            throw new CommonGoalsNumberException();
        }
        this.table = new Player[playersNumber];
        this.board = new LivingRoomBoard(commonGoalsNumber);
        this.bag = new CardsBag();
        clock = LocalTime.now();
        hours = clock.getHour();
        minutes = clock.getMinute();
        seconds = clock.getSecond();
        int nanoseconds = clock.getNano();
        clockString = "";
        clockString += hours;
        clockString += minutes;
        clockString += seconds;
        clockString += nanoseconds;
        long seed = parseLong(clockString);
        Random generator = new Random(seed);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<12; i++){
            list.add(i+1);
        }
        shuffle(list, generator);
        this.personalGoalsDeck = new ArrayList<>();
        for(int i = 0; i < 12; i++){
            personalGoalsDeck.add(new PersonalGoalCard(list.get(i)));
        }

        clock = LocalTime.now();
        hours = clock.getHour();
        minutes = clock.getMinute();
        seconds = clock.getSecond();
        nanoseconds = clock.getNano();
        clockString = "";
        clockString += hours;
        clockString += minutes;
        clockString += seconds;
        clockString += nanoseconds;
        seed = parseLong(clockString);
        generator = new Random(seed);
        //this.commonGoalsDeck=new ArrayList<CommonGoalCard>(); // AGGIUNTO
        //commonGoalsDeck.add(0,new CommonGoalCard3(playersNumber)); //AGGIUNTO
        shuffle(list, generator);
        this.commonGoalsDeck = new ArrayList<>();
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
                    if(i != 0){
                        if(tiles[i-1][j].getObject()!=null){
                            freeSidesCounter -= 1;
                        }
                    }
                    if(j != tiles[i].length - 1){
                        if(tiles[i][j+1].getObject()!=null) {
                            freeSidesCounter -= 1;
                        }
                    }
                    if(j != 0){
                        if(tiles[i][j-1].getObject()!=null) {
                            freeSidesCounter -= 1;
                        }
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

            List<PointCard> pointsDeck = new ArrayList<>();
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
        String clockString = "";
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

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int array_position) {
        this.currentPlayer = array_position;
    }
    public Player[] getLeaderboard(){
        return leaderboard;
    }
    public void setLeaderboard(Player [] leaderboard) {
        this.leaderboard = leaderboard;
    }

    public void nextTurn() {
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
        if(!commonGoal.getPoints().isEmpty()){
            points = this.table[i].getPoints();
            points += commonGoal.getPoints().remove(0).getValue().i;
            this.table[i].setPoints(points);
        }
    }

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
        System.out.println("CHOSEN COLUMN: " + column);
        for (int j = 0; j < order.length; j++) {
            System.out.println("ORDER: " + order[j]);
            objectCardsOrdered[order[j] - 1] = objectCard[j];
        }
        for (int k = 0; k < order.length; k++) {
            bookshelf.setShelf(objectCardsOrdered[k], column);
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
        if(bookshelf.isFull()){
            this.setDone(true);
            if(endGamePoints > 0){
                currentPlayer.setHasFinished(true);
            }
            currentPlayer.setPoints(currentPlayer.getPoints()+endGamePoints);
            endGamePoints=0;
        }
        if(this.getBag().getSize()!=0) {
            updateBoard();
        }


        for(i=0;i<board.getCommonGoals().length;i++) {
            for (int j = 0; j < board.getCommonGoals().length; j++) {
                if (currentPlayer.getCommonGoalsCompleted()[j] == board.getCommonGoals()[i].getGoalID()) {
                    b = false; //Già completato
                }
            }
            if(b==true && board.getCommonGoals()[i].check(bookshelf.getShelf())){
                currentPlayer.setCommonGoalsCompleted(currentPlayer.getCommonGoalsCompleted(), board.getCommonGoals()[i].getGoalID());
                updateCommonGoals(board.getCommonGoals()[i]);
                System.out.println("Player: " + currentPlayer.getNickname() + " completes " + board.getCommonGoals()[i].getGoalID());
            }
            b = true;
        }
        boolean flag=false;
        for(int k=0;k<getBoard().getTiles().length;k++){
            for(int j=0;j<getBoard().getTiles()[0].length;j++){
                if(getBoard().getTiles()[k][j]!=null){
                    flag=true;
                }
            }
        }
        if (flag == false) {
            DeclareWinner();
            handleTurn("","");
        }

        nextTurn();
        i = 0;
        while(this.table[i].getPosition() != this.currentPlayer){
            i += 1;
        }
        currentPlayer = this.table[i];

        if(getDone() == true && currentPlayer.getIsFirst() == true){
            DeclareWinner();
            handleTurn("", "");
        }
        else{
            String turnPlayerMessage = "Choose up to 3 object cards from the board that you want to put in a column of your own library";;
            String otherPlayersMessage = "Now it's " + currentPlayer.getNickname() + "'s turn\nWait your turn";
            handleTurn(turnPlayerMessage, otherPlayersMessage);
        }
    }

    public void updateBoard() {
        LivingRoomBoard board = this.getBoard();
        Tile[][] tiles = board.getTiles();
        boolean free = true;
        int freeSidesCounter=0;
        // Check if each tile has 4 free sides
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                if(this.getPlayersNumber() >= tiles[i][j].getMinPlayers()){
                    if (tiles[i][j].getFreeSides() < 4) {
                        free = false;
                    }
                }
            }
        }
        // Repopulate the board
        if (free) {
            CardsBag bag = this.getBag();
            int cardId;
            for(int i = 0; i < tiles.length; i++){
                for(int j = 0; j < tiles[i].length; j++){
                    if(tiles[i][j].getMinPlayers() <= this.getPlayersNumber()){
                        if(tiles[i][j].getObject()==null) {
                            if(bag.getSize()!=0) {
                                cardId = bag.getCard();
                                ObjectCard drawnCard = new ObjectCard(cardId, i, j);
                                board.placeObject(drawnCard, i, j);
                            }
                        }
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
                        if(i != 0){
                            if(tiles[i-1][j].getObject()!=null){
                                freeSidesCounter -= 1;
                            }
                        }
                        if(j != tiles[i].length - 1){
                            if(tiles[i][j+1].getObject()!=null) {
                                freeSidesCounter -= 1;
                            }
                        }
                        if(j != 0){
                            if(tiles[i][j-1].getObject()!=null) {
                                freeSidesCounter -= 1;
                            }
                        }
                        tiles[i][j].setFreeSides(freeSidesCounter);
                    }
                }
            }
        }
    }

    public void DeclareWinner() {
        int count=0;
        Player[] table = getTable();
        for(int i=0; i< table.length;i++){
            table[i].countPersonalGoalsPoints();
            table[i].countAdjacentItemsPoints();
        }

        Player[] leaderboard = new Player[getTable().length];
        if (playersNumber >= 0) System.arraycopy(table, 0, leaderboard, 0, playersNumber);

        for (int i = 0; i < playersNumber - 1; i++) {
            for (int j = 0; j < playersNumber; j++) {
                if(j > i && leaderboard[j].getPoints() > leaderboard[i].getPoints() || (leaderboard[j].getPoints() == leaderboard[i].getPoints() && leaderboard[j].getPosition() > leaderboard[i].getPosition())){
                    Player tmpPlayer = leaderboard[j];
                    leaderboard[j] = leaderboard[i];
                    leaderboard[i] = tmpPlayer;
                }
            }
        }
        setLeaderboard(leaderboard);

    }

}
