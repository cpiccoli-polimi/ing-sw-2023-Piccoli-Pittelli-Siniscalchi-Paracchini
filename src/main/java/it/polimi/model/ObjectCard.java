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

        if (id < 23) {
            this.type = Type.Cats;
        }else if (23 >= id && id < 45) {
            this.type = Type.Trophies;
        }else if (45 >= id && id < 67) {
            this.type = Type.Plants;
        }else if (67 >= id && id < 89) {
            this.type = Type.Books;
        }else if (89 >= id && id < 101) {
            this.type = Type.Frames;
        }else if (101 >= id && id < 123) {
            this.type = Type.Games;
        }
    };

    public int getId() {
        return id;
    }

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