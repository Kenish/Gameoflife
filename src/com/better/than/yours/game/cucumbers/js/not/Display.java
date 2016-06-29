package com.better.than.yours.game.cucumbers.js.not;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Display extends Application {
    private Group root;
    private Stage primaryStage;
    private static GraphicsContext gc;
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("The Game of Life");
        root = new Group();
        Scene scene = new Scene(root, 800, 600);
        GridPane grid = new GridPane();
        scene.setRoot(grid);

        Button startGameButton = new Button("Start Game");
        startGameButton.setOnAction(event -> {
            try {
                initializeGame();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        startGameButton.isDefaultButton();
        grid.add(startGameButton, 1, 2);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeGame() throws InterruptedException {
 
        System.out.println("Game started");
        Canvas canvas = new Canvas(1000, 1000);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 1000, 1000);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(e->RunGame.shutdown());
        primaryStage.show();
        Thread thread = new Thread(new RunGame());
        thread.start();
    }

    void run(String[] args){
        launch(args);
    }

   static void draw(int x, int y) {
        gc.setFill(Color.BLACK);
        gc.fillRect(x * 10, y * 10, 10, 10);
    }

    static void clear() {
        gc.clearRect(0, 0,1000,1000);
    }
}
