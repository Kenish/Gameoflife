package com.better.than.yours.game.cucumbers.js.not;

import java.util.HashMap;

/**
 * Created by Pszemek on 2016-05-09.
 */
public class BoardObserver {
    Cell cell;
    HashMap<Integer,Cell> toCallMap = new HashMap<>();
    void getinformed(Integer id, Cell cell){
    this.cell = cell;
        toCallMap.put(id,cell);
    }
    void inform(Integer id, Cell cell){

    }

}
