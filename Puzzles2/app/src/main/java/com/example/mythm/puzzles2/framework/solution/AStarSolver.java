package com.example.mythm.puzzles2.framework.solution;

import com.example.mythm.puzzles2.framework.problem.Problem;
import com.example.mythm.puzzles2.framework.problem.State;

import framework.graph.Vertex;
import java.util.Comparator;
import java.util.PriorityQueue;

/* imports go here */

/**
 * This class represents an A* solver by extending the StateSpaceSolver
 * class.
 * @author Sam Schmidt Section 005
 */
public class AStarSolver extends StateSpaceSolver {
    
    /**
     * Creates an A* solver.
     * This constructor should set the queue to a priority queue (PQ)
     * and set the statistics header.
     * @param problem 
     */
    public AStarSolver(Problem problem) {
        super(problem, false);
        super.getStatistics().setHeader("A* Seach Statistics\n" +
                                            "------------------------------\n"
                                            );
        PriorityQueue<Vertex> pq = new PriorityQueue(this.getComparator());
        super.setQueue(pq);
    }
    
    /**
     * Adds a vertex to the PQ.
     * @param v the vertex to be added
     */
    @Override
    public void add(Vertex v) {
        /* you must provide */
        this.getQueue().add(v);
    }
    
    /**
     * Creates a comparator object that compares vertices for ordering
     * in a PQ during A* search.
     * This should be used when creating the PQ.
     * @return the comparator object
     */
    public final Comparator<Vertex> getComparator() {
        /* you must provide */
        return (v1, v2) -> {
	State goal = getProblem().getFinalState();
	State s1 = (State)v1.getData();
	State s2 = (State)v2.getData();
	int h1 = s1.getHeuristic(goal);
	int h2 = s2.getHeuristic(goal);
	return h1 - h2;
    };
    }
}