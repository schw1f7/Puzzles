/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mythm.puzzles2.domains.farmer;

import com.example.mythm.puzzles2.framework.problem.Mover;
import com.example.mythm.puzzles2.framework.problem.State;

import java.util.function.UnaryOperator;

/**
 *
 * @author Sam Schmidt
 */
public class FarmerMover extends Mover {
    
    public static final String FARMER = "Farmer Goes Alone";
    public static final String WOLF = "Farmer Takes Wolf";
    public static final String GOAT = "Farmer Takes Goat";
    public static final String CABBAGE ="Farmer Takes Cabbage";
    
    public FarmerMover(){
        super.addMove(FARMER, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return tryGoesAlone(state);
            }
        });
        super.addMove(WOLF, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return takesWolf(state);
            }
        });
        super.addMove(GOAT, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return takesGoat(state);
            }
        });
        super.addMove(CABBAGE, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return takesCabbage(state);
            }
        });
    }
    
    private State tryGoesAlone(State state){
        final FarmerState s = (FarmerState)state;
        if(safeToMove(new FarmerState(toOpposite(s.getFarmer()), s.getWolf(), s.getGoat(), s.getCabbage())))
            return new FarmerState(toOpposite(s.getFarmer()), s.getWolf(), s.getGoat(), s.getCabbage());
        else
            return null;
        
    }
    
    private State takesWolf(State state){
        FarmerState s = (FarmerState) state;
        if(!(s.getFarmer().equals(s.getWolf()))){
            return null;
        }
        if(safeToMove(new FarmerState(toOpposite(s.getFarmer()), toOpposite(s.getWolf()), s.getGoat(), s.getCabbage()))){
            return new FarmerState(toOpposite(s.getFarmer()), toOpposite(s.getWolf()), s.getGoat(), s.getCabbage());
        }
        return null;
        
    }
    
    private State takesGoat(State state){
        FarmerState s = (FarmerState) state;
        if(!s.getGoat().equals(s.getFarmer()))
            return null;
        if(safeToMove(new FarmerState(toOpposite(s.getFarmer()), s.getWolf(), toOpposite(s.getGoat()), s.getCabbage())))
            return new FarmerState(toOpposite(s.getFarmer()), s.getWolf(), toOpposite(s.getGoat()), s.getCabbage());
        return null;
    }
    
    private State takesCabbage(State state){
        FarmerState s = (FarmerState) state;
        if(!s.getCabbage().equals(s.getFarmer()))
            return null;
        if(safeToMove(new FarmerState(toOpposite(s.getFarmer()), s.getWolf(), s.getGoat(), toOpposite(s.getCabbage()))))
            return new FarmerState(toOpposite(s.getFarmer()), s.getWolf(), s.getGoat(), toOpposite(s.getCabbage()));
        return null;
    }
    private String toOpposite(String side){
        if(side.equals("West"))
            return "East";
        else
            return "West";
    }
            
            
    private boolean safeToMove(FarmerState s){
        String farmer = s.getFarmer();
        String wolf = s.getWolf();
        String goat = s.getGoat();
        String cabbage = s.getCabbage();
        return (!goat.equals(wolf) || goat.equals(farmer)) && 
               (!cabbage.equals(goat) || cabbage.equals(farmer));
    }
}
