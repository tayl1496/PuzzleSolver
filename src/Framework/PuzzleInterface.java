/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import java.util.List;
import puzzlesolver.Util.AlgType;

/**
 * This is to serve as a base Interface for different puzzles so that Settings
 * can accuratly talk to the puzzles
 * @author Sam
 */
public interface PuzzleInterface {
    
    public class VertList {
        List<Vertex> verts;
        int n;

        /**
         * 
         * @param verts
         * @param n this is the number of vertexes in a row so this can deal with 1D and 2D puzzles
         */
        public VertList(List<Vertex> verts, int n) {
            this.verts = verts;
            this.n = n;
        }

        public List<Vertex> getVerts() {
            return verts;
        }

        public void setVerts(List<Vertex> verts) {
            this.verts = verts;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }
    }
    /**
     * The Puzzles will handle generating themselves because they might not all
     * display in the same way
     * @param scale how much is open
     */
    public abstract void Generate(int scale);
    
    /**
     * The Puzzles will handle the implementation for the separate states
     * @param algType
     * @param showSteps
     */
    public abstract void Solve(AlgType algType, boolean showSteps);

    public abstract int getPuzHeight();
    
    public abstract PuzzleInterface.VertList getPuzzleVerts();
    
}
