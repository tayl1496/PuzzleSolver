/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlesolver;

import puzzlesolver.Util.AlgType;

/**
 * This is to serve as a base Interface for different puzzles so that Settings
 * can accuratly talk to the puzzles
 * @author Sam
 */
public interface PuzzleInterface {
    
    /**
     * The Puzzles will handle generating themselves because they might not all
     * display in the same way
     * @param scale how much is open
     */
    public abstract void Generate(int scale);
    
    /**
     * The Puzzles will handle the implementation for the separate states
     * @param algType
     * @return T/F if it found a solution or not
     */
    public abstract boolean Solve(AlgType algType);

    public abstract int getPuzHeight();
    
}
