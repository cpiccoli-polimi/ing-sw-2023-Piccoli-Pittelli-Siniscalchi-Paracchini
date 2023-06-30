package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.ObjectCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Common goal card 5: Four groups each containing at least
 *                     4 tiles of the same type.
 *                     The tiles of one group can be
 *                     different from those of another group
 *
 * @author Lorenzo Pittelli
 * @author Christian Piccoli
 */
public class CommonGoalCard5 extends CommonGoalCard {
    public CommonGoalCard5(int playersNumber) {
        super(5);
    }
    public boolean check(ObjectCard[][] bookshelf) {
        int count=0;
        ObjectCard [][] bookshelfCopy=new ObjectCard[bookshelf.length][bookshelf[0].length];
        for(int i=0;i <bookshelf.length;i++){
            for(int j=0;j<bookshelf[0].length;j++){
                bookshelfCopy[i][j]=bookshelf[i][j];
            }
        }

        for(int r=0;r< bookshelf.length;r++){
            for(int c=0;c<bookshelf[0].length;c++){
                List<ObjectCard> objectList= new ArrayList<>();
                if(bookshelfCopy[r][c]!=null) {
                    objectList.add(bookshelfCopy[r][c]);
                    for (int r2 = 0; r2 < bookshelf.length; r2++) {
                        for (int c2 = 0; c2 < bookshelf[0].length; c2++) {
                            if (bookshelfCopy[r2][c2] != null && bookshelfCopy[r2][c2].getType() != null) {
                                if (bookshelfCopy[r2][c2].getType() == objectList.get(0).getType()) {
                                    if ((c2 > 0 && objectList.contains(bookshelfCopy[r2][c2 - 1])) || (r2 > 0 && objectList.contains(bookshelfCopy[r2 - 1][c2]))) {
                                        if (!objectList.contains(bookshelfCopy[r2][c2])) {
                                            objectList.add(bookshelfCopy[r2][c2]);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                for(int i=0;i< bookshelf.length;i++){
                    for(int j=0;j<bookshelf[i].length;j++){
                        for(int k=0;k<objectList.size();k++){
                            if(bookshelfCopy[i][j]!=null){
                                if(bookshelfCopy[i][j].getId()==objectList.get(k).getId()){
                                    bookshelfCopy[i][j]=null;
                                }
                            }
                        }
                    }
                }
                /*for(int k=0;k<objectList.size();k++){
                    bookshelfCopy[objectList.get(k).getXCoordinate()][objectList.get(k).getYCoordinate()]=null;
                }*/
                if(objectList.size()>=4) count++;
                objectList.clear();
            }
        }

        return count >= 4;
    }
}
