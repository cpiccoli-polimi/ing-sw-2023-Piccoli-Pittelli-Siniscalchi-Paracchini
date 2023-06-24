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
}