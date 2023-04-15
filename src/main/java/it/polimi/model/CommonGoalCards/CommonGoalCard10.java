package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.ObjectCard;
import it.polimi.model.PointCard;
import it.polimi.model.Type;

public class CommonGoalCard10 extends CommonGoalCard {
    public CommonGoalCard10(int playersNumber) {
        goalID = 10;
        // Deck creation
        points = new PointCard[playersNumber];
    }

    @Override
    public boolean check(ObjectCard[][] bookshelf) {
        boolean flag = false;

        for(int i = 1; i < bookshelf.length - 1 && flag == false; i++){
            for(int j = 1; j < bookshelf[i].length - 1 && flag == false; j++){
                if(bookshelf[i-1][j-1].getType() == bookshelf[i-1][j+1].getType() &&
                        bookshelf[i-1][j-1].getType()== bookshelf[i][j].getType() &&
                        bookshelf[i-1][j-1].getType()== bookshelf[i+1][j-1].getType() &&
                        bookshelf[i-1][j-1].getType()== bookshelf[i+1][j+1].getType()){
                    flag = true;
                }
            }
        }

        return flag;
    }
}
