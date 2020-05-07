/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author Sam
 */
public interface Vertex {
    
    public enum Status {
        BLOCKED,
        OPEN,
        START,
        END,
        VISITED,
        ON_PATH
    }
    
    public class vColor {
    public static final Color BLOCKED = Color.BLACK;
    public static final Color OPEN = Color.WHITE;
    public static final Color START = Color.TOMATO;
    public static final Color END = Color.LAWNGREEN;
    public static final Color VISITED = Color.TURQUOISE;
    public static final Color ON_PATH = Color.DODGERBLUE;
    }
    
    /**
     * Gets a list of possible neighbors
     * @return List of near by vertices
     */
    public abstract ArrayList<Vertex> getNeighbors();
    
    /**
     * Gets Distance to End state
     * @return a number showing how close it is to the end state
     */
    public abstract double getHeuristic();
    
    /**
     * This is to check whether a vertex has been seen already when solving
     * @return current status of Vertex
     */
    public abstract Vertex.Status getStatus();
    
    /**
     * This is to check whether a vertex has been seen already when solving
     * @param status
     */
    public abstract void setStatus(Vertex.Status status);
}
