package it.polimi.model;

public class ObjectCard {
    protected int id;
    protected String type;
    protected int xCoordinate;
    protected int yCoordinate;

    protected ObjectCard(int id, int xCoordinate, int yCoordinate) {
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

        if (id < 5) {
            this.type = "Cats";
        }else if (5 < id && id < 10) {
            this.type = "Trophies";
        }else if (10 < id && id < 15) {
            this.type = "Plants";
        }else if (15 < id && id < 20) {
            this.type = "Books";
        }else if (20 < id && id < 25) {
            this.type = "Frames";
        }else if (25 < id && id < 30) {
            this.type = "Games";
        }
    };

    public String getType() {
        return type;
    };

    public int getXCoordinate() {
        return xCoordinate;
    };

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    };

    public int getYCoordinate() {
        return yCoordinate;
    };

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    };
}