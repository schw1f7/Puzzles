package com.example.mythm.puzzles2.framework.solution;
import framework.graph.Vertex;
import java.util.Stack;

public class Solution {

    /**
     * Creates an object that represents a path from a start
     * vertex to an end vertex in a problem solving domain.
     * This constructor will be called after a search has been
     * initiated on the start vertex.
     * If a path from start to end exists, it can be constructed
     * from the predecessor information stored in the end vertex.
     * @param start the start vertex
     * @param end the end vertex
     */
    public Solution(Vertex start, Vertex end) {
        count = 0;
        vertexStack.push(end);
        Vertex predecessor = end.getPredecessor();
        while(predecessor.getPredecessor() != null){
            vertexStack.push(predecessor);
            count++;
            predecessor = predecessor.getPredecessor();
        }
        vertexStack.push(start);
        count++;
        this.start = start;
        this.end = end;
    }

    /**
     * Gets the length of the solution, that is, the number of moves
     * to get to the end state from the start.
     * @return the solution length
     */
    public int getLength() {
        /* you must provide */
        return count;
    }
    
    /**
     * Checks whether there are more vertices in this solution.
     * @return true if there are more vertices in this solution, false
     * otherwise
     */
    public boolean hasNext() {
        /* you must provide */
        return count >= 0;
    }
    
    /**
     * Removes and returns the next vertex in this solution.
     * @return the next vertex in this solution
     * @throws RuntimeException if there are no more vertices
     */
    public Vertex next() {
        /* you must provide */
        count--;
        return vertexStack.pop();
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        
        for(Vertex v : vertexStack){
            builder.append(v);
            builder.append("\n\n");
            
        }
        builder.append("\n");
        return builder.toString();
    }
    
    /* private instance fields and methods here */
    private final Vertex start;
    private final Vertex end;
    private Stack<Vertex> vertexStack = new Stack();
    private int count;
}