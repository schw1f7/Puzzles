package com.example.mythm.puzzles2;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mythm.puzzles2.domains.farmer.FarmerProblem;
import com.example.mythm.puzzles2.domains.farmer.FarmerState;
import com.example.mythm.puzzles2.framework.solution.Solution;
import com.example.mythm.puzzles2.framework.solution.Solver;
import com.example.mythm.puzzles2.framework.solution.SolvingAssistant;
import com.example.mythm.puzzles2.framework.solution.StateSpaceSolver;

public class Farmer_problem extends AppCompatActivity {
    private FarmerProblem problem;
    private SolvingAssistant solveAssistant;
    private TextView currState;
    private TextView message;
    private TextView stats;
    private Solver solver;
    private Solution solution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_problem);
        problem = new FarmerProblem();

        currState = findViewById(R.id.farmer_currState);
        message = findViewById(R.id.message);

        currState.setText(problem.getCurrentState().toString());
        solveAssistant = new SolvingAssistant(problem);
        stats = findViewById(R.id.stats);
        findViewById(R.id.next_button).setEnabled(false);
    }

    public void goesAlone(View view){
        message.setText("");
        solveAssistant.tryMove("Farmer Goes Alone");
        if(!solveAssistant.isMoveLegal())
            message.setText(R.string.illegalMove);
        if(solveAssistant.isProblemSolved())
            message.setText(R.string.finished);
        currState.setText(problem.getCurrentState().toString());
    }

    public void takesWolf(View view){
        message.setText("");
        solveAssistant.tryMove("Farmer Takes Wolf");
        if(!solveAssistant.isMoveLegal())
            message.setText(R.string.illegalMove);
        if(solveAssistant.isProblemSolved())
            message.setText(R.string.finished);
        currState.setText(problem.getCurrentState().toString());
    }

    public void takesGoat(View view){
        message.setText("");
        solveAssistant.tryMove("Farmer Takes Goat");
        if(!solveAssistant.isMoveLegal())
            message.setText(R.string.illegalMove);
        if(solveAssistant.isProblemSolved())
            message.setText(R.string.finished);
        currState.setText(problem.getCurrentState().toString());
    }

    public void takesCabbage(View view){
        message.setText("");
        solveAssistant.tryMove("Farmer Takes Cabbage");
        if(!solveAssistant.isMoveLegal())
            message.setText(R.string.illegalMove);
        if(solveAssistant.isProblemSolved())
            message.setText(R.string.finished);
        currState.setText(problem.getCurrentState().toString());
    }

    public void solve(View view){
        solver = new StateSpaceSolver(this.problem,true);
        solver.solve();
        (this.solution = this.solver.getSolution()).next();
        stats.setText(this.solver.getStatistics().toString());
        findViewById(R.id.next_button).setEnabled(true);
        findViewById(R.id.solve_button).setEnabled(false);
    }

    public void next(View view){
        if(solution.hasNext()){
            FarmerState c = (FarmerState)solution.next().getData();
            currState.setText(c.toString());
        }
        else{
            findViewById(R.id.next_button).setEnabled(false);
            message.setText(R.string.finished);
        }
    }

    public void reset(View view){
        this.solveAssistant.reset();
        message.setText("");
        currState.setText(this.problem.getCurrentState().toString());
        stats.setText("");
        findViewById(R.id.solve_button).setEnabled(true);
        findViewById(R.id.next_button).setEnabled(false);
    }





}
