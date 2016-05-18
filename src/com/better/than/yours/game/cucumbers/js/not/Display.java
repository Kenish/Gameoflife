package com.better.than.yours.game.cucumbers.js.not;

import javafx.application.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by mati on 2016-05-14.
 *
 */

public class Display extends Application {
    private Group root;
    private Stage primaryStage;
    private GraphicsContext gc;
    private int mapSize;
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("The Game of Life");
        root = new Group();
        InitializeGame(800, 600);
        draw(5,4);
    }

    public void run(String[] args) {
        launch(args);
    }

    private void InitializeGame(int mapSize, int populationPercentage) {
        //canvas
        System.out.println("Game started");
        System.out.println(mapSize + " " + populationPercentage);
        Canvas canvas = new Canvas(mapSize * 10, mapSize * 10);
        this.gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, mapSize * 10, mapSize * 10);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void draw(int x, int y) {
        gc.setFill(Color.BLACK);
        gc.fillRect(x * 10, y * 10, 10, 10);
    }
    public void clear() {
        gc.clearRect(0, 0, mapSize * 10, mapSize * 10);
    }
}
