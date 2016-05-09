package com.better.than.yours.game.cucumbers.js.not;

/**
 * Created by Pszemek on 2016-05-09.
 */
public class Cell implements Cells{
    boolean livingStatus;
    int[] poistion = new int[2];
    Cell(boolean livingStatus,int[] position){
        this.livingStatus=livingStatus;
        if (position[0]<0||position[1]<0){
            throw new WrongPositionException("X and Y coordinates should be positive");
        }
        this.poistion=position;



    }
    @Override
    public boolean isAlive() {
        return livingStatus;
    }

    @Override
    public int[] getPostion() {
        return poistion;
    }

    @Override
    public int getLivingNeighbours() {
        return 0;
    }

}
