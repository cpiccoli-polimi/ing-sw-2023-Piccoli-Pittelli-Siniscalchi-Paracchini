package it.polimi.model;
public class Bookshelf {

    private int maxDrawableObjects;
    private ObjectCard [][] shelf;
    protected Bookshelf{
        this.maxDrawableObjects=3;
        this.shelf= new ObjectCard[5][6];
    }
    public void setMaxDrawableObjects(int maxDrawableObjects) {this.maxDrawableObjects = maxDrawableObjects;}
    public int getMaxDrawableObjects(){return maxDrawableObjects;}
    public ObjectCard[][] getShelf(){return shelf;}
    public boolean isFull(){
        return maxDrawableObjects == 0;
    }


}
