package it.polimi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
    static final long serialVersionUID = 1L;
    private String nickname;
    private int points;
    private boolean isFirst;
    private int position;
    private boolean hasFinished;
    private int [] commonGoalsCompleted;
    private ObjectCard [] chosenObjects;
    private PersonalGoalCard personalGoal;
    private Bookshelf bookshelf;
    private int chosenColumn;

    public Player(String nickname, int commonGoalsNumber){
        this.nickname=nickname;
        this.points=0;
        this.isFirst=false;
        this.position=-1;
        this.hasFinished=false;
        this.commonGoalsCompleted= new int [commonGoalsNumber];
        for(int i=0;i<commonGoalsNumber;i++){
            commonGoalsCompleted[i]=-1;
        }
        this.chosenColumn=-1;
        this.chosenObjects=null;
        this.personalGoal=null;
        this.bookshelf=new Bookshelf();

    }


    public String getNickname(){
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPoints(){
        return points;
    }
    public void setPoints(int points){
        this.points=points;
        System.out.println(getNickname()+": "+points);
    }

    public boolean getIsFirst(){ return isFirst;}
    public void setIsFirst(boolean isFirst){ this.isFirst=isFirst; }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position){this.position=position;}

    public boolean getHasFinished(){return hasFinished;}

    public void setHasFinished(boolean hasFinished){ this.hasFinished=hasFinished;}

    public int[] getCommonGoalsCompleted() { return commonGoalsCompleted;}
    public void setCommonGoalsCompleted(int[] commonGoalsCompleted, int newGoal){
        int i=0;
        while(this.commonGoalsCompleted[i]!=-1){
            i++;
        }
        this.commonGoalsCompleted[i]=newGoal;
        System.out.println(newGoal+" completed");
    }

    public ObjectCard[] getChosenObjects() {return chosenObjects;}
    public void setChosenObjects(ObjectCard [] oggettoScelto){
        System.out.println("Player "+position);
        chosenObjects= new ObjectCard[oggettoScelto.length];
        System.out.println(oggettoScelto[0].getType());
        System.arraycopy(oggettoScelto, 0, this.chosenObjects, 0, oggettoScelto.length);
        System.out.println("Copied object "+getChosenObjects()[0].getType());

    }


    public PersonalGoalCard getPersonalGoal() {
        return personalGoal;
    }

    public void setPersonalGoal(PersonalGoalCard personalGoal) {
        this.personalGoal = personalGoal;
    }

    public Bookshelf getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }

    public int getChosenColumn() {
        return chosenColumn;
    }

    public void setChosenColumn(int chosenColumn) {
        this.chosenColumn = chosenColumn;
    }

    public void countPersonalGoalsPoints() {
        int count=0;
        int p=0;
        // Get bookshelf, personalGoal and actual points from Player
        Bookshelf bookshelf = this.getBookshelf();
        // Scan through every row and columns: if two cells match, add one point
        for (int row = 0; row < getBookshelf().getShelf().length; row++) {
            for (int col = 0; col < getBookshelf().getShelf()[0].length; col++) {
                if (bookshelf.shelf[row][col] != null && personalGoal.getGoal().getShelf()[row][col]!=null) {
                    if (bookshelf.shelf[row][col].getType() != null && personalGoal.getGoal().getShelf()[row][col].getType() != null) {
                        if (bookshelf.shelf[row][col].getType() == personalGoal.getGoal().getShelf()[row][col].getType()) {
                            count++;
                        }
                    }
                }
            }
        }
        switch (count){
            case 0 : {
                getPoints();
                break;
            }
            case 1: {
                p=getPoints();
                setPoints(p+1);
                break;

            }
            case 2 : {
                p=getPoints();
                setPoints(p+2);
                break;
            }
            case 3: {
                p=getPoints();
                setPoints(p+4);
                break;
            }
            case 4 : {
                p=getPoints();
                setPoints(p+6);
                break;
            }
            case 5: {
                p=getPoints();
                setPoints(p+9);
                break;
            }
            case 6 : {
                p=getPoints();
                setPoints(p+12);
                break;
            }
        }
        System.out.println("PersonalGoal Tiles Matched: "+count);
    }

    public void countAdjacentItemsPoints() {
        int points=0;
        // Get bookshelf
        ObjectCard[][] shelf = bookshelf.getShelf();
        ObjectCard [][] bookshelfCopy=new ObjectCard[shelf.length][shelf[0].length];
        for(int i=0;i <shelf.length;i++){
            for(int j=0;j<shelf[0].length;j++){
                bookshelfCopy[i][j]=shelf[i][j];
            }
        }

        for(int r=0; r<shelf.length; r++){
            for(int c=0;c<shelf[0].length;c++){
                List<ObjectCard> objectList= new ArrayList<>();
                if(bookshelfCopy[r][c]!=null) {
                    objectList.add(bookshelfCopy[r][c]);
                    for (int r2 = 0; r2 < shelf.length; r2++) {
                        for (int c2 = 0; c2 < shelf[0].length; c2++) {
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
                for(int i=0;i< shelf.length;i++){
                    for(int j=0;j<shelf[0].length;j++){
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
                    // Add points based on how many adjacent points had been made
                    if(objectList.size() == 3) {
                        points = getPoints();
                        setPoints(points + 2);
                    }
                    else if(objectList.size() == 4) {
                        points = getPoints();
                        setPoints(points + 3);
                    }
                    else if(objectList.size() == 5) {
                        points = getPoints();
                        setPoints(points + 5);
                    }
                    else if(objectList.size() >= 6){
                        points = getPoints();
                        setPoints(points+8);
                    }
                objectList.clear();
            }
        }
    }
}

