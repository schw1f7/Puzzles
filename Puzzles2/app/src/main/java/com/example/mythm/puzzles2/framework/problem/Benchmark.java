package com.example.mythm.puzzles2.framework.problem;


/**
 *
 * @author Sam Schmidt Section 005
 */
public class Benchmark {
    public Benchmark(String name, State start, State goal){
        this.name = name;
        this.start = start;
        this.goal = goal;
    }
    
    public State getStart(){
        return this.start;
    }
    
    public State getGoal(){
        return this.goal;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    private final State start;
    private final State goal;
    private final String name;
}
