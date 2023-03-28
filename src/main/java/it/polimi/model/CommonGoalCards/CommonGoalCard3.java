package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;

public class CommonGoalCard3 extends CommonGoalCard {
    public CommonGoalCard3(int playersNumber) {
        goalID = 3;
        // Deck creation
        points = new PointCard[playersNumber];
    }
}
