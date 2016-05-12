package com.better.than.yours.game.cucumbers.js.not.engine;

import com.better.than.yours.game.cucumbers.js.not.models.Board;

/**
 * Created by mati on 2016-05-12.
 */
public class GameThread implements Runnable {
    Engine engine;
    boolean isRunning = false;
    GameThread(Engine engine){
        this.engine = engine;
    }
    public void run(){
        this.isRunning = true;
        gameThread();
    }
    public void pause(){
        this.isRunning = false;
    }
    void gameThread(){
        //for (int i = 0; i < 100; i++){
        while (isRunning){
            engine.checkEach();
            engine.observer.push();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
