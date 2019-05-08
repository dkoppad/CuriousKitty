package edu.pdx.www.curiouskitty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {
    private static final String TAG = "Score Page:";

    private TextView tv_correct, tv_wrong, tv_details;
    private int correct, wrong ;
    private Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        tv_details = (TextView) findViewById(R.id.Score_details);

        correct= getIntent().getExtras().getInt("Score_correct");
        tv_correct = (TextView) findViewById(R.id.score_correct);

        Log.d(TAG, "Correct: " + correct );
        tv_correct.setText("Correct: "+String.valueOf(correct));


        tv_wrong = (TextView) findViewById(R.id.score_wrong);
        wrong= getIntent().getExtras().getInt("Score_wrong");
        Log.d(TAG, "Wrong: " + wrong);
        tv_wrong.setText("Incorrect: "+String.valueOf(wrong));

        Toast.makeText(this,
                R.string.Score_toast,
                Toast.LENGTH_SHORT).show();

        restart = (Button) findViewById(R.id.Quizz_restart);
        restart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openStartpage();
            }
        });


    }

    public void openStartpage () {

        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
        //Log.d(TAG,"answer sent to Cheat Activity");
        //Log.d(TAG,"cheat ans is: "+answer);

    }
}
