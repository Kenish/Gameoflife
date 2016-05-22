package com.better.than.yours.game.cucumbers.js.not;

/**
 * Created by Pszemek on 2016-05-22.
 */
public class RunGame implements Runnable{

    static Boolean a=true;
    int i = 0;
    @Override
    public void run() {

        Board board = new Board(100,100);
        Engine engine = new Engine(board,3000);
        /*engine.cellputter(CellFactory.makeCell(true,new Position(1,5), board));
        engine.cellputter(CellFactory.makeCell(true,new Position(1,6) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(2,5) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(2,6) ,board));

        engine.cellputter(CellFactory.makeCell(true,new Position(11,5) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(11,6) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(11,7) ,board));

        engine.cellputter(CellFactory.makeCell(true,new Position(12,4), board));
        engine.cellputter(CellFactory.makeCell(true,new Position(12,8) ,board));

        engine.cellputter(CellFactory.makeCell(true,new Position(13,3) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(13,9) ,board));

        engine.cellputter(CellFactory.makeCell(true,new Position(14,3) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(14,9) ,board));

        engine.cellputter(CellFactory.makeCell(true,new Position(15,6) ,board));

        engine.cellputter(CellFactory.makeCell(true,new Position(16,4) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(16,8) ,board));

        engine.cellputter(CellFactory.makeCell(true,new Position(17,5) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(17,6) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(17,7) ,board));

        engine.cellputter(CellFactory.makeCell(true,new Position(18,6) ,board));

        engine.cellputter(CellFactory.makeCell(true,new Position(21,3) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(21,4) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(21,5) ,board));

        engine.cellputter(CellFactory.makeCell(true,new Position(22,3) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(22,4) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(22,5) ,board));

        engine.cellputter(CellFactory.makeCell(true,new Position(23,2) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(23,6) ,board));

        engine.cellputter(CellFactory.makeCell(true,new Position(25,2) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(25,6) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(25,1) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(25,7) ,board));

        engine.cellputter(CellFactory.makeCell(true,new Position(35,3) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(35,4) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(36,3) ,board));
        engine.cellputter(CellFactory.makeCell(true,new Position(36,4) ,board));*/
        while (a){
            Display.clear();
            engine.playGame();
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ignored){

            }

        }
    }

    public static void shutdown() {
        a = false;

    }
}
