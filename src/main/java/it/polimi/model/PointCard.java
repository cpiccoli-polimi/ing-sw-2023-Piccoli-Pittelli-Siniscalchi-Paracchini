package it.polimi.model;

import it.polimi.model.enumerations.RomanNumeral;
import it.polimi.model.enumerations.Value;

public class PointCard {
    Value value;
    RomanNumeral backNumber;

    public void pointCard(Value value, RomanNumeral backNumber){};
    public Value getValue(){
        return value;
    };
    public RomanNumeral getBackNumber(){
        return backNumber;
    };
}
