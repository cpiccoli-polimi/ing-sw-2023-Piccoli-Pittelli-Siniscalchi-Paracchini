package it.polimi.model;
import it.polimi.model.exception.AllCommonGoalsCompletedException;
import it.polimi.model.exception.CommonGoalAlreadyCompletedException;
import it.polimi.model.*;
public class Player {
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
    public void setChosenObjects(ObjectCard [] chosenObjects){
        System.arraycopy(chosenObjects, 0, this.chosenObjects, 0, chosenObjects.length);}

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

    private void CountPersonalGoalsPoints() {
        // Get bookshelf, personalGoal and actual points from Player
        ObjectCard[][] shelf = bookshelf.getShelf();
        // Scan through every row and columns: if two cells match, add one point
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (shelf[row][col].getType() == personalGoal.getGoal().getShelf()[row][col].getType()) {
                    points++;
                }
            }
        }
    }

}
