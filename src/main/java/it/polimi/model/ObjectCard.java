package it.polimi.model;

import java.io.Serializable;

public class ObjectCard implements Serializable {
    static final long serialVersionUID = 1L;
    private int id;
    private Type type;
    private int xCoordinate;
    private int yCoordinate;

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

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
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