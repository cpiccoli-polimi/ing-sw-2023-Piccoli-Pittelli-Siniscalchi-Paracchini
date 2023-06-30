package it.polimi.model;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * LivingRoomBoard class represents the living room board
 * on which the game is played
 *
 * @see java.io.Serializable
 * @author Lorenzo Pittelli
 * @author Lorenzo Paracchini
 * @author Nicola Siniscalchi
 */
public class LivingRoomBoard implements Serializable {
    static final long serialVersionUID = 1L;
    private CommonGoalCard[] commonGoals;
    private Tile[][] tile;

    /**
     * Creates the LivingRoomBoard retrieving its
     * attributes from a json file
     *
     * @param commonGoalsNumber the number of common goals used
     *                          in this game
     * @throws FileNotFoundException if the json containing the description
     *                               of the LivingRoomBoard is not found
     */
    protected LivingRoomBoard(int commonGoalsNumber) throws FileNotFoundException {
        this.tile = new Tile[9][9];

        try {
            InputStream stream = PersonalGoalCard.class.getResourceAsStream("/jsonFiles/Tiles.json");
            JsonReader jsonReader = new JsonReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
            JsonElement obj = JsonParser.parseReader(jsonReader);
            JsonArray jsonArray = obj.getAsJsonArray();
            for(JsonElement tileJsonElement : jsonArray){
                JsonObject tileJsonObject = tileJsonElement.getAsJsonObject();
                int row = tileJsonObject.get("row").getAsInt();
                int column = tileJsonObject.get("column").getAsInt();
                int minPlayers = tileJsonObject.get("minPlayers").getAsInt();

                this.tile[row][column] = new Tile(minPlayers);
            }
        }
        catch(NullPointerException e){
            throw e;
        }

        commonGoals = new CommonGoalCard[commonGoalsNumber];
    }
    /**
     * @return the array containing the commonGoals
     */
    public CommonGoalCard[] getCommonGoals() {
        return commonGoals;
    }
    /**
     * Sets the common goals in the order casually chosen
     * and copied into the argument array
     *
     * @param drawnCommonGoals
     */
    public void setCommonGoals(CommonGoalCard[] drawnCommonGoals) {
        System.arraycopy(drawnCommonGoals, 0, this.commonGoals, 0, drawnCommonGoals.length);
    }
    /**
     * @return the 2D array containing the tiles
     */
    public Tile[][] getTiles() {
        return tile;
    }
    /**
     * Places the chosen object card in the chosen
     * x and y coordinates
     *
     * @param object chosen ObjectCard
     * @param xCoordinate chosen x coordinate
     * @param yCoordinate chosen y coordinate
     */
    public void placeObject(ObjectCard object, int xCoordinate, int yCoordinate) {
        tile[xCoordinate][yCoordinate].setObject(object);
    }
    /**
     * Removes the objectCard contained in the
     * selected x and y coordinates
     *
     * @param xCoordinate
     * @param yCoordinate
     */
    public ObjectCard removeObject(int xCoordinate, int yCoordinate) {
        ObjectCard object = tile[xCoordinate][yCoordinate].getObject();
        tile[xCoordinate][yCoordinate].setObject(null);

        return object;
    }
    /**
     * Shows the LivingRoomBoard on the CLI
     *
     * @param playersNumber players in the game
     */
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

    /**
     * Used when an ObjectCard is picked from the
     * LivingRoomBoard updating the "freeSides"
     * attribute of the tiles around the picked one
     *
     * @param pickedObject
     */
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

