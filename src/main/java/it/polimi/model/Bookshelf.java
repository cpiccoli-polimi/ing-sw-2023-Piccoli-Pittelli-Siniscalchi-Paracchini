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

    @Override
    public boolean equals(Object object) {
        boolean result = true;
        if((object instanceof Bookshelf) == false){
            System.out.println("le due bookshelf confrontate non sono della stessa classe");
            return false;
        }
        Bookshelf bookshelf = (Bookshelf) object;

        for(int i = 0; i < shelf.length && result == true; i++){
            for(int j = 0; j < shelf[i].length && result == true; j++){
                if(shelf[i][j] != null && bookshelf.getShelf()[i][j] != null){
                    if(shelf[i][j].equals(bookshelf.getShelf()[i][j])){
                        result = true;
                    }
                    else{
                        result = false;
                    }
                }
                else if(shelf[i][j] == null && bookshelf.getShelf()[i][j] == null){
                    result = true;
                }
                else{
                    result = false;
                }
            }
        }
        return result;
    }
}
