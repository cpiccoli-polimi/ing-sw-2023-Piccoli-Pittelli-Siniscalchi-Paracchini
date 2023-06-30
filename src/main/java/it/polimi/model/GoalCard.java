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
     * @return the goal of this card
     */
    public Object getGoal(){return goal;}
    /**
     * @return the points of this card
     */
    public Object getPoints(){return points;}
}
