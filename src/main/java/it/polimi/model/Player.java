package it.polimi.model;
import it.polimi.model.exception.AllCommonGoalsCompletedException;
import it.polimi.model.exception.CommonGoalAlreadyCompletedException;

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

    public void setCommonGoalsCompleted (int [] commonGoalsCompleted, int newGoals)throws AllCommonGoalsCompletedException, CommonGoalAlreadyCompletedException {
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
    }

    public ObjectCard[] getChosenObjects() {return chosenObjects;}
    public void setChosenObjects(ObjectCard [] oggettoScelto){
        System.out.println("Giocatore"+position);
        chosenObjects= new ObjectCard[oggettoScelto.length];
        System.out.println(oggettoScelto[0].getType());
        for(int i=0;i<oggettoScelto.length;i++){
            this.chosenObjects[i]=oggettoScelto[i];
        }
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
        // Get bookshelf, personalGoal and actual points from Player
        ObjectCard[][] shelf = bookshelf.getShelf();
        // Scan through every row and columns: if two cells match, add one point
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                if (shelf[row][col].getType() == personalGoal.getGoal().getShelf()[row][col].getType()) {
                    points++;
                }
            }
        }
    }

    public void countAdjacentItemsPoints() {
        // Get bookshelf
        ObjectCard[][] shelf = bookshelf.getShelf();
        // Create hashmap to track which types has already been counted
        Map<Type, Integer> countedTypes = new HashMap<>();
        // Cycle through every row and column
        for (int row = 0; row < shelf.length; row++) {
            for (int col = 0; col < shelf[row].length; col++) {
                ObjectCard currentCard = shelf[row][col];
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

                                if (adjacentCard.getType().equals(currentType)) {
                                    adjacentCount++;
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

                                if (adjacentCard.getType().equals(currentType)) {
                                    adjacentCount++;
                                }
                            }
                        }
                    }

                    // Update current type count
                    countedTypes.put(currentType, adjacentCount);
                }
            }
        }
        // Sum all types counting and put them into points attribute
        int adjacentPoints = 0;
        for (int count : countedTypes.values()) {
            adjacentPoints += count;
        }
        points += adjacentPoints;
    }

}
