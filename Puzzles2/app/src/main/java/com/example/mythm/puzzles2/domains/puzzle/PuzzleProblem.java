/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.puzzle;
import com.example.mythm.puzzles2.domains.puzzle.PuzzleMover;
import com.example.mythm.puzzles2.domains.puzzle.PuzzleState;
import com.example.mythm.puzzles2.framework.problem.Benchmark;
import com.example.mythm.puzzles2.framework.problem.Problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *
 * @author Sam Schmidt
 */
public class PuzzleProblem extends Problem {
    
     public PuzzleProblem(){
         super();
         super.setName("Puzzle");
         super.setIntroduction(INTRO);
         super.setMover(new PuzzleMover());
         super.setInitialState(new PuzzleState(
                new int[][]{new int[]{5, 2, 7},
                            new int[]{8, 0, 4},
                            new int[]{3, 6, 1}}));
         super.setCurrentState(super.getInitialState());
         super.setFinalState(new PuzzleState(
                new int[][]{new int[]{1, 2, 3}, 
                            new int[]{8, 0, 4}, 
                            new int[]{7, 6, 5}}));
         bList = new ArrayList();
         bList.add(new Benchmark("Bench 1: 5 moves", b1, END));
         bList.add(new Benchmark("Bench 2: 10 moves", b2, END));
         bList.add(new Benchmark("Bench 3: 13 moves", b3, END));
         bList.add(new Benchmark("Bench 4: 18 moves", b4, END));
         bList.add(new Benchmark("Bench 5: 20 moves", b5, END));
         bList.add(new Benchmark("Bench 6: 24 moves", b6, END));
         bList.add(new Benchmark("Bench 7: 30 moves", b7, END));
         bList.add(new Benchmark("Bench 8: 30 moves", b8, END));
         super.setBList(this.bList);
     }
     
     
     private final PuzzleState END = new PuzzleState(
                new int[][]{new int[]{1, 2, 3}, 
                            new int[]{8, 0, 4}, 
                            new int[]{7, 6, 5}});
     private final String INTRO = "You are given a board in which numbered tiles can slide around. " +
                                    "There is one blank space that holds no tile. A legal move " +
                                    "consists of sliding a tile into the blank space if the tile " + 
                                    "is adjacent to it. the goal is to move tiles around until the "+
                                    "board looks like the final state below.\n\n";
     
     
     
     List<Benchmark> bList;
     PuzzleState b1 = new PuzzleState(
                new int[][]{new int[]{2, 8, 3}, 
                            new int[]{1, 6, 4}, 
                            new int[]{7, 0, 5}});
     PuzzleState b2 = new PuzzleState(
                new int[][]{new int[]{3, 6, 4}, 
                            new int[]{1, 0, 2}, 
                            new int[]{8, 7, 5}});
     PuzzleState b3 = new PuzzleState(
                new int[][]{new int[]{3, 0, 4}, 
                            new int[]{1, 6, 5}, 
                            new int[]{8, 2, 7}});
     PuzzleState b4 = new PuzzleState(
                new int[][]{new int[]{2, 1, 3}, 
                            new int[]{8, 0, 4}, 
                            new int[]{6, 7, 5}});
     PuzzleState b5 = new PuzzleState(
                new int[][]{new int[]{4, 2, 0}, 
                            new int[]{8, 3, 6}, 
                            new int[]{7, 5, 1}});
     PuzzleState b6 = new PuzzleState(
                new int[][]{new int[]{1, 6, 3}, 
                            new int[]{4, 0, 8}, 
                            new int[]{7, 2, 5}});
     PuzzleState b7 = new PuzzleState(
                new int[][]{new int[]{5, 2, 7}, 
                            new int[]{8, 0, 4}, 
                            new int[]{3, 6, 1}});
     PuzzleState b8 = new PuzzleState(
                new int[][]{new int[]{5, 6, 7}, 
                            new int[]{4, 0, 8}, 
                            new int[]{3, 2, 1}});
     
}
