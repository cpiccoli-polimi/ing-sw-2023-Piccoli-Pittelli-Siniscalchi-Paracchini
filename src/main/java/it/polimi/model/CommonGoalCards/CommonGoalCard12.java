package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;

public class CommonGoalCard12 extends CommonGoalCard {
    public CommonGoalCard12(int playersNumber) {
        goalID = 12;
        // Deck creation
        points = new PointCard[playersNumber];
    }
}
