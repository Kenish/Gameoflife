package com.better.than.yours.game.cucumbers.js.not.models;

import java.util.HashMap;

/**
 * Created by Pszemek on 2016-05-10.
 */
public class Board {
    HashMap<Integer, Cell> cellsHashMap = new HashMap<>();
    int width;
    int height;
    public Board(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public HashMap<Integer, Cell> getCells(){
        return cellsHashMap;
    }
    public void addCell(Integer id, Cell cell){
        cellsHashMap.put(id, cell);
    }
    public void removeCell(Integer id){
        cellsHashMap.remove(id);
    }
}
