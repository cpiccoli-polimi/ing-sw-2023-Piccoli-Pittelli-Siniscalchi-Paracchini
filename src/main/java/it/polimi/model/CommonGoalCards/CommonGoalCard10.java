package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.ObjectCard;

public class CommonGoalCard10 extends CommonGoalCard {
    public CommonGoalCard10(int playersNumber) {
        super(10);
    }

    @Override
    public boolean check(ObjectCard[][] bookshelf) {
        boolean flag = false;

        for(int i = 1; i < bookshelf.length - 1 && !flag; i++){
            for(int j = 1; j < bookshelf[i].length - 1 && !flag; j++) {
                if (bookshelf[i - 1][j - 1] != null && bookshelf[i - 1][j + 1] != null &&
                         bookshelf[i][j] != null && bookshelf[i + 1][j - 1] != null &&
                         bookshelf[i + 1][j + 1] != null) {
                    if (bookshelf[i - 1][j - 1].getType() == bookshelf[i - 1][j + 1].getType() &&
                            bookshelf[i - 1][j - 1].getType() == bookshelf[i][j].getType() &&
                            bookshelf[i - 1][j - 1].getType() == bookshelf[i + 1][j - 1].getType() &&
                            bookshelf[i - 1][j - 1].getType() == bookshelf[i + 1][j + 1].getType()) {
                        flag = true;
                    }
                }
            }
        }

        return flag;
    }
}
