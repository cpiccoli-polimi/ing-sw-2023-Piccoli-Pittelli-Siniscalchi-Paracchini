package it.polimi.model;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * The abstract class CommonGoalCard provides all the
 * behaviour that are common between the 12 common goal cards
 *
 * @see java.io.Serializable
 */
public abstract class CommonGoalCard extends GoalCard implements Serializable {
    static final long serialVersionUID = 1L;
    protected int goalID;
    protected List<PointCard> points;
    private String goalDescription;

    /**
     * Creates the CommonGoalCard setting the points and its description,
     * retrieving it from a json file
     *
     * @param goalId the identifier of the Goal
     */
    public CommonGoalCard(int goalId){
        this.goalID = goalId;
        this.points = new ArrayList<>();

        try {
            InputStream stream = PersonalGoalCard.class.getResourceAsStream("/jsonFiles/CommonGoals.json");
            JsonReader jsonReader = new JsonReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
            JsonElement obj = JsonParser.parseReader(jsonReader);
            JsonObject commonGoalsDescriptions = obj.getAsJsonObject();
            this.goalDescription = commonGoalsDescriptions.get(String.valueOf(goalId)).getAsString();
        }
        catch(NullPointerException e){
            System.out.println("5");
            throw e;
        }
    }
    /**
     * Returns the goalID of the card
     *
     * @return this.goalID the id
     */
    public int getGoalID(){
        return this.goalID;
    }
    /**
     * Sets the points gained completing this goalCard,
     * based on the number of players in the game
     *
     * @param points the list containing the points gained
     */
    protected void setPoints(List<PointCard> points){
        this.points.addAll(points);
    }
    /**
     * Returns the lists containing the point gained
     * completing this goalCard
     *
     * @return this.points
     */
    public List<PointCard> getPoints(){ return this.points;}
    /**
     * Returns the description of this goal as a string
     *
     * @return this.goalDescription
     */
    public String getGoalDescription(){
        return this.goalDescription;
    }
    /**
     * Checks if this goal is satisfied (overrided by the 12 subclasses)
     *
     * @param bookshelf the bookshelf to be checked
     * @return false
     */
    public boolean check(ObjectCard[][] bookshelf){return false;}
    @Override
    public boolean equals(Object object) {
        if(!(object instanceof CommonGoalCard)){
            return false;
        }
        CommonGoalCard goalCard = (CommonGoalCard) object;
        return(this.goalID == goalCard.getGoalID());
    }
}
