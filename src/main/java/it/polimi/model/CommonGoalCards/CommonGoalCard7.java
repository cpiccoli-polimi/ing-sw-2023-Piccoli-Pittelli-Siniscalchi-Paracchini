package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;
import it.polimi.model.Type;
import it.polimi.model.ObjectCard;

import java.util.ArrayList;

public class CommonGoalCard7 extends CommonGoalCard {

    public CommonGoalCard7(int playersNumber) {
        super(7);
    }
    @Override
    public boolean check(ObjectCard[][] bookshelf) {
        int count = 0;
        for(int r=0;r<bookshelf.length-1;r++) {
            for (int c = 0; c < bookshelf[r].length - 1; c++) {
                if (bookshelf[r][c]!=null && bookshelf[r+1][c]!=null && bookshelf[r][c+1]!=null && bookshelf[r+1][c+1]!=null && bookshelf[r][c].getType()!=null && bookshelf[r+1][c].getType()!=null && bookshelf[r][c+1].getType()!=null && bookshelf[r+1][c+1].getType()!=null) {
                    if (bookshelf[r][c].getType() == bookshelf[r+1][c].getType() && bookshelf[r][c].getType() == bookshelf[r][c+1].getType() && bookshelf[r][c].getType() == bookshelf[r+1][c+1].getType()) {
                        if (r == 0 && c == 0) { // upper left corner
                            if (bookshelf[r][c + 2] != null && bookshelf[r + 1][c + 2] != null && bookshelf[r + 2][c] != null && bookshelf[r + 2][c + 1] != null) {
                                if (bookshelf[r][c + 2].getType() != null && bookshelf[r + 1][c + 2].getType() != null && bookshelf[r + 2][c].getType() != null && bookshelf[r + 2][c + 1].getType() != null) {
                                    if(bookshelf[r][c].getType()!=bookshelf[r][c + 2].getType() && bookshelf[r][c].getType()!=bookshelf[r + 1][c + 2].getType() && bookshelf[r][c].getType()!=bookshelf[r + 2][c].getType() && bookshelf[r][c].getType()!=bookshelf[r + 2][c + 1].getType()){
                                        count++;
                                    }
                                }
                            }
                        } else if (r == 0 && c == bookshelf[0].length - 2) { // upper right corner
                            if(bookshelf[r][c-1]!=null && bookshelf[r+1][c-1]!=null && bookshelf[r+2][c]!=null && bookshelf[r+2][c+1]!=null){
                                if(bookshelf[r][c-1].getType()!=null && bookshelf[r+1][c-1].getType()!=null && bookshelf[r+2][c].getType()!=null && bookshelf[r+2][c+1].getType()!=null){
                                    if(bookshelf[r][c].getType()!=bookshelf[r][c-1].getType() && bookshelf[r][c].getType()!=bookshelf[r+1][c-1].getType() && bookshelf[r][c].getType()!=bookshelf[r+2][c].getType() && bookshelf[r][c].getType()!=bookshelf[r+2][c+1].getType()){
                                        count++;
                                    }
                                }
                            }

                        } else if (r == bookshelf.length - 2 && c == 0) { // lower left corner
                            if(bookshelf[r-1][c]!=null && bookshelf[r-1][c+1]!=null && bookshelf[r][c+2]!=null && bookshelf[r+1][c+2]!=null){
                                if(bookshelf[r-1][c].getType()!=null && bookshelf[r-1][c+1].getType()!=null && bookshelf[r][c+2].getType()!=null && bookshelf[r+1][c+2].getType()!=null){
                                    if(bookshelf[r][c].getType()!=bookshelf[r-1][c].getType() && bookshelf[r][c].getType()!=bookshelf[r-1][c+1].getType() && bookshelf[r][c].getType()!=bookshelf[r][c+2].getType() && bookshelf[r][c].getType()!=bookshelf[r+1][c+2].getType()){
                                        count++;
                                    }
                                }
                            }
                        } else if (r == bookshelf.length - 2 && c == bookshelf[0].length - 2) { // lower right corner
                            if(bookshelf[r-1][c]!=null && bookshelf[r-1][c+1]!=null && bookshelf[r][c-1]!=null && bookshelf[r+1][c-1]!=null){
                                if(bookshelf[r-1][c].getType()!=null && bookshelf[r-1][c+1].getType()!=null && bookshelf[r][c-1].getType()!=null && bookshelf[r+1][c-1].getType()!=null){
                                    if(bookshelf[r][c].getType()!=bookshelf[r-1][c].getType() && bookshelf[r][c].getType()!=bookshelf[r-1][c+1].getType() && bookshelf[r][c].getType()!=bookshelf[r][c-1].getType() && bookshelf[r][c].getType()!=bookshelf[r+1][c-1].getType()){
                                        count++;
                                    }
                                }
                            }

                        } else if(c==0 && (r==1 || r==2 || r==3)){ // left side
                            if(bookshelf[r-1][c]!=null && bookshelf[r-1][c+1]!=null && bookshelf[r][c+2]!=null && bookshelf[r+1][c+2]!=null && bookshelf[r+2][c]!=null && bookshelf[r+2][c+1]!=null){
                                if(bookshelf[r-1][c].getType()!=null && bookshelf[r-1][c+1].getType()!=null && bookshelf[r][c+2].getType()!=null && bookshelf[r+1][c+2].getType()!=null && bookshelf[r+2][c].getType()!=null && bookshelf[r+2][c+1].getType()!=null){
                                    if(bookshelf[r][c].getType()!=bookshelf[r-1][c].getType() && bookshelf[r][c].getType()!=bookshelf[r-1][c+1].getType() && bookshelf[r][c].getType()!=bookshelf[r][c+2].getType() && bookshelf[r][c].getType()!=bookshelf[r+1][c+2].getType() && bookshelf[r][c].getType()!=bookshelf[r+2][c].getType() && bookshelf[r][c].getType()!=bookshelf[r+2][c+1].getType()){
                                        count++;
                                    }
                                }
                            }

                        } else if(c==bookshelf[0].length-2 && (r==1 || r==2 || r==3)){ // right side
                            if(bookshelf[r-1][c]!=null && bookshelf[r-1][c+1]!=null && bookshelf[r][c-1]!=null && bookshelf[r+1][c-1]!=null && bookshelf[r+2][c]!=null && bookshelf[r+2][c+1]!=null){
                                if(bookshelf[r-1][c].getType()!=null && bookshelf[r-1][c+1].getType()!=null && bookshelf[r][c-1].getType()!=null && bookshelf[r+1][c-1].getType()!=null && bookshelf[r+2][c].getType()!=null && bookshelf[r+2][c+1].getType()!=null) {
                                    if (bookshelf[r][c].getType() != bookshelf[r - 1][c].getType() && bookshelf[r][c].getType() != bookshelf[r - 1][c + 1].getType() && bookshelf[r][c].getType() != bookshelf[r][c - 1].getType() && bookshelf[r][c].getType() != bookshelf[r + 1][c - 1].getType() && bookshelf[r][c].getType() != bookshelf[r + 2][c].getType() && bookshelf[r][c].getType() != bookshelf[r + 2][c + 1].getType()) {
                                        count++;
                                    }
                                }
                            }

                        } else if(r==0 && (c==1 || c==2)){ // upper side
                            if(bookshelf[r][c-1]!=null && bookshelf[r+1][c-1]!=null && bookshelf[r+2][c]!=null && bookshelf[r+2][c+1]!=null && bookshelf[r][c+2]!=null && bookshelf[r+1][c+2]!=null){
                                if(bookshelf[r][c-1].getType()!=null && bookshelf[r+1][c-1].getType()!=null && bookshelf[r+2][c].getType()!=null && bookshelf[r+2][c+1].getType()!=null && bookshelf[r][c+2].getType()!=null && bookshelf[r+1][c+2].getType()!=null){
                                    if(bookshelf[r][c].getType()!=bookshelf[r][c-1].getType() && bookshelf[r][c].getType()!=bookshelf[r+1][c-1].getType() && bookshelf[r][c].getType()!=bookshelf[r+2][c].getType() && bookshelf[r][c].getType()!=bookshelf[r+2][c+1].getType() && bookshelf[r][c].getType()!=bookshelf[r][c+2].getType() && bookshelf[r][c].getType()!=bookshelf[r+1][c+2].getType()){
                                        count++;
                                    }
                                }
                            }
                        } else if(r==bookshelf.length-2 && (c==1 || c==2)){ // lower side
                            if(bookshelf[r][c-1]!=null && bookshelf[r+1][c-1]!=null && bookshelf[r-1][c]!=null && bookshelf[r-1][c+1]!=null && bookshelf[r][c+2]!=null && bookshelf[r+1][c+2]!=null){
                                if(bookshelf[r][c-1].getType()!=null && bookshelf[r+1][c-1].getType()!=null && bookshelf[r-1][c].getType()!=null && bookshelf[r-1][c+1].getType()!=null && bookshelf[r][c+2].getType()!=null && bookshelf[r+1][c+2].getType()!=null){
                                    if(bookshelf[r][c].getType()!=bookshelf[r][c-1].getType() && bookshelf[r][c].getType()!=bookshelf[r+1][c-1].getType() && bookshelf[r][c].getType()!=bookshelf[r-1][c].getType() && bookshelf[r][c].getType()!=bookshelf[r-1][c+1].getType() && bookshelf[r][c].getType()!=bookshelf[r][c+2].getType() && bookshelf[r][c].getType()!=bookshelf[r+1][c+2].getType()){
                                        count++;
                                    }
                                }
                            }
                        }
                        else{
                            if(bookshelf[r][c-1]!=null && bookshelf[r+1][c-1]!=null && bookshelf[r-1][c]!=null && bookshelf[r-1][c+1]!=null && bookshelf[r][c+2]!=null && bookshelf[r+1][c+2]!=null && bookshelf[r+2][c]!=null && bookshelf[r+2][c+1]!=null){
                                if(bookshelf[r][c-1].getType()!=null && bookshelf[r+1][c-1].getType()!=null && bookshelf[r-1][c].getType()!=null && bookshelf[r-1][c+1].getType()!=null && bookshelf[r][c+2].getType()!=null && bookshelf[r+1][c+2].getType()!=null && bookshelf[r+2][c].getType()!=null && bookshelf[r+2][c+1].getType()!=null){
                                    if(bookshelf[r][c].getType()!=bookshelf[r][c-1].getType() && bookshelf[r][c].getType()!=bookshelf[r+1][c-1].getType() && bookshelf[r][c].getType()!=bookshelf[r-1][c].getType() && bookshelf[r][c].getType()!=bookshelf[r-1][c+1].getType() && bookshelf[r][c].getType()!=bookshelf[r][c+2].getType() && bookshelf[r][c].getType()!=bookshelf[r+1][c+2].getType() && bookshelf[r][c].getType()!=bookshelf[r+2][c].getType() && bookshelf[r][c].getType()!=bookshelf[r+2][c+1].getType()){
                                        count++;
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
        if(count>1) return true;
        else return false;
    }
}
