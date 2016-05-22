package com.better.than.yours.game.cucumbers.js.not;

class RunGame implements Runnable{
    private static Boolean shouldBeRunning =true;
    @Override
    public void run() {

        new Board(100,100);
        Engine engine = new Engine(0); // change to anything else than 0 and play randomly
        // cannon
        //change everything here
        engine.cellPutter(CellFactory.makeCell(true,new Position(1,5)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(1,6)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(2,5)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(2,6)));

        engine.cellPutter(CellFactory.makeCell(true,new Position(11,5)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(11,6)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(11,7)));

        engine.cellPutter(CellFactory.makeCell(true,new Position(12,4)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(12,8)));

        engine.cellPutter(CellFactory.makeCell(true,new Position(13,3)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(13,9)));

        engine.cellPutter(CellFactory.makeCell(true,new Position(14,3)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(14,9)));

        engine.cellPutter(CellFactory.makeCell(true,new Position(15,6)));

        engine.cellPutter(CellFactory.makeCell(true,new Position(16,4)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(16,8)));

        engine.cellPutter(CellFactory.makeCell(true,new Position(17,5)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(17,6)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(17,7)));

        engine.cellPutter(CellFactory.makeCell(true,new Position(18,6)));

        engine.cellPutter(CellFactory.makeCell(true,new Position(21,3)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(21,4)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(21,5)));

        engine.cellPutter(CellFactory.makeCell(true,new Position(22,3)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(22,4)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(22,5)));

        engine.cellPutter(CellFactory.makeCell(true,new Position(23,2)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(23,6)));

        engine.cellPutter(CellFactory.makeCell(true,new Position(25,2)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(25,6)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(25,1)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(25,7)));

        engine.cellPutter(CellFactory.makeCell(true,new Position(35,3)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(35,4)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(36,3)));
        engine.cellPutter(CellFactory.makeCell(true,new Position(36,4)));
        // Todo:nice pretty thingies to change rules etc.
        while (shouldBeRunning){
            Display.clear();
            engine.playGame();
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ignored){

            }

        }
    }

    static void shutdown() {
        shouldBeRunning = false;

    }
}
