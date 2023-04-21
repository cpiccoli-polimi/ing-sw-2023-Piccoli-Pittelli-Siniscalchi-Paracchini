package it.polimi.model;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LivingRoomBoard {
    private CommonGoalCard[] commonGoals;
    private Tile[][] tile;

    protected LivingRoomBoard(int commonGoalsNumber) throws FileNotFoundException {
        this.tile = new Tile[9][9];

        Gson gson = new Gson();
        File tilesJsonFile = new File("src/main/resources/Tiles.json");
        try {
            FileReader tilesJsonFileReader = new FileReader(tilesJsonFile);
            JsonArray tiles = gson.fromJson( tilesJsonFileReader, JsonArray.class);
            for(JsonElement tileJsonElement:tiles){
                JsonObject tileJsonObject = tileJsonElement.getAsJsonObject();
                int row = tileJsonObject.get("row").getAsInt();
                int column = tileJsonObject.get("column").getAsInt();
                int minPlayers = tileJsonObject.get("minPlayers").getAsInt();

                this.tile[row][column] = new Tile(minPlayers);
            }

        } catch (FileNotFoundException e) {
            throw e;
        }

        commonGoals = new CommonGoalCard[commonGoalsNumber];
    };

    public CommonGoalCard[] getCommonGoals() {
        return commonGoals;
    };

    public void setCommonGoals(CommonGoalCard[] commonGoals) {
        this.commonGoals = commonGoals;
    };

    public Tile[][] getTiles() {
        return tile;
    };

    public void placeObject(ObjectCard object, int xCoordinate, int yCoordinate) {
        tile[xCoordinate][yCoordinate].setObject(object);
    };

    public ObjectCard removeObject(int xCoordinate, int yCoordinate) {
        ObjectCard object = tile[xCoordinate][yCoordinate].getObject();
        tile[xCoordinate][yCoordinate] = null;

        return object;
    };
}