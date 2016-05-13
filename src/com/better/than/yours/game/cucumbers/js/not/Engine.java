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

    public Integer lookForCells(Cell cell,Board board,CellFactory factory) {
        cell.zeroNeighbours();
        Integer posX = mapCells.get(cell.getId()).getPositionX();
        Integer posY = mapCells.get(cell.getId()).getPositionY();

        for (int j=-1; j<2;j++) {
            for (int i = -1; i < 2; i++) {
                if (!(i==0&&j==0)){
                    Integer Checkposition = generateId(board, posX + j, posY + i);
                    /*System.out.println(Checkposition +" ");*/
                    if(mapCells.containsKey(Checkposition)&&mapCells.get(Checkposition).isAlive()){
                        cell.addNeigbour();
                    }
                    else{
                        if(posX+j>0&&posY+i>0&&posX<board.width+j&&posY+i<board.height&&cell.livingStatus) {
                            int position[] = {posX + j, posY + i};
                            cellputter(factory.makeCell(false, position, board),mapCells,board);
                        }
                    }
                }
            }
        }
        return cell.neigbours;
    }

    void cellDecider(Cell cell,Board board,CellFactory factory){
        if (lookForCells(cell,board,factory)==3 && !cell.livingStatus){
         toRevive.add(cell);
        }
        else if (lookForCells(cell,board,factory)<2 || lookForCells(cell,board,factory)>3 && cell.livingStatus ){
            toKill.add(cell);
        }
    }
    void nextTurn(){
        toRevive.forEach(Cell::revive) ;
        toKill.forEach(Cell::kill);
    }

    public Integer generateId(Board board,Integer posX,Integer posY){

        return posX+(posY*board.width);
    }
    void cellputter(Cell cell, HashMap<Integer, Cell> mapCells,Board board){
        mapCells.put(generateId(board,cell.getPositionX(),cell.getPositionY()),cell);
       /* System.out.println("I've put cell");*/
    }



}
