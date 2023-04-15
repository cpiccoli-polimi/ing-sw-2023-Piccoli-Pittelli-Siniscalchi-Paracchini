package it.polimi.model;

import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class PersonalGoalCard extends GoalCard{
    private static Bookshelf goal;
    private static Map<Integer,Integer> points;
    public PersonalGoalCard(int id) {

        // Read file from JSON file and copy it into Personal Goal Card
        InputStream stream = PersonalGoalCard.class.getResourceAsStream("/PersonalGoalCards.json");
        if (stream == null) throw new NullPointerException();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
        JsonElement obj = JsonParser.parseReader(jsonReader);
        JsonObject jsonObject = obj.getAsJsonObject();
        //Convert id to String to search for it into JSON
        String idString = Integer.toString(id);
        JsonArray jsonArray = jsonObject.get(idString).getAsJsonArray();
        // Create Bookshelf
        Bookshelf goal = new Bookshelf();
        for(JsonElement jsonElement : jsonArray){
            JsonObject jObject = jsonElement.getAsJsonObject();
            // Retrieve attributes
            int xCoordinate = jObject.get("xCoordinate").getAsInt();
            int yCoordinate = jObject.get("yCoordinate").getAsInt();
            String objectType = jObject.get("objectType").getAsString();

            int cardId;
            switch (objectType){
                case("Cats"):
                    cardId = 0;
                case("Trophies"):
                    cardId = 23;
                case("Plants"):
                    cardId = 45;
                case("Books"):
                    cardId = 67;
                case("Frames"):
                    cardId = 89;
                case("Games"):
                    cardId = 101;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + objectType);
            }
            // Create a new ObjectCard
            ObjectCard newCard = new ObjectCard(cardId, xCoordinate, yCoordinate);
            // Copy them into card
            goal.setShelf(newCard);
        }

        // Initialize Map
        // TODO: Check if correct
        points =  Map.ofEntries(
                Map.entry(1, 1),
                Map.entry(2, 2),
                Map.entry(3, 4),
                Map.entry(5, 9),
                Map.entry(6, 12)
        );
    };
    public Bookshelf getGoal(){
        return goal;
    }

}

