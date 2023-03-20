package it.polimi.model.enumerations;

public enum value {
    due(2),
    quattro(4),
    sei(6),
    otto(8);

    int i;

    value(int i) {
        this.i = i;
    }
}
