package com.better.than.yours.game.cucumbers.js.not;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(10,10);
        Engine engine = new Engine(board,10);
        HashMap map = engine.getMap();

	// write your code here
    }
}
