package it.polimi.model.enumerations;

public enum Value {
    two(2),
    four(4),
    six(6),
    eight(8);

    int i;

    Value(int i) {
        this.i = i;
    }
}