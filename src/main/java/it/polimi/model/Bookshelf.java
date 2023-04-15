package it.polimi.model;
public class Bookshelf {

    private int maxDrawableObjects;
    protected ObjectCard [][] shelf;
    protected Bookshelf(){
        this.maxDrawableObjects=3;
        this.shelf= new ObjectCard[6][5];
        for(int i=0;i<shelf.length;i++){
            for(int j=0;j<shelf[0].length;j++){
                shelf[i][j]=null;
            }
        }
    }
    public void setMaxDrawableObjects(int maxDrawableObjects) {this.maxDrawableObjects = maxDrawableObjects;}
    public int getMaxDrawableObjects(){return maxDrawableObjects;}
    public ObjectCard[][] getShelf(){return shelf;}
    public void setShelf(ObjectCard card){
        shelf[card.getXCoordinate()][card.getYCoordinate()]=card;
    }
    public boolean isFull(){
        return maxDrawableObjects == 0;
    }


}
