package it.polimi.view;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import it.polimi.model.*;

public class TextualUI {
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
    int[] askGameParameters(){
        Scanner userInput = new Scanner(System.in);
        int[] parameters = new int[2];
        System.out.println("How many players will play? (2 to 4):");
        String numberOfPlayers = userInput.nextLine();
        parameters[0] = Integer.parseInt(numberOfPlayers);
        System.out.println("How many common goals cards to use? (1 or 2):");
        String commonGoalsNumber = userInput.nextLine();
        parameters[1] = Integer.parseInt(commonGoalsNumber);
        return parameters;
        //TODO: Exceptions
    }
    String askNickname(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter your nickname:");
        return userInput.nextLine();
    }
}
