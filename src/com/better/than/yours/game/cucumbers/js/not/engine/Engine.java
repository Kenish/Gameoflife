package com.better.than.yours.game.cucumbers.js.not.engine;
import com.better.than.yours.game.cucumbers.js.not.models.Board;
import com.better.than.yours.game.cucumbers.js.not.models.BoardObserver;
import com.better.than.yours.game.cucumbers.js.not.models.Cell;
import com.better.than.yours.game.cucumbers.js.not.models.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by mati on 2016-05-10.
 */
public class Engine {
    Board board;
    BoardObserver observer;
    Rules rules;
    public Engine(Board board, Rules rules){
        this.board = board;
        this.rules = rules;
        this.observer = new BoardObserver(board);
        board.passObserver(observer);
    }
    public void startGame(int startPopulation){
        for (int i = 0; i < startPopulation; i++){
            int x = (int) (Math.random() * board.getWidth());
            int y = (int) (Math.random() * board.getHeight());
            Position position = new Position(x, y, board);
            board.createCell(position, true);
        }
        HashMap<Integer, Cell> clone = (HashMap) board.getCells().clone();
        for(Map.Entry entry : clone.entrySet()){
            Cell cell = (Cell) entry.getValue();
            if (cell.isAlive()){
                System.out.println("notify");
                cell.notifyObserver(true);
            }
        }
        gameThread();
    }
    void checkEach(){
        HashMap<Integer, Cell> cellsInBoard = (HashMap) board.getCells().clone();
        for (Map.Entry<Integer, Cell> entry : cellsInBoard.entrySet()){
            Cell cell = entry.getValue();
            int neighbors = cell.getLivingNeighbours();
            if (cell.isAlive()){
                aliveOracle(cell, neighbors);
            } else {
                deadOracle(cell, neighbors);
            }
        }
    }
    void aliveOracle(Cell cell, int neighbors){
        if (neighbors <= rules.tooAloneLimit){
            cell.kill();
        } else if (neighbors >= rules.overPopulationLimit){
            cell.kill();
        }
    }
    void deadOracle(Cell cell, int neighbors){
        if (neighbors == rules.bornTime){
            cell.revive();
        } else if (neighbors < 1){
            board.removeCell(cell.getId());
        }
    }
    void gameThread(){
        for(int i = 0; i < 100; i++){
            checkEach();
            observer.push();
            System.out.println("P: " + getAlivePopulation()); //??
            System.out.println("Size: " + board.getCells().size()); //????
        }
    }
    int getPopulation(){
        return board.getCells().values().size();
    }
    int getAlivePopulation(){
        int alivePopulation = 0;
        for (Map.Entry entry : board.getCells().entrySet()){
            Cell cell = (Cell) entry.getValue();
            if(cell.isAlive()){
                alivePopulation += 1;
            }
        }
        return alivePopulation;
    }
}
