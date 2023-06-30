package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.ObjectCard;

/**
 * Common goal card 12: Five columns of increasing or decreasing height.
 *                      Starting from the first column on the left or on
 *                      the right, each next column must be made of exactly
 *                      one more tile. Tiles can be of any type
 *
 * @author Nicola Siniscalchi
 */
public class CommonGoalCard12 extends CommonGoalCard {
    public CommonGoalCard12(int playersNumber) {
        super(12);
    }

    @Override
    public boolean check(ObjectCard[][] bookshelf){
        boolean flag = true;

        for(int i = 0; i < bookshelf.length - 1; i++){
            if(bookshelf[i][i] == null || bookshelf[i][i].getType() == null){
                flag = false;
            }
            else if(i < bookshelf.length - 2 && bookshelf[i][i+1] != null){
                if(bookshelf[i][i+1].getType() != null) {
                    flag = false;
                }
            }
        }
        if(flag == true){
            return flag;
        }

        flag  = true;
        for(int i = 1; i < bookshelf.length; i++){
            if(bookshelf[i][i-1] == null || bookshelf[i][i-1].getType() == null){
                flag = false;
            }
            else if(bookshelf[i-1][i-1] != null){
                if(bookshelf[i-1][i-1].getType() != null) {
                    flag = false;
                }
            }
        }
        if(flag == true){
            return flag;
        }

        flag  = true;
        for(int i = 0; i < bookshelf.length - 1; i++){
            if(i > 0 && (bookshelf[i][bookshelf[i].length-i-1] == null || bookshelf[i][bookshelf[i].length-i-1].getType() == null)){
                flag = false;
            }
            else if(i < bookshelf.length - 2 && bookshelf[i][bookshelf[i].length-i-2] != null){
                if(bookshelf[i][bookshelf[i].length-i-2].getType() != null){
                    flag = false;
                }
            }
        }
        if(flag == true){
            return flag;
        }

        flag  = true;
        for(int i = 1; i < bookshelf.length; i++){
            if(bookshelf[i][bookshelf.length-1-i] == null || bookshelf[i][bookshelf.length-1-i].getType() == null){
                flag = false;
            }
            else if(bookshelf[i-1][bookshelf.length-1-i] != null){
                if(bookshelf[i][bookshelf.length-1-i].getType() != null){
                    flag = false;
                }
            }
        }
        if(flag == true){
            return flag;
        }
        return flag;
    }
}
