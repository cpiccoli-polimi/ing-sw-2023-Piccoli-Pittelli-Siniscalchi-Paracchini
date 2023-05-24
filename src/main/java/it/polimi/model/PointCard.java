package it.polimi.model;

import java.io.Serializable;

public class PointCard implements Serializable {
    Value value;
    RomanNumeral backNumber;
    public PointCard(Value value, RomanNumeral backNumber){
        this.value = value;
        this.backNumber = backNumber;
    }
    public Value getValue(){
        return value;
    }
    public RomanNumeral getBackNumber(){
        return backNumber;
    }
}
