package it.polimi.model;

import java.io.Serializable;

/**
 * PointCard reflects the actual PointCard in
 * the game, with a roman numeral on the back
 *
 * @author Christian Piccoli
 */
public class PointCard implements Serializable {
    static final long serialVersionUID = 1L;
    Value value;
    RomanNumeral backNumber;
    /**
     * Creates the desired PointCard based on
     * parameters passed as arguments
     *
     * @param value
     * @param backNumber
     */
    public PointCard(Value value, RomanNumeral backNumber){
        this.value = value;
        this.backNumber = backNumber;
    }
    /**
     * @return the value
     */
    public Value getValue(){
        return value;
    }
    /**
     * @return the back number
     */
    public RomanNumeral getBackNumber(){
        return backNumber;
    }
}
