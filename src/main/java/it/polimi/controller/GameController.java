package it.polimi.controller;

import it.polimi.controller.exception.*;
import it.polimi.model.*;

import java.time.LocalTime;
import java.util.*;

import static java.lang.Long.parseLong;

public class GameController {
    public final Game model;
    public GameController(Game model){
        this.model=model;
    }
    private Game GetModel() {
        return this.model;
    }
    private void SaveNickname(String nickname, int commonGoalsNumber) {
        Player player = new Player(nickname,commonGoalsNumber);
        Player[] table = model.getTable();
        for(int i=0;i<4;i++){
            if (table[i] == null){
                model.setTable(player,i);
                break;
            }
        }
    }

    private void setup(){
        setupBoardObjects();
        setupCommonGoals();
        setupPersonalGoals();
        setupFirstPlayer();
    }

    private void setupBoardObjects(){
        LivingroomBoard board = model.getBoard();
        Tile[][] tiles = board.getTiles();
        CardsBag bag = model.getBag();
        int cardId;
        int freeSidesCounter;

        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                if(model.getPlayersNumber() >= tiles[i][j].getMinPlayers()){
                    cardId = bag.getCard();
                    ObjectCard drawnCard = new ObjectCard( cardId, i, j);
                    board.placeObject(drawnCard);
                }
            }
        }

        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                if(model.getPlayersNumber() >= tiles[i][j].getMinPlayers()){
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

    private void setupCommonGoals(){
        LivingroomBoard board = model.getBoard();
        CommonGoalCard[] drawnCommonGoals = new CommonGoalCard[model.getCommonGoalsNumber()];

        for(int i = 0; i < model.getCommonGoalsNumber(); i++){
            drawnCommonGoals[i] = model.getCommonGoalsDeck()[i];

            PointCard[] pointsDeck = new PointCard[model.getPlayersNumber()];
            switch(model.getPlayersNumber()){
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

    private void setupPersonalGoals(){
        Player[] playersTable = model.getTable();
        PersonalGoalCard[] personalGoalsDeck = model.getPersonalGoalsDeck();
        for(int i = 0; i < model.getPlayersNumber(); i++){
            playersTable[i].setPersonalGoal(personalGoalsDeck[i]);
        }
    }

    private void setupFirstPlayer(){
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

        Player[] playersTable = model.getTable();
        for(int i = 0; i < model.getPlayersNumber(); i++){
            if(i == firstPlayerIndex){
                playersTable[i].setIsFirst(true);
                playersTable[i].setPosition(0);
                model.setCurrentPlayer(0);
            }
            else{
                playersTable[i].setIsFirst(false);
                if(i - firstPlayerIndex > 0){
                    playersTable[i].setPosition(i - firstPlayerIndex);
                }
                else{
                    playersTable[i].setPosition(playersTable.length - firstPlayerIndex + i);
                }
            }
        }
    }

    private void CountPersonalGoalsPoints() {
        // Get all the players
        Player[] table = model.getTable();
        // For each of them count points
        for(int i=0;i< table.length;i++) {
            // Get bookshelf, personalGoal and actual points from Player
            ObjectCard[][] bookshelf = table[i].getBookshelf().getShelf();
            PersonalGoalCard personalGoal = table[i].getPersonalGoal();
            int points = table[i].getPoints();
            // Scan through every row and columns: if two cells match, add one point
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (bookshelf[row][col].type == personalGoal[row][col].type) {
                        points++;
                    }
                }
            }
            table[i].setPoints(points);
        }
    }
    private void CountAdjacentItemsPoints() {
        Player[] table = model.getTable();
        for(int i=0;i< table.length;i++) {
            // Get bookshelf from each player
            ObjectCard[][] bookshelf = table[i].getBookshelf().getShelf();
            // Create hashmap to track which types has already been counted
            Map<String, Integer> countedTypes = new HashMap<>();
            // Cycle through every row and column
            for (int row = 0; row < bookshelf.length; row++) {
                for (int col = 0; col < bookshelf[row].length; col++) {
                    ObjectCard currentCard = bookshelf[row][col];
                    String currentType = currentCard.getType();
                    // If currentType has not been counted yet, we start counting from 0
                    if (!countedTypes.containsKey(currentType)) {
                        int adjacentCount = 0; // Counter for adjacent cards

                        // Cycle through every row and column adjacent to the actual card
                        for (int j = row - 1; j <= row + 1; j++) {
                            for (int k = col - 1; k <= col + 1; k++) {
                                // If adjacent slot is not empty and it is not actual card, add to count
                                if (j >= 0 && j < bookshelf.length && k >= 0 && k < bookshelf[row].length && !(j == row && k == col)) {
                                    ObjectCard adjacentCard = bookshelf[i][j];

                                    if (adjacentCard.getType().equals(currentType)) {
                                        adjacentCount++;
                                    }
                                }
                            }
                        }

                        // Add actual type to counted types map
                        countedTypes.put(currentType, adjacentCount);
                    } else {
                        // If actual type has already been counted, restart from previous count
                        // In case there are separated groups of adjacent cards from the same type
                        int previousCount = countedTypes.get(currentType);

                        // Restart from previous count
                        int adjacentCount = previousCount;
                        for (int j = row - 1; j <= row + 1; j++) {
                            for (int k = col - 1; k <= col + 1; k++) {
                                if (j >= 0 && j < bookshelf.length && k >= 0 && k < bookshelf[row].length && !(j == row && k == col)) {
                                    ObjectCard adjacentCard = bookshelf[i][j];

                                    if (adjacentCard.getType().equals(currentType)) {
                                        adjacentCount++;
                                    }
                                }
                            }
                        }

                        // Update current type count
                        countedTypes.put(currentType, adjacentCount);
                    }
                }
            }
            // Sum all types countings and put them into points attribute
            int adjacentPoints = 0;
            for (int count : countedTypes.values()) {
                adjacentPoints += count;
            }
            int points = table[i].getPoints();
            points += adjacentPoints;
            table[i].setPoints(points);
        }
    }
    private void DeclareWinner() {
        Player[] table = model.getTable();
        CountPersonalGoalsPoints();
        // Common goals points already calculated?
        CountAdjacentItemsPoints();
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
            model.setLeaderboard(table[points[i][1]],i);
        }

        // TODO: How to notify view?
    }

    private boolean checkPickedObject(ObjectCard [] pickedObject) throws MaxDrawableObjectsException, NoFreeSidesException, AlreadyPickedException, NoStraightLineException, NoAdjacentException {
        int p=-1;
        int x;
        int y;
        List<Integer> sortX = new ArrayList<Integer>();
        sortX.add(pickedObject[0].getXCoordinate());
        List<Integer> sortY = new ArrayList<Integer>();
        sortY.add(pickedObject[0].getYCoordinate());
        //sotto deve arrivargli un player
        if (model.getCurrentPlayer().getBookshelf().maxDrawableObjects() < pickedObject.length) {
            throw new MaxDrawableObjectsException(); //il giocatore non ha lo spazio per poter inserire "pickedObject.lenght" tessere
            return false;
        }
        for(int l=0;l< pickedObject.length;l++){
            x=pickedObject[l].getXCoordinate();
            y=pickedObject[l].getYCoordinate();
            if(model.getBoard().getTiles()[x][y].getFreeSides()==0){
                throw new NoFreeSidesException();
                return false;
            }
        }
        for (int i = 1; i < pickedObject.length; i++) { // suppongo che gli venga passato un array con solo e soltanto le tessere scelte
            if (sortX.contains(pickedObject[i].getXCoordinate()) && sortY.contains(pickedObject[i].getYCoordinate())) {
                throw new AlreadyPickedException();
                return false;
            } else {
                if (!sortY.contains(pickedObject[i].getYCoordinate())) {
                    sortY.add(pickedObject[i].getYCoordinate());
                }
                if (!sortX.contains(pickedObject[i].getXCoordinate())) {
                    sortX.add(pickedObject[i].getXCoordinate());
                }
            }
            if (sortX.size() == 1 && sortY.size() == pickedObject.length) {//le tessere sono state scelte su una linea orizzontale
                for( int j=0; j<sortY.size();j++){
                    p= sortY.get(j);
                    if(!sortY.contains(p-1) && !sortY.contains(p+1)){
                        throw new NoAdjacentException();
                        return false;
                    }
                }
            }
            else if (sortY.size() == 1 && sortX.size() == pickedObject.length) {// le tessere sono state scelte su una linea verticale
                for( int k=0; k<sortX.size();k++){
                    p= sortX.get(k);
                    if(!sortX.contains(p-1) && !sortX.contains(p+1)){
                        throw new NoAdjacentException();
                        return false;
                    }
                }
            }
            else{
                throw new NoStraightLineException();
                return false;
            }
        }
        return true;
    }

    private void updateFreeSides(ObjectCard [] pickedObject){
        int x=-1;
        int y=-1;
        int fs=-1;
        Tile tile=null;
        for(int i=0;i<pickedObject.length;i++){
            x=pickedObject[i].getXCoordinate();
            y=pickedObject[i].getYCoordinate();
            tile=model.getBoard().getTiles()[x-1][y]; //up
            fs= tile.getFreeSides();
            tile.setFreeSides(fs-1);
            tile=model.getBoard().getTiles()[x+1][y]; //down
            fs= tile.getFreeSides();
            tile.setFreeSides(fs-1);
            tile=model.getBoard().getTiles()[x][y-1]; //left
            fs= tile.getFreeSides();
            tile.setFreeSides(fs-1);
            tile=model.getBoard().getTiles()[x][y+1]; //right
            fs= tile.getFreeSides();
            tile.setFreeSides(fs-1);
        }

    }
}

