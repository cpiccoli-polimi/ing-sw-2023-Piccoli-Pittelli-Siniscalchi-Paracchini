package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.ObjectCard;

import java.util.ArrayList;
import java.util.List;

/*public class CommonGoalCard1 extends CommonGoalCard {
    public CommonGoalCard1(int playersNumber) {
        super(1);
    }
    public boolean check(ObjectCard[][] bookshelf) {
        boolean flag = false;
        int count = 0;
        int maxrow = bookshelf.length;
        int maxcol = bookshelf[0].length;
        // Create an array to track already counted object
        // Array has [xCoordinate][yCoordinate] of counted tiles
        // It is initialized to -1 in every cell
        int[][] counted = new int[12][2];
        for(int j=0;j<12;j++){
            counted[j][0] = -1;
            counted[j][1] = -1;
        }
        for(int row=0;row<maxrow;row++){
            count = 0;
            for(int col=0;col<maxcol;col++){
                // Has this tile been already counted?
                boolean alreadyCounted = false;
                for(int crow=0;crow<counted.length;crow++){
                    // This combination of [row][col] is in the array
                    if(counted[crow][0] == row && counted[crow][1] == col){
                        //Skip to next cycle
                        alreadyCounted = true;
                        break;
                    }
                }
                if(!alreadyCounted) {
                    // Same type on the right (if exists)
                    if(col+1 < maxcol && bookshelf[row][col] != null && bookshelf[row][col + 1] != null) {
                        if (bookshelf[row][col].getType() == bookshelf[row][col + 1].getType()) {
                            for (int i = 0; i < counted.length; i++) {
                                if (counted[i][0] == -1) {
                                    counted[i][0] = row;
                                    counted[i][1] = col;
                                    counted[i + 1][0] = row;
                                    counted[i + 1][1] = col + 1;
                                }
                            }
                        }
                    }
                    // Same type below (if exists)
                    else if (row-1 >= 0 && bookshelf[row][col] != null && bookshelf[row-1][col] != null) {
                        if (bookshelf[row][col].getType() == bookshelf[row - 1][col].getType()) {
                            for (int i = 0; i < counted.length; i++) {
                                if (counted[i][0] == -1) {
                                    counted[i][0] = row;
                                    counted[i][1] = col;
                                    counted[i + 1][0] = row - 1;
                                    counted[i + 1][1] = col;
                                }
                            }
                        }
                    }
                    // Same type on the left (if exists)
                    else if (col - 1 >= 0 && bookshelf[row][col] != null && bookshelf[row][col - 1] != null) {
                        if (bookshelf[row][col].getType() == bookshelf[row][col - 1].getType()) {
                            for (int i = 0; i < counted.length; i++) {
                                if (counted[i][0] == -1) {
                                    counted[i][0] = row;
                                    counted[i][1] = col;
                                    counted[i + 1][0] = row;
                                    counted[i + 1][1] = col - 1;
                                }
                            }
                        }
                    }
                    // Same type above (if exists)
                    else if (row+1 < maxrow && bookshelf[row][col] != null && bookshelf[row + 1][col] != null) {
                        if (bookshelf[row][col].getType() == bookshelf[row + 1][col].getType()) {
                            for (int i = 0; i < counted.length; i++) {
                                if (counted[i][0] == -1) {
                                    counted[i][0] = row;
                                    counted[i][1] = col;
                                    counted[i + 1][0] = row + 1;
                                    counted[i + 1][1] = col;
                                }
                            }
                        }
                    }
                    // If the array is full (found 6 couples): goal completed
                    for(int j=0;j< counted.length;j++) {
                        if(counted[j][0] != -1){
                            count += 1;
                        }
                        if (count == 12) {
                            flag = true;
                            return flag;
                        }
                    }
                }
            }
            // If the array is full (found 6 couples): goal completed
            for(int j=0;j< counted.length;j++) {
                if(counted[j][0] != -1){
                    count += 1;
                }
                if (count == 12) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }
}*/

public class CommonGoalCard1 extends CommonGoalCard {
    public CommonGoalCard1(int playersNumber) {
        super(1);
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
                if(objectList.size()>=2) count++;
                objectList.clear();
                }
            }
        return count >= 6;
    }
}

