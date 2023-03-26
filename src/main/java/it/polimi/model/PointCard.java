package it.polimi.model;

public class PointCard {
    Value value;
    RomanNumeral backNumber;
    protected PointCard(int value, RomanNumeral backNumber){
        this.value = value;
        this.backNumber = backNumber;
    }

    public void pointCard(Value value, RomanNumeral backNumber){};
    public Value getValue(){
        return value;
    };
    public RomanNumeral getBackNumber(){
        return backNumber;
    };
}
