package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;

public class CommonGoalCard8 extends CommonGoalCard {
    public CommonGoalCard8(int playersNumber) {
        goalID = 8;
        // Deck creation
        points = new PointCard[playersNumber];
    }
}
