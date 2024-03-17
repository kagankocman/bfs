package org.example.Classes;

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
enum Types {
    Empty,
    Tree,
    Mountain,
    Rock,
    Wall,
    Bird,
    Bee,
    Gold,
    Silver,
    Emerald,
    Copper,
    Road,
    Character,
}
public class Cell {
    Types objectType;
    Point point;
    private boolean isVisited;
    private boolean isSmoked;
    private boolean isSummer;
    private boolean isWinter;
    private boolean isObstacle;

    public Cell (Point p) {
        this.point = p;
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

    public boolean isSmoked() {
        return isSmoked;
    }

    public void setSmoked(boolean smoked) {
        isSmoked = smoked;
    }

    public boolean isObstacle() {
        return isObstacle;
    }

    public void setObstacle(boolean obstacle) {
        isObstacle = obstacle;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
