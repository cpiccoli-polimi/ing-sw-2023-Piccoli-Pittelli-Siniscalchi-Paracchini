package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;

public class CommonGoalCard2 extends CommonGoalCard {
    public CommonGoalCard2(int playersNumber) {
        goalID = 2;
        // Deck creation
        points = new PointCard[playersNumber];
    }
}
