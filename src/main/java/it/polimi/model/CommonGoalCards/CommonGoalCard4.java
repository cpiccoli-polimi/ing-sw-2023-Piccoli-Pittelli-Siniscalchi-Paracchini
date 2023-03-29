package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;

public class CommonGoalCard4 extends CommonGoalCard {
    public CommonGoalCard4(int playersNumber) {
        goalID = 4;
        // Deck creation
        points = new PointCard[playersNumber];
    }
}
