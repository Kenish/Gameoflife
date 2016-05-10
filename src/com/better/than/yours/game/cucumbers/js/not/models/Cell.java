package com.better.than.yours.game.cucumbers.js.not.models;

import com.better.than.yours.game.cucumbers.js.not.exceptions.WrongPositionException;
import com.better.than.yours.game.cucumbers.js.not.engine.BoardObserver;

/**
 * Created by Pszemek on 2016-05-09.
 * Refactor by Mati on 2016-05-10.
 */
public class Cell implements Cells {
    boolean livingStatus;
    public final Position position;
    private int id;
    public Cell(Position position, boolean livingStatus){
        this.livingStatus = livingStatus;
        if (!position.isValid()){
            throw new WrongPositionException("X and Y coordinates should be positive");
        }
        this.position = position;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(int id){
        return this.id;
    };
    @Override
    public boolean isAlive() {
        return livingStatus;
    }

    @Override
    public int getLivingNeighbours() {
        return 0;
    }

}
