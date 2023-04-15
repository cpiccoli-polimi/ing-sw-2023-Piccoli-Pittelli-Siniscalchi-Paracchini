package it.polimi.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class LivingRoomBoard {
    private CommonGoalCard[] commonGoals;
    private Tile[][] tile;

    protected LivingRoomBoard(int commonGoalsNumber) {
        this.tile = new Tile[9][9];

        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[0].length; j++) {
            
            }   
        }

        commonGoals = CommonGoalCard(CommonGoalsNumber);
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