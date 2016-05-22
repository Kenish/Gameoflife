package com.better.than.yours.game.cucumbers.js.not;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


/**
 * Created by Pszemek on 2016-05-10.
 */
public class Engine {
    ArrayList<Cell> toRevive = new ArrayList();
    ArrayList<Cell> toKill = new ArrayList<>();
    Board board;
    HashMap<Integer,Cell> mapCells= new HashMap<>();
    public Engine(Board board, int population) {
        Random rnd = new Random();
        for (int i = 0; i < population; i++) {
            Position position = new Position(rnd.nextInt(board.width), rnd.nextInt(board.height));
            Cell cell = CellFactory.makeCell(true, position, board);
            mapCells.put(cell.getId(), cell);
        }
        this.board=board;
    }

    public Integer lookForCells(Cell cell,Board board) {
        cell.zeroNeighbours();
        Integer posX = cell.position.getX();
        Integer posY = cell.position.getY();

        for (int j=-1; j<2;j++) {
            for (int i = -1; i < 2; i++) {
                if (!(i==0&&j==0)){
                    Integer checkposition = generateId(board, posX + j, posY + i);
                    if(mapCells.containsKey(checkposition)&&mapCells.get(checkposition).isAlive()){
                            cell.addNeigbour();
                    }
                }
            }
        }
        return cell.getLivingNeighbours();
    }

    void makeSomeDeadCells (Cell cell,Board board){
        Integer posX = cell.position.getX();
        Integer posY = cell.position.getY();
        for (int j=-1; j<2;j++) {
            for (int i = -1; i < 2; i++) {
                if (!(i == 0 && j == 0)) {
                    Integer Checkposition = generateId(board, posX + j, posY + i);
                    if (posX + j > 0 && posY + i > 0 && posX + j < board.width && posY + i < board.height && !mapCells.containsKey(Checkposition)) {
                        Position position = new Position(posX+j,posY+i);
                        cellputter(CellFactory.makeCell(false, position, board));
                    }

                }
            }
        }
    }

    void cellDecider(Cell cell){
        if (cell.getLivingNeighbours()==3 && !cell.isAlive()){
            toRevive.add(cell);
        }
        else if ((cell.getLivingNeighbours()<2 && cell.isAlive()) || (cell.getLivingNeighbours()>3 && cell.isAlive()) ){
            toKill.add(cell);
        }
    }

    void nextTurn(){
        toRevive.forEach(Cell::revive) ;
        toRevive.clear();
        toKill.forEach(Cell::kill);
        toKill.clear();
    }
    public static Integer generateId(Board board,Integer posX,Integer posY){

        return posX+(posY*board.width);
    }

    void cellputter(Cell cell){
        mapCells.put(generateId(board,cell.position.getX(),cell.position.getY()),cell);
    }
    public HashMap getMap() {

        return mapCells;
    }
    void playGame(){

        for (int i=0; i<board.width*board.height;i++) {
            if (mapCells.containsKey(i)&&mapCells.get(i).isAlive()) {
                makeSomeDeadCells(mapCells.get(i), board);
                Display.draw(mapCells.get(i).position.getX(),mapCells.get(i).position.getY());
                System.out.print("a");
            }
        }
        System.out.println();
        for (int j=0; j<board.width*board.height;j++) {
            if (mapCells.containsKey(j)){
                lookForCells(mapCells.get(j),board);

            }

        }
        mapCells.forEach((k,v)->cellDecider(v)) ;
        nextTurn();
    }


}
