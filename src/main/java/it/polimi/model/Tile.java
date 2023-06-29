package it.polimi.model;

import java.io.Serializable;

/**
 * Tile's class represents the tiles: each square
 * in the LivingRoomBoard that may have on top (contain)
 * an ObjectCard
 *
 * @see java.io.Serializable
 */
public class Tile implements Serializable {
    static final long serialVersionUID = 1L;
    private int minPlayers;
    private int freeSides;
    private ObjectCard object;

    /**
     * Creates the Tile and sets default attributes
     *
     * @param minPlayers with how many players playing the
     *                   game can be used this specific tile
     */
    protected Tile (int minPlayers) {
        this.minPlayers = minPlayers;
        freeSides = 0;
        object = null;
    }
    /**
     * Returns the minimum number of player
     * required to use that tile
     *
     * @return minPlayers
     */
    public int getMinPlayers(){
        return minPlayers;
    }
    /**
     * Returns how many free sides does
     * that tile have
     *
     * @return freeSides
     */
    public int getFreeSides(){
        return freeSides;
    }
    /**
     * Sets how many free sides does
     * that tile have
     *
     * @param freeSides
     */
    public void setFreeSides(int freeSides) {
        this.freeSides = freeSides;
    }
    /**
     * Returns the ObjectCard placed
     * on that tile
     *
     * @return object
     */
    public ObjectCard getObject() {
        return object;
    }
    /**
     * "Places" the ObjectCard passed
     * as parameter on this tile
     *
     * @param object
     */
    protected void setObject(ObjectCard object) {
        this.object = object;
    }
}