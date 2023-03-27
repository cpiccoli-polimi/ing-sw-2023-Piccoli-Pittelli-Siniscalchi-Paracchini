package it.polimi.model;

import static it.polimi.model.RomanNumeral.*;

public class CommonGoalCard extends GoalCard{
    //Remove "Field Can Be Local" warning in IntelliJ
    @SuppressWarnings("FieldCanBeLocal")
    private static int goalID;
    // Constructor
    public CommonGoalCard(int id, int playersNumber, int goalNumber){
        // Set Goal ID
        goalID = id;

        // Decks creation
        PointCard[] commonGoalDeckI;
        commonGoalDeckI = new PointCard[playersNumber];
        PointCard[] commonGoalDeckII;
        commonGoalDeckII = new PointCard[playersNumber];

        // Deck(s) population in reverse order
        for(int i=0; i<playersNumber;i++){
            int value = 8;
            commonGoalDeckI[i] = new PointCard(value,I);
            if(goalNumber > 0){
            commonGoalDeckII[i] = new PointCard(value,II);}
            value -= 2;
        }

    }
    private void setPoints(){}
}
