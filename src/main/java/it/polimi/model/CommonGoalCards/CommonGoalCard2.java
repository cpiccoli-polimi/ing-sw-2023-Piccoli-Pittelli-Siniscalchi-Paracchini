package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.ObjectCard;

public class CommonGoalCard2 extends CommonGoalCard {

    public CommonGoalCard2(int playersNumber) {
        super(2);
    }
    @Override
    public boolean check(ObjectCard[][] bookshelf) {
        boolean satisfied = false;

        // Top left
        for(int i = 0; i < bookshelf[0].length; i++) {
            if(i == (bookshelf[0].length-1)){
                if (bookshelf[i][i] == null){ break;}
            }
            else if (bookshelf[0][0] != null && bookshelf[0][0].getType() != bookshelf[i + 1][i + 1].getType() || bookshelf[i][i] == null) {
                break;
            }
            else satisfied = true;
        }
        // Second row top left
        for(int i = 0; i < bookshelf[0].length; i++) {
            if(i == (bookshelf[0].length-1)){
                if (bookshelf[i+1][i] == null){ break;}
            }
            else if (bookshelf[1][0] != null && bookshelf[1][0].getType() != bookshelf[i + 2][i + 1].getType() || bookshelf[i][i] == null) {
                break;
            }
            else satisfied = true;
        }
        // Bottom left
        if(!satisfied) {
            for (int i = 0; i < bookshelf[0].length; i++) {
                if(i == (bookshelf[0].length-1)){
                    if (bookshelf[i][i] == null){ break;}
                }
                else if (bookshelf[5][0] != null && bookshelf[5][0].getType() != bookshelf[5 - i][i + 1].getType() || bookshelf[5 - i][i] == null) {
                    break;
                }
                else satisfied = true;
            }
        }
        // Second bottom left
        if(!satisfied) {
            for (int i = 0; i < bookshelf[0].length; i++) {
                if(i == (bookshelf[0].length-1)){
                    if (bookshelf[i][i] == null){ break;}
                }
                else if (bookshelf[4][0] != null && bookshelf[4][0].getType() != bookshelf[4 - i][i + 1].getType() || bookshelf[5 - i][i] == null) {
                    break;
                }
                else satisfied = true;
            }
        }
        return satisfied;
    }
}
