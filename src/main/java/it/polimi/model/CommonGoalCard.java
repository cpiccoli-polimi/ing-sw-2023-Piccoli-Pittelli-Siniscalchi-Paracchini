package it.polimi.model;

public abstract class CommonGoalCard extends GoalCard{

    protected int goalID;
    protected PointCard[] points;

    public int getGoalID(){
        return this.goalID;
    }
    protected void setPoints(PointCard[] points){
        this.points = points;
    }
    public boolean check(ObjectCard[][] bookshelf){return false;}
    @Override
    public boolean equals(Object object) {
        if((object instanceof CommonGoalCard) == false){
            return false;
        }
        CommonGoalCard goalCard = (CommonGoalCard) object;
        return(this.goalID == goalCard.getGoalID());
    }
}
