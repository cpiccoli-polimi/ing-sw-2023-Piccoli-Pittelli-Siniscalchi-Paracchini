package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;

public class CommonGoalCard5 extends CommonGoalCard {
    public CommonGoalCard5(int playersNumber) {
        goalID = 5;
        // Deck creation
        points = new PointCard[playersNumber];
    }
}
