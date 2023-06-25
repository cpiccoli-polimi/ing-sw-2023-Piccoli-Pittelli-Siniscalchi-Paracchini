package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.ObjectCard;

public class CommonGoalCard6 extends CommonGoalCard {

    public CommonGoalCard6(int playersNumber) {
        super(6);
    }
    @Override
    public boolean check(ObjectCard[][] bookshelf) {
        int columnsCounter = 0;
        for(int col=0;col<bookshelf[0].length-1;col++){
            for(int row=0;row< bookshelf.length-1;row++){
                if(bookshelf[row][col] != null && bookshelf[row+1][col] != null){
                    if(bookshelf[row][col].getType() == bookshelf[row+1][col].getType()){
                        return false;
                    }
                    if(row == bookshelf[0].length-1){
                        columnsCounter+=1;
                        if(columnsCounter == 2){
                            return true;
                        }
                    }
                }
            }
        }
    return false;
    }
}
