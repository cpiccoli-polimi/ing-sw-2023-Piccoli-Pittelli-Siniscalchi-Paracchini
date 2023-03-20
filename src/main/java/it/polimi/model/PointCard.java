package it.polimi.model;

import it.polimi.model.enumerations.romanNumeral;
import it.polimi.model.enumerations.value;

public class PointCard {
    value value;
    romanNumeral backNumber;

    public void pointCard(value value,romanNumeral backNumber){};
    public value getValue(){
        return value;
    };
    public romanNumeral getBackNumber(){
        return backNumber;
    };
}
