package it.polimi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bookshelf implements Serializable {
    static final long serialVersionUID = 1L;
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
        if(!(object instanceof Bookshelf)){
            return false;
        }
        Bookshelf bookshelf = (Bookshelf) object;

        for(int i = 0; i < shelf.length && result; i++){
            for(int j = 0; j < shelf[i].length && result; j++){
                if(shelf[i][j] != null && bookshelf.getShelf()[i][j] != null){
                    result = shelf[i][j].equals(bookshelf.getShelf()[i][j]);
                }
                else result = shelf[i][j] == null && bookshelf.getShelf()[i][j] == null;
            }
        }
        return result;
    }
    public void setShelf(ObjectCard card,int column){
        int i=0;
        for(i=0; i< shelf.length;i++){
            if(shelf[i][column]!=null){
                break;
            }
        }
        shelf[i-1][column]=card;
    }

    public String showBookshelf(int row){
        String returnString = "";
        char squareCharacter = 9632;
        ObjectCard[][] shelf = this.getShelf();

        for(int j = 0; j < shelf[row].length; j++){
            returnString = returnString.concat("|");
            if(shelf[row][j] == null){
                returnString =  returnString.concat(" ");
            }
            else{
                returnString = returnString.concat(shelf[row][j].getType().getColor());
                returnString = returnString.concat( squareCharacter + Type.RESET);
            }
        }
        returnString = returnString.concat("|");
        return returnString;
    }
    public void updateMaxDrawableObjects(){
        int maxDrawableObjects=this.getMaxDrawableObjects();
        int i=0;
        int max;
        List<Integer> list = new ArrayList<>();
        for(int c=0;c<shelf[0].length;c++){
            for(int r=0;r<shelf.length;r++){
                if(shelf[r][c]==null){
                    i=r+1;
                }
            }
            list.add(i);
            i=0;
        }
        max=list.stream().max(Comparator.comparing(a->a)).get();
        if(max<maxDrawableObjects){
            setMaxDrawableObjects(max);
        }
    }

}
