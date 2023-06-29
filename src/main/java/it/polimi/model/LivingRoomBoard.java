package it.polimi.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;

public class LivingRoomBoard implements Serializable {
    static final long serialVersionUID = 1L;
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
    }

    public CommonGoalCard[] getCommonGoals() {
        return commonGoals;
    }

    public void setCommonGoals(CommonGoalCard[] drawnCommonGoals) {
        System.arraycopy(drawnCommonGoals, 0, this.commonGoals, 0, drawnCommonGoals.length);
    }

    public Tile[][] getTiles() {
        return tile;
    }

    public void placeObject(ObjectCard object, int xCoordinate, int yCoordinate) {
        tile[xCoordinate][yCoordinate].setObject(object);
    }

    public ObjectCard removeObject(int xCoordinate, int yCoordinate) {
        ObjectCard object = tile[xCoordinate][yCoordinate].getObject();
        tile[xCoordinate][yCoordinate].setObject(null);

        return object;
    }

    public void showBoard( int playersNumber){
        char squareCharacter = 9632;
        Tile[][] tiles = this.getTiles();

        System.out.print("  ");
        for(int i = 1; i < tiles[0].length+1; i++){
            System.out.print("\u001B[31m" + " " + i + "\u001B[0m");
        }
        System.out.println();
        for(int i = 0; i < tiles.length; i++){
            int h = i;
            h += 1;
            System.out.print("\u001B[31m" + h + " " + "\u001B[0m");
            for(int j = 0; j < tiles[i].length; j++){
                if(tiles[i][j]==null){System.out.print(" ");}
                if(tiles[i][j].getMinPlayers() != 9999){
                    int k = j;
                    k += 1;
                    System.out.print("|");
                    if(playersNumber >= tiles[i][j].getMinPlayers()){
                        if(tiles[i][j].getObject() == null){
                            System.out.print(" ");
                        }
                        else{
                            if(tiles[i][j].getObject().getType()==null){ System.out.print("p");}
                            else{
                                if(tiles[i][j].getObject().getType().getColor()==null){System.out.print("l");}
                                else System.out.print(tiles[i][j].getObject().getType().getColor() + squareCharacter + Type.RESET);
                            }}
                    }
                    else{
                        System.out.print(tiles[i][j].getMinPlayers());
                    }
                    if(k <= tiles[i].length - 1){
                        if(tile[i][k]==null || tiles[i][k].getMinPlayers() == 9999){
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

    public void updateFreeSides(ObjectCard [] pickedObject){
        int x, y, fs;
        Tile tile;
        for (ObjectCard objectCard : pickedObject) {
            x = objectCard.getXCoordinate();
            y = objectCard.getYCoordinate();
            tile=getTiles()[x][y];
            tile.setFreeSides(4);
            if (x > 0) {
                tile = getTiles()[x - 1][y]; //up
                if (tile != null) {
                    fs = tile.getFreeSides();
                    tile.setFreeSides(fs + 1);
                }
            }
            if (x < this.tile.length-1) {
                tile = getTiles()[x + 1][y]; //down
                if (tile != null) {
                    fs = tile.getFreeSides();
                    tile.setFreeSides(fs + 1);
                }
            }
            if (y > 0) {
                tile = getTiles()[x][y - 1]; //left
                if (tile != null) {
                    fs = tile.getFreeSides();
                    tile.setFreeSides(fs + 1);
                }
            }
            if (y < this.tile[0].length-1) {
                tile = getTiles()[x][y + 1]; //right
                if (tile != null) {
                    fs = tile.getFreeSides();
                    tile.setFreeSides(fs + 1);
                }
            }
        }
    }
}

