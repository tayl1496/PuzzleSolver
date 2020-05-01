/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlesolver.Maze;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sam
 */
public final class Cell extends Rectangle {
    private boolean wall;
    
    public static int DIM_OF_CELL = 10;
    
    public Cell(Color color){
        super(DIM_OF_CELL,DIM_OF_CELL);
        super.setStroke(Color.BLACK);
        super.setStrokeWidth(0.5);
        wall = false;
        setColor(color);
    }
    
    public void setColor(Color color) {
        super.setFill(color);
        if (color == Color.BLACK) {
            wall = true;
        }
    }
    
    public boolean isWall(){
        return wall;
    }
}
