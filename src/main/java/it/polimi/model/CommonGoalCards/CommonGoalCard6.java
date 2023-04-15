package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;
import it.polimi.model.ObjectCard;
public class CommonGoalCard6 extends CommonGoalCard {

    public CommonGoalCard6(int playersNumber) {
        goalID = 6;
        // Deck creation
        points = new PointCard[playersNumber];
    }
    @Override
    public boolean check(ObjectCard[][] bookshelf) {
        int columnsCounter = 0;

        for (int i = 0; i < bookshelf.length; i++) {

            if (bookshelf[i][0] == null) {
                continue;
            }

            for (int j = 0; j < bookshelf[0].length - 1; j++) {
                for (int k = j + 1; k < bookshelf[0].length; k++) {

                    if (bookshelf[i][j].getType() != bookshelf[i][k].getType() && j == bookshelf[0].length - 1) {
                        columnsCounter += 1;
                        if (columnsCounter == 2) {
                            return true;
                        }
                    }else if (bookshelf[i][j].getType() == bookshelf[i][k].getType()) {
                        return false;
                    }
                }
            }
        }
    return false;
    }
}
