package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;
import it.polimi.model.ObjectCard;

import it.polimi.model.Type;
import java.util.Arrays;

public class CommonGoalCard11 extends CommonGoalCard {
    public CommonGoalCard11(int playersNumber) {
        goalID = 11;
        // Deck creation
        points = new PointCard[playersNumber];
    }

    @Override
    public boolean check(ObjectCard[][] bookshelf){
        int[] a;
        int k=-1;
        Type objectType;
        a= new int[Type.values().length];
        Arrays.fill(a,0);
        for(int i=0;i<bookshelf.length;i++){
            for(int j=0;j<bookshelf[0].length && bookshelf[i][j].getType()!=null;j++){
                objectType=bookshelf[i][j].getType();
                if(objectType!=null){
                    k=objectType.ordinal();
                    a[k]++;
                    if(a[k]==8){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}