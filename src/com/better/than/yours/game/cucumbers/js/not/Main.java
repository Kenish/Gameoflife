package com.better.than.yours.game.cucumbers.js.not;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(100,100);
        Engine engine = new Engine(board,0);
        CellFactory factory= new CellFactory();
        HashMap map = engine.getMap();
        int[] a = {22,21};
        int[] b = {22,23};
        int[] c = {23,22};
        int[] d = {23,23};
        int[] e = {21,23};
        map.put(engine.generateId(board,22,21),factory.makeCell(true,a,board));
        map.put(engine.generateId(board,22,23),factory.makeCell(true,b,board));
        map.put(engine.generateId(board,23,22),factory.makeCell(true,c,board));
        map.put(engine.generateId(board,23,23),factory.makeCell(true,d,board));
        map.put(engine.generateId(board,21,23),factory.makeCell(true,e,board));

        for (int j=0;j<25;j++) {
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
        }

    }
}
