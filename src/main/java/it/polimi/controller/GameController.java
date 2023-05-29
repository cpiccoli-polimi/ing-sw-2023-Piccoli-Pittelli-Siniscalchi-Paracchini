package it.polimi.controller;

import it.polimi.controller.exception.*;
import it.polimi.model.*;
import it.polimi.observer.Observer;
import java.util.*;


public class GameController implements Observer<PlayerChoice> {
    public final Game model;
    public GameController(Game model){
        this.model=model;
    }

    @Override
    public void update(PlayerChoice message) {
        handleMessage(message);
    }

    private synchronized void handleMessage(PlayerChoice message){
        if(model.getCurrentPlayer()!=message.getPlayer().getPosition()){//getPosition deve restituire il numero della posizione in base al primo giocatore che ha iniziato il gioco, non rispetto al primo entrato
            message.getView().reportError("It is not your turn");
            return;
        }
        System.out.println("Tocca a te");
        boolean b=false;
        String mes= message.getMessage();
        String[] input=mes.split(":");
        ObjectCard [] chosenObjectCards=null;
        if(Objects.equals(input[0], "OBJECTCARDSCHOICE")){//TODO checkMessageCorrectness
            System.out.println("Prima dello split di spazio");
            String [] space=input[1].split(" ");
            if(space.length==1){
                int [] coordinate= new int[2];
                String [] comma=space[0].split(",");
                coordinate[0]=Integer.parseInt(comma[0]);
                coordinate[1]=Integer.parseInt(comma[1]);
                chosenObjectCards= new ObjectCard[1];
                System.out.println("Prima del model");
                System.out.println(coordinate[0]+","+coordinate[1]);
                chosenObjectCards[0] = model.getBoard().getTiles()[coordinate[0]][coordinate[1]].getObject();
                if(chosenObjectCards[0]==null){
                    System.out.println("Oggetto vuoto");
                }
                System.out.println(chosenObjectCards[0].getType());

            } else if(space.length==2){
                int [] coordinate = new int [4];
                String [] comma=space[0].split(",");
                coordinate[0]=Integer.parseInt(comma[0]);
                coordinate[1]=Integer.parseInt(comma[1]);
                comma=space[1].split(",");
                coordinate[2]=Integer.parseInt(comma[0]);
                coordinate[3]=Integer.parseInt(comma[1]);
                chosenObjectCards= new ObjectCard[2];
                chosenObjectCards[0] = model.getBoard().getTiles()[coordinate[0]][coordinate[1]].getObject();
                chosenObjectCards[1] = model.getBoard().getTiles()[coordinate[2]][coordinate[3]].getObject();
            }else if(space.length==3){
                int [] coordinate = new int [6];
                String [] comma=space[0].split(",");
                coordinate[0]=Integer.parseInt(comma[0]);
                coordinate[1]=Integer.parseInt(comma[1]);
                comma=space[1].split(",");
                coordinate[2]=Integer.parseInt(comma[0]);
                coordinate[3]=Integer.parseInt(comma[1]);
                comma=space[2].split(",");
                coordinate[4]=Integer.parseInt(comma[0]);
                coordinate[5]=Integer.parseInt(comma[1]);
                chosenObjectCards= new ObjectCard[3];
                chosenObjectCards[0] = model.getBoard().getTiles()[coordinate[0]][coordinate[1]].getObject();
                chosenObjectCards[1] = model.getBoard().getTiles()[coordinate[2]][coordinate[3]].getObject();
                chosenObjectCards[2] = model.getBoard().getTiles()[coordinate[4]][coordinate[5]].getObject();
            }else{
                message.getView().reportError("Troppi oggetti selezionati");

            }
            if(chosenObjectCards!=null){
                try {
                    b=checkPickedObject(chosenObjectCards);
                } catch (MaxDrawableObjectsException e) {
                    message.getView().reportError("Troppi oggetti selezionati");
                } catch (NoAdjacentException e) {
                    message.getView().reportError("Oggetti non adiacenti");
                } catch (NoFreeSidesException e) {
                    message.getView().reportError("Gli oggetti devono avere almeno un lato libero");
                } catch (AlreadyPickedException e) {
                    message.getView().reportError("Hai selezionato lo stesso oggetto");
                } catch (NoStraightLineException e) {
                    message.getView().reportError("Gli oggetti devono essere in linea retta");
                }
                if(b==true){
                    savePickedObject(chosenObjectCards);
                    System.out.println("Oggetti scelti salvati");
                    String m="In which bookshelf column do you want to insert those cards?";
                    model.handleTurn(m);
                }
                else{
                    System.out.println("Oggetti non salvati");
                }
            }
            else{
                System.out.println("Oggetto vuoto");
            }
        }
        else if(Objects.equals(input[0], "BOOKSHELFCOLUMNCHOICE")){//TODO checkMessageCorrectness
            int chosenColumn=Integer.parseInt(input[1]);
            b=checkChosenColumn(chosenColumn);
            if(b==true){
                model.getTable()[model.getCurrentPlayer()].setChosenColumn(chosenColumn);
                String m="In which order do you want to insert the cards in that bookshelf column?";
                model.handleTurn(m);
            }
        } else if(Objects.equals(input[0], "INSERTIONORDERCHOICE")){//TODO checkMessageCorrectness
            String [] space;
            space= input[1].split(" ");
            int [] chosenInsertionOrder;
            chosenInsertionOrder=new int[space.length];
            for(int i=0;i<space.length;i++){
                chosenInsertionOrder[i]=Integer.parseInt(space[i]);
            }
            model.insertInOrder(chosenInsertionOrder);
            model.endTurnChecks();

        } else if(Objects.equals(input[0], "LEADERBOARD")){

        }
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

    public void setup(){
        model.setupBoardObjects();
        model.setupCommonGoals();
        model.setupPersonalGoals();
        model.setupFirstPlayer();
    }

    /*private void DeclareWinner() {
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
    }*/

    private boolean checkPickedObject(ObjectCard [] pickedObject) throws MaxDrawableObjectsException, NoFreeSidesException, AlreadyPickedException, NoStraightLineException, NoAdjacentException {
        int x;
        int y;
        int i = 0;
        int p;
        List<Integer> sortX = new ArrayList<Integer>();
        sortX.add(pickedObject[0].getXCoordinate());
        List<Integer> sortY = new ArrayList<Integer>();
        sortY.add(pickedObject[0].getYCoordinate());
        while(model.getTable()[i].getPosition() != model.getCurrentPlayer()){
            i += 1;
        }
        Player currentPlayer = model.getTable()[i];
        if (currentPlayer.getBookshelf().getMaxDrawableObjects() < pickedObject.length) {
            throw new MaxDrawableObjectsException(); //il giocatore non ha lo spazio per poter inserire "pickedObject.lenght" tessere
        }
        for (ObjectCard objectCard : pickedObject) {
            x = objectCard.getXCoordinate();
            y = objectCard.getYCoordinate();
            if (model.getBoard().getTiles()[x][y].getFreeSides() == 0) {
                throw new NoFreeSidesException();
            }
        }
        for (i = 1; i < pickedObject.length; i++) { // suppongo che gli venga passato un array con solo e soltanto le tessere scelte
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

        return true;
    }

    /*private void updateFreeSides(ObjectCard [] pickedObject){
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

    }*/

    private void savePickedObject(ObjectCard [] pickedObject){
        int x=-1;
        int y=-1;
        int i = 0;
        while(model.getTable()[i].getPosition() != model.getCurrentPlayer()){
            i += 1;
        }
        Player currentPlayer = model.getTable()[i];
        model.getBoard().updateFreeSides(pickedObject);
        for (ObjectCard objectCard : pickedObject) {
            x = objectCard.getXCoordinate();
            y = objectCard.getYCoordinate();
            model.getBoard().removeObject(x, y);
        }
        currentPlayer.setChosenObjects(pickedObject);
        //model.getBoard().removeObject(chosenObjectCards[i].getXCoordinate(),chosenObjectCards[i].getYCoordinate());
        //model.getTable()[message.getPlayer().getPosition()].setChosenObjects(chosenObjectCards);
    }


    private boolean checkChosenColumn(int column) {
        int i = 0;
        while(model.getTable()[i].getPosition() != model.getCurrentPlayer()){
            i += 1;
        }
        Player currentPlayer = model.getTable()[i];
        // Get chosen column and counter of empty slot for checking
        //int column = table[currentPlayer].getChosenColumn();
        int nullCounter = 0;
        // Get current player's bookshelf and chosen object size
        ObjectCard[][] bookshelf = currentPlayer.getBookshelf().getShelf();
        int size = currentPlayer.getChosenObjects().length;
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
        int i = 0;
        while(model.getTable()[i].getPosition() != model.getCurrentPlayer()){
            i += 1;
        }
        Player currentPlayer = model.getTable()[i];
        int column = currentPlayer.getChosenColumn();
        ObjectCard[] chosenObject = currentPlayer.getChosenObjects();
        ObjectCard[][] bookshelf = currentPlayer.getBookshelf().getShelf();
        // Insert chosen object into the bookshelf
        for (int reverse = currentPlayer.getChosenObjects().length - 1; reverse >= 0; reverse--) {
            bookshelf[column][reverse] = chosenObject[reverse];
            chosenObject[reverse] = null;
        }
    }

    private void isDone() {
        // Get the current players
        int i = 0;
        while(model.getTable()[i].getPosition() != model.getCurrentPlayer()){
            i += 1;
        }
        Player currentPlayer = model.getTable()[i];
        // Check if the bookshelf is full and end game
        if (currentPlayer.getBookshelf().isFull() == true) {
            model.setDone(true);
        }
    }

    /*private void updateBoard() {
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
            model.updateBoard();
        }
    }

    private void verifyCommonGoals() {
        int currentPlayer = model.getCurrentPlayer();
        Player[] table = model.getTable();
        LivingRoomBoard board = model.getBoard();

        for(int i = 0; i < model.getCommonGoalsNumber(); i++) {
            drawnCommonGoals[i] = board.getCommonGoals()[i];
            if (drawnCommonGoals[i].check() == true) {

                List<PointCard> listPoints = new List<PointCard>();
                listPoints = drawnCommonGoals[i].getPoints();
                PointCard lastPoint = listPoints.get(listPoints.size());
                int valuePoint = lastPoint.getValue();
                //rimuovi lastpoint; listPoints.remove(lastPoint)
                table[currentPlayer].setPoints(valuePoint);
            }
        }
    }*/
}

