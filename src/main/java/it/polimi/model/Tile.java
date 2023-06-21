package it.polimi.model;

import java.io.Serializable;

public class Tile implements Serializable {
    static final long serialVersionUID = 1L;
    private int minPlayers;
    private int freeSides;
    private ObjectCard object;

    protected Tile (int minPlayers) {
        this.minPlayers = minPlayers;
        freeSides = 0;
        object = null;
    };

    public int getMinPlayers(){
        return minPlayers;
    };

    public int getFreeSides(){
        return freeSides;
    };

    public void setFreeSides(int freeSides) {
        this.freeSides = freeSides;
    };

    public ObjectCard getObject() {
        return object;
    };

    protected void setObject(ObjectCard object) {
        this.object = object;
    };
}