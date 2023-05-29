package it.polimi.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class CommonGoalCard extends GoalCard implements Serializable {

    protected int goalID;
    protected List<PointCard> points;
    private String goalDescription;

    public CommonGoalCard(int goalId){
        this.goalID = goalId;
        this.points = new ArrayList<PointCard>();

        try {
            Gson gson = new Gson();
            File commonGoalsDescriptionFile = new File("src/main/resources/CommonGoals.json");
            FileReader commonGoalsDescriptionFileReader = new FileReader(commonGoalsDescriptionFile);
            JsonObject commonGoalsDescriptions = gson.fromJson( commonGoalsDescriptionFileReader, JsonObject.class);
            this.goalDescription = commonGoalsDescriptions.get(String.valueOf(goalId)).getAsString();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public int getGoalID(){
        return this.goalID;
    }
    protected void setPoints(List<PointCard> points){
        this.points.addAll(points);
    }
    public List<PointCard> getPoints(){ return this.points;}
    protected void setGoalDescription(String goalDescription){
        this.goalDescription = goalDescription;
    }
    public String getGoalDescription(){
        return this.goalDescription;
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
