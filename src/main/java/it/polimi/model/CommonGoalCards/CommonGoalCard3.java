package it.polimi.model.CommonGoalCards;

import it.polimi.model.*;

import java.util.ArrayList;

public class CommonGoalCard3 extends CommonGoalCard {
    public CommonGoalCard3(int playersNumber) {
        super(3);
    }
    @Override
    public boolean check(ObjectCard[][] bookshelf) {
        boolean flag = false;
        int maxR = bookshelf.length-1;
        int maxC=bookshelf[0].length-1;
        if(bookshelf[0][0]!=null && bookshelf[0][maxC]!=null && bookshelf[maxR][0]!=null && bookshelf[maxR][maxC]!=null) {
            if (bookshelf[0][0].getType() != null && bookshelf[0][maxC].getType() != null && bookshelf[maxR][0].getType() != null && bookshelf[maxR][maxC].getType() != null) {
                if (bookshelf[0][0].getType() == bookshelf[0][maxC].getType()
                        && bookshelf[0][0].getType() == bookshelf[maxR][0].getType()
                        && bookshelf[0][0].getType() == bookshelf[maxR][maxC].getType()) {
                    flag = true;
                }
            }
        }
        return flag;
    }
}
