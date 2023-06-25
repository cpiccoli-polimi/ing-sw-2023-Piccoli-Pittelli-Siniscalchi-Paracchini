package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.ObjectCard;

public class CommonGoalCard5 extends CommonGoalCard {
    public CommonGoalCard5(int playersNumber) {
        super(5);
    }
    public boolean check(ObjectCard[][] bookshelf) {
        boolean flag = false;
        int count = 0;
        int maxrow = bookshelf.length;
        int maxcol = bookshelf[0].length;
        // Create an array to track already counted object
        // Array has [xCoordinate][yCoordinate] of counted tiles
        // It is initialized to -1 in every cell
        int[][] counted = new int[16][2];
        for(int j=0;j<16;j++){
            counted[j][0] = -1;
            counted[j][1] = -1;
        }
        for(int row=0;row<maxrow;row++){
            for(int col=0;col<maxcol;col++){
                // Has this tile been already counted?
                boolean alreadyCounted = false;
                for(int crow=0;crow<counted.length;crow++){
                    // This combination of [row][col] is in the array
                    if(counted[crow][1] == row && counted[crow][2] == col){
                        //Skip to next cycle
                        alreadyCounted = true;
                        break;
                    }
                }
                if(!alreadyCounted) {
                    // Same type on the right (if exists)
                    if (bookshelf[row][col] != null && bookshelf[row][col + 1] != null && bookshelf[row][col + 2] != null && bookshelf[row][col + 3] != null){
                        if (col + 1 < maxcol && bookshelf[row][col].getType() == bookshelf[row][col + 1].getType()) {
                            if (col + 2 < maxcol && bookshelf[row][col].getType() == bookshelf[row][col + 2].getType()) {
                                if (col + 3 < maxcol && bookshelf[row][col].getType() == bookshelf[row][col + 3].getType()) {
                                    for (int i = 0; i < counted.length; i++) {
                                        if (counted[i][0] == -1) {
                                            counted[i][0] = row;
                                            counted[i][1] = col;
                                            counted[i + 1][0] = row;
                                            counted[i + 1][1] = col + 1;
                                            counted[i + 2][0] = row;
                                            counted[i + 2][1] = col + 2;
                                            counted[i + 3][0] = row;
                                            counted[i + 3][1] = col + 3;
                                        }
                                    }
                                }
                            }
                        }
                }
                    // Same type on the bottom (if exists)
                    else if (bookshelf[row][col] != null && bookshelf[row+1][col] != null && bookshelf[row+2][col] != null && bookshelf[row+3][col] != null) {
                        if (bookshelf[row][col].getType() == bookshelf[row + 1][col].getType()) {
                            if (bookshelf[row][col].getType() == bookshelf[row + 2][col].getType()) {
                                if (bookshelf[row][col].getType() == bookshelf[row + 3][col].getType()) {
                                    for (int i = 0; i < counted.length; i++) {
                                        if (counted[i][0] == -1) {
                                            counted[i][0] = row;
                                            counted[i][1] = col;
                                            counted[i + 1][0] = row + 1;
                                            counted[i + 1][1] = col;
                                            counted[i + 2][0] = row + 2;
                                            counted[i + 2][1] = col;
                                            counted[i + 3][0] = row + 3;
                                            counted[i + 3][1] = col;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    // If the array is full (found 4 quartets): goal completed
                    for(int j=0;j< counted.length;j++) {
                        if(counted[j][0] != -1){
                            count += 1;
                        }
                        if (count == 16) {
                            flag = true;
                            return flag;
                        }
                    }
                }
            }
            // If the array is full (found 4 quartets): goal completed
            for(int j=0;j< counted.length;j++) {
                if(counted[j][0] != -1){
                    count += 1;
                }
                if (count == 16) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }
}
