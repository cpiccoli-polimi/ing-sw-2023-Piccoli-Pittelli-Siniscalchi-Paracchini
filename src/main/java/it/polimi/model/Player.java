package it.polimi.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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


    public String getNickname(){
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPoints(){
        return points;
    }
    public void setPoints(int points){
        this.points=points;
    }

    public boolean getIsFirst(){ return isFirst;}
    public void setIsFirst(boolean isFirst){ this.isFirst=isFirst; }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position){this.position=position;}

    public boolean getHasFinished(){return hasFinished;}

    public void setHasFinished(boolean hasFinished){ this.hasFinished=hasFinished;}

    public int[] getCommonGoalsCompleted() { return commonGoalsCompleted;}
    public void setCommonGoalsCompleted(int[] commonGoalsCompleted, int newGoal){
        int i=0;
        while(this.commonGoalsCompleted[i]!=-1){
            i++;
        }
        this.commonGoalsCompleted[i]=newGoal;
        System.out.println(newGoal+"completed");
    }

    /*public void setCommonGoalsCompleted (int [] commonGoalsCompleted, int newGoals)throws AllCommonGoalsCompletedException, CommonGoalAlreadyCompletedException {
        if(commonGoalsCompleted[commonGoalsCompleted.length-1]!=-1){
            throw new AllCommonGoalsCompletedException();
        }
        int i=0;
        while(i<commonGoalsCompleted.length && commonGoalsCompleted[i]!=-1){
            if(commonGoalsCompleted[i]==newGoals){
                throw new CommonGoalAlreadyCompletedException();
            }
            i++;
        }
        commonGoalsCompleted[i]=newGoals;
    }*/

    public ObjectCard[] getChosenObjects() {return chosenObjects;}
    public void setChosenObjects(ObjectCard [] oggettoScelto){
        System.out.println("Giocatore"+position);
        chosenObjects= new ObjectCard[oggettoScelto.length];
        System.out.println(oggettoScelto[0].getType());
        System.arraycopy(oggettoScelto, 0, this.chosenObjects, 0, oggettoScelto.length);
        System.out.println("Oggetto copiato"+getChosenObjects()[0].getType());

    }


    public PersonalGoalCard getPersonalGoal() {
        return personalGoal;
    }

    public void setPersonalGoal(PersonalGoalCard personalGoal) {
        this.personalGoal = personalGoal;
    }

    public Bookshelf getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }

    public int getChosenColumn() {
        return chosenColumn;
    }

    public void setChosenColumn(int chosenColumn) {
        this.chosenColumn = chosenColumn;
    }

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
        System.out.println("Punti"+count);
    }

    public void countAdjacentItemsPoints() {
        // Get bookshelf
        ObjectCard[][] shelf = bookshelf.getShelf();
        // Create hashmap to track which types has already been counted
        Map<Type, Integer> countedTypes = new HashMap<>();
        // Create an array to track already counted object
        // Array has [xCoordinate][yCoordinate] of counted tiles
        // It is initialized to -1 in every cell
        int tileCount = shelf.length + shelf[0].length;
        int[][] countedCoordinates = new int[tileCount][2];
        for(int j=0;j<tileCount;j++){
            countedCoordinates[j][0] = -1;
            countedCoordinates[j][1] = -1;
        }

        // Cycle through every row and column
        for (int row = 0; row < shelf.length; row++) {
            for (int col = 0; col < shelf[row].length; col++) {
                ObjectCard currentCard = shelf[row][col];
                boolean currentCardCounted = false;
                if(currentCard != null) {
                    Type currentType = currentCard.getType();
                    // If currentType has not been counted yet, we start counting from 0
                    if (!countedTypes.containsKey(currentType)) {
                        int adjacentCount = 0; // Counter for adjacent cards

                        // Cycle through every row and column adjacent to the actual card
                        for (int j = row - 1; j <= row + 1; j++) {
                            for (int k = col - 1; k <= col + 1; k++) {
                                // If adjacent slot is not empty and it is not actual card, add to count (if types match)
                                if (j >= 0 && j < shelf.length && k >= 0 && k < shelf[row].length && !(j == row && k == col)) {
                                    ObjectCard adjacentCard = shelf[j][k];
                                    boolean adjacentCardCounted = false;

                                    if(adjacentCard != null && (k == col || j == row)) {
                                        if (adjacentCard.getType().equals(currentType)) {
                                            // Insert currentCard coordinates (if not already inserted)
                                            for (int crow = 0; crow < countedCoordinates.length && !currentCardCounted; crow++) {
                                                // This combination of [row][col] is in the array
                                                if (countedCoordinates[crow][0] == row && countedCoordinates[crow][1] == col) {
                                                    currentCardCounted = true;
                                                    break;
                                                }
                                            }
                                            if (!currentCardCounted) {
                                                for (int i = 0; i < countedCoordinates.length; i++) {
                                                    if (countedCoordinates[i][0] == -1) {
                                                        countedCoordinates[i][0] = currentCard.getXCoordinate();
                                                        countedCoordinates[i][1] = currentCard.getYCoordinate();
                                                        currentCardCounted = true;
                                                        adjacentCount++;
                                                        break;
                                                    }
                                                }
                                            }
                                            // Insert adjacentCard coordinates and (if not already inserted) add points
                                            for (int crow = 0; crow < countedCoordinates.length && !adjacentCardCounted; crow++) {
                                                // This combination of [row][col] is in the array
                                                if (countedCoordinates[crow][0] == j && countedCoordinates[crow][1] == k) {
                                                    adjacentCardCounted = true;
                                                    break;
                                                }
                                            }
                                            if (!adjacentCardCounted) {
                                                for (int i = 0; i < countedCoordinates.length; i++) {
                                                    if (countedCoordinates[i][0] == -1) {
                                                        countedCoordinates[i][0] = adjacentCard.getXCoordinate();
                                                        countedCoordinates[i][1] = adjacentCard.getYCoordinate();
                                                        adjacentCardCounted = true;
                                                        adjacentCount++;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        // Add actual type to counted types map
                        countedTypes.put(currentType, adjacentCount);
                    } else {
                        // If actual type has already been counted, restart from previous count
                        // In case there are separated groups of adjacent cards from the same type
                        int previousCount = countedTypes.get(currentType);

                        // Restart from previous count
                        int adjacentCount = previousCount;
                        for (int j = row - 1; j <= row + 1; j++) {
                            for (int k = col - 1; k <= col + 1; k++) {
                                if (j >= 0 && j < shelf.length && k >= 0 && k < shelf[row].length && !(j == row && k == col)) {
                                    ObjectCard adjacentCard = shelf[j][k];
                                    boolean adjacentCardCounted = false;

                                    if (adjacentCard != null && (k == col || j == row)) {
                                        if (adjacentCard.getType().equals(currentType)) {
                                            // Insert currentCard coordinates (if not already inserted)
                                            for(int crow=0;crow<countedCoordinates.length;crow++){
                                                // This combination of [row][col] is in the array
                                                if(countedCoordinates[crow][0] == row && countedCoordinates[crow][1] == col){
                                                    currentCardCounted = true;
                                                    break;
                                                }
                                            }
                                            if(!currentCardCounted){
                                                for (int i = 0; i < countedCoordinates.length; i++) {
                                                    if (countedCoordinates[i][0] == -1) {
                                                        countedCoordinates[i][0] = currentCard.getXCoordinate();
                                                        countedCoordinates[i][1] = currentCard.getYCoordinate();
                                                        currentCardCounted = true;
                                                        adjacentCount++;
                                                        break;
                                                    }
                                                }
                                            }
                                            // Insert adjacentCard coordinates and (if not already inserted) add points
                                            for(int crow=0;crow<countedCoordinates.length;crow++){
                                                // This combination of [row][col] is in the array
                                                if(countedCoordinates[crow][0] == j && countedCoordinates[crow][1] == k){
                                                    adjacentCardCounted = true;
                                                    break;
                                                }
                                            }
                                            if(!adjacentCardCounted){
                                                for (int i = 0; i < countedCoordinates.length; i++) {
                                                    if (countedCoordinates[i][0] == -1) {
                                                        countedCoordinates[i][0] = adjacentCard.getXCoordinate();
                                                        countedCoordinates[i][1] = adjacentCard.getYCoordinate();
                                                        adjacentCardCounted = true;
                                                        adjacentCount++;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        // Update current type count
                        countedTypes.put(currentType, adjacentCount);
                    }
                }
            }
        }
        // Sum all types counting and put them into points attribute
        for (int adjacentPoints : countedTypes.values()) {
            // Add points based on how many adjacent points had been made
            if(adjacentPoints == 3){
                points += 2;
            }
            else if(adjacentPoints == 4){
                points += 3;
            }
            else if(adjacentPoints == 5){
                points += 5;
            }
            else if(adjacentPoints >= 6){
                points += 8;
            }
        }
    }

}
