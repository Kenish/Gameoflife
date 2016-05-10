package com.better.than.yours.game.cucumbers.js.not.models;

import com.better.than.yours.game.cucumbers.js.not.exceptions.WrongPositionException;


/**
 * Created by Pszemek on 2016-05-09.
 * Refactor by Mati on 2016-05-10.
 */
public class Cell implements Cells {
    boolean livingStatus;
    public final Position position;
    private BoardObserver observer;
    private int id;
    private int neighbors;
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
    public int getId(){

        return this.id;
    };
    public void setObserver(BoardObserver observer){

        this.observer = observer;
    }
    public void notifyObserver(boolean isReviveEvent){

        this.observer.update(position, isReviveEvent);
    }
    @Override
    public boolean isAlive() {

        return livingStatus;
    }
    public void kill(){

        livingStatus = false;
        observer.update(position, false);
    }
    public void revive(){

        livingStatus = true;
        observer.update(position, true);
    }
    @Override
    public int getLivingNeighbours() {

        return neighbors;
    }

    public void updateNumberOfNeighbors(int neighbors){

        this.neighbors = neighbors;
    }

}
