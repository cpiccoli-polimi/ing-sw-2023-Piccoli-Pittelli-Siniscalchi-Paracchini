package it.polimi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The bookshelf class represents personal bookshelf of each player
 *
 * @author Christian Piccoli
 * @author Lorenzo Pittelli
 * @author Nicola Siniscalchi
 */
public class Bookshelf implements Serializable {
    static final long serialVersionUID = 1L;
    private int maxDrawableObjects;
    protected ObjectCard [][] shelf;
    /**
     * Builds the bookshelf setting its parameters and
     * initializing it all with all the tiles set to null
     */
    protected Bookshelf(){
        this.maxDrawableObjects=3;
        this.shelf= new ObjectCard[6][5];
        for(int i=0;i<shelf.length;i++){
            for(int j=0;j<shelf[0].length;j++){
                shelf[i][j]=null;
            }
        }
    }
    /**
     * Sets the max amount of drawable objects from the bookshelf
     *
     * @param maxDrawableObjects the amount of objects that can be picked up
     *                           from the LivingRoomBoard
     */
    public void setMaxDrawableObjects(int maxDrawableObjects) {this.maxDrawableObjects = maxDrawableObjects;}
    /**
     * @return the amount of objects that can be picked up
     *         from the LivingRoomBoard
     */
    public int getMaxDrawableObjects(){return maxDrawableObjects;}
    /**
     * @return the array containing all the tiles
     */
    public ObjectCard[][] getShelf(){return shelf;}
    /**
     * Sets the card passed as parameter in the bookshelf in its
     * correct position (when picked up from LivingRoomBoard)
     *
     * @param card the card picked
     */
    public void setShelf(ObjectCard card){
        shelf[card.getXCoordinate()][card.getYCoordinate()]=card;
    }
    /**
     * Checks if maxDrawableObjects equals 0, meaning there are no
     * empty spots in the bookshelf
     *
     * @return true if the bookshelf is full, else false
     */
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
    /**
     * Places the card picked from the LivingRoomBoard in the
     * chosen column in the Bookshelf
     *
     * @param card the picked card
     * @param column the chosen column
     */
    public void setShelf(ObjectCard card,int column){
        int i;
        for(i=0; i< shelf.length;i++){
            if(shelf[i][column]!=null){
                break;
            }
        }
        shelf[i-1][column]=card;
    }

    /**
     * Displays the chosen row of the bookshelf as a string
     * in terminal (used in TUI)
     *
     * @param row chosen row
     * @return visual representation of the row as a string
     */
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
    /**
     * Checks how many free spots are left in the bookshelf
     * and updates maxDrawableObject attribute
     */
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
