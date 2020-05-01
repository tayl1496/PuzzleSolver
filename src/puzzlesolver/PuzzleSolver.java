/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlesolver;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import puzzlesolver.Maze.Maze;
import puzzlesolver.Util.Settings;

/**
 *
 * @author Sam
 */
public class PuzzleSolver extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();
        
        Maze puzzle = new Maze(50,50);
        Settings settings = new Settings("This Is the puzzle Solver",puzzle);
        
        root.getChildren().addAll(settings,puzzle);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Puzzle Solver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
