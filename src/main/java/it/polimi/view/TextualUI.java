package it.polimi.view;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.polimi.model.*;
import it.polimi.util.Observable;

public class TextualUI extends Observable<TextualUI.Event> implements Runnable {
    public enum Event{
        NICKNAME,
        GAME_PARAMETERS,
        OBJECT_CARDS_CHOICE, //(board, tutte le librerie, i common goal, e il proprio personal goal)
        COLUMN_CHOICE,
        INSERTION_ORDER_CHOICE,
        END_GAME
    }

    private int playersNumber;
    private int commonGoalsNumber;
    private String nickname;
    private List<Integer[]> objectCardsChoice;
    private int columnChoice;
    private List<Integer> insertionOrderChoice;

    public TextualUI(){
        this.objectCardsChoice = new ArrayList<Integer[]>();
        this.insertionOrderChoice = new ArrayList<Integer>();
    }
    public int getPlayersNumber() {
        return playersNumber;
    }

    public void setPlayersNumber(int playersNumber) {
        this.playersNumber = playersNumber;
    }

    public int getCommonGoalsNumber() {
        return commonGoalsNumber;
    }

    public void setCommonGoalsNumber(int commonGoalsNumber) {
        this.commonGoalsNumber = commonGoalsNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Integer[]> getObjectCardsChoice() {
        return objectCardsChoice;
    }

    public void setObjectCardsChoice(Integer[] objectCardCoordinates) {
        this.objectCardsChoice.add(objectCardCoordinates);
    }

    public int getColumnChoice() {
        return columnChoice;
    }
    public void setColumnChoice(int columnChoice) {
        this.columnChoice = columnChoice;
    }

    public List<Integer> getInsertionOrderChoice() {
        return insertionOrderChoice;
    }

    public void setInsertionOrderChoice(Integer insertionOrderChoice) {
        this.insertionOrderChoice.add(insertionOrderChoice);
    }
    public void showBookshelf(Bookshelf bookshelf){
        char squareCharacter = 9632;
        ObjectCard[][] shelf = bookshelf.getShelf();

        for(int i = 0; i < shelf.length; i++){
            for(int j = 0; j < shelf[i].length; j++){
                System.out.print("|");
                if(shelf[i][j] == null){
                    System.out.print(" ");
                }
                else{
                    System.out.print(shelf[i][j].getType().getColor() + squareCharacter + Type.RESET);
                }
            }
            System.out.println("|");
        }
    }
    public void showPlayer(Player player){
        String nickname = player.getNickname();

        System.out.println(nickname + "'s bookshelf");
        showBookshelf(player.getBookshelf());
    }
    public void showBoard(LivingRoomBoard board, int playersNumber){
        char squareCharacter = 9632;
        Tile[][] tiles = board.getTiles();

        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                if(tiles[i][j].getMinPlayers() != 9999){
                    int k = j;
                    k += 1;
                    System.out.print("|");
                    if(playersNumber >= tiles[i][j].getMinPlayers()){
                        if(tiles[i][j].getObject() == null){
                            System.out.print(" ");
                        }
                        else{
                            System.out.print(tiles[i][j].getObject().getType().getColor() + squareCharacter + Type.RESET);
                        }
                    }
                    else{
                        System.out.print(tiles[i][j].getMinPlayers());
                    }
                    if(k <= tiles[i].length - 1){
                        if(tiles[i][k].getMinPlayers() == 9999){
                            System.out.print("|");
                        }
                    }
                    else{
                        System.out.print("|");
                    }
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    void showCommonGoal(int id){
        // Read file from JSON file and copy it into Personal Goal Card
        InputStream stream = TextualUI.class.getResourceAsStream("/CommonGoals.json");
        if (stream == null) throw new NullPointerException();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
        JsonElement obj = JsonParser.parseReader(jsonReader);
        JsonObject jsonObject = obj.getAsJsonObject();
        //Convert id to String to search for it into JSON
        String idString = Integer.toString(id);
        JsonArray jsonArray = jsonObject.get(idString).getAsJsonArray();
        for(JsonElement jsonElement : jsonArray) {
            JsonObject jObject = jsonElement.getAsJsonObject();
            // Retrieve attribute
            String goal = jObject.get("Goal").getAsString();
            System.out.println("Common Goal ID: "+id);
            System.out.println("Goal: " + goal);
        }
    }
    public static void showLeaderboard(Player[] leaderboard){
        for(int i=1; i<=leaderboard.length;i++){
            System.out.println("Position " + i + ": " + leaderboard[i-1]);
        }
    }
    public void askGameParameters(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("How many players will play? (2 to 4):");
        String numberOfPlayersString = userInput.nextLine();
        setPlayersNumber(Integer.parseInt(numberOfPlayersString));
        System.out.println("How many common goals cards to use? (1 or 2):");
        String commonGoalsNumberString = userInput.nextLine();
        setCommonGoalsNumber(Integer.parseInt(commonGoalsNumberString));
        //TODO: Exceptions
    }
    public void askNickname(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter your nickname:");
        setNickname(userInput.nextLine());
    }
    ObjectCard[] askObjectCard() {
        Scanner userInput = new Scanner(System.in);
        Integer[] objectCardCoordinates = new Integer[3];
        System.out.println("Which tiles do you choose to include in the bookshelf? (1 to 81):");
        for (int i = 0; i < 3; i++) {
            String position = userInput.nextLine();
            objectCardCoordinates[i] = Integer.parseInt(position);
        }
        setObjectCardsChoice(objectCardCoordinates);
    }
    int askColumn() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Choose the column of the bookshelf in which to place the tiles (1 to 5):");
        String column = userInput.nextLine();
        setColumnChoice(Integer.parseInt(column));
        return columnChoice;
    }
    ObjectCard[] askCardsOrder() {
        Scanner userInput = new Scanner(System.in);
        // completare
    }
    public void update(GameView model, Game.Event arg){
        switch(arg){

        }
    }
    @Override
    public void run() {

    }
    private void setChangedAndNotifyObservers(TextualUI.Event arg) {
        setChanged();
        notifyObservers(arg);
    }
}
