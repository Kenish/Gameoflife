package com.better.than.yours.game.cucumbers.js.not.models;

import com.better.than.yours.game.cucumbers.js.not.engine.Engine;
import com.better.than.yours.game.cucumbers.js.not.engine.Rules;
import com.better.than.yours.game.cucumbers.js.not.exceptions.WrongPositionException;
import com.better.than.yours.game.cucumbers.js.not.factories.CellFactory;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

/**
 * Created by mati on 2016-05-10.
 */
public class BoardTest {
    Board board = new Board(10, 15);
    BoardObserver observer = new BoardObserver(board);
    CellFactory cellFactory = new CellFactory();

    @Test
    public void getWidth() throws Exception {
        assertEquals(10, board.getWidth());
    }

    @Test
    public void getHeight() throws Exception {
        assertEquals(15, board.getHeight());
    }

    @Test
    public void addCell() throws Exception {
        board.passObserver(observer);
        Position position = new Position(2,1, board);
        Cell cell = board.createCell(position, true);
        assertEquals(9, board.getCells().size());
    }
    @Test
    public void addTwoCellsNear() throws Exception {
        board.passObserver(observer);
        Position position = new Position(2,1, board);
        Position position2 = new Position(2,2, board);
        Cell cell2 = board.createCell(position2, true);
        Cell cell = board.createCell(position, true);
        assertEquals(12, board.getCells().size());
    }
    @Test
    public void addTwoCellsFar() throws Exception {
        board.passObserver(observer);
        Position position = new Position(2,1, board);
        Position position2 = new Position(5,7, board);
        Cell cell2 = board.createCell(position2, true);
        Cell cell = board.createCell(position, true);
        assertEquals(18, board.getCells().size());
    }

    @Test
    public void createCellTest() throws Exception {
        board.passObserver(observer);
        Position position = new Position(2,1, board);
        Cell cell = board.createCell(position, true);
        assertEquals(9, board.getCells().size());
    }
    @Test
    public void createCellTestTheSamePosition() throws Exception {
        board.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Position position2 = new Position(2,1, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        assertEquals(9, board.getCells().size());
    }
    @Test (expected = WrongPositionException.class)
    public void createCellBadCoordinates() throws Exception {
        board.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Position position2 = new Position(2,-1, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
    }

    @Test
    public void getCells() throws Exception {
        board.passObserver(observer);
        Position position1 = new Position(3,4, board);
        Position position2 = new Position(8,6, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        assertEquals(18, board.getCells().size());
    }
    @Test
    public void getCellsWithRemoval() throws Exception {
        board.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Position position2 = new Position(8,6, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        cell1.kill();
        board.removeCell(cell1.getId());
        assertEquals(9, board.getCells().size());
    }
    @Test
    public void setCellId() throws Exception {
        board.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Cell cell1 = cellFactory.makeCell(position1);
        board.setCellId(cell1, 17);
        assertEquals(17, cell1.getId());
    }
    @Test
    public void getLivingNeighbours() {
        board.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Position position2 = new Position(2,2, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        observer.push();
        assertEquals(1, cell1.getLivingNeighbours());
        assertEquals(1, cell2.getLivingNeighbours());
    }
    @Test
    public void getLivingNeighboursAfterRemoval() {
        board.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Position position2 = new Position(2,2, board);
        Position position3 = new Position(3,1, board);
        Position position4 = new Position(3,2, board);
        Position position5 = new Position(2,4, board);


        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        Cell cell3 = board.createCell(position3, true);
        Cell cell4 = board.createCell(position4, true);
        Cell cell5 = board.createCell(position5, true);

        observer.push();
        assertEquals(3, cell2.getLivingNeighbours());
        cell5.kill();
        observer.push();
        System.out.println(cell1.isAlive());
        System.out.println(cell2.isAlive());
        assertEquals(3, cell2.getLivingNeighbours());
        assertEquals(3, cell4.getLivingNeighbours());
    }
    @Test
    public void getCell() throws Exception {
        board.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Position position2 = new Position(9,6, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        assertEquals(cell1, board.getCell(cell1.getId()));
    }

    @Test //it should be in engine tests.
    public void removeCell() throws Exception {
        board.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Cell cell1 = board.createCell(position1, true);
        cell1.kill();
        cell1.oracle();
        observer.push();
        assertEquals(0, board.getCells().size());
    }
    @Test
    public void lonelyDeath() throws Exception {
        board.passObserver(observer);
        Position position1 = new Position(3,2, board);
        Position position2 = new Position(2,2, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        observer.push();
        cell1.kill();
        observer.push();
        assertEquals(0, board.getCells().size());
    }

    @Test
    public void generateCellIdTest() throws Exception {
        board.passObserver(observer);
        Position position1 = new Position(9,6, board);
        int id = board.generateCellId(position1);
        assertEquals(6*10 + 9, id);
    }
    @Test
    public void isAlive()  {
        board.passObserver(observer);
        Position position = new Position(2,1, board);
        Cell cell = board.createCell(position, true);
        assertTrue(cell.isAlive());
    }
    @Test
    public void isNotAlive() {
        Position position = new Position(2,1, board);
        Cell cell = board.createCell(position, false);
        assertFalse(cell.isAlive());
    }
    @Test
    public void setCellId1Test() throws Exception {
        Position position2 = new Position(9,6, board);
        Cell cell1 = cellFactory.makeCell(position2);
        board.setCellId(cell1, 6*10 + 9);
        assertEquals(6 * 10 + 9, cell1.getId());
    }

    @Test
    public void getCellPosition() throws Exception {
        board.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Cell cell1 = board.createCell(position1, true);
        assertEquals(cell1.position, position1);
    }

    @Test
    public void getNextNeighborRightDown() throws Exception {
        board.passObserver(observer);
        Position position1 = new Position(3,4, board);
        Position position2 = new Position(4,5, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        Cell cell3 = board.getNextNeighbor(position1, 7);
        assertEquals(cell2, cell3);
    }
    @Test
    public void getNextNeighborLeftUp() throws Exception {
        board.passObserver(observer);
        Position position1 = new Position(3,4, board);
        Position position2 = new Position(2,3, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        Cell cell3 = board.getNextNeighbor(position1, 0);
        assertEquals(cell2, cell3);
    }
    @Test
    public void getNextNeighborNotNeighbor() throws Exception {
        board.passObserver(observer);
        Position position1 = new Position(3,4, board);
        Position position2 = new Position(3,3, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        Cell cell3 = board.getNextNeighbor(position1, 0);
        assertNotEquals(cell2, cell3);
    }

}