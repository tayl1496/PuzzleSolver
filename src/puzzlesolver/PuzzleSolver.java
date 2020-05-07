/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlesolver;

import Framework.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import puzzlesolver.Util.AlgType;

/**
 *
 * @author Sam
 */
public class PuzzleSolver {
    
    private final  PuzzleInterface puzzle;
    private final  Vertex start;
    private final Stack<Vertex> stack;
    private final List<Vertex> path;
    private boolean showSteps;
    
    public PuzzleSolver(PuzzleInterface puzzle, Vertex start) {
        path = new ArrayList<>();
        stack = new Stack<>();
        this.puzzle = puzzle;
        this.start = start;
        showSteps = false;
    }
    
    
    public List<Vertex> solveUsing(AlgType alg, boolean showSteps) {
        this.showSteps = showSteps;
        switch(alg) {
            case BREADTH_FIRST:
                return Collections.EMPTY_LIST;
            case DEPTH_FIRST:
                return depthFirst();
            case DIJKSTRA:
                return Collections.EMPTY_LIST;
            case ASTAR:
                return Collections.EMPTY_LIST;
            case TURN_LEFT:
                return Collections.EMPTY_LIST;
            default:
                System.out.println("Error: Algorithm Not Found - FileName: MazeSolver");
        }
        return Collections.EMPTY_LIST;
    }

    private List<Vertex> depthFirst() {
        path.add(start);
        addNeighborsToStack(start);
        if (DFS(stack.pop())) {
            return path;
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    private boolean DFS(Vertex vert) {
        if (vert.getStatus() == Vertex.Status.END) {
            return true;
        } else {
            vert.setStatus(Vertex.Status.ON_PATH);
            path.add(vert);
        } 
        addNeighborsToStack(vert);
        if (stack.isEmpty()) {
            return false;
        }
        return DFS(stack.pop());
    }

    private void addNeighborsToStack(Vertex vert) {
        vert.getNeighbors().forEach((v) -> { 
            if (v.getStatus() == Vertex.Status.OPEN || v.getStatus() == Vertex.Status.END) {
                 stack.push(v);
            }
        });
    }

    private void displayStack() {
        stack.forEach((v) -> {
        System.out.println(v.getStatus());
        });
    }
}
