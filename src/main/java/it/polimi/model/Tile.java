package it.polimi.model;

import java.io.Serializable;

/**
 * Tile's class represents the tiles: each square
 * in the LivingRoomBoard that may have on top (contain)
 * an ObjectCard
 *
 * @see java.io.Serializable
 * @author Lorenzo Paracchini
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
     * @return the minimum number of player
     *         required to use that tile
     */
    public int getMinPlayers(){
        return minPlayers;
    }
    /**
     * @return how many free sides does
     *         that tile have
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
     * @return the ObjectCard placed
     *         on that tile
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