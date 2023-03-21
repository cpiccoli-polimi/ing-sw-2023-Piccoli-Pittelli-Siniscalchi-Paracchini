package it.polimi.model.enumerations;

public enum value {
    two(2),
    four(4),
    six(6),
    eight(8);

    int i;

    value(int i) {
        this.i = i;
    }
}
