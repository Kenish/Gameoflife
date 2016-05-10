package com.better.than.yours.game.cucumbers.js.not.models;

import com.better.than.yours.game.cucumbers.js.not.exceptions.WrongPositionException;


/**
 * Created by Pszemek on 2016-05-09.
 * Refactor by Mati on 2016-05-10.
 */
public class Cell implements Cells {
    private boolean livingStatus;
    public final Position position;
    private BoardObserver observer;
    private int id;
    private int neighbors;
    public Cell(Position position){

        this.livingStatus = false;

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
    public BoardObserver getObserver(){
        return this.observer;
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
        notifyObserver(false);
    }
    public void revive(){
        livingStatus = true;
        notifyObserver(true);
    }
    @Override
    public int getLivingNeighbours() {

        return neighbors;
    }

    public void updateNumberOfNeighbors(int neighbors){

        this.neighbors = neighbors;
    }

}
