package it.polimi.model.CommonGoalCards;

import it.polimi.model.*;

public class CommonGoalCard3 extends CommonGoalCard {
    public CommonGoalCard3(int playersNumber) {
        goalID = 3;
        // Deck creation
        points = new PointCard[playersNumber];
    }
    public boolean check(ObjectCard[][] bookshelf) {
        boolean flag = false;
        int max = bookshelf.length;
        if(bookshelf[0][0].getType == bookshelf[0][max].getType == bookshelf[max][0].getType ==  bookshelf[max][max].getType){
            flag = true;
        }
        return flag;
    }
}
