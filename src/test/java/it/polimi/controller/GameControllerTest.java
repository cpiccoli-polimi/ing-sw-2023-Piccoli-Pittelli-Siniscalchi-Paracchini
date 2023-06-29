package it.polimi.controller;

import it.polimi.controller.exception.*;
import it.polimi.model.*;
import it.polimi.model.CommonGoalCards.CommonGoalCard1;
import it.polimi.model.exception.CommonGoalsNumberException;
import it.polimi.model.exception.PlayersNumberException;
import it.polimi.observer.Observer;
import it.polimi.server.ClientConnection;
import it.polimi.view.RemoteView;
import it.polimi.view.View;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    @Test
    void update() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        Game model=new Game(2,2);
        GameController gameController=new GameController(model);
        Player player1=new Player("player1",1);
        Player player2=new Player("player2",1);
        model.setTable(player1,0);
        model.setTable(player2,1);
        model.setupFirstPlayer();
        model.setupBoardObjects();
        CommonGoalCard cm=new CommonGoalCard1(2);
        CommonGoalCard[] cmc=new CommonGoalCard[]{cm};
        model.getBoard().setCommonGoals(cmc);
        ClientConnection clientConnection=new ClientConnection() {
            @Override
            public void closeConnection(String closingMessage) {

            }

            @Override
            public void addObserver(Observer<String> observer) {

            }

            @Override
            public void asyncSend(Object message) {

            }
        };
        View view=new RemoteView(player1,clientConnection);
        PlayerChoice message=new PlayerChoice(player1,"OBJECTCARDSCHOICE:2,4 3,4",view);

        gameController.update(message);

    }
    @Test
    void correctHandleMessage() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        Game model=new Game(2,2);
        GameController gameController=new GameController(model);
        Player player1=new Player("player1",1);
        Player player2=new Player("player2",1);
        model.setTable(player1,0);
        model.setTable(player2,1);
        model.setupFirstPlayer();
        model.setupBoardObjects();
        CommonGoalCard cm=new CommonGoalCard1(2);
        CommonGoalCard[] cmc=new CommonGoalCard[]{cm};
        model.getBoard().setCommonGoals(cmc);
        ClientConnection clientConnection=new ClientConnection() {
            @Override
            public void closeConnection(String s) {

            }

            @Override
            public void addObserver(Observer<String> observer) {

            }

            @Override
            public void asyncSend(Object message) {

            }
        };
        View view=new RemoteView(player1,clientConnection);



        PlayerChoice message=new PlayerChoice(player1,"OBJECTCARDSCHOICE:2,4 3,4",view);
        PlayerChoice message2=new PlayerChoice(player2,"OBJECTCARDSCHOICE:2,4 3,4",view);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);
        /*ObjectCard objectCard1= new PublicObjectCard(1,1,4);
        ObjectCard [] objectCard = new ObjectCard[]{objectCard1};
        player1.setChosenObjects(objectCard);
        player2.setChosenObjects(objectCard);*/
        message=new PlayerChoice(player1,"BOOKSHELFCOLUMNCHOICE:2",view);
        message2=new PlayerChoice(player2,"BOOKSHELFCOLUMNCHOICE:2",view);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);

        message=new PlayerChoice(player1,"INSERTIONORDERCHOICE:1 2",view);
        message2=new PlayerChoice(player2,"INSERTIONORDERCHOICE:1 2",view);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);
        assertNull(model.getBoard().getTiles()[1][3].getObject());
        assertNull(model.getBoard().getTiles()[2][3].getObject());

        message=new PlayerChoice(player1,"OBJECTCARDSCHOICE:2,5",view);
        message2=new PlayerChoice(player2,"OBJECTCARDSCHOICE:2,5",view);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);
        /*ObjectCard objectCard1= new PublicObjectCard(1,1,4);
        ObjectCard [] objectCard = new ObjectCard[]{objectCard1};
        player1.setChosenObjects(objectCard);
        player2.setChosenObjects(objectCard);*/
        message=new PlayerChoice(player1,"BOOKSHELFCOLUMNCHOICE:2",view);
        message2=new PlayerChoice(player2,"BOOKSHELFCOLUMNCHOICE:2",view);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);

        message=new PlayerChoice(player1,"INSERTIONORDERCHOICE:1",view);
        message2=new PlayerChoice(player2,"INSERTIONORDERCHOICE:1",view);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);
        assertNull(model.getBoard().getTiles()[1][4].getObject());
    }
    @Test
    void handleMessageWithException() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        Game model=new Game(2,2);
        GameController gameController=new GameController(model);
        Player player1=new Player("player1",1);
        Player player2=new Player("player2",1);
        model.setTable(player1,0);
        model.setTable(player2,1);
        model.setupFirstPlayer();
        model.setupBoardObjects();
        CommonGoalCard cm=new CommonGoalCard1(2);
        CommonGoalCard[] cmc=new CommonGoalCard[]{cm};
        model.getBoard().setCommonGoals(cmc);
        ClientConnection clientConnection=new ClientConnection() {
            @Override
            public void closeConnection(String s) {

            }

            @Override
            public void addObserver(Observer<String> observer) {

            }

            @Override
            public void asyncSend(Object message) {

            }
        };
        View view=new RemoteView(player1,clientConnection);
        View view2=new RemoteView(player2,clientConnection);
        PlayerChoice message=new PlayerChoice(player1,"OBJECTCARDSCHOICE:1,4",view);
        PlayerChoice message2=new PlayerChoice(player2,"OBJECTCARDSCHOICE:1,4",view2);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);


        player1.getBookshelf().setMaxDrawableObjects(1);
        player2.getBookshelf().setMaxDrawableObjects(1);
        message=new PlayerChoice(player1,"OBJECTCARDSCHOICE:2,5 2,6",view);
        message2=new PlayerChoice(player2,"OBJECTCARDSCHOICE:2,5 2,6",view2);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);
        player1.getBookshelf().setMaxDrawableObjects(3);
        player2.getBookshelf().setMaxDrawableObjects(3);

        message=new PlayerChoice(player1,"OBJECTCARDSCHOICE:r,4",view);
        message2=new PlayerChoice(player2,"OBJECTCARDSCHOICE:r,4",view2);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);
        message=new PlayerChoice(player1,"OBJECTCARDSCHOICE:2,5,4",view);
        message2=new PlayerChoice(player2,"OBJECTCARDSCHOICE:2,5,4",view2);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);
        message=new PlayerChoice(player1,"OBJECTCARDSCHOICE:2,5 2,5",view);
        message2=new PlayerChoice(player2,"OBJECTCARDSCHOICE:2,5 2,5",view2);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);
        message=new PlayerChoice(player1,"OBJECTCARDSCHOICE:4,3 6,3",view);
        message2=new PlayerChoice(player2,"OBJECTCARDSCHOICE:4,3 6,3",view2);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);
        message=new PlayerChoice(player1,"OBJECTCARDSCHOICE:",view);
        message2=new PlayerChoice(player2,"OBJECTCARDSCHOICE:",view2);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);
        message=new PlayerChoice(player1,"OBJECTCARDSCHOICE:2,4 2,5 3,4",view);
        message2=new PlayerChoice(player2,"OBJECTCARDSCHOICE:2,4 2,5 3,4",view2);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);


        message=new PlayerChoice(player1,"OBJECTCARDSCHOICE:2,5",view);
        message2=new PlayerChoice(player2,"OBJECTCARDSCHOICE:2,5",view2);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);
        message=new PlayerChoice(player1,"BOOKSHELFCOLUMNCHOICE:-1",view);
        message2=new PlayerChoice(player2,"BOOKSHELFCOLUMNCHOICE:-1",view2);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);
        message=new PlayerChoice(player1,"BOOKSHELFCOLUMNCHOICE:r",view);
        message2=new PlayerChoice(player2,"BOOKSHELFCOLUMNCHOICE:r",view2);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);



        /*message=new PlayerChoice(player1,"OBJECTCARDSCHOICE:2,5",view);
        message2=new PlayerChoice(player2,"OBJECTCARDSCHOICE:2,5",view);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);*/
        message=new PlayerChoice(player1,"BOOKSHELFCOLUMNCHOICE:1",view);
        message2=new PlayerChoice(player2,"BOOKSHELFCOLUMNCHOICE:1",view);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);
        message=new PlayerChoice(player1,"INSERTIONORDERCHOICE:1 2",view);
        message2=new PlayerChoice(player2,"INSERTIONORDERCHOICE:1 2",view);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);
        message=new PlayerChoice(player1,"INSERTIONORDERCHOICE:r",view);
        message2=new PlayerChoice(player2,"INSERTIONORDERCHOICE:r",view);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);
        message=new PlayerChoice(player1,"INSERTIONORDERCHOICE:12",view);
        message2=new PlayerChoice(player2,"INSERTIONORDERCHOICE:12",view);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);

        /*message=new PlayerChoice(player1,"INSERTIONORDERCHOICE:r",view);
        message2=new PlayerChoice(player2,"INSERTIONORDERCHOICE:r",view);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);*/
        message=new PlayerChoice(player1,"INSERTIONORDERCHOICE:1",view);
        message2=new PlayerChoice(player2,"INSERTIONORDERCHOICE:1",view);
        gameController.handleMessage(message);
        gameController.handleMessage(message2);
        assertNull(model.getBoard().getTiles()[1][4].getObject());
    }

    @Test
    void convertOrder() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException, OrderException, NumberFormatException {
        Game model=new Game(2,2);
        GameController gameController=new GameController(model);
        String s="1";
        int [] i= new int[]{1};
        assertArrayEquals(i,gameController.convertOrder(s));

        s="1 2";
        i= new int[]{1,2};
        assertArrayEquals(i,gameController.convertOrder(s));

        s="1 2 3";
        i= new int[]{1,2,3};
        assertArrayEquals(i,gameController.convertOrder(s));

    }
    @Test
    void convertColumnTest() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        Game model=new Game(2,2);
        GameController gameController=new GameController(model);
        String string="1";
        assertEquals(0,gameController.convertColumn(string));
        string="2";
        assertEquals(1,gameController.convertColumn(string));
        string="3";
        assertEquals(2,gameController.convertColumn(string));
        string="4";
        assertEquals(3,gameController.convertColumn(string));
        string="5";
        assertEquals(4,gameController.convertColumn(string));

        string="2147483647";
        assertEquals(2147483646,gameController.convertColumn(string));
        string="-2147483647";
        assertEquals(-2147483648,gameController.convertColumn(string));
        string="2147483648";

        string="2 2";
        try{
            gameController.convertColumn(string);
        } catch (NumberFormatException e){
            assertTrue(true);
        }
    }

    @Test
    void convert() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException, CoordinateException {
        Game model=new Game(2,2);
        GameController gameController=new GameController(model);
        model.setupBoardObjects();

        String s="2,4 2,5";
        ObjectCard objectCard1= model.getBoard().getTiles()[1][3].getObject();
        ObjectCard objectCard2= model.getBoard().getTiles()[1][4].getObject();
        ObjectCard [] objectCards= new ObjectCard[]{objectCard1, objectCard2};
        ObjectCard [] objectCardsConv;
        objectCardsConv= gameController.convert(s);
        System.out.println(objectCardsConv[0].getType());
        assertArrayEquals(objectCards,gameController.convert(s));

        // EmptyTileException
        try{
            s="1,3";
            objectCardsConv= gameController.convert(s);
            for(int i=0;i<objectCardsConv.length;i++) {
                objectCardsConv[0].getType();
            }
        }catch (EmptyTileException e){
            assertTrue(true);
        }
        try{
            s="1,3 2,4";
            objectCardsConv= gameController.convert(s);
            for(int i=0;i<objectCardsConv.length;i++) {
                objectCardsConv[0].getType();
            }
        }catch (EmptyTileException e){
            assertTrue(true);
        }

        //NumberFormatException
        try{
            s="r,4";
            gameController.convert(s);
        }catch(NumberFormatException e){
            assertTrue(true);
        }
        try{
            s="1,4 r,5";
            gameController.convert(s);
        }catch(NumberFormatException e){
            assertTrue(true);
        }

        //CoordinateException
        try{
            s="1,3,4";
            gameController.convert(s);

        }catch (CoordinateException e){
            assertTrue(true);
        }
        try {
                s="r";
                gameController.convert(s);
            }catch (CoordinateException e){
            assertTrue(true);

        }

    }


    @Test
    void checkOrder() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException, DifferentLengthException, OrderException {
        Game model=new Game(2,2);
        GameController gameController=new GameController(model);
        Player player1=new Player("player1",2);
        Player player2=new Player("player2",2);
        model.setTable(player1,0);
        model.setTable(player2,1);
        model.setupFirstPlayer();
        model.setupBoardObjects();
        ObjectCard objectCard1= model.getBoard().getTiles()[1][3].getObject();
        ObjectCard objectCard2= model.getBoard().getTiles()[1][4].getObject();
        ObjectCard [] objectCards= new ObjectCard[]{objectCard1, objectCard2};
        player1.setChosenObjects(objectCards);
        player2.setChosenObjects(objectCards);
        int [] i={1,2};
        assertEquals(true,gameController.checkOrder(i));

        //DifferentLengthException
        try{
            i= new int[]{1};
            gameController.checkOrder(i);
        }catch (DifferentLengthException e){
            assertTrue(true);
        }
        try{
            i= new int[]{1,2,3};
            gameController.checkOrder(i);
        }catch (DifferentLengthException e){
            assertTrue(true);
        }

        //OrderException
        try{
            i=new int[]{1,1};
            gameController.checkOrder(i);
        }catch (OrderException e){
            assertTrue(true);
        }
        try{
            i=new int[]{1,3};
            gameController.checkOrder(i);
        }catch (OrderException e){
            assertTrue(true);
        }
        try{
            i=new int[]{1,23};
            gameController.checkOrder(i);
        }catch (OrderException e){
            assertTrue(true);
        }

    }

    @Test
    void checkPickedObject() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException, MaxDrawableObjectsException, NoAdjacentException, NoFreeSidesException, AlreadyPickedException, NoStraightLineException {
        Game model=new Game(2,2);
        GameController gameController=new GameController(model);
        Player player1=new Player("player1",2);
        Player player2=new Player("player2",2);
        model.setTable(player1,0);
        model.setTable(player2,1);
        model.setupFirstPlayer();
        model.setupBoardObjects();
        ObjectCard objectCard1= model.getBoard().getTiles()[1][3].getObject();
        ObjectCard objectCard2= model.getBoard().getTiles()[1][4].getObject();
        ObjectCard [] objectCards= new ObjectCard[]{objectCard1, objectCard2};
        assertEquals(true,gameController.checkPickedObject(objectCards));

        //MaxDrawableObjectsException
        try {
            objectCard1 = model.getBoard().getTiles()[1][3].getObject();
            objectCard2 = model.getBoard().getTiles()[1][4].getObject();
            player1.getBookshelf().setMaxDrawableObjects(1);
            player2.getBookshelf().setMaxDrawableObjects(1);
            objectCards = new ObjectCard[]{objectCard1, objectCard2};
            gameController.checkPickedObject(objectCards);
        }catch (MaxDrawableObjectsException e){
            assertTrue(true);
        }
        player1.getBookshelf().setMaxDrawableObjects(3);
        player2.getBookshelf().setMaxDrawableObjects(3);

        //NoFreeSidesException
        try {
            objectCard1 = model.getBoard().getTiles()[5][5].getObject();
            objectCards = new ObjectCard[]{objectCard1};
            gameController.checkPickedObject(objectCards);
        }catch (NoFreeSidesException e){
            assertTrue(true);
        }

        //AlreadyPickedException
        try {
            objectCard1 = model.getBoard().getTiles()[1][4].getObject();
            objectCard2 = model.getBoard().getTiles()[1][4].getObject();
            objectCards = new ObjectCard[]{objectCard1, objectCard2};
            gameController.checkPickedObject(objectCards);
        }catch (AlreadyPickedException e){
            assertTrue(true);
        }

        //NoStraightLineException
        try {
            objectCard1 = model.getBoard().getTiles()[1][4].getObject();
            objectCard2 = model.getBoard().getTiles()[2][3].getObject();
            //ObjectCard objectCards3=model.getBoard().getTiles()[1][3].getObject();
            objectCards = new ObjectCard[]{objectCard1, objectCard2,/*objectCards3*/};
            gameController.checkPickedObject(objectCards);
        }catch (NoStraightLineException e){
            assertTrue(true);
        }
        //NoAdjacentException
        try {
            model.getBoard().removeObject(1,4);
            objectCard1 = model.getBoard().getTiles()[2][5].getObject();
            objectCard2 = model.getBoard().getTiles()[2][3].getObject();
            //ObjectCard objectCards3=model.getBoard().getTiles()[1][3].getObject();
            objectCards = new ObjectCard[]{objectCard1, objectCard2,/*objectCards3*/};
            gameController.checkPickedObject(objectCards);
        }catch (NoAdjacentException e){
            assertTrue(true);
        }

    }

    @Test
    void savePickedObject(){

    }

    @Test void checkChosenColumn() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException, OutOfBookshelfException {
        Game model=new Game(2,2);
        GameController gameController=new GameController(model);
        Player player1=new Player("player1",2);
        Player player2=new Player("player2",2);
        model.setTable(player1,0);
        model.setTable(player2,1);
        model.setupFirstPlayer();
        model.setupBoardObjects();
        ObjectCard objectCard1= model.getBoard().getTiles()[1][3].getObject();
        ObjectCard objectCard2= model.getBoard().getTiles()[1][4].getObject();
        ObjectCard [] objectCards= new ObjectCard[]{objectCard1, objectCard2};
        player1.setChosenObjects(objectCards);
        player2.setChosenObjects(objectCards);
        assertEquals(true,gameController.checkChosenColumn(4));

        //OutOfBookshelfException
        try {
            gameController.checkChosenColumn(0);
        } catch (OutOfBookshelfException e){
            assertTrue(true);
        }
        try {
            gameController.checkChosenColumn(5);
        } catch (OutOfBookshelfException e){
            assertTrue(true);
        }

        for(int i=0;i<player1.getBookshelf().getShelf().length;i++){
            player1.getBookshelf().setShelf(new PublicObjectCard(1,2,3),0);
            player2.getBookshelf().setShelf(new PublicObjectCard(1,2,3),0);
        }
        try {
            gameController.checkChosenColumn(0);
        } catch (OutOfBookshelfException e){
            assertTrue(true);
        }

    }

    @Test
    void setup() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        Game game=new Game(2,1);
        GameController gameController=new GameController(game);
        Player player1=new Player("player1",1);
        Player player2=new Player("player2",1);
        game.setTable(player1,0);
        game.setTable(player2,1);
        gameController.setup();

    }
}