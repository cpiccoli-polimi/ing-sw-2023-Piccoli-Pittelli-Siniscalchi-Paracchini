package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;

public class CommonGoalCard1 extends CommonGoalCard {
    public CommonGoalCard1(int playersNumber) {
        goalID = 1;
        // Deck creation
        points = new PointCard[playersNumber];
    }

}
