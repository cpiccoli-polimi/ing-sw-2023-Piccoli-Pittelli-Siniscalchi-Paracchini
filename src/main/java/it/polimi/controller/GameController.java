package it.polimi.controller;

import it.polimi.controller.exception.*;
import it.polimi.model.*;
import it.polimi.observer.Observer;
import java.util.*;

/**
 * GameController is the class that acts as
 * controller in the MVC pattern
 *
 * @see it.polimi.observer.Observer
 * @author Nicola Siniscalchi
 * @author Lorenzo Pittelli
 */
public class GameController implements Observer<PlayerChoice> {
    public final Game model;
    public GameController(Game model){
        this.model=model;
    }

    /**
     * Allows GameController to receive PlayerChoice notified
     * from MessageReceiver of RemoteView
     *
     * @param message player's choice
     */
    @Override
    public void update(PlayerChoice message) {
        handleMessage(message);
    }

    /**
     * Checks on player's choices notified to GameController,
     * based on those it calls specific Game methods to allow
     * game prosecution and proceed to next turn
     *
     * @param message player's choice
     */
    protected synchronized void handleMessage(PlayerChoice message){
        if(model.getCurrentPlayer()!=message.getPlayer().getPosition()){
            message.getView().reportError(new NotYourTurnException());
        }
        else {
            boolean b = false;
            String mes = message.getMessage();
            try {
                String[] input = mes.split(":");
                if(input.length == 1){
                    message.getView().reportError(new EmptyMessageException());
                }
                else if (Objects.equals(input[0], "OBJECTCARDSCHOICE")) {//TODO checkMessageCorrectness
                    ObjectCard[] chosenObjectCards = null;
                    try {
                        chosenObjectCards = convert(input[1]);
                        if (chosenObjectCards != null) {
                            try {
                                b = checkPickedObject(chosenObjectCards);
                            } catch (MaxDrawableObjectsException | NoAdjacentException | NoFreeSidesException |
                                     AlreadyPickedException | NoStraightLineException e) {
                                message.getView().reportError(e);
                            }
                            if (b) {
                                savePickedObject(chosenObjectCards);
                                String turnPlayerMessage = "In which bookshelf column do you want to insert those cards?";
                                String otherPlayersMessage = "Now it's " + message.getPlayer().getNickname() + "'s turn\nWait your turn";
                                model.handleTurn(turnPlayerMessage, otherPlayersMessage);
                            } else {
                                System.out.println("Objects not saved");
                            }
                        } else {
                            System.out.println("Empty objects");
                        }
                    } catch (EmptyTileException | CoordinateException e) {
                        message.getView().reportError(e);
                    } catch (NumberFormatException e){
                        e = new NumberFormatException("You wrote the object cards coordinates in an incorrect format");
                    }
                } else if (Objects.equals(input[0], "BOOKSHELFCOLUMNCHOICE")) {
                    int chosenColumn = -5;
                    try {
                        chosenColumn = convertColumn(input[1]);
                        try {
                            b = checkChosenColumn(chosenColumn);
                        } catch (OutOfBookshelfException e) {
                            message.getView().reportError(e);
                        }
                        if (b) {
                            int i = 0;
                            while (model.getTable()[i].getPosition() != model.getCurrentPlayer()) {
                                i += 1;
                            }
                            Player currentPlayer = model.getTable()[i];
                            currentPlayer.setChosenColumn(chosenColumn);
                            String turnPlayerMessage = "In which order do you want to insert the cards in that bookshelf column?";
                            String otherPlayersMessage = "Now it's " + message.getPlayer().getNickname() + "'s turn\nWait your turn";
                            model.handleTurn(turnPlayerMessage, otherPlayersMessage);
                        }
                    } catch (NumberFormatException e) {
                        e = new NumberFormatException("You wrote the column number in an incorrect format");
                        message.getView().reportError(e);
                    }
                } else if (Objects.equals(input[0], "INSERTIONORDERCHOICE")) {
                    int[] chosenInsertionOrder = null;
                    boolean c = false;
                    try {
                        chosenInsertionOrder = convertOrder(input[1]);
                        try {
                            c = checkOrder(chosenInsertionOrder);
                        } catch (DifferentLengthException | OrderException e) {
                            message.getView().reportError(e);
                        }
                        if (c) {
                            int i = 0;
                            while (model.getTable()[i].getPosition() != model.getCurrentPlayer()) {
                                i += 1;
                            }
                            Player currentPlayer = model.getTable()[i];
                            model.insertInOrder(chosenInsertionOrder);
                            model.endTurnChecks();
                        } else {
                            System.out.println("Order not saved");
                        }
                    } catch (OrderException e) {
                        message.getView().reportError(e);
                    }
                    catch(NumberFormatException e){
                        e = new NumberFormatException("You wrote the insertion order in an incorrect format");
                        message.getView().reportError(e);
                    }


                }
            }catch (IndexOutOfBoundsException e){
                message.getView().reportError(e);
            }
        }
    }

    /**
     * Converts order of insert received from the player into
     * an int array that can be used from handleMessage method
     *
     * @param s string containing order of insertion
     * @return an array of int containing order of insertion
     * @throws NumberFormatException if the string does not contain
     *                               correctly formatted numbers
     * @throws OrderException if the order is wrong
     */
    public int [] convertOrder(String s)throws NumberFormatException, OrderException {
        String [] space;
        space= s.split(" ");
        int [] chosenInsertionOrder;
        chosenInsertionOrder=new int[space.length];
        for(int j=0;j<space.length;j++){
            chosenInsertionOrder[j]=Integer.parseInt(space[j]);
        }
        return chosenInsertionOrder;
    }
    /**
     * Converts column where to insert received from the player
     * into an int that can be used from handleMessage method
     *
     * @param s string containing the number of column chosen
     * @return chosenColumn integer reference
     * @throws NumberFormatException if the string does not contain
     *                               correctly formatted number
     */
    public int convertColumn(String s) throws NumberFormatException{
        int chosenColumn = Integer.parseInt(s) - 1;
        return chosenColumn;
    }

    /**
     * Converts the coordinates of chosen objects received
     * from the player into an ObjectCard array that can be
     * used from handleMessage
     *
     * @param s string containing x/y coordinates of
     *          chosen objects
     * @return
     * @throws EmptyTileException
     * @throws NumberFormatException
     * @throws CoordinateException
     */
    public ObjectCard [] convert(String s) throws EmptyTileException, NumberFormatException, CoordinateException {
        String [] space;
        String [] comma;
        ObjectCard [] chosenObjectCards;
        space=s.split(" ");
        int j=0;
        String [] output=new String[space.length*2];
        int [] outputInt=new int[space.length*2];
        for(int i=0; i<space.length;i++){
            comma=space[i].split(",");

            if(comma.length!=2){
                throw new CoordinateException();
            }

            output[j] = comma[0];
            j++;
            output[j] = comma[1];
            j++;

        }
        for (int i=0;i< output.length;i++){
            outputInt[i]=Integer.parseInt(output[i]) - 1;
        }
        j=0;
        chosenObjectCards=new ObjectCard[space.length];
        for(int i=0;i< space.length;i++){
            chosenObjectCards[i] = model.getBoard().getTiles()[outputInt[j]][outputInt[j+1]].getObject();
            if (chosenObjectCards[i]==null){
                throw new EmptyTileException();
            }
            //System.out.println(outputInt[j]+","+outputInt[j+1]);
            //System.out.println(chosenObjectCards[0].getType());
            j=j+2;
        }
        return chosenObjectCards;

    }

    /**
     * Calls Game method to setup the game,
     * like the board, the common goal(s),
     * the personal goal(s) and chooses
     * the first player to start
     */
    public void setup(){
        model.setupBoardObjects();
        model.setupCommonGoals();
        model.setupPersonalGoals();
        model.setupFirstPlayer();
    }

    /**
     * Checks if the order chosen by the player
     * is correct and satisfy the rules of the
     * game
     *
     * @param chosenInsertionOrder player's chosen order
     *                             of insertion
     * @return true if is correct, false else
     * @throws DifferentLengthException
     * @throws OrderException
     */
    protected boolean checkOrder(int [] chosenInsertionOrder) throws DifferentLengthException, OrderException{
        int i = 0;
        while(model.getTable()[i].getPosition() != model.getCurrentPlayer()){
            i += 1;
        }
        Player currentPlayer = model.getTable()[i];
        if(chosenInsertionOrder.length!=currentPlayer.getChosenObjects().length){
            throw new DifferentLengthException();
        }
        int [] order=new int[chosenInsertionOrder.length];
        for(int k=0;k<chosenInsertionOrder.length;k++){
            order[k]=k+1;
        }
        for(int k=0;k<chosenInsertionOrder.length;k++) {
            for (int o = 0; o < chosenInsertionOrder.length; o++) {
                if (chosenInsertionOrder[k] > chosenInsertionOrder.length || chosenInsertionOrder[k]<=0) {
                    throw new OrderException("Number " + chosenInsertionOrder[k] + " is not a valid insertion number");
                }
                if(chosenInsertionOrder[k]==order[o]){
                    order[o]=-1;
                }
            }
        }
        for(int o=0;o<chosenInsertionOrder.length;o++){
            if(order[o]!=-1){
                throw new OrderException("You have to choose a different insertion number for each object");
            }
        }
        return true;
    }

    /**
     * Checks if player's chosen object can
     * be taken, are correct and satisfy
     * game's rules
     *
     * @param pickedObject player's chosen object
     * @return true if can be picked, false else
     * @throws MaxDrawableObjectsException if can't be taken because
     *                                     of not available free spots
     *                                     in player's bookshelf
     * @throws NoFreeSidesException if can't be taken because
     *                              does not have at least 1
     *                              free side
     * @throws AlreadyPickedException if can't be picked because
     *                                was already picked
     * @throws NoStraightLineException if can't be picked because
     *                                 are not placed on a straight
     *                                 line on the board
     * @throws NoAdjacentException if can't be picked because
     *                             are not adjacent
     */
    protected boolean checkPickedObject(ObjectCard[] pickedObject) throws MaxDrawableObjectsException, NoFreeSidesException, AlreadyPickedException, NoStraightLineException, NoAdjacentException {
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
        if(pickedObject.length!=1) {

            if (sortX.size() == 1 && sortY.size() == pickedObject.length) {//le tessere sono state scelte su una linea orizzontale
                for (int j = 0; j < sortY.size(); j++) {
                    p = sortY.get(j);
                    if (!sortY.contains(p - 1) && !sortY.contains(p + 1)) {
                        throw new NoAdjacentException();
                    }
                }
            } else if (sortY.size() == 1 && sortX.size() == pickedObject.length) {// le tessere sono state scelte su una linea verticale
                for (int k = 0; k < sortX.size(); k++) {
                    p = sortX.get(k);
                    if (!sortX.contains(p - 1) && !sortX.contains(p + 1)) {
                        throw new NoAdjacentException();
                    }
                }
            } else {
                throw new NoStraightLineException();
            }
        }

        return true;
    }

    /**
     * Removes chosen objects from the board
     * and saves them into current player's
     * chosenObject attribute
     *
     * @param pickedObject player's chosen objects
     */
    protected void savePickedObject(ObjectCard [] pickedObject){
        int x, y;
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
    }

    /**
     * Check if chosen column can be used and
     * is correct based on game's rules
     *
     * @param column chosen column
     * @return true if can be used, false else
     * @throws OutOfBookshelfException if the chosen column is
     *                                 out of bookshelf bounds
     */
    protected boolean checkChosenColumn(int column) throws OutOfBookshelfException {
        int i = 0;
        while(model.getTable()[i].getPosition() != model.getCurrentPlayer()){
            i += 1;
        }
        Player currentPlayer = model.getTable()[i];
        if(column<0 || column>=currentPlayer.getBookshelf().getShelf()[0].length){
            throw new OutOfBookshelfException("The column you have selected doesn't exists");
        }
        // Get chosen column and counter of empty slot for checking
        int nullCounter = 0;
        // Get current player's bookshelf and chosen object size
        ObjectCard[][] bookshelf = currentPlayer.getBookshelf().getShelf();
        int size = currentPlayer.getChosenObjects().length;
        // Count empty slots
        for (int row = 0; row < bookshelf.length; row++) {
            if (bookshelf[row][column] == null) {
                nullCounter += 1;
            }
        }
        // Set a error trigger for insufficient space 
        if (nullCounter < size) { throw new OutOfBookshelfException("The column you have selected doesn't have enough empty cells for all the object cards you chose"); }
        return true;

    }
}

