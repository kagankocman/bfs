package org.example.Classes;

public class Cell {
    private int objectType;
    private int locationX;
    private int locationY;
    private boolean isBarrier;
    private boolean isWrongWay;
    private boolean isVisited;
    private boolean isVisible;
    private boolean isSummer;
    private boolean isWinter;

    public Cell (int x, int y) {
        this.locationX = x;
        this.locationY = y;
        this.objectType = 0;
    }

    public void setSummer(boolean summer) {
        isSummer = summer;
    }
    public boolean getSummer() {
        return this.isSummer;
    }

    public void setWinter(boolean winter) {
        isWinter = winter;
    }
    public boolean getWinter() {
        return this.isWinter;
    }
}
