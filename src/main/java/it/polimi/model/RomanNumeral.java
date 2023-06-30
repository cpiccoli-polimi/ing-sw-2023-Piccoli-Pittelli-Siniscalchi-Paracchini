package it.polimi.model;

/**
 * RomanNumeral class allows to use
 * roman numerals to reflect the real game
 *
 * @author Christian Piccoli
 */
public enum RomanNumeral {
    I(1),
    II(2);
    int i;

    RomanNumeral(int i) {
        this.i = i;
    }
}
