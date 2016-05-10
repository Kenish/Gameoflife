package com.better.than.yours.game.cucumbers.js.not.factories;

import com.better.than.yours.game.cucumbers.js.not.models.Cell;
import com.better.than.yours.game.cucumbers.js.not.models.Position;

public class CellFactory {
    public static Cell makeCell(Position position, boolean isAlive){

        return new Cell(position, isAlive);
    }
}
