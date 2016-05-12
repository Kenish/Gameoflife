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
    HashMap<Integer,Boolean> changeStatusMap = new HashMap<>();
    Board board;
    public BoardObserver(Board board){
        this.board = board;
    }
    public void update(Integer id, boolean reviveEvent){
        Position position = board.getCellPosition(id);
        int difference = (reviveEvent) ? 1 : -1;
        changeStatusMap.put(id, reviveEvent);
        for (int i = 0; i < 8; i++){
            Cell cell =  board.getNextNeighbor(position, i);
            if (cell != null){
                Integer neighId = cell.getId();
                int val = (toCallMap.containsKey(neighId)) ? toCallMap.get(neighId) + difference : difference;
                toCallMap.put(neighId, val);
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
        for (Map.Entry<Integer, Boolean> entry : changeStatusMap.entrySet()){
            int id = entry.getKey();
            boolean value = entry.getValue();
            board.getCell(id).setLivingStatus(value);
        }
        toCallMap.clear();
        changeStatusMap.clear();
    }
    void deleteCell(int id){
        board.removeCell(id);
    }

}
