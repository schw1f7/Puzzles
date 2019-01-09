/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mythm.puzzles2.domains.puzzle;

import com.example.mythm.puzzles2.framework.problem.Mover;
import com.example.mythm.puzzles2.framework.problem.State;
import com.example.mythm.puzzles2.domains.puzzle.PuzzleState.Location;

import java.util.function.UnaryOperator;

/**
 *
 * @author Sam Schmidt
 */
public class PuzzleMover extends Mover {
    
    private final String slide1 = "Slide Tile 1";
    private final String slide2 = "Slide Tile 2";
    private final String slide3 = "Slide Tile 3";
    private final String slide4 = "Slide Tile 4";
    private final String slide5 = "Slide Tile 5";
    private final String slide6 = "Slide Tile 6";
    private final String slide7 = "Slide Tile 7";
    private final String slide8 = "Slide Tile 8";
    
    public PuzzleMover(){

        super.addMove(slide1, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return trySlide1(state);
            }
        });
        super.addMove(slide2, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return trySlide2(state);
            }
        });
        super.addMove(slide3, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return trySlide3(state);
            }
        });
        super.addMove(slide4, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return trySlide4(state);
            }
        });
        super.addMove(slide5, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return trySlide5(state);
            }
        });
        super.addMove(slide6, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return trySlide6(state);
            }
        });
        super.addMove(slide7, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return trySlide7(state);
            }
        });
        super.addMove(slide8, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return trySlide8(state);
            }
        });

    }
    
    public State trySlide1(State state){
        PuzzleState otherState = (PuzzleState) state;
        PuzzleState.Location blank = otherState.getLocation(0);
        PuzzleState.Location one = otherState.getLocation(1);
        
        if(one.getRow() == blank.getRow() && ((one.getColumn() - 1) == blank.getColumn() || 
          (one.getColumn() + 1) == blank.getColumn()) )
            return new com.example.mythm.puzzles2.domains.puzzle.PuzzleState(otherState, blank,one);
        if(one.getColumn() == blank.getColumn() && ((one.getRow() - 1) == blank.getRow() || 
          (one.getRow() + 1) == blank.getRow()) )
             return new PuzzleState(otherState, blank,one);
        
        else
            return null;
    }
    public State trySlide2(State state){
        PuzzleState otherState = (PuzzleState) state;
        PuzzleState.Location blank = otherState.getLocation(0);
        PuzzleState.Location two = otherState.getLocation(2);
        
        if(two.getRow() == blank.getRow() && ((two.getColumn() - 1) == blank.getColumn() || 
          (two.getColumn() + 1) == blank.getColumn()) )
            return new PuzzleState(otherState, blank, two);
        if(two.getColumn() == blank.getColumn() && ((two.getRow() - 1) == blank.getRow() || 
          (two.getRow() + 1) == blank.getRow()) )
             return new PuzzleState(otherState, blank,two);
        
        else
            return null;
    }
    public State trySlide3(State state){
        PuzzleState otherState = (PuzzleState) state;
        Location blank = otherState.getLocation(0);
        Location three = otherState.getLocation(3);
        
        if(three.getRow() == blank.getRow() && ((three.getColumn() - 1) == blank.getColumn() || 
          (three.getColumn() + 1) == blank.getColumn()) )
            return new PuzzleState(otherState, blank, three);
        if(three.getColumn() == blank.getColumn() && ((three.getRow() - 1) == blank.getRow() || 
          (three.getRow() + 1) == blank.getRow()) )
             return new PuzzleState(otherState, blank,three);
        
        else
            return null;
    }
    public State trySlide4(State state){
        PuzzleState otherState = (PuzzleState) state;
        Location blank = otherState.getLocation(0);
        Location four = otherState.getLocation(4);
        
        if(four.getRow() == blank.getRow() && ((four.getColumn() - 1) == blank.getColumn() || 
          (four.getColumn() + 1) == blank.getColumn()) )
            return new PuzzleState(otherState, blank, four);
        if(four.getColumn() == blank.getColumn() && ((four.getRow() - 1) == blank.getRow() || 
          (four.getRow() + 1) == blank.getRow()) )
             return new PuzzleState(otherState, blank,four);
        
        else
            return null;
    }
    public State trySlide5(State state){
        PuzzleState otherState = (PuzzleState) state;
        Location blank = otherState.getLocation(0);
        Location five = otherState.getLocation(5);
        
        if(five.getRow() == blank.getRow() && ((five.getColumn() - 1) == blank.getColumn() || 
          (five.getColumn() + 1) == blank.getColumn()) )
            return new PuzzleState(otherState, blank, five);
        if(five.getColumn() == blank.getColumn() && ((five.getRow() - 1) == blank.getRow() || 
          (five.getRow() + 1) == blank.getRow()) )
             return new PuzzleState(otherState, blank,five);
        
        else
            return null;
    }
    public State trySlide6(State state){
        PuzzleState otherState = (PuzzleState) state;
        Location blank = otherState.getLocation(0);
        Location six = otherState.getLocation(6);
        
        if(six.getRow() == blank.getRow() && ((six.getColumn() - 1) == blank.getColumn() || 
          (six.getColumn() + 1) == blank.getColumn()) )
            return new PuzzleState(otherState, blank, six);
        if(six.getColumn() == blank.getColumn() && ((six.getRow() - 1) == blank.getRow() || 
          (six.getRow() + 1) == blank.getRow()) )
             return new PuzzleState(otherState, blank, six);
        
        else
            return null;
    }
    public State trySlide7(State state){
        PuzzleState otherState = (PuzzleState) state;
        Location blank = otherState.getLocation(0);
        Location seven = otherState.getLocation(7);
        
        if(seven.getRow() == blank.getRow() && ((seven.getColumn() - 1) == blank.getColumn() || 
          (seven.getColumn() + 1) == blank.getColumn()) )
            return new PuzzleState(otherState, blank, seven);
        if(seven.getColumn() == blank.getColumn() && ((seven.getRow() - 1) == blank.getRow() || 
          (seven.getRow() + 1) == blank.getRow()) )
             return new PuzzleState(otherState, blank, seven);
        
        else
            return null;
    }
    public State trySlide8(State state){
        PuzzleState otherState = (PuzzleState) state;
        Location blank = otherState.getLocation(0);
        Location eight = otherState.getLocation(8);
        
        if(eight.getRow() == blank.getRow() && ((eight.getColumn() - 1) == blank.getColumn() || 
          (eight.getColumn() + 1) == blank.getColumn()) )
            return new PuzzleState(otherState, blank, eight);
        if(eight.getColumn() == blank.getColumn() && ((eight.getRow() - 1) == blank.getRow() || 
          (eight.getRow() + 1) == blank.getRow()) )
             return new PuzzleState(otherState, blank, eight);
        else
            return null;
    }
    
    
}
