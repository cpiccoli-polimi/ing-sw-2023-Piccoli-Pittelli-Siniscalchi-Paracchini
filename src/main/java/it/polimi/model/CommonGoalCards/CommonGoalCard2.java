package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.ObjectCard;

public class CommonGoalCard2 extends CommonGoalCard {

    public CommonGoalCard2(int playersNumber) {
        super(2);
    }
    @Override
    public boolean check(ObjectCard[][] bookshelf) {
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
        if(flag == false){
            return flag;
        }

        // Top left
        for(int i = 0; i < bookshelf[0].length; i++) {
            if(bookshelf[0][0] == null){
                break;
            }
            else if (i+1 < bookshelf[0].length && (bookshelf[i + 1][i + 1] == null || bookshelf[0][0].getType() != bookshelf[i + 1][i + 1].getType())) {
                flag = false;
                break;
            }
        }

        // Second row top left
        if(flag) {
            for (int i = 0; i < bookshelf[0].length; i++) {
                if (bookshelf[1][0] == null) {
                    break;
                }
                else if (i+1 < bookshelf[0].length && (bookshelf[i + 2][i + 1] == null || bookshelf[1][0].getType() != bookshelf[i + 2][i + 1].getType())) {
                    flag = false;
                    break;
                }
            }
        }

        // Second bottom left
        if(flag) {
            for (int i = 0; i < bookshelf[0].length; i++) {
                if(bookshelf[4][0] == null){
                    break;
                }
                else if (bookshelf[4 - i][i] == null || bookshelf[4][0].getType() != bookshelf[4 - i][i].getType()) {
                    flag = false;
                    break;
                }
            }
        }

        // Bottom left
        if(flag) {
            for (int i = 0; i < bookshelf[0].length; i++) {
                if(bookshelf[5][0] == null){
                    break;
                }
                else if (bookshelf[5 - i][i] == null || bookshelf[5][0].getType() != bookshelf[5 - i][i].getType()) {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }
}
