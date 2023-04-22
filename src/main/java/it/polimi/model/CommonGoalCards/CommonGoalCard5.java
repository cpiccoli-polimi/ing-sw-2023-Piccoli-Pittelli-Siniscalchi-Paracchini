package it.polimi.model.CommonGoalCards;

import it.polimi.model.*;

public class CommonGoalCard5 extends CommonGoalCard {
    public CommonGoalCard5(int playersNumber) {
        goalID = 5;
        // Deck creation
        points = new PointCard[playersNumber];
    }
    public boolean check(ObjectCard[][] bookshelf) {
        boolean flag = false;
        int max = bookshelf.length;
        // Create an array to track already counted object
        // Array has [xCoordinate][yCoordinate] of counted tiles
        // It is initialized to -1 in every cell
        int[][] counted = new int[16][2];
        for(int j=0;j<16;j++){
            counted[j][0] = -1;
            counted[j][1] = -1;
        }
        for(int row=0;row<max;row++){
            for(int col=0;col<max;col++){
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
                if(alreadyCounted == false) {
                    // Same type on the right (if exists)
                    if (col + 1 < max && bookshelf[row][col].getType() == bookshelf[row][col + 1].getType()) {
                        if (col + 2 < max && bookshelf[row][col].getType() == bookshelf[row][col + 2].getType()) {
                            if (col + 3 < max && bookshelf[row][col].getType() == bookshelf[row][col + 3].getType()) {
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
                    // Same type on the bottom (if exists)
                    else if (row + 1 >= 0 && bookshelf[row][col].getType() == bookshelf[row + 1][col].getType()) {
                        if (row + 2 >= 0 && bookshelf[row][col].getType() == bookshelf[row + 2][col].getType()) {
                            if (row + 3 >= 0 && bookshelf[row][col].getType() == bookshelf[row + 3][col].getType()) {
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
                    // If the array is full (found 4 quartets): goal completed
                    if (counted.length == 16) {
                        flag = true;
                        return flag;
                    }
                }
            }
            // If the array is full (found 4 quartets): goal completed
            if(counted.length == 16){
                flag = true;
                return flag;
            }
        }
        return flag;
    }
}
