package com.better.than.yours.game.cucumbers.js.not;

class CellFactory {
    static Cell makeCell(boolean isAlive, Position position){

        return new Cell(isAlive,position);
    }
}
