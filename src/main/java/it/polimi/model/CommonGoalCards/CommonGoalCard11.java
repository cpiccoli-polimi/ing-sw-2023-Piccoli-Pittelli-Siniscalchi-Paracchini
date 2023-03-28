package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;

public class CommonGoalCard11 extends CommonGoalCard {
    public CommonGoalCard11(int playersNumber) {
        goalID = 11;
        // Deck creation
        points = new PointCard[playersNumber];
    }
}
