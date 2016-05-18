package com.better.than.yours.game.cucumbers.js.not;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


/**
 * Created by Pszemek on 2016-05-10.
 */
public class Engine {
    HashMap<Integer, Cell> mapCells = new HashMap<>();
    ArrayList<Cell> toRevive = new ArrayList();
    ArrayList<Cell> toKill = new ArrayList<>();

    public Engine(Board board, int population) {
        Random rnd = new Random();
        CellFactory factory = new CellFactory();
        HashMap<Integer, Cell> mapCells = new HashMap<>();

        for (int i = 0; i < population; i++) {
            int[] position = {rnd.nextInt(board.width), rnd.nextInt(board.height)};
            Cell cell = factory.makeCell(true, position, board);
            mapCells.put(cell.getId(), cell);
        }
        this.mapCells = mapCells;

    }

    public HashMap getMap() {

        return mapCells;
    }

    public Integer lookForCells(Cell cell,Board board) {
        cell.zeroNeighbours();
        Integer posX = cell.getPositionX();
        Integer posY = cell.getPositionY();

        for (int j=-1; j<2;j++) {
            for (int i = -1; i < 2; i++) {
                if (!(i==0&&j==0)){
                    Integer Checkposition = generateId(board, posX + j, posY + i);
                    if(mapCells.containsKey(Checkposition)&&mapCells.get(Checkposition).isAlive()){
                        cell.addNeigbour();
                    }
                }
            }
        }
        return cell.neigbours;
    }

    void makeSomeDeadCells (Cell cell,Board board,CellFactory factory){
        Integer posX = cell.getPositionX();
        Integer posY = cell.getPositionY();
        for (int j=-1; j<2;j++) {
            for (int i = -1; i < 2; i++) {
                if (!(i == 0 && j == 0)) {
                    Integer Checkposition = generateId(board, posX + j, posY + i);
                    if (posX + j > 0 && posY + i > 0 && posX + j < board.width && posY + i < board.height && cell.isAlive()&& !mapCells.containsKey(Checkposition)) {
                        int position[] = {posX + j, posY + i};
                        cellputter(factory.makeCell(false, position, board), mapCells, board);
                    }

                }
            }
        }
    }
    void cellDecider(Cell cell,Board board,CellFactory factory){
        if (lookForCells(cell,board)==3 && !cell.isAlive()){
         toRevive.add(cell);
        }
        else if (lookForCells(cell,board)<2 && cell.isAlive() || lookForCells(cell,board)>3 && cell.isAlive() ){
            toKill.add(cell);
        }
    }
    void nextTurn(){
        toRevive.forEach(Cell::revive) ;
        toRevive.clear();
        toKill.forEach(Cell::kill);
        toKill.clear();
    }

    public Integer generateId(Board board,Integer posX,Integer posY){

        return posX+(posY*board.width);
    }
    void cellputter(Cell cell, HashMap<Integer, Cell> mapCells,Board board){
        cell.addNeigbour();
        mapCells.put(generateId(board,cell.getPositionX(),cell.getPositionY()),cell);
       /* System.out.println("I've put cell");*/
    }



}
