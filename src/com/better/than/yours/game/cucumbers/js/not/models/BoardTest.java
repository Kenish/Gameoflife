package com.better.than.yours.game.cucumbers.js.not.models;

import com.better.than.yours.game.cucumbers.js.not.exceptions.WrongPositionException;
import com.better.than.yours.game.cucumbers.js.not.factories.CellFactory;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by mati on 2016-05-10.
 */
public class BoardTest {
    Board board = new Board(10, 15);
    CellFactory cellFactory = new CellFactory();
    BoardObserver observer = new BoardObserver(board);
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
        cellFactory.passObserver(observer);
        Position position = new Position(2,1, board);
        Cell cell = cellFactory.makeCell(position, true);
        board.addCell(5, cell);
        assertEquals(1, board.getCells().size());
    }

    @Test
    public void createCellTest() throws Exception {
        cellFactory.passObserver(observer);
        Position position = new Position(2,1, board);
        Cell cell = board.createCell(position, true);
        assertEquals(1, board.getCells().size());
    }
    @Test
    public void createCellTestTheSamePosition() throws Exception {
        cellFactory.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Position position2 = new Position(2,1, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        assertEquals(1, board.getCells().size());
    }
    @Test (expected = WrongPositionException.class)
    public void createCellBadCoordinates() throws Exception {
        cellFactory.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Position position2 = new Position(2,-1, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
    }

    @Test
    public void getCells() throws Exception {
        cellFactory.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Position position2 = new Position(9,6, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        assertEquals(2, board.getCells().size());
    }
    @Test
    public void getCellsWithRemoval() throws Exception {
        cellFactory.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Position position2 = new Position(9,6, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        board.removeCell(cell1.getId());
        assertEquals(1, board.getCells().size());
    }

    @Test
    public void setCellId() throws Exception {
        cellFactory.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Cell cell1 = cellFactory.makeCell(position1, true);
        board.setCellId(cell1, 17);
        assertEquals(17, cell1.getId());
    }

    @Test
    public void getCell() throws Exception {
        cellFactory.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Position position2 = new Position(9,6, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        assertEquals(cell1, board.getCell(cell1.getId()));
    }

    @Test
    public void removeCell() throws Exception {
        cellFactory.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Position position2 = new Position(9,6, board);
        Cell cell1 = board.createCell(position1, true);
        board.removeCell(cell1.getId());
        assertEquals(0, board.getCells().size());
    }

    @Test
    public void generateCellIdTest() throws Exception {
        cellFactory.passObserver(observer);
        Position position1 = new Position(9,6, board);
        int id = board.generateCellId(position1);
        assertEquals(6*10 + 9, id);
    }

    @Test
    public void setCellId1Test() throws Exception {
        Position position2 = new Position(9,6, board);
        Cell cell1 = cellFactory.makeCell(position2, true);
        board.setCellId(cell1, 6*10 + 9);
        assertEquals(6 * 10 + 9, cell1.getId());
    }

    @Test
    public void getCellPosition() throws Exception {
        cellFactory.passObserver(observer);
        Position position1 = new Position(2,1, board);
        Cell cell1 = board.createCell(position1, true);
        assertEquals(cell1.position, position1);
    }

    @Test
    public void getNextNeighborRightDown() throws Exception {
        cellFactory.passObserver(observer);
        Position position1 = new Position(3,4, board);
        Position position2 = new Position(4,5, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        Cell cell3 = board.getNextNeighbor(position1, 7);
        assertEquals(cell2, cell3);
    }
    @Test
    public void getNextNeighborLeftUp() throws Exception {
        cellFactory.passObserver(observer);
        Position position1 = new Position(3,4, board);
        Position position2 = new Position(2,3, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        Cell cell3 = board.getNextNeighbor(position1, 0);
        assertEquals(cell2, cell3);
    }
    @Test
    public void getNextNeighborNotNeighbor() throws Exception {
        cellFactory.passObserver(observer);
        Position position1 = new Position(3,4, board);
        Position position2 = new Position(3,3, board);
        Cell cell1 = board.createCell(position1, true);
        Cell cell2 = board.createCell(position2, true);
        Cell cell3 = board.getNextNeighbor(position1, 0);
        assertNotEquals(cell2, cell3);
    }

}