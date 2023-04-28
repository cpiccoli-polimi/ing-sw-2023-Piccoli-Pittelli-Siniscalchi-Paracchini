package it.polimi.controller;

import it.polimi.controller.exception.*;
import it.polimi.model.*;
import it.polimi.view.TextualUI;


import java.util.HashMap;
import java.util.Map;
import java.util.*;


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
        model.setupBoardObjects();
        model.setupCommonGoals();
        model.setupPersonalGoals();
        model.setupFirstPlayer();
    }

    private void DeclareWinner() {
        Player[] table = model.getTable();
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
            model.setLeaderboard(table[points[i][1]],i);
        }

        TextualUI.showLeaderboard(model.getLeaderboard());
    }

    private boolean checkPickedObject(ObjectCard [] pickedObject) throws MaxDrawableObjectsException, NoFreeSidesException, AlreadyPickedException, NoStraightLineException, NoAdjacentException {
        int p=-1;
        int x;
        int y;
        List<Integer> sortX = new ArrayList<Integer>();
        sortX.add(pickedObject[0].getXCoordinate());
        List<Integer> sortY = new ArrayList<Integer>();
        sortY.add(pickedObject[0].getYCoordinate());
        p= model.getCurrentPlayer();
        if (model.getTable()[p].getBookshelf().getMaxDrawableObjects() < pickedObject.length) {
            throw new MaxDrawableObjectsException(); //il giocatore non ha lo spazio per poter inserire "pickedObject.lenght" tessere
        }
        for (ObjectCard objectCard : pickedObject) {
            x = objectCard.getXCoordinate();
            y = objectCard.getYCoordinate();
            if (model.getBoard().getTiles()[x][y].getFreeSides() == 0) {
                throw new NoFreeSidesException();
            }
        }
        for (int i = 1; i < pickedObject.length; i++) { // suppongo che gli venga passato un array con solo e soltanto le tessere scelte
            if (sortX.contains(pickedObject[i].getXCoordinate()) && sortY.contains(pickedObject[i].getYCoordinate())) {
                throw new AlreadyPickedException();
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
                    }
                }
            }
            else if (sortY.size() == 1 && sortX.size() == pickedObject.length) {// le tessere sono state scelte su una linea verticale
                for( int k=0; k<sortX.size();k++){
                    p= sortX.get(k);
                    if(!sortX.contains(p-1) && !sortX.contains(p+1)){
                        throw new NoAdjacentException();
                    }
                }
            }
            else{
                throw new NoStraightLineException();
            }
        }
        return true;
    }

    private void updateFreeSides(ObjectCard [] pickedObject){
        int x=-1;
        int y=-1;
        int fs=-1;
        Tile tile=null;
        for (ObjectCard objectCard : pickedObject) {
            x = objectCard.getXCoordinate();
            y = objectCard.getYCoordinate();
            tile = model.getBoard().getTiles()[x - 1][y]; //up
            fs = tile.getFreeSides();
            tile.setFreeSides(fs - 1);
            tile = model.getBoard().getTiles()[x + 1][y]; //down
            fs = tile.getFreeSides();
            tile.setFreeSides(fs - 1);
            tile = model.getBoard().getTiles()[x][y - 1]; //left
            fs = tile.getFreeSides();
            tile.setFreeSides(fs - 1);
            tile = model.getBoard().getTiles()[x][y + 1]; //right
            fs = tile.getFreeSides();
            tile.setFreeSides(fs - 1);
        }

    }

    private void savePickedObject(ObjectCard [] pickedObject){
        int x=-1;
        int g=-1;
        int y=-1;
        for (ObjectCard objectCard : pickedObject) {
            x = objectCard.getXCoordinate();
            y = objectCard.getYCoordinate();
            model.getBoard().removeObject(x, y);
        }
        g=model.getCurrentPlayer();
        model.getTable()[g].setChosenObjects(pickedObject);
    }

    private boolean checkChosenColumn() {
        int currentPlayer = model.getCurrentPlayer();
        Player[] table = model.getTable();
        // Get chosen column and counter of empty slot for checking 
        int column = table[currentPlayer].getChosenColumn();
        int nullCounter = 0;
        // Get current player's bookshelf and chosen object size
        ObjectCard[][] bookshelf = table[currentPlayer].getBookshelf().getShelf();
        int size = table[currentPlayer].getChosenObjects().length;
        // Count empty slots
        for (int row = 0; row < bookshelf[column].length; row++) {
            if (bookshelf[column][row] == null) {
                nullCounter += 1;
            }
        }
        // Set a error trigger for insufficient space 
        if (nullCounter < size) { return false; }
        else { return true; }
    }

    private void arrangeChosenObjects() {
        // Get the current player info
        int currentPlayer = model.getCurrentPlayer();
        Player[] table = model.getTable();
        int column = table[currentPlayer].getChosenColumn();
        ObjectCard[] chosenObject = table[currentPlayer].getChosenObjects();
        ObjectCard[][] bookshelf = table[currentPlayer].getBookshelf().getShelf();
        // Insert chosen object into the bookshelf
        for (int reverse = table[currentPlayer].getChosenObjects().length - 1; reverse >= 0; reverse--) {
            bookshelf[column][reverse] = chosenObject[reverse];
            chosenObject[reverse] = null;
        }
    }

    private void isDone() {
        // Get the current players
        int currentPlayer = model.getCurrentPlayer();
        Player[] table = model.getTable();
        // Check if the bookshelf is full and end game
        if (table[currentPlayer].getBookshelf().isFull() == true) {
            DeclareWinner();
        }
    }

    private void updateBoard() {
        LivingRoomBoard board = model.getBoard();
        Tile[][] tiles = board.getTiles();
        boolean free = true;

        // Check if each tile has 4 free sides
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                if(model.getPlayersNumber() >= tiles[i][j].getMinPlayers()){
                    if (tiles[i][j].getFreeSides() != 4) {
                        free = false;
                        j = tiles[i].length;
                        i = tiles.length;
                    }
                }
            }
        }
        // Repopulate the board
        if (free == true) {
            CardsBag bag = model.getBag();
            int cardId;

            for(int i = 0; i < tiles.length; i++){
                for(int j = 0; j < tiles[i].length; j++){
                    if(tiles[i][j].getMinPlayers() <= model.getPlayersNumber() && tiles[i][j] != null){
                        cardId = bag.getCard();
                        ObjectCard drawnCard = new ObjectCard(cardId, i, j);
                        board.placeObject(drawnCard,i,j);
                    }
                }
            }
        }
    }
}

