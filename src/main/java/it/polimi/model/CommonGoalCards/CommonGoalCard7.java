package it.polimi.model.CommonGoalCards;

import it.polimi.model.CommonGoalCard;
import it.polimi.model.PointCard;
import it.polimi.model.Type;

import java.util.Arrays;

public class CommonGoalCard7 extends CommonGoalCard {

    public CommonGoalCard7(int playersNumber) {
        goalID = 7;
        // Deck creation
        points = new PointCard[playersNumber];
    }
    @Override
    public boolean check(ObjectCard[][] bookshelf){
        int count=0;
        Type [] type=new Type[4];
        //ObjectCard[][] memo=new ObjectCard[2][2];
        for(int r=0;r<bookshelf.length;r++){
            for(int c=0;c<bookshelf[r].length;c++){
                type[0]=bookshelf[r][c].getType();
                type[1]=bookshelf[r+1][c].getType();
                type[2]=bookshelf[r][c+1].getType();
                type[3]=bookshelf[r+1][c+1].getType();
                if(type[0]==type[1] && type[0]==type[2] && type[0]==type[3]){
                    if(r==0 && c==0){
                        if(type[0]!=bookshelf[0][2].getType() && type[0]!=bookshelf[1][2].getType()
                                && type[0]!=bookshelf[2][0].getType() && type[0]!=bookshelf[2][1].getType()){
                            /*for(int i=0;i<memo.length;i++){
                                for(int j=0;j<memo[i].length;j++){
                                    memo[i][j].setXCoordinate(r+i);
                                    memo[i][j].setYCoordinate(c+j);
                                }
                            }*/
                            count++;
                        }
                    }
                    else if (r==0 && c==4) {
                        if(type[0]!=bookshelf[0][2].getType() && type[0]!=bookshelf[1][2].getType()
                                && type[0]!=bookshelf[2][3].getType() && type[0]!=bookshelf[2][4].getType()){
                            count++;
                        }

                    }
                    else if (r==5 && c==0){
                        if(type[0]!=bookshelf[3][0].getType() && type[0]!=bookshelf[3][1].getType()
                                && type[0]!=bookshelf[4][2].getType() && type[0]!=bookshelf[5][2].getType()){
                            count++;
                        }

                    }
                    else if (r==5 && c==4){
                        if(type[0]!=bookshelf[3][3].getType() && type[0]!=bookshelf[3][4].getType()
                                && type[0]!=bookshelf[4][2].getType() && type[0]!=bookshelf[5][2].getType()){
                            count++;
                        }
                    }
                    else{
                        if(type[0]!=bookshelf[r-1][c].getType() && type[0]!=bookshelf[r-1][c+1].getType()
                        && type[0]!=bookshelf[r][c-1].getType() && type[0]!=bookshelf[r][c+2].getType()
                        && type[0]!=bookshelf[r+1][c-1].getType() && type[0]!=bookshelf[r+1][c+2].getType()
                        && type[0]!= bookshelf[r+2][c].getType() && type[0]!=bookshelf[r+2][c+1].getType()){
                            count++;
                        }
                    }
                }
            }
        }
        if(count<=1){
            return false;
        }
        else{
            return true;
        }
    }


}
