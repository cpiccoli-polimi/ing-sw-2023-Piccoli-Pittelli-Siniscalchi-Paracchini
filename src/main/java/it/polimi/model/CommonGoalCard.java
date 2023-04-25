package it.polimi.model;

import java.util.List;

public abstract class CommonGoalCard extends GoalCard{

    protected int goalID;
    protected List<PointCard> points;

    public int getGoalID(){
        return this.goalID;
    }
    protected void setPoints(List<PointCard> points){
        for(int i = 0; i < points.size(); i++){
            this.points.addAll(points);
        }
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
