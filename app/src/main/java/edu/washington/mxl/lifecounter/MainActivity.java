package edu.washington.mxl.lifecounter;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private int score1 = 20;
    private int score2  = 20;
    private int score3 = 20;
    private int score4 = 20;
    private static int scores1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if( savedInstanceState != null ) {
            score1 = savedInstanceState.getInt("p1Lives");
            score2 = savedInstanceState.getInt("p2Lives");
            score3 = savedInstanceState.getInt("p3Lives");
            score4 = savedInstanceState.getInt("p4Lives");
            TextView score;
            score = (TextView) findViewById(R.id.score_1);
            score.setText("" + score1);
            score = (TextView) findViewById(R.id.score_2);
            score.setText("" + score2);
            score = (TextView) findViewById(R.id.score_3);
            score.setText("" + score3);
            score = (TextView) findViewById(R.id.score_4);
            score.setText("" + score4);
        }

        Log.i("check", "On Create");
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("p1Lives", score1);
        outState.putInt("p2Lives", score2);
        outState.putInt("p3Lives", score3);
        outState.putInt("p4Lives", score4);
        Log.i("check", "On Saved Instance State");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("check", "On Restore Instance State");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick (View v) {
        int layoutID = ((View) v.getParent()).getId();
        int tempScore = 0;
        int prevScore = 0;
        TextView score;
        Button but = (Button) findViewById(v.getId());
        int player = 0;

        CharSequence s = but.getText();
        if (s.equals("+")) {
            tempScore++;
        } else if (s.equals("+5")) {
            tempScore+=5;
        } else if (s.equals("-")) {
            tempScore--;
        } else if (s.equals("-5")) {
            tempScore-=5;
        }

        if (layoutID == R.id.linearLayout1) {
            score = (TextView) findViewById(R.id.score_1);
            prevScore = score1;
            score1 += tempScore;
            score.setText("" + score1);
            tempScore = score1;
            player = 1;
        } else if (layoutID == R.id.linearLayout2) {
            score = (TextView) findViewById(R.id.score_2);
            prevScore = score2;
            score2 += tempScore;
            score.setText("" + score2);
            tempScore = score2;
            player = 2;
        } else if (layoutID == R.id.linearLayout3) {
            score = (TextView) findViewById(R.id.score_3);
            prevScore = score3;
            score3 += tempScore;
            score.setText("" + score3);
            tempScore = score3;
            player = 3;
        } else if (layoutID == R.id.linearLayout4) {
            score = (TextView) findViewById(R.id.score_4);
            prevScore = score4;
            score4 += tempScore;
            score.setText("" + score4);
            tempScore = score4;
            player = 4;
        }

        if (tempScore + prevScore <= 0) {
            TextView label = (TextView) findViewById(R.id.label);
            label.setText("Player " + player + " LOSES!");
            label.setVisibility(View.VISIBLE);
        }
    }
}
