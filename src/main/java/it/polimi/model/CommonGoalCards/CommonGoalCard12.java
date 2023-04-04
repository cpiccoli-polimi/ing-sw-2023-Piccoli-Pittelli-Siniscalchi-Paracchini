package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;

public class CommonGoalCard12 extends CommonGoalCard {
    public CommonGoalCard12(int playersNumber) {
        goalID = 12;
        // Deck creation
        points = new PointCard[playersNumber];
    }

    @Override
    public boolean check(ObjectCard[][] bookshelf){
        boolean flag = true;

        if(bookshelf[0][0].getType() != null){
            for(int i = 0; i < bookshelf.length - 1 && flag == true; i++) {
                if(bookshelf[i][i].getType() == null){
                    flag = false;
                }
                if(i - 1 >= 0){
                    if(bookshelf[i - 1][i].getType() != null){
                        flag = false;
                    }
                }
            }
        }
        else if(bookshelf[1][0].getType() != null){
            for(int i = 0; i < bookshelf.length - 1 && flag == true; i++) {
                if(bookshelf[i+1][i].getType() == null && bookshelf[i][i].getType() != null){
                    flag = false;
                }
            }
        }
        else if(bookshelf[0][bookshelf[0].length].getType() != null){
            for(int i = 0; i < bookshelf.length - 1 && flag == true){
                if(bookshelf[i][bookshelf.length - 1 - i].getType() == null){
                    flag = false;
                }
                if(i - 1 >= 0){
                    if(bookshelf[i - 1][bookshelf.length - 1 - i].getType() != null){
                        flag = false;
                    }
                }
            }

        }
        else if(bookshelf[1][bookshelf[4].length].getType() != null){
            for(int i = 0; i < bookshelf.length - 1 && flag == true; i++) {
                if(bookshelf[i+1][bookshelf.length - 1 - i].getType() == null && bookshelf[i][bookshelf.length - 1 - i].getType() !=null){
                    flag = false;
                }
            }
        }

        return flag;
    }
}
