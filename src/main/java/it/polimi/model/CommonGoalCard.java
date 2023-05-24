package it.polimi.model;

import java.io.Serializable;
import java.util.List;

public abstract class CommonGoalCard extends GoalCard implements Serializable {

    protected int goalID;
    protected List<PointCard> points;

    public int getGoalID(){
        return this.goalID;
    }
    protected void setPoints(List<PointCard> points){
        this.points.addAll(points);
    }
    public List<PointCard> getPoints(){ return this.points;}
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
