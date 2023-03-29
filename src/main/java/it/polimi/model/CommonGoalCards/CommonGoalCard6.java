package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;

public class CommonGoalCard6 extends CommonGoalCard {
    public CommonGoalCard6(int playersNumber) {
        goalID = 6;
        // Deck creation
        points = new PointCard[playersNumber];
    }
}
