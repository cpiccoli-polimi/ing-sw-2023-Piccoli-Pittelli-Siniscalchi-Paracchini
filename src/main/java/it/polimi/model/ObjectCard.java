package it.polimi.model;

import java.io.Serializable;

/**
 * ObjectCard class represents the cards
 * placed in the tiles on the LivingRoomBoard
 *
 * @see java.io.Serializable
 */
public class ObjectCard implements Serializable {
    static final long serialVersionUID = 1L;
    private int id;
    private Type type;
    private int xCoordinate;
    private int yCoordinate;

    /**
     * Creates the ObjectCard setting the type based on its id
     *
     * @param id the identifier of the card (defines the type)
     * @param xCoordinate its x coordinate
     * @param yCoordinate its y coordinate
     */
    protected ObjectCard(int id, int xCoordinate, int yCoordinate) {
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

        if (id>=1 && id<= 22) {
            this.type = Type.Cats;
        }else if (id >= 23 && id <=45) {
            this.type = Type.Trophies;
        }else if (id >= 46 && id <= 67) {
            this.type = Type.Plants;
        }else if (id >= 68 && id <= 89) {
            this.type = Type.Books;
        }else if (id >= 90 && id <= 111) {
            this.type = Type.Frames;
        }else if (id >= 112 && id <= 132) {
            this.type = Type.Games;
        }
    }

    /**
     * Returns the id of the card
     *
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * Returns the type of the card
     *
     * @return type
     */
    public Type getType() {
        return type;
    }
    /**
     * Returns the x coordinate of the card
     *
     * @return xCoordinate
     */
    public int getXCoordinate() {
        return xCoordinate;
    }
    /**
     * Returns the y coordinate of the card
     *
     * @return yCoordinate
     */
    public int getYCoordinate() {
        return yCoordinate;
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof ObjectCard)){
            return false;
        }
        ObjectCard objectCard = (ObjectCard) object;
        return(this.id == objectCard.getId() && this.type == objectCard.getType() && this.xCoordinate == objectCard.getXCoordinate() && this.yCoordinate == objectCard.getYCoordinate());
    }
}