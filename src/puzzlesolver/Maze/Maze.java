/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlesolver.Maze;

import Framework.PuzzleInterface;
import Framework.Vertex;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.layout.Pane;
import puzzlesolver.PuzzleSolver;
import puzzlesolver.Util.AlgType;

/**
 *
 * @author Sam
 */
public class Maze extends Pane implements PuzzleInterface {
    public int wCell, hCell, height, width, offSet;
    private ArrayList<ArrayList<Cell>> CellList;
    private Cell start, end;
    
    public Maze(int width,int height) {
        offSet = Cell.DIM_OF_CELL;
        this.width = width * offSet;    //width in pixels for the Maze Pane
        this.height = height * offSet;  //height in pixels for the Maze Pane
        this.wCell = width;             //width in number of cells
        this.hCell = height;            //height in number of cells
        
        initList();
        
        super.setPrefSize(this.height, this.width);
        clearGrid();
    }
    
    private void initList() {
        CellList = new ArrayList<>();
        CellList.ensureCapacity(height);
        for (int i = 0; i < height; ++i) {
            CellList.add(new ArrayList<>());
        }
    }
    
    private void clearGrid() {
        super.getChildren().clear();
        for(int r = 0; r < hCell; r++) {
            for (int c = 0; c < wCell; c++) {
                addCelltoPane(new Cell(CellList, Vertex.Status.OPEN, c, r));
            }
        }
    }
    
    private void createMazeArray(Cell start, Cell end,int scale) {
        for (int r = 0; r < hCell; ++r) {
            for (int c = 0; c < wCell; ++c) {
                if((Math.random() * 100) < scale){
                    CellList.get(c).add(new Cell(CellList, Vertex.Status.BLOCKED, c, r));
                } else {
                    CellList.get(c).add(new Cell(CellList, Vertex.Status.OPEN, c, r));
                }
            }
        }
        for (int r = 0; r < hCell; ++r) {
            CellList.get(r).get(0).setStatus(Vertex.Status.BLOCKED);
            CellList.get(r).get(hCell-1).setStatus(Vertex.Status.BLOCKED);
        }
        for (int c = 0; c < wCell; ++c) {
            CellList.get(0).get(c).setStatus(Vertex.Status.BLOCKED);
            CellList.get(wCell-1).get(c).setStatus(Vertex.Status.BLOCKED);
        }
        CellList.get(start.getLocX()).set(start.getLocY(),start);
        CellList.get(end.getLocX()).set(end.getLocY(), end);
    }
    
    private void displayMazeArray() {
        clearGrid();
        for (int r = 0; r < hCell; ++r) {
            for (int c = 0; c < wCell; ++c) {
                super.getChildren().add(CellList.get(c).get(r));
            }
        }
    }
    
    @Override
    public int getPuzHeight() {
        return height;
    }
    
    @Override
    public void Generate(int scale) {
        clearGrid();
        initList();
        start = new Cell(CellList, Vertex.Status.START,1,1);
        end = new Cell(CellList, Vertex.Status.END,wCell - 2, hCell - 2);
        createMazeArray(start, end, scale);
        displayMazeArray();
    }

    @Override
    public void Solve(AlgType algType, boolean showSteps) {
        PuzzleSolver solver = new PuzzleSolver(this, start);
        if (solver.solveUsing(algType, showSteps) != Collections.EMPTY_LIST) {
            System.out.println("There is a Solution who Knows if you want it.");
            displayMazeArray();
        } else {
            System.out.println("The Solution List is EMPTY! I can't use this.");
        }
    }
    
    @Override
    public  PuzzleInterface.VertList getPuzzleVerts(){
        List<Vertex> list = new ArrayList<>();
        for (int r = 0; r < hCell; ++r) {
            for (int c = 0; c < wCell; ++c) {
                list.add(CellList.get(c).get(r));
            }
        }
        return new PuzzleInterface.VertList(list, wCell);
    }
    
    private void addCelltoPane(Cell cell) {
        cell.relocate(cell.getLocX()*offSet, cell.getLocY()*offSet);
        super.getChildren().add(cell);
    }

    public int getWCell() {
        return wCell;
    }

    public int getHCell() {
        return hCell;
    }

    public Cell getStart() {
        return start;
    }

    public Cell getEnd() {
        return end;
    }

    public ArrayList<ArrayList<Cell>> getCellList() {
        return CellList;
    }

    
}
