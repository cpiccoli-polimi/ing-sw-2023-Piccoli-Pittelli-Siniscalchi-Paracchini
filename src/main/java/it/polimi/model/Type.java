package it.polimi.model;

/**
 * Type's class is used to associate each
 * type to a specific color and allow to refer to
 * each type with his name
 */
public enum Type {
    Cats("\u001B[32m"),
    Books("\u001B[37m"),
    Games("\u001B[33m"),
    Frames("\u001B[34m"),
    Trophies("\u001B[36m"),
    Plants("\u001B[35m");

    public static final String RESET = "\u001B[0m";

    private String color;

    Type(String color) {
        this.color = color;
    }
    public String getColor(){
        return color;
    }
}
