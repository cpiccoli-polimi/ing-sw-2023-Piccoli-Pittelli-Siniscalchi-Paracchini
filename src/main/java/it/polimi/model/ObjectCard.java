package it.polimi.model;

public class ObjectCard {
    private int id;
    private Type type;
    private int xCoordinate;
    private int yCoordinate;

    protected ObjectCard(int id, int xCoordinate, int yCoordinate) {
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

        if (id < 5) {
            this.type = Type.Cats;
        }else if (5 < id && id < 10) {
            this.type = Type.Trophies;
        }else if (10 < id && id < 15) {
            this.type = Type.Plants;
        }else if (15 < id && id < 20) {
            this.type = Type.Books;
        }else if (20 < id && id < 25) {
            this.type = Type.Frames;
        }else if (25 < id && id < 30) {
            this.type = Type.Games;
        }
    };

    public Type getType() {
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