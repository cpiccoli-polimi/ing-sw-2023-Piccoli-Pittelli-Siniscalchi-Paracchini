package it.polimi.model;

import java.io.Serializable;

public class PointCard implements Serializable {
    static final long serialVersionUID = 1L;
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
