package com.better.than.yours.game.cucumbers.js.not;

/**
 * Created by Pszemek on 2016-05-09.
 */
public class CellFactory {
    static Cell makeCell(boolean isAlive, int[] position,Board board){

        return new Cell(isAlive,position,board);
    }
}
