package com.better.than.yours.game.cucumbers.js.not.engine;

import com.better.than.yours.game.cucumbers.js.not.models.Board;
import com.better.than.yours.game.cucumbers.js.not.models.Cell;

/**
 * Created by mati on 2016-05-10.
 */
public class Engine {
    Board board;
    public Engine(Board board){
        this.board = board;
    }
    Board getBoard(){
        return board;
    }
    int getCellPosition(int CellId){
        return 0;
    }

    void setCellId(Cell cell){
        int id = board.getWidth() * cell.position.getY() + cell.position.getX();
        cell.setId(id);
    }
}
