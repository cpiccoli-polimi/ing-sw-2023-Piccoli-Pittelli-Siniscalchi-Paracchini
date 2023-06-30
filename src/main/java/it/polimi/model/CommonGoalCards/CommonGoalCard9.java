package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.ObjectCard;
import it.polimi.model.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Common goal card 9: Three columns each formed by 6
 *                     tiles of maximum three different types.
 *                     One column can show the same or a
 *                     different combination of another column
 *
 * @author Lorenzo Pittelli
 */
public class CommonGoalCard9 extends CommonGoalCard {
    public CommonGoalCard9(int playersNumber) {
        super(9);
    }
    @Override
    public boolean check(ObjectCard[][] bookshelf) {
        List<Type> typeList= new ArrayList<>();
        Type objectType;
        int tess;
        int count=0;
        for(int i=0; i<bookshelf[0].length;i++){
            tess=0;
            for(int j=0; j<bookshelf.length;j++){
                if(bookshelf[j][i]!=null){
                    objectType=bookshelf[j][i].getType();
                    if(objectType!=null) {
                        tess++;
                        if (!typeList.contains(objectType)) {
                            typeList.add(objectType);
                        }
                    }
                }
            }
            if(tess==bookshelf.length && typeList.size()<=3) {
                count++;
            }
            typeList.clear();
        }
        return count >= 3;
    }
}
