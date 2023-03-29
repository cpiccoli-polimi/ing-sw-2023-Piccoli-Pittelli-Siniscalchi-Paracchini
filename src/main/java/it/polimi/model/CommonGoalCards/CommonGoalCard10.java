package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;

public class CommonGoalCard10 extends CommonGoalCard {
    public CommonGoalCard10(int playersNumber) {
        goalID = 10;
        // Deck creation
        points = new PointCard[playersNumber];
    }
}
