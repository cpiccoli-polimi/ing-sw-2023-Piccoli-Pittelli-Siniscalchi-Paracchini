package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.ObjectCard;
import it.polimi.model.PointCard;
import it.polimi.model.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonGoalCard8 extends CommonGoalCard {
    public CommonGoalCard8(int playersNumber) {
        goalID = 8;
        // Deck creation
        points = new ArrayList<PointCard>();
    }

    @Override
    public boolean check(ObjectCard[][] bookshelf) {
        List<Type> typesList = new ArrayList<Type>();
        Type objectType;
        boolean flag = true;
        int rowsCounter = 0;

        for(int i = 0; i < bookshelf.length; i++){
            for(int j = 0; j <= bookshelf[i].length - 5 && flag == true; j++){
                typesList.clear();
                flag = true;
                for(int k = j; k < j+5 && flag == true; k++){
                    objectType = bookshelf[i][k].getType();
                    if(typesList.contains(objectType) == false){
                        typesList.add(objectType);
                    }
                    else{
                        flag = false;
                    }
                }
                if(flag == true){
                    rowsCounter += 1;
                    flag = false;
                }
                else{
                    flag = true;
                }
            }
        }

        if(rowsCounter == 2){
            return true;
        }
        else{
            return false;
        }
    }
}
