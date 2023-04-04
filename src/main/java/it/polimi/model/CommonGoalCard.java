package it.polimi.model;

public abstract class CommonGoalCard extends GoalCard{

    protected int goalID;
    protected PointCard[] points;
    protected void setPoints(){}
    public boolean check(ObjectCard[][] bookshelf){}
}
