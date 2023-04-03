package it.polimi.model;

public class Player {
    private String nickname;
    private int points;
    private boolean isFirst;
    private int position;
    private boolean hasFinished;
    private int [] commonGoalsCompleted;
    private ObjectCard [] chosenObject; // is now an array
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
        this.chosenColumn=-1;
        this.chosenObjects=new ObjectCard [3];
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
    public void setCommonGoalsCompleted(int [] commonGoalsCompleted){
        System.arraycopy(commonGoalsCompleted, 0, this.commonGoalsCompleted, 0, commonGoalsCompleted.length); }

    public ObjectCard[] getChosenObject() {return chosenObject;}
    public void setChosenObject(ObjectCard [] chosenObject){
        System.arraycopy(chosenObject, 0, this.chosenObject, 0, chosenObject.length);}

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


}
