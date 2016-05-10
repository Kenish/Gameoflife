package com.better.than.yours.game.cucumbers.js.not.tests;

import com.better.than.yours.game.cucumbers.js.not.exceptions.CellNotFoundException;
import com.better.than.yours.game.cucumbers.js.not.factories.CellFactory;
import com.better.than.yours.game.cucumbers.js.not.engine.Engine;
import com.better.than.yours.game.cucumbers.js.not.exceptions.WrongPositionException;
import com.better.than.yours.game.cucumbers.js.not.models.Board;
import com.better.than.yours.game.cucumbers.js.not.models.Cell;
import com.better.than.yours.game.cucumbers.js.not.models.Position;

import static junit.framework.TestCase.*;

/**
 * Created by Pszemek on 2016-05-09.
 */
public class CellTest {
    CellFactory factory = new CellFactory();
    Board board = new Board(10,10);
    @org.junit.Test
    public void isAlive()  {
        CellFactory factory = new CellFactory();
        Position position = new Position(2,1, board);
        Cell cell=factory.makeCell(position, true);
        assertTrue(cell.isAlive());
    }
    @org.junit.Test
    public void isNotAlive() {
        Position position = new Position(2,1, board);
        Cell cell=factory.makeCell(position, false);
        assertFalse(cell.isAlive());
    }

    @org.junit.Test
    public void getPositionX()  {
        Position position = new Position(2,1, board);
        Cell cell=factory.makeCell(position, true);
        assertEquals(2,cell.position.getX());
    }
    @org.junit.Test
    public void getPositionY()  {
        Position position = new Position(2,1, board);
        Cell cell=factory.makeCell(position, true);
        assertEquals(1,cell.position.getY());
    }
    @org.junit.Test(expected = WrongPositionException.class)
    public void getWrongPosition()  {
        CellFactory factory = new CellFactory();
        Position position = new Position(2,1, board);
        Cell cell = factory.makeCell(position, true);
    }
    @org.junit.Test
    public void getLivingNeighbours() {
        CellFactory factory = new CellFactory();
        Position position = new Position(2,1, board);
        Cell cell = factory.makeCell(position, true);
        //dodaj sasiada TODO:zrobic to
        assertEquals(1, cell.getLivingNeighbours());
    }
    @org.junit.Test
    public void getLivingNeighboursAfterRemoval() {
        Engine engine = new Engine(board);
        CellFactory factory = new CellFactory();
        Position position1 = new Position(2,1, board);
        Position position2 = new Position(2,2, board);
        Cell cell1 = factory.makeCell(position1, true);
        Cell cell2 = factory.makeCell(position2, true);
        Integer id1 = 1;
        Integer id2 = 2;
        board.addCell(id1, cell1);
        board.addCell(id2, cell2);
        board.removeCell(id1);
        assertEquals(1, cell2.getLivingNeighbours());
    }
    @org.junit.Test(expected = CellNotFoundException.class)
    public void removeNotExistingCell() {
        Engine engine = new Engine(board);
        CellFactory factory = new CellFactory();
        Position position1 = new Position(2,1, board);
        Position position2 = new Position(2,2, board);
        Cell cell1 = factory.makeCell(position1, true);
        Cell cell2 = factory.makeCell(position2, true);
        Integer id1 = 1;
        Integer id2 = 2;
        board.addCell(id1, cell1);
        board.addCell(id2, cell2);
        board.removeCell(id1);
        assertEquals(1, cell2.getLivingNeighbours());
    }
}