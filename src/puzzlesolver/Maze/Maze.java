/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlesolver.Maze;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import puzzlesolver.PuzzleInterface;
import puzzlesolver.Util.AlgType;

/**
 *
 * @author Sam
 */
public class Maze extends Pane implements PuzzleInterface {
    public int wCell, hCell, height, width, offSet;
    private ArrayList<ArrayList<CellStates>> cellStateList;
    
    public Maze(int width,int height) {
        offSet = Cell.DIM_OF_CELL;
        this.width = width * offSet;
        this.height = height * offSet;
        this.wCell = width;
        this.hCell = height;
        
        initList();
        
        super.setPrefSize(this.height, this.width);
        clearGrid();
    }
    
    private void initList() {
        cellStateList = new ArrayList<>();
        cellStateList.ensureCapacity(height);
        for (int i = 0; i < height; ++i) {
            cellStateList.add(new ArrayList<>());
        }
    }
    
    private void clearGrid() {
        super.getChildren().clear();
        cellStateList.clear();
        initList();
        for(int r = 0; r < hCell; r++) {
            for (int c = 0; c < wCell; c++) {
                addCelltoPane(new Cell(Color.WHITE),r , c);
            }
        }
    }
    
    private void createMazeArray(Location start, Location end,int scale) {
        for (int r = 0; r < hCell; ++r) {
            for (int c = 0; c < wCell; ++c) {
                if((Math.random() * 100) < scale){
                    cellStateList.get(c).add(CellStates.WALL);
                } else {
                    cellStateList.get(c).add(CellStates.OPEN);
                }
            }
        }
        cellStateList.get(start.x).set(start.y,CellStates.START);
        cellStateList.get(end.x - 1).set(end.y - 1,CellStates.END);
    }
    
    private void displayMazeArray() {
        for (int r = 0; r < hCell; ++r) {
            for (int c = 0; c < wCell; ++c) {
                switch (cellStateList.get(c).get(r)) {
                    case START:
                        addCell(c * offSet, r * offSet,Color.CRIMSON);
                        break;
                    case END:
                        addCell(c * offSet, r * offSet,Color.CHARTREUSE);
                        break;
                    case WALL:
                        addCell(c * offSet, r * offSet,Color.BLACK);
                        break;
                    case OPEN:
                        addCell(c * offSet, r * offSet,Color.WHITE);
                        break;
                    case ON_PATH:
                        addCell(c * offSet, r * offSet,Color.CORNFLOWERBLUE);
                        break;
                    case VISITED:
                        addCell(c * offSet, r * offSet,Color.DARKTURQUOISE);
                        break;
                    default:
                        System.out.println("A Cell State Was Not Implimented");
                }
            }
        }
    }
    private void addCell(int x, int y, Color col) {
        Cell newCell = new Cell(col);
        newCell.relocate(x, y);
        super.getChildren().add(newCell);
    }
    
    
    @Override
    public int getPuzHeight() {
        return height;
    }
    
    @Override
    public void Generate(int scale) {
        clearGrid();
        createMazeArray(new Location(0,0), new Location(wCell,hCell), scale);
        displayMazeArray();
    }

    @Override
    public boolean Solve(AlgType algType) {
        clearGrid();
        System.out.println("Im trying to solve a maze");
        return false;    
    }
    
    /**
     * Gets the Valid Set of neighbors to a cell
     * @param x
     * @param y
     * @return 
     */
    private ArrayList<Location> getValidLocalList(int x, int y) {
        ArrayList<Location> localList = new ArrayList<>();
        
       
        return localList;
    }
    
    private void addCelltoPane(Cell cell, int r, int c) {
        cell.relocate(c*offSet, r*offSet);
        super.getChildren().add(cell);
    }

    public class Location {
        
        private int x, y;
        
        Location (int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
    } 
}
