package it.polimi.model;

import java.io.Serializable;

public abstract class GoalCard implements Serializable {
    static final long serialVersionUID = 1L;
    private Object goal;
    private Object points;
    public Object getGoal(){return goal;}

    public Object getPoints(){return points;}
}
