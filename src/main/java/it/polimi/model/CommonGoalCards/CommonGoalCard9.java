package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;

public class CommonGoalCard9 extends CommonGoalCard {
    public CommonGoalCard9(int playersNumber) {
        goalID = 9;
        // Deck creation
        points = new PointCard[playersNumber];
    }
}
