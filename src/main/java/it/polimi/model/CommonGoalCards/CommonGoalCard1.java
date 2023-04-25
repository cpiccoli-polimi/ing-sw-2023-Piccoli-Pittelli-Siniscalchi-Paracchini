package it.polimi.model.CommonGoalCards;

import it.polimi.model.*;

import java.util.ArrayList;

public class CommonGoalCard1 extends CommonGoalCard {
    public CommonGoalCard1(int playersNumber) {
        goalID = 1;
        // Deck creation
        points = new ArrayList<PointCard>();
    }
    public boolean check(ObjectCard[][] bookshelf) {
        boolean flag = false;
        int max = bookshelf.length;
        // Create an array to track already counted object
        // Array has [xCoordinate][yCoordinate] of counted tiles
        // It is initialized to -1 in every cell
        int[][] counted = new int[12][2];
        for(int j=0;j<12;j++){
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
                        for (int i = 0; i < counted.length; i++) {
                            if (counted[i][0] == -1) {
                                counted[i][0] = row;
                                counted[i][1] = col;
                                counted[i + 1][0] = row;
                                counted[i + 1][1] = col + 1;
                            }
                        }
                    }
                    // Same type below (if exists)
                    else if (row - 1 >= 0 && bookshelf[row][col].getType() == bookshelf[row - 1][col].getType()) {
                        for (int i = 0; i < counted.length; i++) {
                            if (counted[i][0] == -1) {
                                counted[i][0] = row;
                                counted[i][1] = col;
                                counted[i + 1][0] = row - 1;
                                counted[i + 1][1] = col;
                            }
                        }
                    }
                    // Same type on the left (if exists)
                    else if (col - 1 >= 0 && bookshelf[row][col].getType() == bookshelf[row][col - 1].getType()) {
                        for (int i = 0; i < counted.length; i++) {
                            if (counted[i][0] == -1) {
                                counted[i][0] = row;
                                counted[i][1] = col;
                                counted[i + 1][0] = row;
                                counted[i + 1][1] = col - 1;
                            }
                        }
                    }
                    // Same type above (if exists)
                    else if (row + 1 < max && bookshelf[row][col].getType() == bookshelf[row + 1][col].getType()) {
                        for (int i = 0; i < counted.length; i++) {
                            if (counted[i][0] == -1) {
                                counted[i][0] = row;
                                counted[i][1] = col;
                                counted[i + 1][0] = row + 1;
                                counted[i + 1][1] = col;
                            }
                        }
                    }
                    // If the array is full (found 6 couples): goal completed
                    if (counted.length == 12) {
                        flag = true;
                        return flag;
                    }
                }
            }
            // If the array is full (found 6 couples): goal completed
            if(counted.length == 12){
                flag = true;
                return flag;
            }
        }
        return flag;
    }
}
