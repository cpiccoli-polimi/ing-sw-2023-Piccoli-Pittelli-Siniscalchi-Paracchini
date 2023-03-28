package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;

public class CommonGoalCard7 extends CommonGoalCard {
    public CommonGoalCard7(int playersNumber) {
        goalID = 7;
        // Deck creation
        points = new PointCard[playersNumber];
    }
}
