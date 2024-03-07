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
    public int getLocationX() { return this.locationX; }
    public int getLocationY() { return this.locationY; }

    public void move_left() { this.locationX -= 1; }

    public void move_right() {
        this.locationX += 1;
    }

    public void move_up() {
        this.locationY += 1;
    }

    public void move_down() {
        this.locationY -= 1;
    }

}
