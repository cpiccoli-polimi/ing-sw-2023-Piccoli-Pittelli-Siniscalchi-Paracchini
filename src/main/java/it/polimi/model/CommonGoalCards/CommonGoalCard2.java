package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;
import it.polimi.model.ObjectCard;

import java.util.ArrayList;

public class CommonGoalCard2 extends CommonGoalCard {

    public CommonGoalCard2(int playersNumber) {
        goalID = 2;
        // Deck creation
        points = new ArrayList<PointCard>();
    }
    @Override
    public boolean check(ObjectCard[][] bookshelf) {

        for(int i = 0; i < bookshelf.length; i++){

            if (bookshelf[0][0].getType() != bookshelf[i+1][i+1].getType() || bookshelf[i][i] == null) {
                return false;
            }else if (bookshelf[4][0].getType() != bookshelf[4-i][i+1].getType() || bookshelf[4-i][i] == null) {
                return false;
            }else if (bookshelf[0][1].getType() != bookshelf[i+1][i+2].getType() || bookshelf[i][i+1] == null) {
                return false;
            }else if (bookshelf[4][1].getType() != bookshelf[4-i][i+2].getType() || bookshelf[4-i][i+1] == null) {
                return false;
            }
        }

        return true;
    }
}
