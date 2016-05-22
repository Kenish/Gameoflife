package com.better.than.yours.game.cucumbers.js.not;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
class Engine {
   private ArrayList<Cell> toRevive = new ArrayList<>();
    private ArrayList<Cell> toKill = new ArrayList<>();
    private HashMap<Integer,Cell> mapCells= new HashMap<>();
    Engine(int population) {
        Random rnd = new Random();
        for (int i = 0; i < population; i++) {
            Position position = new Position(rnd.nextInt(Board.width), rnd.nextInt(Board.height));
            Cell cell = CellFactory.makeCell(true, position);
            mapCells.put(cell.getId(), cell);
        }
    }

    private Integer lookForCells(Cell cell) { // looking for all Cell neighbours
        cell.zeroNeighbours();
        Integer posX = cell.position.getX();
        Integer posY = cell.position.getY();

        for (int j=-1; j<2;j++) {
            for (int i = -1; i < 2; i++) {
                if (!(i==0&&j==0)){
                    Integer checkPosition = generateId(posX + j, posY + i);
                    if(mapCells.containsKey(checkPosition)&&mapCells.get(checkPosition).isAlive()){
                            cell.addNeigbour();
                    }
                }
            }
        }
        return cell.getLivingNeighbours();
    }

    private void makeSomeDeadCells(Cell cell){ //making dead neighbours
        Integer posX = cell.position.getX();
        Integer posY = cell.position.getY();
        for (int j=-1; j<2;j++) {
            for (int i = -1; i < 2; i++) {
                if (!(i == 0 && j == 0)) {
                    Integer checkPosition = generateId(posX + j, posY + i);
                    if (posX + j > 0 && posY + i > 0 && posX + j < Board.width && posY + i < Board.height && !mapCells.containsKey(checkPosition)) {
                        Position position = new Position(posX+j,posY+i);
                        cellPutter(CellFactory.makeCell(false, position));
                    }

                }
            }
        }
    }

    private void cellDecider(Cell cell){ //deciding of life and death
        if (cell.getLivingNeighbours()==3 && !cell.isAlive()){
            toRevive.add(cell);
        }
        else if ((cell.getLivingNeighbours()<2 && cell.isAlive()) || (cell.getLivingNeighbours()>3 && cell.isAlive()) ){
            toKill.add(cell);
        }
    }

    private void nextTurn(){ // flushing
        toRevive.forEach(Cell::revive) ;
        toRevive.clear();
        toKill.forEach(Cell::kill);
        toKill.clear();
        //it might need HashMap clearing
    }
    private static Integer generateId(Integer posX, Integer posY){
    //unique id generator
        return posX+(posY*Board.width);
    }

    void cellPutter(Cell cell){//puttin cellse
        mapCells.put(generateId(cell.position.getX(),cell.position.getY()),cell);
    }

    void playGame(){//main play loop

        for (int i=0; i<Board.width*Board.height;i++) {
            if (mapCells.containsKey(i)&&mapCells.get(i).isAlive()) {
                makeSomeDeadCells(mapCells.get(i));
                Display.draw(mapCells.get(i).position.getX(),mapCells.get(i).position.getY());
                System.out.print("a");
            }
        }
        System.out.println();
        for (int j=0; j<Board.width*Board.height;j++) {
            if (mapCells.containsKey(j)){
                lookForCells(mapCells.get(j));

            }

        }
        mapCells.forEach((k,v)->cellDecider(v)) ;
        nextTurn();
    }


}
