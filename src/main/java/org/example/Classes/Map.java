package org.example.Classes;

public class Map {

    public Cell[][] createMap(int length) {
        Cell[][] cells = new Cell[length][length] ;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length/2; j++) {
                cells[i][j] = new Cell(i,j);
                cells[i][j].setSummer(true);
                // yaz temalı yollar ve engeller
            }
        }

        for (int i = 0 ; i < length; i++) {
            for (int j = length/2; j < length; j++) {
                cells[i][j] = new Cell(i,j);
                cells[i][j].setWinter(true);
                // kış temalı yollar ve engeller
            }
        }
        Character character = new Character().createCharacter(3,5);
        cells[character.getLocationX()][character.getLocationY()] =
        return cells;
    }
}
