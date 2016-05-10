package com.better.than.yours.game.cucumbers.js.not.models;

import com.better.than.yours.game.cucumbers.js.not.models.Board;
import com.better.than.yours.game.cucumbers.js.not.models.Cell;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pszemek on 2016-05-09.
 */
public class BoardObserver {
    HashMap<Integer,Integer> toCallMap = new HashMap<>();
    Board board;
    public BoardObserver(Board board){
        this.board = board;
    }
    public void update(Position position, boolean reviveEvent){
        int difference = (reviveEvent) ? 1 : -1;
        int testCounter = 0;
        for (int i = 0; i < 8; i++){
            Cell cell =  board.getNextNeighbor(position, i);
            if (cell != null){
                Integer id = cell.getId();
                int currentValue = 0;
                if (toCallMap.containsKey(id)){
                    currentValue = toCallMap.get(id);
                }
                toCallMap.put(id, currentValue + difference);
            }
        }
    }
    public void push(){
        for (Map.Entry<Integer, Integer> entry : toCallMap.entrySet()){
            int id = entry.getKey();
            Cell cell = board.getCell(id);
            if (cell != null){
                int currentNeighbors = cell.getLivingNeighbours();
                cell.updateNumberOfNeighbors(currentNeighbors + entry.getValue());
            }
        }
    }

}
