package com.example.pro_abdo.footballscoresapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Tracks the score for Team A
    int scoreTeamA = 0;
    int pointTeamA = 18; // Points collected by the Team A in the league
    int yellowCardTeamA = 0;
    int redCardTeamA = 0;

    // Tracks the score for Team B
    int scoreTeamB = 0;
    int pointTeamB = 13;  // Points collected by the Team B in the league
    int yellowCardTeamB = 0;
    int redCardTeamB = 0;

    TextView pointViewForTeamA ;
    TextView pointViewForTeamB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pointViewForTeamA = (TextView) findViewById(R.id.team_a_point);
        pointViewForTeamB = (TextView) findViewById(R.id.team_b_point);

        //Increase the points for Team A and Team B by 1 point.
        twoTeamAreDraw();

    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addGoalForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayScoreForTeamA(scoreTeamA);
        checkResultToAddPoints();
    }

    /**
     * Increase the Yellow Card for Team A by 1 points.
     */
    public void addYellowCardForTeamA(View v) {
        //There are 11 players in team A so that the yellow cards do not exceed 11
        if(yellowCardTeamA < 12) {

            yellowCardTeamA = yellowCardTeamA + 1;
            displayYellowCardForTeamA(yellowCardTeamA);

        }
    }

    /**
     * Increase the Red Card for Team A by 1 points.
     */
    public void addRedCardForTeamA(View v) {
        //There are 11 players in team B so that the red cards do not exceed 11
        if(redCardTeamA < 12) {

            redCardTeamA = redCardTeamA + 1;
            displayRedCardForTeamA(redCardTeamA);

        }
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addGoalForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayScoreForTeamB(scoreTeamB);
        checkResultToAddPoints();
    }

    /**
     * Increase the Yellow Card for Team B by 1 points.
     */
    public void addYellowCardForTeamB(View v) {
        //There are 11 players in team B so that the yellow cards do not exceed 11
        if(yellowCardTeamB < 12) {

            yellowCardTeamB = yellowCardTeamB + 1;
            displayYellowCardForTeamB(yellowCardTeamB);

        }
    }

    /**
     * Increase the Red Card for Team B by 1 points.
     */
    public void addRedCardForTeamB(View v) {
        //There are 11 players in team A so that the red cards do not exceed 11
        if(redCardTeamB < 12) {

            redCardTeamB = redCardTeamB + 1;
            displayRedCardForTeamB(redCardTeamB);

        }
    }

    /**
     * Resets the score for both teams and fouls back to 0.
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        yellowCardTeamA = 0;
        redCardTeamA = 0;

        scoreTeamB = 0;
        yellowCardTeamB = 0;
        redCardTeamB = 0;

        displayScoreForTeamA(scoreTeamA);
        displayYellowCardForTeamA(yellowCardTeamA);
        displayRedCardForTeamA(redCardTeamA);

        displayScoreForTeamB(scoreTeamB);
        displayYellowCardForTeamB(yellowCardTeamB);
        displayRedCardForTeamB(redCardTeamB);

        twoTeamAreDraw();
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given number of Yellow Card for Team A.
     */
    public void displayYellowCardForTeamA(int NumberOfYellowCard) {
        TextView YellowCardView = (TextView) findViewById(R.id.team_a_yellow);
        YellowCardView.setText(String.valueOf(NumberOfYellowCard));
    }

    /**
     * Displays the given number of Red Card for Team A.
     */
    public void displayRedCardForTeamA(int NumberOfRedCard) {
        TextView RedCardView = (TextView) findViewById(R.id.team_a_red);
        RedCardView.setText(String.valueOf(NumberOfRedCard));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given number of Yellow Card for Team B.
     */
    public void displayYellowCardForTeamB(int NumberOfYellowCard) {
        TextView YellowCardView = (TextView) findViewById(R.id.team_b_yellow);
        YellowCardView.setText(String.valueOf(NumberOfYellowCard));
    }

    /**
     * Displays the given number of Red Card for Team B.
     */
    public void displayRedCardForTeamB(int NumberOfRedCard) {
        TextView RedCardView = (TextView) findViewById(R.id.team_b_red);
        RedCardView.setText(String.valueOf(NumberOfRedCard));
    }

    public void checkResultToAddPoints() {

        if (scoreTeamA > scoreTeamB) {
            // Team A is the Winner
            // Increase Points for Team A by 3 points and for Team B previous points.
            pointViewForTeamA.setText(String.valueOf(pointTeamA + 3));
            pointViewForTeamB.setText(String.valueOf(pointTeamB));

        } else if (scoreTeamA < scoreTeamB) {
            // Team B is Winner
            // Increase Points for Team B by 3 points and for Team A previous points.
            pointViewForTeamB.setText(String.valueOf(pointTeamB + 3));
            pointViewForTeamA.setText(String.valueOf(pointTeamA));

        } else {
            //Team A and Team B are Draw
            // Increase Points for Team A by 1 points and for Team B 1 points.
            twoTeamAreDraw();

        }

    }

    public void twoTeamAreDraw(){
        pointViewForTeamA.setText(String.valueOf(pointTeamA + 1));
        pointViewForTeamB.setText(String.valueOf(pointTeamB + 1));

    }
}
