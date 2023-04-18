package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;
import it.polimi.model.Type;
import it.polimi.model.ObjectCard;

public class CommonGoalCard7 extends CommonGoalCard {

    public CommonGoalCard7(int playersNumber) {
        goalID = 7;
        // Deck creation
        points = new PointCard[playersNumber];
    }
    @Override
    public boolean check(ObjectCard[][] bookshelf){
        int count=0;
        Type[] type =new Type[4];
        for(int r=0;r<bookshelf.length-1;r++){
            for(int c=0;c<bookshelf[r].length-1;c++){
                if(bookshelf[r][c]!=null && bookshelf[r+1][c]!=null && bookshelf[r][c+1]!=null && bookshelf[r+1][c+1]!=null){
                    type[0]=bookshelf[r][c].getType();
                    type[1]=bookshelf[r+1][c].getType();
                    type[2]=bookshelf[r][c+1].getType();
                    type[3]=bookshelf[r+1][c+1].getType();
                    if(type[0]==type[1] && type[0]==type[2] && type[0]==type[3]){
                        if(r==0 && c==0){ //angolo altoSX
                            if(bookshelf[0][2]!=null && bookshelf[1][2]!=null && bookshelf[2][0]!=null && bookshelf[2][1]!=null){
                                if(type[0]!=bookshelf[0][2].getType() && type[0]!=bookshelf[1][2].getType() && type[0]!=bookshelf[2][0].getType() && type[0]!=bookshelf[2][1].getType()){
                                    count++;
                                }
                            }
                        }
                        else if(r==0 && c==3){
                            if(bookshelf[0][2]!=null && bookshelf[1][2]!=null && bookshelf[2][3]!=null && bookshelf[2][4]!=null ){
                                if(type[0]!=bookshelf[0][2].getType() && type[0]!=bookshelf[1][2].getType() && type[0]!=bookshelf[2][3].getType() && type[0]!=bookshelf[2][4].getType()){
                                    count++;
                                }

                            }
                        }
                        else if(r==4 && c==0){
                            if(bookshelf[3][0]!=null && bookshelf[3][1]!=null && bookshelf[4][2]!=null && bookshelf[5][2]!=null){
                                if(type[0]!=bookshelf[3][0].getType() && type[0]!=bookshelf[3][1].getType() && type[0]!=bookshelf[4][2].getType() && type[0]!=bookshelf[5][2].getType()){
                                    count++;
                                }

                            }
                        }
                        else if(r==4 && c==3){
                            if(bookshelf[3][3]!=null && bookshelf[3][4]!=null && bookshelf[4][2]!=null && bookshelf[5][2]!=null){
                                if(type[0]!=bookshelf[3][3].getType() && type[0]!=bookshelf[3][4].getType() && type[0]!=bookshelf[4][2].getType() && type[0]!=bookshelf[5][2].getType()){
                                    count++;
                                }

                            }
                        }
                        else if(r==0){
                            if(bookshelf[0][c-1]!=null && bookshelf[0][c+2]!=null && bookshelf[1][c-1]!=null
                                    && bookshelf[1][c+2]!=null && bookshelf[2][c]!=null && bookshelf[2][c+1]!=null){
                                if(type[0]!=bookshelf[0][c-1].getType() && type[0]!=bookshelf[0][c+2].getType() && type[0]!=bookshelf[1][c-1].getType()
                                        && type[0]!=bookshelf[1][c+2].getType() && type[0]!=bookshelf[2][c].getType() && type[0]!=bookshelf[2][c+1].getType()){
                                    count++;
                                }

                            }

                        }
                        else if(c==0){
                            if(bookshelf[r-1][0]!=null && bookshelf[r+2][0]!=null && bookshelf[r-1][1]!=null
                                    && bookshelf[r+2][1]!=null && bookshelf[r][2]!=null && bookshelf[r+1][2]!=null){
                                if(type[0]!=bookshelf[r-1][0].getType() && type[0]!=bookshelf[r+2][0].getType() && type[0]!=bookshelf[r-1][1].getType()
                                        && type[0]!=bookshelf[r+2][1].getType() && type[0]!=bookshelf[r][2].getType() && type[0]!=bookshelf[r+1][2].getType()){
                                    count++;
                                }

                            }

                        }
                        else if(r==4){
                            if(bookshelf[3][c]!=null && bookshelf[3][c+1]!=null && bookshelf[r][c-1]!=null
                                    && bookshelf[r][c+2]!=null && bookshelf[r+1][c-1]!=null && bookshelf[r+1][c+2]!=null){
                                if(type[0]!=bookshelf[3][c].getType() && type[0]!=bookshelf[3][c+1].getType() && type[0]!=bookshelf[r][c-1].getType()
                                        && type[0]!=bookshelf[r][c+2].getType() && type[0]!=bookshelf[r+1][c-1].getType() && type[0]!=bookshelf[r+1][c+2].getType()){
                                    count++;
                                }

                            }

                        }
                        else if(c==3){
                            if(bookshelf[r-1][c]!=null && bookshelf[r-1][c+1]!=null && bookshelf[r][2]!=null
                                    && bookshelf[r+1][2]!=null && bookshelf[r+2][c]!=null && bookshelf[r+2][c+1]!=null){
                                if(type[0]!=bookshelf[r-1][c].getType() && type[0]!=bookshelf[r-1][c+1].getType() && type[0]!=bookshelf[r][2].getType()
                                        && type[0]!=bookshelf[r+1][2].getType() && type[0]!=bookshelf[r+2][c].getType() && type[0]!=bookshelf[r+2][c+1].getType()){
                                    count++;
                                }

                            }

                        }
                        else {
                            if(bookshelf[r-1][c]!=null && bookshelf[r-1][c+1]!=null
                                    && bookshelf[r][c-1]!=null && bookshelf[r][c+2]!=null
                                    && bookshelf[r+1][c-1]!=null && bookshelf[r+1][c+2]!=null
                                    && bookshelf[r+2][c]!=null && bookshelf[r+2][c+1]!=null){
                                if(type[0]!=bookshelf[r-1][c].getType() && type[0]!=bookshelf[r-1][c+1].getType()
                                        && type[0]!=bookshelf[r][c-1].getType() && type[0]!=bookshelf[r][c+2].getType()
                                        && type[0]!=bookshelf[r+1][c-1].getType() && type[0]!=bookshelf[r+1][c+2].getType()
                                        && type[0]!=bookshelf[r+2][c].getType() && type[0]!=bookshelf[r+2][c+1].getType()){
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (count <= 1) {
            return false;
        }
        else return true;
    }
}
