package com.better.than.yours.game.cucumbers.js.not.tests;

import com.better.than.yours.game.cucumbers.js.not.engine.Engine;
import com.better.than.yours.game.cucumbers.js.not.engine.Rules;
import com.better.than.yours.game.cucumbers.js.not.models.Board;
import com.better.than.yours.game.cucumbers.js.not.models.Cell;
import com.better.than.yours.game.cucumbers.js.not.models.Position;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by mati on 2016-05-11.
 */
public class EngineTest {
    @Test
    //super final static test GLIDER
    public void gliderTest() throws Exception {
        Rules rules = new Rules(1, 4, 3);
        Board board = new Board(100, 100);
        Engine engine = new Engine(board, rules);
        Position[] positions = new Position[5];
        positions[0] = new Position(22,21, board);
        positions[1] = new Position(22,23, board);
        positions[2] = new Position(23,22, board);
        positions[3] = new Position(23,23, board);
        positions[4] = new Position(21,23, board);
        engine.startGame(positions);
        Thread.sleep(1000);
        engine.endGame();
        int alive = 0;
        for(Map.Entry<Integer, Cell> entry : board.getCells().entrySet()){
            Cell cell = entry.getValue();
            if (cell.isAlive()){
                alive +=1;
            }
        }
        assertEquals(5, alive);
    }
    @Test
    public void gliderOutOfMapTest() throws Exception {
        Rules rules = new Rules(1, 4, 3);
        Board board = new Board(100, 100);
        Engine engine = new Engine(board, rules);
        Position[] positions = new Position[5];
        positions[0] = new Position(22,21, board);
        positions[1] = new Position(22,23, board);
        positions[2] = new Position(23,22, board);
        positions[3] = new Position(23,23, board);
        positions[4] = new Position(21,23, board);
        engine.startGame(positions);
        Thread.sleep(1000 * 5);
        engine.endGame();
        int alive = 0;
        for(Map.Entry<Integer, Cell> entry : board.getCells().entrySet()){
            Cell cell = entry.getValue();
            if (cell.isAlive()){
                alive +=1;
            }
        }
        assertEquals(4, alive);
    }

}