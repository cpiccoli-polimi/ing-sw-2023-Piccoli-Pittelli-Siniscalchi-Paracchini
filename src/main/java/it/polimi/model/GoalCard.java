package it.polimi.model;

import java.io.Serializable;

/**
 * The abstract class CommonGoalCard provides all the
 * behaviour that are common between personal and common
 * goal cards
 *
 * @see java.io.Serializable
 */
public abstract class GoalCard implements Serializable {
    static final long serialVersionUID = 1L;
    private Object goal;
    private Object points;
    /**
     * Returns the goal
     */
    public Object getGoal(){return goal;}
    /**
     * Returns the points of the goal card
     */
    public Object getPoints(){return points;}
}
