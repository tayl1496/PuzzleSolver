/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlesolver.Maze;

import Framework.Vertex;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sam
 */
public final class Cell extends Rectangle implements Vertex {
    private Vertex.Status status;
    private int x, y;
    private final ArrayList<ArrayList<Cell>> CellList;
    
    public static int DIM_OF_CELL = 10;
    
    public Cell(ArrayList<ArrayList<Cell>> CellList,Vertex.Status status,int x,int y){
        super(DIM_OF_CELL,DIM_OF_CELL);
        super.setStroke(Color.BLACK);
        super.setStrokeWidth(0.5);
        this.CellList = CellList;
        
        setLocX(x);
        setLocY(y);
        this.status = status;
        setColorWithState(status);
    }
    
    @Override
    public ArrayList<Vertex> getNeighbors() {
        ArrayList<Vertex> validCells = new ArrayList<>();
        for (int c = (this.x - 1); c <= (this.x + 1); ++c) {
            for (int r = (this.y - 1); r <= (this.y + 1); ++r) {
                Cell aCell = CellList.get(c).get(r);
                validCells.add(aCell);
            }
        }
        
        return validCells;
    }

    @Override
    public double getHeuristic() {
        return 0;
    }
    
    public void setColorWithState (Vertex.Status status) {
        switch (status) {
            case START:
                super.setFill(Vertex.vColor.START);
                break;
            case END:
                super.setFill(Vertex.vColor.END);
                break;
            case BLOCKED:
                super.setFill(Vertex.vColor.BLOCKED);
                break;
            case OPEN:
                super.setFill(Vertex.vColor.OPEN);
                break;
            case ON_PATH:
                super.setFill(Vertex.vColor.ON_PATH);
                break;
            case VISITED:
                super.setFill(Vertex.vColor.VISITED);
                break;
            default:
                System.out.println("A Cell State Was Not Implimented - Cell.java");
        }
    }
    
    @Override
    public Vertex.Status getStatus(){
        return status;
    }
    @Override
    public void setStatus(Vertex.Status status){
        this.status = status;
        setColorWithState(status);
    }
    
    public int getLocX() {
        return x;
    }
    
    public int getLocY(){
        return y;
    }
    
    public void setLocX(int x) {
        super.setX(x * DIM_OF_CELL);
        this.x = x;
    }
    
    public void setLocY(int y) {
        super.setY(y * DIM_OF_CELL);
        this.y = y;
    }

    
}
