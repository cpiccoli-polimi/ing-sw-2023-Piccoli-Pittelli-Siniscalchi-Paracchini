package it.polimi.model;

/**
 * Value class is used to set the
 * value of PointCard
 *
 * @author Christian Piccoli
 */
public enum Value {
    two(2),
    four(4),
    six(6),
    eight(8);

    int i;

    Value(int i) {
        this.i = i;
    }

    /**
     * @return the value associated to the
     *         roman numeral
     */
    public int getI() {
        return i;
    }
}
