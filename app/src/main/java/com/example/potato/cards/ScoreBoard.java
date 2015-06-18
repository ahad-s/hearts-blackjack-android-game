package com.example.potato.cards;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Potato on 6/7/2015.
 */
public class ScoreBoard extends Activity{


    // assigning views and stuff
    HashMap<Integer, Integer> scores; // player_number, score_in_round

    ArrayList<Integer> addedUpScores = new ArrayList<>();

    TableRow addedScoresRow = null;
    TableLayout rootTable;
    DisplayMetrics display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.scoreboard);

        rootTable = (TableLayout) findViewById(R.id.scoreboard_main_layout);

        rootTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // this is to make it a smaller window on screen
        display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);

        double popUpPercentX = 0.8; // easy to adjust here
        double popUpPercentY = 0.6;

        getWindow().setLayout((int) (display.widthPixels * popUpPercentX), (int) (display.heightPixels * popUpPercentY)); // sets the popUp's w/h to x% of original res


    }


    // adds rows and automatically sets a "total score" row at the end in red
    public void addNewRow(ArrayList<Integer> scores){
        if (addedScoresRow != null){
            rootTable.removeView(addedScoresRow);
        }

        TableRow newRow = new TableRow(this);

        newRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));

        // adds a new row with given values
        for (int i = 0; i < scores.size(); i++){
            TextView newText = new TextView(this);
            newText.setText(String.valueOf(scores.get(i)));

            TableRow.LayoutParams textParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
            textParams.gravity = Gravity.CENTER;
            textParams.column = i;

            newText.setLayoutParams(textParams);

            newText.setTextSize(10 * display.density);

            newRow.addView(newText);
        }

        rootTable.addView(newRow);
        addedScoresRow = new TableRow(this);
        rootTable.addView(addedScoresRow);

        addedUpScores = new ArrayList<>(4);
        addedUpScores.add(0);
        addedUpScores.add(0);
        addedUpScores.add(0);
        addedUpScores.add(0);

        // gets the sums from all columns and puts them into tempTotalScores
        // need to do this in order
        for (int i = 1; i < rootTable.getChildCount(); i++){ // i = 1 because need to skip the first one which is just names
            TableRow toExtract;
            try {
                toExtract = (TableRow) rootTable.getChildAt(i);
            } catch (Exception e) {continue;}

            for (int x = 0; x < toExtract.getChildCount(); x++){
                TextView viewExtract = (TextView) toExtract.getChildAt(x);
                Integer total = addedUpScores.get(x);
                total += Integer.valueOf(viewExtract.getText().toString());
                addedUpScores.set(x, total);
            }
        }

        // sets the last row showing total scores
        for (int i = 0; i < addedUpScores.size(); i++){
            TextView newText = new TextView(this);
            newText.setText(String.valueOf(addedUpScores.get(i)));
            TableRow.LayoutParams textParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
            textParams.gravity = Gravity.CENTER;
            textParams.column = i;
            newText.setTextColor(Color.RED);

            newText.setLayoutParams(textParams);

            newText.setTextSize(10 * display.density);
            addedScoresRow.addView(newText);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        MusicControl.leavingClass();

    }

    @Override
    protected void onResume() {
        super.onResume();
        MusicControl.inClass(this);
        ArrayList<Integer> toAdd = getIntent().getIntegerArrayListExtra("newscores");
        if (toAdd.size() > 0)
            addNewRow(toAdd);
    }
}
