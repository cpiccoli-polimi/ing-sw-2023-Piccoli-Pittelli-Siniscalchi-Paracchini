package it.polimi.model.CommonGoalCards;

import it.polimi.model.Type;
import it.polimi.model.ObjectCard;
import it.polimi.model.CommonGoalCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Common goal card 4: Four lines each formed by 5 tiles of
 *                     maximum three different types.
 *                     One line can show the same or a
 *                     different combination of another line
 *
 * @author Lorenzo Paracchini
 * @author Christian Piccoli
 * @author Nicola Siniscalchi
 */
public class CommonGoalCard4 extends CommonGoalCard {

    public CommonGoalCard4(int playersNumber) {
        super(4);
    }
    @Override
    public boolean check(ObjectCard[][] bookshelf) {
        List<Type> typeList= new ArrayList<>();
        int rowsCounter = 0;
        int rowSize = 0;

        for (int i = 0; i < bookshelf.length; i++) {
            for (int j = 0; j < bookshelf[i].length; j++) {
                if (bookshelf[i][j] != null) {
                    rowSize += 1;
                    if (!typeList.contains(bookshelf[i][j].getType())) {
                        typeList.add(bookshelf[i][j].getType());
                    }
                }
            }
            if (typeList.size() <= 3 && typeList.size() > 0) {
                if(rowSize == 5){
                        rowsCounter += 1;
                };
                if (rowsCounter == 4){ return true;}
            }
            typeList.clear();
            rowSize = 0;
        }
        return false;
    }
}
