package com.better.than.yours.game.cucumbers.js.not;

import java.util.HashMap;
import java.util.Random;


/**
 * Created by Pszemek on 2016-05-10.
 */
public class Engine {
    HashMap<Integer, Cell> mapCells = new HashMap<>();
    public Engine(Board board, int population){
        Random rnd = new Random();
        CellFactory factory = new CellFactory();
        HashMap<Integer, Cell> mapCells = new HashMap<>();

        for (int i=0; i<population; i++ ){
            int[] position = {rnd.nextInt(board.width),rnd.nextInt(board.height)};
            Cell cell = factory.makeCell(true,position);
            mapCells.put(cell.getId(),cell);
        }
        this.mapCells=mapCells;

    }
    public HashMap getMap(){

        return mapCells;
    }



}
