package it.polimi.model.CommonGoalCards;

import it.polimi.model.Type;
import it.polimi.model.ObjectCard;
import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;

import java.util.ArrayList;
import java.util.List;

public class CommonGoalCard4 extends CommonGoalCard {

    public CommonGoalCard4(int playersNumber) {
        super(4);
    }
    @Override
    public boolean check(ObjectCard[][] bookshelf) {
        List<Type> typeList= new ArrayList<Type>();
        int rowsCounter = 0;

        for (int i = 0; i < bookshelf[0].length; i++) {
            for (int j = 0; j < bookshelf.length; j++) {

                if (bookshelf[j][i].getType() != null) {

                    if (!typeList.contains(bookshelf[j][i].getType())) {
                        typeList.add(bookshelf[j][i].getType());
                    }
                }else {
                    continue;
                }
            }

            if (typeList.size() <= 3) {
                rowsCounter += 1;
            }

            typeList.clear();
        }

        if (rowsCounter < 4){ return false; }
        else { return true; }
    }
}
