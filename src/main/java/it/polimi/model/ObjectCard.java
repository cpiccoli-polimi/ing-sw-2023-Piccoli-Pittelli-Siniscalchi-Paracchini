package it.polimi.model;

public class ObjectCard {
    private int id;
    private Type type;
    private int xCoordinate;
    private int yCoordinate;

    protected objectCard(int id, int xCoordinate, int yCoordinate) {
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

        if (id < 5) {
            this.type = "Cats";
        }if else (5 < id < 10) {
            this.type = "Trophies";
        }if else (10 < id < 15) {
            this.type = "Plants";
        }if else (15 < id < 20) {
            this.type = "Books";
        }if else (20 < id < 25) {
            this.type = "Frames";
        }if else (25 < id < 30) {
            this.type = "Games";
        }
    };

    public Type getType() {
        return type;
    };

    public void getXCoordinate() {
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