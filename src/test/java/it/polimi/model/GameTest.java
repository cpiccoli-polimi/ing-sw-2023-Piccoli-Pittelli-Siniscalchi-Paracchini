package it.polimi.model;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import it.polimi.model.CommonGoalCards.*;
import it.polimi.model.exception.CommonGoalsNumberException;
import it.polimi.model.exception.PlayersNumberException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Long.parseLong;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void classConstructionWith2Players1CommonGoal(){
        int playersNumber = 2;
        int commonGoalsNumber = 1;
        try{
        Game gameModel = new Game(playersNumber, commonGoalsNumber);
        assertEquals(playersNumber, gameModel.getPlayersNumber());
        assertEquals(playersNumber, gameModel.getTable().length);
        assertEquals(playersNumber, gameModel.getLeaderboard().length);
        assertEquals(commonGoalsNumber, gameModel.getCommonGoalsNumber());
        assertEquals(commonGoalsNumber, gameModel.getBoard().getCommonGoals().length);
        assertTrue(gameModel.getDone() == false);
        assertTrue(gameModel.getEndGamePoints() == 1);
        assertTrue(gameModel.getCurrentPlayer() == 0);
        assertTrue(gameModel.getCommonGoalsDeck().size() == 12);
        assertTrue(gameModel.getPersonalGoalsDeck().size() == 12);
        assertTrue(gameModel.getBag() instanceof CardsBag);}
        catch (PlayersNumberException | CommonGoalsNumberException | FileNotFoundException exception){
            fail("classConstructionWith2Players1CommonGoal: FAILED due to " + exception.getMessage());
        }
    }
    @Test
    public void classConstructionWith3Players1CommonGoal(){
        int playersNumber = 3;
        int commonGoalsNumber = 1;
        try{
        Game gameModel = new Game(playersNumber, commonGoalsNumber);
        assertEquals(playersNumber, gameModel.getPlayersNumber());
        assertEquals(playersNumber, gameModel.getTable().length);
        assertEquals(playersNumber, gameModel.getLeaderboard().length);
        assertEquals(commonGoalsNumber, gameModel.getCommonGoalsNumber());
        assertEquals(commonGoalsNumber, gameModel.getBoard().getCommonGoals().length);
        assertTrue(gameModel.getDone() == false);
        assertTrue(gameModel.getEndGamePoints() == 1);
        assertTrue(gameModel.getCurrentPlayer() == 0);
        assertTrue(gameModel.getCommonGoalsDeck().size() == 12);
        assertTrue(gameModel.getPersonalGoalsDeck().size() == 12);
        assertTrue(gameModel.getBag() instanceof CardsBag);}
        catch (PlayersNumberException | CommonGoalsNumberException | FileNotFoundException exception){
            fail("classConstructionWith3Players1CommonGoal: FAILED due to " + exception.getMessage());
        }
    }
    @Test
    public void classConstructionWith4Players1CommonGoal(){
        int playersNumber = 4;
        int commonGoalsNumber = 1;
        try{
        Game gameModel = new Game(playersNumber, commonGoalsNumber);
        assertEquals(playersNumber, gameModel.getPlayersNumber());
        assertEquals(playersNumber, gameModel.getTable().length);
        assertEquals(playersNumber, gameModel.getLeaderboard().length);
        assertEquals(commonGoalsNumber, gameModel.getCommonGoalsNumber());
        assertEquals(commonGoalsNumber, gameModel.getBoard().getCommonGoals().length);
        assertTrue(gameModel.getDone() == false);
        assertTrue(gameModel.getEndGamePoints() == 1);
        assertTrue(gameModel.getCurrentPlayer() == 0);
        assertTrue(gameModel.getCommonGoalsDeck().size() == 12);
        assertTrue(gameModel.getPersonalGoalsDeck().size() == 12);
        assertTrue(gameModel.getBag() instanceof CardsBag);
        }
        catch (PlayersNumberException | CommonGoalsNumberException | FileNotFoundException exception){
            fail("classConstructionWith4Players1CommonGoal: FAILED due to " + exception.getMessage());
        }
    }
    @Test
    public void classConstructionWith2Players2CommonGoals(){
        int playersNumber = 2;
        int commonGoalsNumber = 2;
        try{
        Game gameModel = new Game(playersNumber, commonGoalsNumber);
        assertEquals(playersNumber, gameModel.getPlayersNumber());
        assertEquals(playersNumber, gameModel.getTable().length);
        assertEquals(playersNumber, gameModel.getLeaderboard().length);
        assertEquals(commonGoalsNumber, gameModel.getCommonGoalsNumber());
        assertEquals(commonGoalsNumber, gameModel.getBoard().getCommonGoals().length);
        assertTrue(gameModel.getDone() == false);
        assertTrue(gameModel.getEndGamePoints() == 1);
        assertTrue(gameModel.getCurrentPlayer() == 0);
        assertTrue(gameModel.getCommonGoalsDeck().size() == 12);
        assertTrue(gameModel.getPersonalGoalsDeck().size() == 12);
        assertTrue(gameModel.getBag() instanceof CardsBag);}
        catch (PlayersNumberException | CommonGoalsNumberException | FileNotFoundException exception){
            fail("classConstructionWith2Players2CommonGoals: FAILED due to " + exception.getMessage());
        }
    }
    @Test
    public void classConstructionWith3Players2CommonGoals(){
        int playersNumber = 3;
        int commonGoalsNumber = 2;
        try{
        Game gameModel = new Game(playersNumber, commonGoalsNumber);
        assertEquals(playersNumber, gameModel.getPlayersNumber());
        assertEquals(playersNumber, gameModel.getTable().length);
        assertEquals(playersNumber, gameModel.getLeaderboard().length);
        assertEquals(commonGoalsNumber, gameModel.getCommonGoalsNumber());
        assertEquals(commonGoalsNumber, gameModel.getBoard().getCommonGoals().length);
        assertTrue(gameModel.getDone() == false);
        assertTrue(gameModel.getEndGamePoints() == 1);
        assertTrue(gameModel.getCurrentPlayer() == 0);
        assertTrue(gameModel.getCommonGoalsDeck().size() == 12);
        assertTrue(gameModel.getPersonalGoalsDeck().size() == 12);
        assertTrue(gameModel.getBag() instanceof CardsBag);}
        catch (PlayersNumberException | CommonGoalsNumberException | FileNotFoundException exception){
            fail("classConstructionWith3Players2CommonGoals: FAILED due to " + exception.getMessage());
        }
    }
    @Test
    public void classConstructionWith4Players2CommonGoals(){
        int playersNumber = 4;
        int commonGoalsNumber = 2;
        try{
        Game gameModel = new Game(playersNumber, commonGoalsNumber);
        assertEquals(playersNumber, gameModel.getPlayersNumber());
        assertEquals(playersNumber, gameModel.getTable().length);
        assertEquals(playersNumber, gameModel.getLeaderboard().length);
        assertEquals(commonGoalsNumber, gameModel.getCommonGoalsNumber());
        assertEquals(commonGoalsNumber, gameModel.getBoard().getCommonGoals().length);
        assertTrue(gameModel.getDone() == false);
        assertTrue(gameModel.getEndGamePoints() == 1);
        assertTrue(gameModel.getCurrentPlayer() == 0);
        assertTrue(gameModel.getCommonGoalsDeck().size() == 12);
        assertTrue(gameModel.getPersonalGoalsDeck().size() == 12);
        assertTrue(gameModel.getBag() instanceof CardsBag);}
        catch (PlayersNumberException | CommonGoalsNumberException | FileNotFoundException exception){
            fail("classConstructionWith4Players2CommonGoals test: FAILED due to "+ exception.getMessage());
        }
    }
    @Test
    public void classConstructionWith0Players(){
        try{
            Game gameModel = new Game(0, 1);
        }
        catch (PlayersNumberException exception){
            System.out.println("classConstructionWith0Players: " + exception.getMessage());
        }
        catch(CommonGoalsNumberException | FileNotFoundException exception){
            fail();
        }
    }
    @Test
    public void classConstructionWith5PlusPlayers(){
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
        try{
            Game gameModel = new Game(generator.nextInt(10000), 1);
        }
        catch (PlayersNumberException exception){
            System.out.println("classConstructionWith5PlusPlayers: " + exception.getMessage());
        }
        catch(CommonGoalsNumberException | FileNotFoundException exception){
            fail();
        }
    }
    @Test
    public void classConstructionWith0CommonGoals(){
        try{
            Game gameModel = new Game(2, 0);
        }
        catch (CommonGoalsNumberException exception){
            System.out.println("classConstructionWith0CommonGoals: " + exception.getMessage());
        }
        catch(PlayersNumberException | FileNotFoundException exception){
            fail();
        }
    }
    @Test
    public void classConstructionWith2PlusCommonGoals(){
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
        try{
            Game gameModel = new Game(2, generator.nextInt(10000));
        }
        catch (CommonGoalsNumberException exception){
            System.out.println("classConstructionWith2PlusCommonGoals: " + exception.getMessage());
        }
        catch(PlayersNumberException | FileNotFoundException exception){
            fail();
        }
    }
    @Test
    public void setupFirstPlayerWith2Players(){
        try{
            int firstPlayerIndex;
            List<Integer> indexList = new ArrayList<Integer>();
            Game gameModel;
            indexList.add(0, 0);
            indexList.add(1, 1);

            while(indexList.isEmpty() == false){
                gameModel = new Game(2, 2);
                gameModel.setTable(new Player("Topolino", gameModel.getCommonGoalsNumber()), 0);
                gameModel.setTable(new Player("Pippo", gameModel.getCommonGoalsNumber()), 1);
                gameModel.setupFirstPlayer();
                firstPlayerIndex = -1;
                for(int i = 0; i < gameModel.getPlayersNumber() && firstPlayerIndex == -1; i++){
                    if(gameModel.getTable()[i].getIsFirst() == true){
                        firstPlayerIndex = i;
                    }
                }

                switch(firstPlayerIndex){
                    case 0:
                        if(indexList.contains(firstPlayerIndex) == true){
                        assertEquals(0, gameModel.getTable()[0].getPosition());
                        assertEquals(1, gameModel.getTable()[1].getPosition());
                        System.out.println("setupFirstPlayerWith2Players: passed with table[" + firstPlayerIndex + "] as first player");
                        indexList.remove(indexList.indexOf(firstPlayerIndex));
                        break;
                        } else {
                            break;
                        }
                    case 1:
                        if(indexList.contains(firstPlayerIndex) == true){
                            assertEquals(0, gameModel.getTable()[1].getPosition());
                            assertEquals(1, gameModel.getTable()[0].getPosition());
                            System.out.println("setupFirstPlayerWith2Players: passed with table[" + firstPlayerIndex + "] as first player");
                            indexList.remove(indexList.indexOf(firstPlayerIndex));
                            break;
                        } else {
                            break;
                        }
                    default:
                        fail();
                }
            }
            System.out.println("setupFirstPlayerWith2Players: PASSED all cases");
        }
        catch (PlayersNumberException | CommonGoalsNumberException | FileNotFoundException exception){
            fail();
        }
    }
    @Test
    public void setupFirstPlayerWith3Players(){
        try{
            int firstPlayerIndex;
            List<Integer> indexList = new ArrayList<Integer>();
            Game gameModel;
            indexList.add(0, 0);
            indexList.add(1, 1);
            indexList.add(2, 2);

            while(indexList.isEmpty() == false){
                gameModel = new Game(3, 2);
                gameModel.setTable(new Player("Topolino", gameModel.getCommonGoalsNumber()), 0);
                gameModel.setTable(new Player("Pippo", gameModel.getCommonGoalsNumber()), 1);
                gameModel.setTable(new Player("Pluto", gameModel.getCommonGoalsNumber()), 2);
                gameModel.setupFirstPlayer();
                firstPlayerIndex = -1;
                for(int i = 0; i < gameModel.getPlayersNumber() && firstPlayerIndex == -1; i++){
                    if(gameModel.getTable()[i].getIsFirst() == true){
                        firstPlayerIndex = i;
                    }
                }

                switch(firstPlayerIndex){
                    case 0:
                        if(indexList.contains(firstPlayerIndex) == true){
                            assertEquals(0, gameModel.getTable()[0].getPosition());
                            assertEquals(1, gameModel.getTable()[1].getPosition());
                            assertEquals(2, gameModel.getTable()[2].getPosition());
                            System.out.println("setupFirstPlayerWith3Players: passed with table[" + firstPlayerIndex + "] as first player");
                            indexList.remove(indexList.indexOf(firstPlayerIndex));
                            break;
                        }
                        else{
                            break;
                        }
                    case 1:
                        if(indexList.contains(firstPlayerIndex) == true){
                            assertEquals(0, gameModel.getTable()[1].getPosition());
                            assertEquals(1, gameModel.getTable()[2].getPosition());
                            assertEquals(2, gameModel.getTable()[0].getPosition());
                            System.out.println("setupFirstPlayerWith3Players: passed with table[" + firstPlayerIndex + "] as first player");
                            indexList.remove(indexList.indexOf(firstPlayerIndex));
                            break;
                        }
                        else{
                            break;
                        }
                    case 2:
                        if(indexList.contains(firstPlayerIndex) == true){
                            assertEquals(0, gameModel.getTable()[2].getPosition());
                            assertEquals(1, gameModel.getTable()[0].getPosition());
                            assertEquals(2, gameModel.getTable()[1].getPosition());
                            System.out.println("setupFirstPlayerWith3Players: passed with table[" + firstPlayerIndex + "] as first player");
                            indexList.remove(indexList.indexOf(firstPlayerIndex));
                            break;
                        }
                        else{
                            break;
                        }
                    default:
                        fail();
                }
            }
            System.out.println("setupFirstPlayerWith2Players: PASSED all cases");
        }
        catch (PlayersNumberException | CommonGoalsNumberException | FileNotFoundException exception){
            fail();
        }
    }
    @Test
    public void setupFirstPlayerWith4Players(){
        try{
            int firstPlayerIndex;
            List<Integer> indexList = new ArrayList<Integer>();
            Game gameModel;
            indexList.add(0, 0);
            indexList.add(1, 1);
            indexList.add(2, 2);
            indexList.add(3, 3);


            while(indexList.isEmpty() == false){
                gameModel = new Game(4, 2);
                gameModel.setTable(new Player("Topolino", gameModel.getCommonGoalsNumber()), 0);
                gameModel.setTable(new Player("Pippo", gameModel.getCommonGoalsNumber()), 1);
                gameModel.setTable(new Player("Pluto", gameModel.getCommonGoalsNumber()), 2);
                gameModel.setTable(new Player("Paperino", gameModel.getCommonGoalsNumber()), 3);
                gameModel.setupFirstPlayer();
                firstPlayerIndex = -1;
                for(int i = 0; i < gameModel.getPlayersNumber() && firstPlayerIndex == -1; i++){
                    if(gameModel.getTable()[i].getIsFirst() == true){
                        firstPlayerIndex = i;
                    }
                }

                switch(firstPlayerIndex){
                    case 0:
                        if(indexList.contains(firstPlayerIndex) == true){
                            assertEquals(0, gameModel.getTable()[0].getPosition());
                            assertEquals(1, gameModel.getTable()[1].getPosition());
                            assertEquals(2, gameModel.getTable()[2].getPosition());
                            assertEquals(3, gameModel.getTable()[3].getPosition());
                            System.out.println("setupFirstPlayerWith4Players: passed with table[" + firstPlayerIndex + "] as first player");
                            indexList.remove(indexList.indexOf(firstPlayerIndex));
                            break;
                        }
                        else{
                            break;
                        }
                    case 1:
                        if(indexList.contains(firstPlayerIndex) == true){
                            assertEquals(0, gameModel.getTable()[1].getPosition());
                            assertEquals(1, gameModel.getTable()[2].getPosition());
                            assertEquals(2, gameModel.getTable()[3].getPosition());
                            assertEquals(3, gameModel.getTable()[0].getPosition());
                            System.out.println("setupFirstPlayerWith4Players: passed with table[" + firstPlayerIndex + "] as first player");
                            indexList.remove(indexList.indexOf(firstPlayerIndex));
                            break;
                        }
                        else{
                            break;
                        }
                    case 2:
                        if(indexList.contains(firstPlayerIndex) == true){
                            assertEquals(0, gameModel.getTable()[2].getPosition());
                            assertEquals(1, gameModel.getTable()[3].getPosition());
                            assertEquals(2, gameModel.getTable()[0].getPosition());
                            assertEquals(3, gameModel.getTable()[1].getPosition());
                            System.out.println("setupFirstPlayerWith4Players: passed with table[" + firstPlayerIndex + "] as first player");
                            indexList.remove(indexList.indexOf(firstPlayerIndex));
                            break;
                        }
                        else{
                            break;
                        }
                    case 3:
                        if(indexList.contains(firstPlayerIndex) == true){
                            assertEquals(0, gameModel.getTable()[3].getPosition());
                            assertEquals(1, gameModel.getTable()[0].getPosition());
                            assertEquals(2, gameModel.getTable()[1].getPosition());
                            assertEquals(3, gameModel.getTable()[2].getPosition());
                            System.out.println("setupFirstPlayerWith4Players: passed with table[" + firstPlayerIndex + "] as first player");
                            indexList.remove(indexList.indexOf(firstPlayerIndex));
                            break;
                        }
                        else{
                            break;
                        }
                    default:
                        fail();
                }
            }
            System.out.println("setupFirstPlayerWith2Players: PASSED all cases");
        }
        catch (PlayersNumberException | CommonGoalsNumberException | FileNotFoundException exception){
            fail();
        }
    }
    @Test
    public void setupBoardObjectsWith2Players(){
        List<Integer> idList;
        Game gameModel;
        Gson gson = new Gson();
        File testCasesJsonFile = new File("src/test/resources/SetupBoardCases.json");
        try {
            FileReader testCasesJsonFileReader = new FileReader(testCasesJsonFile);
            JsonObject testCases = gson.fromJson( testCasesJsonFileReader, JsonObject.class);

            try{
                idList = new ArrayList<Integer>();
                gameModel = new Game(2, 2);
                gameModel.setupBoardObjects();

                JsonArray twoPlayersTestCase = testCases.getAsJsonArray("2PlayersCase");
                for(JsonElement tileJsonElement : twoPlayersTestCase){
                    JsonObject tileJsonObject = tileJsonElement.getAsJsonObject();
                    int row = tileJsonObject.get("row").getAsInt();
                    int column = tileJsonObject.get("column").getAsInt();
                    boolean objectCard = tileJsonObject.get("objectCard").getAsBoolean();
                    int minPlayers = tileJsonObject.get("minPlayers").getAsInt();
                    int freeSidesCounter = tileJsonObject.get("freeSidesCounter").getAsInt();

                    if(objectCard == true){
                        assertNotNull(gameModel.getBoard().getTiles()[row][column].getObject());
                        if(idList.contains(gameModel.getBoard().getTiles()[row][column].getObject().getId()) == false){
                            idList.add(gameModel.getBoard().getTiles()[row][column].getObject().getId());
                        }
                        else{
                            fail();
                        }
                    }
                    else if(objectCard == false){
                        assertNull(gameModel.getBoard().getTiles()[row][column].getObject());
                    }
                    assertEquals(minPlayers, gameModel.getBoard().getTiles()[row][column].getMinPlayers());
                    assertEquals(freeSidesCounter, gameModel.getBoard().getTiles()[row][column].getFreeSides());
                    System.out.println("setupBoardObjectsWith2Players: passed test case with tile [" + row + "][" + column + "]");
                }
            } catch (PlayersNumberException | CommonGoalsNumberException e) {
                fail();
            }
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    @Test
    public void setupBoardObjectsWith3Players(){
        List<Integer> idList;
        Game gameModel;
        Gson gson = new Gson();
        File testCasesJsonFile = new File("src/test/resources/SetupBoardCases.json");
        try {
            FileReader testCasesJsonFileReader = new FileReader(testCasesJsonFile);
            JsonObject testCases = gson.fromJson( testCasesJsonFileReader, JsonObject.class);

            try{
                idList = new ArrayList<Integer>();
                gameModel = new Game(3, 2);
                gameModel.setupBoardObjects();

                JsonArray twoPlayersTestCase = testCases.getAsJsonArray("3PlayersCase");
                for(JsonElement tileJsonElement : twoPlayersTestCase){
                    JsonObject tileJsonObject = tileJsonElement.getAsJsonObject();
                    int row = tileJsonObject.get("row").getAsInt();
                    int column = tileJsonObject.get("column").getAsInt();
                    boolean objectCard = tileJsonObject.get("objectCard").getAsBoolean();
                    int minPlayers = tileJsonObject.get("minPlayers").getAsInt();
                    int freeSidesCounter = tileJsonObject.get("freeSidesCounter").getAsInt();

                    if(objectCard == true){
                        assertNotNull(gameModel.getBoard().getTiles()[row][column].getObject());
                        if(idList.contains(gameModel.getBoard().getTiles()[row][column].getObject().getId()) == false){
                            idList.add(gameModel.getBoard().getTiles()[row][column].getObject().getId());
                        }
                        else{
                            fail();
                        }
                    }
                    else if(objectCard == false){
                        assertNull(gameModel.getBoard().getTiles()[row][column].getObject());
                    }
                    assertEquals(minPlayers, gameModel.getBoard().getTiles()[row][column].getMinPlayers());
                    assertEquals(freeSidesCounter, gameModel.getBoard().getTiles()[row][column].getFreeSides());
                    System.out.println("setupBoardObjectsWith3Players: passed test case with tile [" + row + "][" + column + "]");
                }
            } catch (PlayersNumberException | CommonGoalsNumberException e) {
                fail();
            }
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    @Test
    public void setupBoardObjectsWith4Players(){
        List<Integer> idList;
        Game gameModel;
        Gson gson = new Gson();
        File testCasesJsonFile = new File("src/test/resources/SetupBoardCases.json");
        try {
            FileReader testCasesJsonFileReader = new FileReader(testCasesJsonFile);
            JsonObject testCases = gson.fromJson( testCasesJsonFileReader, JsonObject.class);

            try{
                idList = new ArrayList<Integer>();
                gameModel = new Game(4, 2);
                gameModel.setupBoardObjects();

                JsonArray twoPlayersTestCase = testCases.getAsJsonArray("4PlayersCase");
                for(JsonElement tileJsonElement : twoPlayersTestCase){
                    JsonObject tileJsonObject = tileJsonElement.getAsJsonObject();
                    int row = tileJsonObject.get("row").getAsInt();
                    int column = tileJsonObject.get("column").getAsInt();
                    boolean objectCard = tileJsonObject.get("objectCard").getAsBoolean();
                    int minPlayers = tileJsonObject.get("minPlayers").getAsInt();
                    int freeSidesCounter = tileJsonObject.get("freeSidesCounter").getAsInt();

                    if(objectCard == true){
                        assertNotNull(gameModel.getBoard().getTiles()[row][column].getObject());
                        if(idList.contains(gameModel.getBoard().getTiles()[row][column].getObject().getId()) == false){
                            idList.add(gameModel.getBoard().getTiles()[row][column].getObject().getId());
                        }
                        else{
                            fail();
                        }
                    }
                    else if(objectCard == false){
                        assertNull(gameModel.getBoard().getTiles()[row][column].getObject());
                    }
                    assertEquals(minPlayers, gameModel.getBoard().getTiles()[row][column].getMinPlayers());
                    assertEquals(freeSidesCounter, gameModel.getBoard().getTiles()[row][column].getFreeSides());
                    System.out.println("setupBoardObjectsWith4Players: passed test case with tile [" + row + "][" + column + "]");
                }
            } catch (PlayersNumberException | CommonGoalsNumberException e) {
                fail();
            }
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    @Test
    public void setupPersonalGoalsWith2Players(){
        List<PersonalGoalCard> actualPersonalGoalCardList = new ArrayList<PersonalGoalCard>();
        List<PersonalGoalCard> expectedPersonalGoalCardList = new ArrayList<PersonalGoalCard>();
        PersonalGoalCard actualCard;
        PersonalGoalCard expectedCard;
        PersonalGoalCard newCard;

        for(int i = 1; i <= 12; i++){
            newCard = new PersonalGoalCard(i);
            expectedPersonalGoalCardList.add(i-1, newCard);
        }

        try{
            Game gameModel = new Game(2, 2);
            gameModel.setTable(new Player("Topolino", gameModel.getCommonGoalsNumber()), 0);
            gameModel.setTable(new Player("Pippo", gameModel.getCommonGoalsNumber()), 1);
            gameModel.setupPersonalGoals();
            actualPersonalGoalCardList.addAll(gameModel.getPersonalGoalsDeck());
            for(int i = 0; i < gameModel.getPlayersNumber(); i++){
                actualPersonalGoalCardList.add(gameModel.getTable()[i].getPersonalGoal());
            }

            for(int i = 0; i < gameModel.getPersonalGoalsDeck().size() + gameModel.getPlayersNumber(); i++){
                int j = 0;
                while(j < expectedPersonalGoalCardList.size() && j != -1){
                    actualCard = actualPersonalGoalCardList.get(0);
                    expectedCard = expectedPersonalGoalCardList.get(j);
                    if(actualCard.equals(expectedCard) == false){
                        j += 1;
                    }
                    else{
                        assertEquals(actualCard, expectedCard);
                        actualPersonalGoalCardList.remove(0);
                        expectedPersonalGoalCardList.remove(j);
                        j = -1;
                    }
                }
                if(j != -1){
                    fail();
                }
            }
            assertTrue(actualPersonalGoalCardList.isEmpty() == true);
            assertTrue(expectedPersonalGoalCardList.isEmpty() == true);
        } catch (FileNotFoundException | PlayersNumberException | CommonGoalsNumberException e) {
            fail();
        }
    }
    @Test
    public void setupPersonalGoalsWith3Players(){
        List<PersonalGoalCard> actualPersonalGoalCardList = new ArrayList<PersonalGoalCard>();
        List<PersonalGoalCard> expectedPersonalGoalCardList = new ArrayList<PersonalGoalCard>();
        PersonalGoalCard actualCard;
        PersonalGoalCard expectedCard;
        PersonalGoalCard newCard;

        for(int i = 1; i <= 12; i++){
            newCard = new PersonalGoalCard(i);
            expectedPersonalGoalCardList.add(i-1, newCard);
        }

        try{
            Game gameModel = new Game(3, 2);
            gameModel.setTable(new Player("Topolino", gameModel.getCommonGoalsNumber()), 0);
            gameModel.setTable(new Player("Pippo", gameModel.getCommonGoalsNumber()), 1);
            gameModel.setTable(new Player("Pluto", gameModel.getCommonGoalsNumber()), 2);
            gameModel.setupPersonalGoals();
            actualPersonalGoalCardList.addAll(gameModel.getPersonalGoalsDeck());
            for(int i = 0; i < gameModel.getPlayersNumber(); i++){
                actualPersonalGoalCardList.add(gameModel.getTable()[i].getPersonalGoal());
            }

            for(int i = 0; i < gameModel.getPersonalGoalsDeck().size() + gameModel.getPlayersNumber(); i++){
                int j = 0;
                while(j < expectedPersonalGoalCardList.size() && j != -1){
                    actualCard = actualPersonalGoalCardList.get(0);
                    expectedCard = expectedPersonalGoalCardList.get(j);
                    if(actualCard.equals(expectedCard) == false){
                        j += 1;
                    }
                    else{
                        assertEquals(actualCard, expectedCard);
                        actualPersonalGoalCardList.remove(0);
                        expectedPersonalGoalCardList.remove(j);
                        j = -1;
                    }
                }
                if(j != -1){
                    fail();
                }
            }
            assertTrue(actualPersonalGoalCardList.isEmpty() == true);
            assertTrue(expectedPersonalGoalCardList.isEmpty() == true);
        } catch (FileNotFoundException | PlayersNumberException | CommonGoalsNumberException e) {
            fail();
        }
    }
    @Test
    public void setupPersonalGoalsWith4Players(){
        List<PersonalGoalCard> actualPersonalGoalCardList = new ArrayList<PersonalGoalCard>();
        List<PersonalGoalCard> expectedPersonalGoalCardList = new ArrayList<PersonalGoalCard>();
        PersonalGoalCard actualCard;
        PersonalGoalCard expectedCard;
        PersonalGoalCard newCard;

        for(int i = 1; i <= 12; i++){
            newCard = new PersonalGoalCard(i);
            expectedPersonalGoalCardList.add(i-1, newCard);
        }

        try{
            Game gameModel = new Game(4, 2);
            gameModel.setTable(new Player("Topolino", gameModel.getCommonGoalsNumber()), 0);
            gameModel.setTable(new Player("Pippo", gameModel.getCommonGoalsNumber()), 1);
            gameModel.setTable(new Player("Pluto", gameModel.getCommonGoalsNumber()), 2);
            gameModel.setTable(new Player("Paperino", gameModel.getCommonGoalsNumber()), 3);
            gameModel.setupPersonalGoals();
            actualPersonalGoalCardList.addAll(gameModel.getPersonalGoalsDeck());
            for(int i = 0; i < gameModel.getPlayersNumber(); i++){
                actualPersonalGoalCardList.add(gameModel.getTable()[i].getPersonalGoal());
            }

            for(int i = 0; i < gameModel.getPersonalGoalsDeck().size() + gameModel.getPlayersNumber(); i++){
                int j = 0;
                while(j < expectedPersonalGoalCardList.size() && j != -1){
                    actualCard = actualPersonalGoalCardList.get(0);
                    expectedCard = expectedPersonalGoalCardList.get(j);
                    if(actualCard.equals(expectedCard) == false){
                        j += 1;
                    }
                    else{
                        assertEquals(actualCard, expectedCard);
                        actualPersonalGoalCardList.remove(0);
                        expectedPersonalGoalCardList.remove(j);
                        j = -1;
                    }
                }
                if(j != -1){
                    fail();
                }
            }
            assertTrue(actualPersonalGoalCardList.isEmpty() == true);
            assertTrue(expectedPersonalGoalCardList.isEmpty() == true);
        } catch (FileNotFoundException | PlayersNumberException | CommonGoalsNumberException e) {
            fail();
        }
    }
    @Test
    public void setupCommonGoalsWith1CommonGoals(){
        List<CommonGoalCard> actualCommonGoalCardList = new ArrayList<CommonGoalCard>();
        List<CommonGoalCard> expextedCommonGoalCardList = new ArrayList<CommonGoalCard>();

        try{
            Game gameModel = new Game(4, 1);

            expextedCommonGoalCardList.add(new CommonGoalCard1(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard2(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard3(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard4(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard5(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard6(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard7(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard8(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard9(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard10(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard11(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard12(gameModel.getPlayersNumber()));

            gameModel.setupCommonGoals();
            actualCommonGoalCardList.addAll(gameModel.getCommonGoalsDeck());
            for(int i = 0; i < gameModel.getBoard().getCommonGoals().length; i++){
                actualCommonGoalCardList.add(gameModel.getBoard().getCommonGoals()[i]);
            }

            for(int i = 0; i < gameModel.getCommonGoalsDeck().size() + gameModel.getCommonGoalsNumber(); i++){
                int j = 0;
                while(j < expextedCommonGoalCardList.size() && j != -1){
                    if(actualCommonGoalCardList.get(0).equals(expextedCommonGoalCardList.get(j)) != true){
                        j += 1;
                    }
                    else{
                        assertEquals(actualCommonGoalCardList.get(0), expextedCommonGoalCardList.get(j));
                        actualCommonGoalCardList.remove(0);
                        expextedCommonGoalCardList.remove(j);
                        j = -1;
                    }
                }
                if(j != -1){
                    fail();
                }
            }
            assertTrue(actualCommonGoalCardList.isEmpty() == true);
            assertTrue(expextedCommonGoalCardList.isEmpty() == true);
        } catch (FileNotFoundException | PlayersNumberException | CommonGoalsNumberException e) {
            fail();
        }
    }
    @Test
    public void setupCommonGoalsWith2CommonGoals(){
        List<CommonGoalCard> actualCommonGoalCardList = new ArrayList<CommonGoalCard>();
        List<CommonGoalCard> expextedCommonGoalCardList = new ArrayList<CommonGoalCard>();

        try{
            Game gameModel = new Game(4, 2);

            expextedCommonGoalCardList.add(new CommonGoalCard1(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard2(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard3(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard4(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard5(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard6(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard7(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard8(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard9(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard10(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard11(gameModel.getPlayersNumber()));
            expextedCommonGoalCardList.add(new CommonGoalCard12(gameModel.getPlayersNumber()));

            gameModel.setupCommonGoals();
            actualCommonGoalCardList.addAll(gameModel.getCommonGoalsDeck());
            for(int i = 0; i < gameModel.getBoard().getCommonGoals().length; i++){
                actualCommonGoalCardList.add(gameModel.getBoard().getCommonGoals()[i]);
            }

            for(int i = 0; i < gameModel.getCommonGoalsDeck().size() + gameModel.getCommonGoalsNumber(); i++){
                int j = 0;
                while(j < expextedCommonGoalCardList.size() && j != -1){
                    if(actualCommonGoalCardList.get(0).equals(expextedCommonGoalCardList.get(j)) != true){
                        j += 1;
                    }
                    else{
                        assertEquals(actualCommonGoalCardList.get(0), expextedCommonGoalCardList.get(j));
                        actualCommonGoalCardList.remove(0);
                        expextedCommonGoalCardList.remove(j);
                        j = -1;
                    }
                }
                if(j != -1){
                    fail();
                }
            }
            assertTrue(actualCommonGoalCardList.isEmpty() == true);
            assertTrue(expextedCommonGoalCardList.isEmpty() == true);
        } catch (FileNotFoundException | PlayersNumberException | CommonGoalsNumberException e) {
            fail();
        }
    }
    @Test
    public void nextTurnTest() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        Game game = new Game(4,1);
        Player player1 = new Player("1",1);
        player1.setPosition(1);
        Player player2 = new Player("2",1);
        player2.setPosition(2);
        Player player3 = new Player("3",1);
        player3.setPosition(3);
        Player player4 = new Player("4",1);
        player4.setPosition(4);
        game.setTable(player1,0);
        game.setTable(player2,1);
        game.setTable(player3,2);
        game.setTable(player4,3);
        game.setCurrentPlayer(1);
        game.nextTurn();
        assertEquals(2,game.getCurrentPlayer());
    }

    @Test
    public void updateCommonGoalsTest() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        Game game = new Game(4,1);
        Player player1 = new Player("1",1);
        player1.setPosition(1);
        Player player2 = new Player("2",1);
        player2.setPosition(2);
        Player player3 = new Player("3",1);
        player3.setPosition(3);
        Player player4 = new Player("4",1);
        player4.setPosition(4);
        game.setTable(player1,0);
        game.setTable(player2,1);
        game.setTable(player3,2);
        game.setTable(player4,3);
        game.setCurrentPlayer(1);
        List<PointCard> points = new ArrayList<>();
        points.add(new PointCard(Value.eight, RomanNumeral.II));
        points.add(new PointCard(Value.four, RomanNumeral.II));
        CommonGoalCard1 cm1 = new CommonGoalCard1(4);
        cm1.setPoints(points);
        game.setupCommonGoals();
        game.updateCommonGoals(cm1);
        assertEquals(8,game.getTable()[0].getPoints());
    }

    @Test
    public void repopulateBoardTest() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        Game game = new Game(4,1);
        LivingRoomBoard board = game.getBoard();
        Tile[][] tiles = board.getTiles();
        // Simulate each tile with 4 free sides to force board repopulation
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                if(game.getPlayersNumber() >= tiles[i][j].getMinPlayers()){
                    tiles[i][j].setFreeSides(4);
                }
            }
        }
        game.updateBoard();
        //Test 5 casual tiles to check if the board has been populated
        assertNotEquals(null,game.getBoard().getTiles()[1][3]);
        assertNotEquals(null,game.getBoard().getTiles()[2][3]);
        assertNotEquals(null,game.getBoard().getTiles()[3][4]);
        assertNotEquals(null,game.getBoard().getTiles()[4][1]);
        assertNotEquals(null,game.getBoard().getTiles()[5][5]);
        //Test if those 5 casual tiles have less than 4 free sides
        boolean freeSides1 = (game.getBoard().getTiles()[1][3].getFreeSides() == 4);
        assertFalse(freeSides1);
        boolean freeSides2 = (game.getBoard().getTiles()[2][3].getFreeSides() == 4);
        assertFalse(freeSides2);
        boolean freeSides3 = (game.getBoard().getTiles()[3][4].getFreeSides() == 4);
        assertFalse(freeSides3);
        boolean freeSides4 = (game.getBoard().getTiles()[4][1].getFreeSides() == 4);
        assertFalse(freeSides4);
        boolean freeSides5 = (game.getBoard().getTiles()[5][5].getFreeSides() == 4);
        assertFalse(freeSides5);

    }

    @Test
    public void insertInOrderTest() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        Game game = new Game(4,1);
        Player player1 = new Player("1",1);
        player1.setPosition(1);
        Player player2 = new Player("2",1);
        player2.setPosition(2);
        Player player3 = new Player("3",1);
        player3.setPosition(3);
        Player player4 = new Player("4",1);
        player4.setPosition(4);
        game.setTable(player1,0);
        game.setTable(player2,1);
        game.setTable(player3,2);
        game.setTable(player4,3);
        // Set player 2 as actual player
        game.setCurrentPlayer(2);
        //Set chosen column
        player2.setChosenColumn(2);
        //Set chosen objects
        ObjectCard[] choice = new ObjectCard[3];
        choice[0] = new ObjectCard(1,0,1);
        choice[1] = new ObjectCard(1,0,2);
        choice[2] = new ObjectCard(1,0,3);
        player2.setChosenObjects(choice);
        //Create order array to insert in order
        int[] order = new int[3];
        order[0] = 1;
        order[1] = 2;
        order[2] = 3;
        //Call insertInOrder method
        game.insertInOrder(order);
        //Check the tiles were inserted in order
        assertEquals(choice[0],player2.getBookshelf().getShelf()[5][2]);
        assertEquals(choice[1],player2.getBookshelf().getShelf()[4][2]);
        assertEquals(choice[2],player2.getBookshelf().getShelf()[3][2]);
    }

    @Test
    public void firstToFinishTest() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        //Assert the first player to finish has 1 extra point
        Game game = new Game(4,1);
        Player player1 = new Player("1",1);
        player1.setPosition(1);
        Player player2 = new Player("2",1);
        player2.setPosition(2);
        Player player3 = new Player("3",1);
        player3.setPosition(3);
        Player player4 = new Player("4",1);
        player4.setPosition(4);
        game.setTable(player1,0);
        game.setTable(player2,1);
        game.setTable(player3,2);
        game.setTable(player4,3);
        //Set player 1 as current player
        game.setCurrentPlayer(1);
        //Set player 1 bookshelf to be full
        player1.getBookshelf().setMaxDrawableObjects(0);
        //Set common goal of the game
        CommonGoalCard[] drawn = new CommonGoalCard[1];
        drawn[0] = new CommonGoalCard1(4);
        game.getBoard().setCommonGoals(drawn);
        //Set done to true and player 1 as first player
        game.setDone(true);
        player1.setIsFirst(true);
        //Call endTurnChecks method
        game.endTurnChecks();
        assertEquals(1,player1.getPoints());
    }

    @Test
    public void declareWinnerTest() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        //Assert the player with highest points wins
        Game game = new Game(4,1);
        Player player1 = new Player("1",1);
        player1.setPosition(1);
        player1.setPoints(2);
        Player player2 = new Player("2",1);
        player2.setPosition(2);
        player2.setPoints(8);
        Player player3 = new Player("3",1);
        player3.setPosition(3);
        player3.setPoints(10);
        Player player4 = new Player("4",1);
        player4.setPosition(4);
        player4.setPoints(3);
        game.setTable(player1,0);
        game.setTable(player2,1);
        game.setTable(player3,2);
        game.setTable(player4,3);
        //Call declareWinner method
        game.DeclareWinner();
        assertEquals(player3,game.getLeaderboard()[0]);
        assertEquals(player2,game.getLeaderboard()[1]);
        assertEquals(player4,game.getLeaderboard()[2]);
        assertEquals(player1,game.getLeaderboard()[3]);
    }

    @Test
    public void declareWinnerEqualPointsTest() throws FileNotFoundException, PlayersNumberException, CommonGoalsNumberException {
        //Assert the player with highest points wins
        //Assert if equal points between two player let the player far from the first get the best placement
        Game game = new Game(4,1);
        Player player1 = new Player("1",1);
        player1.setPosition(1);
        player1.setPoints(8);
        Player player2 = new Player("2",1);
        player2.setPosition(2);
        player2.setPoints(8);
        Player player3 = new Player("3",1);
        player3.setPosition(3);
        player3.setPoints(10);
        Player player4 = new Player("4",1);
        player4.setPosition(4);
        player4.setPoints(2);
        game.setTable(player1,0);
        game.setTable(player2,1);
        game.setTable(player3,2);
        game.setTable(player4,3);
        //Call declareWinner method
        game.DeclareWinner();
        assertEquals(player3,game.getLeaderboard()[0]);
        assertEquals(player1,game.getLeaderboard()[1]);
        assertEquals(player2,game.getLeaderboard()[2]);
        assertEquals(player4,game.getLeaderboard()[3]);
    }
}