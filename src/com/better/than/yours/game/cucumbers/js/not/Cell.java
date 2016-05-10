package com.better.than.yours.game.cucumbers.js.not;

/**
 * Created by Pszemek on 2016-05-09.
 */
public class Cell implements Cells{
    boolean livingStatus;
    BoardObserver observer;
    Board board;
    int[] position ;
    Integer id;
    Cell(boolean livingStatus,int[] position){
        this.livingStatus=livingStatus;
        if (position[0]<0||position[1]<0){
            throw new WrongPositionException("X and Y coordinates should be positive");
        }
        this.position =position;
        this.id= (position[0])+position[1]*board.width;
    }

    @Override
    public boolean isAlive() {
        return livingStatus;
    }

    @Override
    public int[] getPosition() {
        return position;
    }

    @Override
    public int getLivingNeighbours() {
        return 0 ;
    }
    public Integer getId(){
        Integer id = this.id;
        return id;
    }

    public  int getPositionX(){
        int x = this.position[0];
        return x;
    }
    public  int getPositionY(){
        int x = this.position[1];
        return x;
    }
    public void setPositionX(int x){
        this.position[0]= x;
    }
    public void  setPositionY(int x){
        this.position[1] = x  ;
    }
}
