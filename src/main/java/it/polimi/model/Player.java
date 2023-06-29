package it.polimi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Player class represents the single player
 *
 * @see java.io.Serializable
 */
public class Player implements Serializable {
    static final long serialVersionUID = 1L;
    private String nickname;
    private int points;
    private boolean isFirst;
    private int position;
    private boolean hasFinished;
    private int [] commonGoalsCompleted;
    private ObjectCard [] chosenObjects;
    private PersonalGoalCard personalGoal;
    private Bookshelf bookshelf;
    private int chosenColumn;

    /**
     * Creates the player setting its attributes to default values
     * nickname from input and commonGoalsNumber from the game
     *
     * @param nickname
     * @param commonGoalsNumber
     */
    public Player(String nickname, int commonGoalsNumber){
        this.nickname=nickname;
        this.points=0;
        this.isFirst=false;
        this.position=-1;
        this.hasFinished=false;
        this.commonGoalsCompleted= new int [commonGoalsNumber];
        for(int i=0;i<commonGoalsNumber;i++){
            commonGoalsCompleted[i]=-1;
        }
        this.chosenColumn=-1;
        this.chosenObjects=null;
        this.personalGoal=null;
        this.bookshelf=new Bookshelf();

    }

    /**
     * Returns player's nickname
     *
     * @return nickname
     */
    public String getNickname(){
        return nickname;
    }
    /**
     * Returns player's points
     *
     * @return points
     */
    public int getPoints(){
        return points;
    }
    /**
     * Sets player's points
     *
     * @param points
     */
    public void setPoints(int points){
        this.points=points;
        System.out.println(getNickname()+": "+points);
    }
    /**
     * Checks if the player is the first to play
     *
     * @return true if the player is first, else false
     */
    public boolean getIsFirst(){ return isFirst;}
    /**
     * Sets the player to be the first to play
     *
     * @param isFirst
     */
    public void setIsFirst(boolean isFirst){ this.isFirst=isFirst; }
    /**
     * Returns the relative position of the player
     *
     * @return position
     */
    public int getPosition() {
        return position;
    }
    /**
     * Sets the relative position of the player
     *
     * @param position
     */
    public void setPosition(int position){this.position=position;}
    /**
     * Checks if the player has finished the game
     * (its bookshelf is full)
     *
     * @return true if has finished, else false
     */
    public boolean getHasFinished(){return hasFinished;}
    /**
     * Sets to true the hasFinished parameter when
     * player's bookshelf is full
     *
     * @param hasFinished
     */
    public void setHasFinished(boolean hasFinished){ this.hasFinished=hasFinished;}
    /**
     * Returns an array containing how many common goals
     * the player has completed
     *
     * @return commonGoalsCompleted
     */
    public int[] getCommonGoalsCompleted() { return commonGoalsCompleted;}
    /**
     * Sets the array containing how many common goals
     * the player has completed
     *
     * @param commonGoalsCompleted
     * @param newGoal
     */
    public void setCommonGoalsCompleted(int[] commonGoalsCompleted, int newGoal){
        int i=0;
        while(this.commonGoalsCompleted[i]!=-1){
            i++;
        }
        this.commonGoalsCompleted[i]=newGoal;
        System.out.println(newGoal+" completed");
    }
    /**
     * Returns an array containing the objects chosen
     * from the LivingRoomBoard by the player
     *
     * @return chosenOjects
     */
    public ObjectCard[] getChosenObjects() {return chosenObjects;}
    /**
     * Sets the objects chosen from the LivingRoomBoard
     * by the player in the ChosenObjects attribute
     *
     * @param chosenObjects
     */
    public void setChosenObjects(ObjectCard [] chosenObjects){
        System.out.println("Player "+position);
        this.chosenObjects = new ObjectCard[chosenObjects.length];
        System.out.println(chosenObjects[0].getType());
        System.arraycopy(chosenObjects, 0, this.chosenObjects, 0, chosenObjects.length);
        System.out.println("Copied object "+getChosenObjects()[0].getType());

    }
    /**
     * Returns player's personal goal
     *
     * @return personalGoal
     */
    public PersonalGoalCard getPersonalGoal() {
        return personalGoal;
    }
    /**
     * Sets player's personal goal
     *
     * @param personalGoal
     */
    public void setPersonalGoal(PersonalGoalCard personalGoal) {
        this.personalGoal = personalGoal;
    }
    /**
     * Returns player's bookshelf
     *
     * @return bookshelf
     */
    public Bookshelf getBookshelf() {
        return bookshelf;
    }
    /**
     * Sets player's bookshelf
     *
     * @param bookshelf
     */
    public void setBookshelf(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }
    /**
     * Returns player's chosen column in
     * which to place the objects picked from
     * the LivingRoomBoard
     *
     * @return chosenColumn
     */
    public int getChosenColumn() {
        return chosenColumn;
    }
    /**
     * Sets player's chosen column
     *
     * @param chosenColumn
     */
    public void setChosenColumn(int chosenColumn) {
        this.chosenColumn = chosenColumn;
    }
    /**
     * Counts personal goal points based on how many
     * tiles in personal bookshelf match personal
     * goal card positions and gives him points
     */
    public void countPersonalGoalsPoints() {
        int count=0;
        int p=0;
        // Get bookshelf, personalGoal and actual points from Player
        Bookshelf bookshelf = this.getBookshelf();
        // Scan through every row and columns: if two cells match, add one point
        for (int row = 0; row < getBookshelf().getShelf().length; row++) {
            for (int col = 0; col < getBookshelf().getShelf()[0].length; col++) {
                if (bookshelf.shelf[row][col] != null && personalGoal.getGoal().getShelf()[row][col]!=null) {
                    if (bookshelf.shelf[row][col].getType() != null && personalGoal.getGoal().getShelf()[row][col].getType() != null) {
                        if (bookshelf.shelf[row][col].getType() == personalGoal.getGoal().getShelf()[row][col].getType()) {
                            count++;
                        }
                    }
                }
            }
        }
        switch (count){
            case 0 : {
                getPoints();
                break;
            }
            case 1: {
                p=getPoints();
                setPoints(p+1);
                break;

            }
            case 2 : {
                p=getPoints();
                setPoints(p+2);
                break;
            }
            case 3: {
                p=getPoints();
                setPoints(p+4);
                break;
            }
            case 4 : {
                p=getPoints();
                setPoints(p+6);
                break;
            }
            case 5: {
                p=getPoints();
                setPoints(p+9);
                break;
            }
            case 6 : {
                p=getPoints();
                setPoints(p+12);
                break;
            }
        }
        System.out.println("PersonalGoal Tiles Matched: "+count);
    }
    /**
     * Counts how many points the player has achieved
     * by placing adjacent tiles with the same type
     * in his bookshelf
     */
    public void countAdjacentItemsPoints() {
        int points=0;
        // Get bookshelf
        ObjectCard[][] shelf = bookshelf.getShelf();
        ObjectCard [][] bookshelfCopy=new ObjectCard[shelf.length][shelf[0].length];
        for(int i=0;i <shelf.length;i++){
            for(int j=0;j<shelf[0].length;j++){
                bookshelfCopy[i][j]=shelf[i][j];
            }
        }

        for(int r=0; r<shelf.length; r++){
            for(int c=0;c<shelf[0].length;c++){
                List<ObjectCard> objectList= new ArrayList<>();
                if(bookshelfCopy[r][c]!=null) {
                    objectList.add(bookshelfCopy[r][c]);
                    for (int r2 = 0; r2 < shelf.length; r2++) {
                        for (int c2 = 0; c2 < shelf[0].length; c2++) {
                            if (bookshelfCopy[r2][c2] != null && bookshelfCopy[r2][c2].getType() != null) {
                                if (bookshelfCopy[r2][c2].getType() == objectList.get(0).getType()) {
                                    if ((c2 > 0 && objectList.contains(bookshelfCopy[r2][c2 - 1])) || (r2 > 0 && objectList.contains(bookshelfCopy[r2 - 1][c2]))) {
                                        if (!objectList.contains(bookshelfCopy[r2][c2])) {
                                            objectList.add(bookshelfCopy[r2][c2]);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                for(int i=0;i< shelf.length;i++){
                    for(int j=0;j<shelf[0].length;j++){
                        for(int k=0;k<objectList.size();k++){
                            if(bookshelfCopy[i][j]!=null){
                                if(bookshelfCopy[i][j].getId()==objectList.get(k).getId()){
                                    bookshelfCopy[i][j]=null;
                                }
                            }
                        }
                    }
                }
                /*for(int k=0;k<objectList.size();k++){
                    bookshelfCopy[objectList.get(k).getXCoordinate()][objectList.get(k).getYCoordinate()]=null;
                }*/
                    // Add points based on how many adjacent points had been made
                    if(objectList.size() == 3) {
                        points = getPoints();
                        setPoints(points + 2);
                    }
                    else if(objectList.size() == 4) {
                        points = getPoints();
                        setPoints(points + 3);
                    }
                    else if(objectList.size() == 5) {
                        points = getPoints();
                        setPoints(points + 5);
                    }
                    else if(objectList.size() >= 6){
                        points = getPoints();
                        setPoints(points+8);
                    }
                objectList.clear();
            }
        }
    }
}

