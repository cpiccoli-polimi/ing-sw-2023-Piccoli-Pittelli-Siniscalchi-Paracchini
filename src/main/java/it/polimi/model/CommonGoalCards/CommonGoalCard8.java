package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.ObjectCard;
import it.polimi.model.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Common goal card 8: Two lines each formed by 5
 *                     different types of tiles.
 *                     One line can show the same or a
 *                     different combination of the other line
 *
 * @author Nicola Siniscalchi
 * @author Christian Piccoli
 */
public class CommonGoalCard8 extends CommonGoalCard {
    public CommonGoalCard8(int playersNumber) {
        super(8);
    }

    @Override
    public boolean check(ObjectCard[][] bookshelf) {
        List<Type> typesList = new ArrayList<>();
        Type objectType;
        boolean flag = true;
        int rowsCounter = 0;

        for(int i = 0; i < bookshelf.length; i++){
            for(int j = 0; j <= bookshelf[i].length - 5 && flag; j++){
                typesList.clear();
                flag = true;
                for(int k = j; k < j+5 && flag; k++){
                    if(bookshelf[i][k] != null) {
                        objectType = bookshelf[i][k].getType();
                        if (!typesList.contains(objectType)) {
                            typesList.add(objectType);
                        } else {
                            flag = false;
                        }
                    }
                    else if(bookshelf[i][k] == null){
                        flag = false;
                    }
                }
                if(flag){
                    rowsCounter += 1;
                }
                else{
                    flag = true;
                }
            }
        }

        return rowsCounter >= 2;
    }
}
