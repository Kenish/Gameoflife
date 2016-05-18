package com.better.than.yours.game.cucumbers.js.not;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(100,100);
        Engine engine = new Engine(board,0);
        CellFactory factory= new CellFactory();
        HashMap map = engine.getMap();
        int a[] = {30,5};
        int b[] = {30,7 };
        int c[] = {29,7 };
        int d[] = {32,6 };
        int e[] = {33,7 };
        int f[] = {34,7 };
        int g[] = {35,7 };
        map.put(engine.generateId(board,30,5),factory.makeCell(true,a,board));
        map.put(engine.generateId(board,30,7),factory.makeCell(true,b,board));
        map.put(engine.generateId(board,29,7),factory.makeCell(true,c,board));
        map.put(engine.generateId(board,32,6),factory.makeCell(true,d,board));
        map.put(engine.generateId(board,33,7),factory.makeCell(true,e,board));
        map.put(engine.generateId(board,34,7),factory.makeCell(true,f,board));
        map.put(engine.generateId(board,35,7),factory.makeCell(true,g,board));
        for (int j=0;j<60;j++) {
            for (int k=0; k<board.height*board.width;k++){
                if (map.containsKey(k)){
                    engine.lookForCells((Cell)map.get(k),board);
                    engine.makeSomeDeadCells((Cell)map.get(k),board,factory);

                }
            }

            for (int i = 0; (i < board.height * board.width); i++) {
                if (map.containsKey(i)) {
                    if(((Cell) map.get(i)).isAlive()){
                        System.out.println("X: "+ ((Cell) map.get(i)).getPositionX() + " Y:" + ((Cell) map.get(i)).getPositionY());
                    }
                    engine.cellDecider((Cell) map.get(i), board, factory);
                }

            }
            engine.nextTurn();
            System.out.println("new turn");
            System.out.println("population" + map.size());
        }

    }
}
