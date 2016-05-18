package com.better.than.yours.game.cucumbers.js.not;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
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
    private int dwa;
    public void start(Stage primaryStage) throws Exception {
        //jakies gowno;
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("The Game of Life");
        root = new Group();
        Scene scene = new Scene(root, 800, 600);
        GridPane grid = new GridPane();
        scene.setRoot(grid);
        //button on-click: initializeGame();
        Button startGameButton = new Button("Start Game");
        startGameButton.setOnAction(event -> initializeGame());
        startGameButton.isDefaultButton();
        grid.add(startGameButton, 1, 2);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeGame(){
        //canvas
        System.out.println("Game started");
        Canvas canvas = new Canvas(1000, 1000);
        this.gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 1000, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();

        //TODO: TUTAJ MUSISZ URUCHOMIć GRE, WIĘC WYPIERDZIELAJ Z NIĄ Z MAINA :D
        //engine.initializeGame() //or sth like that;
    }

    public void run(String[] args){
        launch(args);
    }

    public void draw(int x, int y) {
        gc.setFill(Color.BLACK);
        gc.fillRect(x * 10, y * 10, 10, 10);
    }

    public void clear() {
        gc.clearRect(0, 0, mapSize * 10, mapSize * 10);
    }
}
