package com.better.than.yours.game.cucumbers.js.not;

import static junit.framework.TestCase.*;

/**
 * Created by Pszemek on 2016-05-09.
 */
public class CellTest {
    @org.junit.Test
    public void isAlive()  {
        CellFactory factory = new CellFactory();
        int[] position = {1,2};
        Cell cell=factory.makeCell(true,position);
        assertTrue(cell.isAlive());
    }
    @org.junit.Test
    public void isNotAlive() {
        CellFactory factory = new CellFactory();
        int[] position = {1,2};
        Cell cell=factory.makeCell(false,position);
        assertFalse(cell.isAlive());
    }

    @org.junit.Test
    public void getPosition()  {
        CellFactory factory = new CellFactory();
        int[] position = {1,2};
        Cell cell=factory.makeCell(false,position);
        assertEquals(position,cell.getPosition());
    }
    @org.junit.Test(expected = WrongPositionException.class)
    public void getWrongPosition()  {
        CellFactory factory = new CellFactory();
        int[] position = {1,-2};
        Cell cell=factory.makeCell(false,position);
        assertEquals(position,cell.getPosition());
    }
    @org.junit.Test
    public void getLivingNeighbours() {
        CellFactory factory = new CellFactory();
        int[] position = {1,2};
        Cell cell=factory.makeCell(false,position);
        //dodaj sasiada TODO:zrobic to
        assertEquals(cell.getLivingNeighbours(),1);
    }
    @org.junit.Test
    public void getLivingNeighboursAfterRemoval() {
        CellFactory factory = new CellFactory();
        int[] position = {1,2};
        Cell cell=factory.makeCell(false,position);
        //dodaj sasiada TODO:zrobic to
        //usuń sasiada
        //dodaj sasiada
        assertEquals(cell.getLivingNeighbours(),1);
    }

}