package com.better.than.yours.game.cucumbers.js.not;

import com.better.than.yours.game.cucumbers.js.not.engine.Engine;
import com.better.than.yours.game.cucumbers.js.not.engine.Rules;
import com.better.than.yours.game.cucumbers.js.not.models.Board;

public class Main {

    public static void main(String[] args) {
        Rules rules = new Rules(1, 4, 3);
        Board board = new Board(10, 10);
        Engine engine = new Engine(board, rules);
        engine.startGame(40);
    }
}
