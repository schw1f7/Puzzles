package com.example.mythm.puzzles2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mythm.puzzles2.domains.puzzle.PuzzleState;
import com.example.mythm.puzzles2.framework.solution.AStarSolver;
import com.example.mythm.puzzles2.framework.solution.Solution;
import com.example.mythm.puzzles2.framework.solution.Solver;
import com.example.mythm.puzzles2.framework.solution.SolvingAssistant;

import java.lang.reflect.Array;

import domains.puzzle.PuzzleProblem;

public class Puzzle_problem extends AppCompatActivity {
    private PuzzleProblem problem;
    private Solver solver;
    private SolvingAssistant solvingAssistant;
    private Solution solution;
    private TextView stats;
    private TextView message;
    private Button[] buttonList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_problem);
        this.problem = new PuzzleProblem();
        solver = new AStarSolver(this.problem);
        solvingAssistant = new SolvingAssistant(this.problem);
        message = findViewById(R.id.puzzle_message);
        stats = findViewById(R.id.puzzle_stats);
        findViewById(R.id.puzzle_NextBTN).setEnabled(false);
        buttonList = new Button[9];
        buttonList[1] = findViewById(R.id.button);
        buttonList[2] = findViewById(R.id.button2);
        buttonList[3] = findViewById(R.id.button3);
        buttonList[4] = findViewById(R.id.button4);
        buttonList[5] = findViewById(R.id.button5);
        buttonList[6] = findViewById(R.id.button6);
        buttonList[7] = findViewById(R.id.button7);
        buttonList[8] = findViewById(R.id.button8);
    }
    public void reset(View view){
        this.solvingAssistant.reset();
        message.setText("");
        stats.setText("");
        resetGrid();
        findViewById(R.id.puzzle_solveBTN).setEnabled(true);
        findViewById(R.id.puzzle_NextBTN).setEnabled(false);
    }

    public void next(View view){
        if(solution.hasNext()){
            PuzzleState c = (PuzzleState) solution.next().getData();
            for(int i = 1; i < 9; i++){
                PuzzleState.Location tile = c.getLocation(i);
                buttonList[i].setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(tile.getRow()), GridLayout.spec(tile.getColumn())));
            }
        }
        else{
            findViewById(R.id.puzzle_NextBTN).setEnabled(false);
            message.setText(R.string.finished);
            for(int i = 1; i < 9; i++)
                buttonList[i].setEnabled(false);
        }
    }

    public void solve(View view){
        solver.solve();
        (this.solution = this.solver.getSolution()).next();
        stats.setText(this.solver.getStatistics().toString());
        findViewById(R.id.puzzle_NextBTN).setEnabled(true);
        findViewById(R.id.puzzle_solveBTN).setEnabled(false);
        for(int i = 1; i < 9; i++)
            buttonList[i].setEnabled(false);
    }


    public void tryMove(View view){
        findViewById(R.id.puzzle_solveBTN).setEnabled(false);
        Button b = (Button)view;
        String buttonText = b.getText().toString();
        PuzzleState currState = (PuzzleState)this.problem.getCurrentState();
        PuzzleState.Location blankTile = currState.getLocation(0);
        switch (buttonText){
            case "1": {
                message.setText("");
                solvingAssistant.tryMove("Slide Tile 1");
                if (!solvingAssistant.isMoveLegal()) {
                    message.setText(R.string.illegalMove);
                    break;
                } else {
                    b.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(blankTile.getRow()), GridLayout.spec(blankTile.getColumn())));
                }
                if(solvingAssistant.isProblemSolved())
                    message.setText(R.string.finished);
                break;
            }
            case "2": {
                message.setText("");
                solvingAssistant.tryMove("Slide Tile 2");
                if (!solvingAssistant.isMoveLegal()) {
                    message.setText(R.string.illegalMove);
                    break;
                } else {
                    b.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(blankTile.getRow()), GridLayout.spec(blankTile.getColumn())));
                }
                if(solvingAssistant.isProblemSolved())
                    message.setText(R.string.finished);
                break;
            }
            case "3": {
                message.setText("");
                solvingAssistant.tryMove("Slide Tile 3");
                if (!solvingAssistant.isMoveLegal()) {
                    message.setText(R.string.illegalMove);
                    break;
                } else {
                    b.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(blankTile.getRow()), GridLayout.spec(blankTile.getColumn())));
                }
                if(solvingAssistant.isProblemSolved())
                    message.setText(R.string.finished);
                break;
            }
            case "4": {
                message.setText("");
                solvingAssistant.tryMove("Slide Tile 4");
                if (!solvingAssistant.isMoveLegal()) {
                    message.setText(R.string.illegalMove);
                    break;
                } else {
                    b.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(blankTile.getRow()), GridLayout.spec(blankTile.getColumn())));
                }
                if(solvingAssistant.isProblemSolved())
                    message.setText(R.string.finished);
                break;
            }
            case "5":{
                message.setText("");
                solvingAssistant.tryMove("Slide Tile 5");
                if(!solvingAssistant.isMoveLegal()) {
                    message.setText(R.string.illegalMove);
                    break;
                }
                else{

                    b.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(blankTile.getRow()),GridLayout.spec(blankTile.getColumn())));
                }
                if(solvingAssistant.isProblemSolved())
                    message.setText(R.string.finished);
                break;

            }
            case "6":{
                message.setText("");
                solvingAssistant.tryMove("Slide Tile 6");
                if(!solvingAssistant.isMoveLegal()) {
                    message.setText(R.string.illegalMove);
                    break;
                }
                else{
                    b.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(blankTile.getRow()),GridLayout.spec(blankTile.getColumn())));
                }
                if(solvingAssistant.isProblemSolved())
                    message.setText(R.string.finished);
                break;
            }
            case "7": {
                message.setText("");
                solvingAssistant.tryMove("Slide Tile 7");
                if (!solvingAssistant.isMoveLegal()) {
                    message.setText(R.string.illegalMove);
                    break;
                } else {
                    b.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(blankTile.getRow()), GridLayout.spec(blankTile.getColumn())));
                }
                if(solvingAssistant.isProblemSolved())
                    message.setText(R.string.finished);
                break;
            }
            case "8": {
                message.setText("");
                solvingAssistant.tryMove("Slide Tile 8");
                if (!solvingAssistant.isMoveLegal()) {
                    message.setText(R.string.illegalMove);
                    break;
                } else {
                    b.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(blankTile.getRow()), GridLayout.spec(blankTile.getColumn())));
                }
                if(solvingAssistant.isProblemSolved())
                    message.setText(R.string.finished);
                break;
            }
        }
    }

    private void resetGrid(){
        findViewById(R.id.button).setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(2), GridLayout.spec(2)));;
        findViewById(R.id.button2).setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(0), GridLayout.spec(1)));;
        findViewById(R.id.button3).setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(2), GridLayout.spec(0)));;
        findViewById(R.id.button4).setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(1), GridLayout.spec(2)));;
        findViewById(R.id.button5).setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(0), GridLayout.spec(0)));;
        findViewById(R.id.button6).setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(2), GridLayout.spec(1)));;
        findViewById(R.id.button7).setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(0), GridLayout.spec(2)));;
        findViewById(R.id.button8).setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(1), GridLayout.spec(0)));;
        for(int i = 1; i < 9; i++)
            buttonList[i].setEnabled(true);
    }

}
