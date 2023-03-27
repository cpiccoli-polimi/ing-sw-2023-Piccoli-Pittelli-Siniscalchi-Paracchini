package it.polimi.model;

public class PointCard {
    int value;
    RomanNumeral backNumber;
    public PointCard(int value, RomanNumeral backNumber){
        this.value = value;
        this.backNumber = backNumber;
    }
    public int getValue(){
        return value;
    }
    public RomanNumeral getBackNumber(){
        return backNumber;
    }
}
