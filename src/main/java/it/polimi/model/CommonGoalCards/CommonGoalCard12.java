package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.ObjectCard;

public class CommonGoalCard12 extends CommonGoalCard {
    public CommonGoalCard12(int playersNumber) {
        super(12);
    }

    @Override
    public boolean check(ObjectCard[][] bookshelf){
        boolean flag = false;
        // Empty bookshelf case
        for(int row = 0; row<bookshelf.length && !flag; row++){
            for(int col = 0; col<bookshelf[row].length; col++){
                if (bookshelf[row][col] != null) {
                    flag = true;
                    break;
                }
            }
        }
        if(!flag){return flag;}

        // Not empty bookshelf case
        if(bookshelf[0][0] != null) {
            if (bookshelf[0][0].getType() != null) {
                for (int i = 0; i < bookshelf.length - 1 && flag; i++) {
                    if(bookshelf[i][i] != null) {
                        if (bookshelf[i][i].getType() == null) {
                            flag = false;
                        }
                        if (i - 1 >= 0  && bookshelf[i-1][i] != null) {
                            if (bookshelf[i - 1][i].getType() != null) {
                                flag = false;
                            }
                        }
                    }
                }
            }
        }
        else if (bookshelf[1][0] != null){
            if (bookshelf[1][0].getType() != null) {
                for (int i = 0; i < bookshelf.length - 1 && flag; i++) {
                    if (bookshelf[i + 1][i] != null && bookshelf[i][i] != null) {
                        if (bookshelf[i + 1][i].getType() == null && bookshelf[i][i].getType() != null) {
                            flag = false;
                        }
                    }
                }
            }
        }
        else if (bookshelf[0][bookshelf[0].length-1] != null){
            if (bookshelf[0][bookshelf[0].length-1].getType() != null) {
                for (int i = 0; i < bookshelf.length - 1 && flag; i++) {
                    if(bookshelf[i][bookshelf[i].length - 1 - i] != null) {
                        if (bookshelf[i][bookshelf[i].length - 1 - i].getType() == null) {
                            flag = false;
                        }
                        if (i - 1 >= 0 && bookshelf[i - 1][bookshelf.length - 1 - i] != null) {
                            if (bookshelf[i - 1][bookshelf.length - 1 - i].getType() != null) {
                                flag = false;
                            }
                        }
                    }
                }
            }
        }
        else if(bookshelf[1][bookshelf[4].length-1] != null){
            if (bookshelf[1][bookshelf[4].length-1].getType() != null) {
                for (int i = 0; i < bookshelf.length - 1 && flag; i++) {
                    if (bookshelf[i + 1][bookshelf[i].length - 1 - i] != null && bookshelf[i][bookshelf.length - 1 - i] != null) {
                        if (bookshelf[i + 1][bookshelf.length - 1 - i].getType() == null && bookshelf[i][bookshelf.length - 1 - i].getType() != null) {
                            flag = false;
                        }
                    }
                }
            }
        }


        return flag;
    }
}
