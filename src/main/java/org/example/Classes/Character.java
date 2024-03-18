package org.example.Classes;

public class Character {
    private int object_type = 1;
    private int locationX;
    private int locationY;

    public Character(int x, int y) {
        this.locationY = y;
        this.locationX = x;
    }
    public Character createCharacter(int x, int y) {
        Character character = new Character(x,y);
        this.locationX = x;
        this.locationY = y;
        return character;
    }
}
