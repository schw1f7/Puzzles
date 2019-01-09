/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mythm.puzzles2.domains.farmer;

import com.example.mythm.puzzles2.framework.problem.State;

import java.util.Objects;
/**
 *
 * @author Sam Schmidt
 */
public class FarmerState implements State {
    public FarmerState(String farmerPos, String wolfPos, String goatPos, String cabbagePos){
        this.farmer = farmerPos;
        this.wolf = wolfPos;
        this.goat = goatPos;
        this.cabbage = cabbagePos;
    }
    
    @Override
    public String toString(){
        String str = "   |  |   \n";
        if(farmer.equals("West"))
            str += " F |  |   \n";
        else
            str += "   |  | F \n";
        
        if(wolf.equals("West"))
            str += " W |  |   \n";
        else
            str += "   |  | W \n";
        
        if(goat.equals("West"))
            str += " G |  |   \n";
        else
            str += "   |  | G \n";
        
        if(cabbage.equals("West"))
            str += " C |  |   \n";
        else
            str += "   |  | C \n";
        
        str += "   |  |   ";
        return str;
    }
    
    @Override
    public boolean equals(Object other){
        if(other == null)
            return false;
        if(this == other)
            return true;
        FarmerState otherState = (FarmerState) other;
        return (this.farmer.equals(otherState.farmer) &&
                this.wolf.equals(otherState.wolf) &&
                this.goat.equals(otherState.goat) &&
                this.cabbage.equals(otherState.cabbage));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.farmer);
        hash = 73 * hash + Objects.hashCode(this.wolf);
        hash = 73 * hash + Objects.hashCode(this.goat);
        hash = 73 * hash + Objects.hashCode(this.cabbage);
        return hash;
    }
    
    public String getFarmer(){
        return farmer;
    }
    
    public String getWolf(){
        return wolf;
    }
    
    public String getGoat(){
        return goat;
    }
    
    public String getCabbage(){
        return cabbage;
    }
    
    private final String farmer;
    private final String wolf;
    private final String goat;
    private final String cabbage;
    
}
