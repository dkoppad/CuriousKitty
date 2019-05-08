package edu.pdx.www.curiouskitty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = "Main/Start Page";
    private TextView tv;
    private ImageView iv;
    private Button mstart;
    private String quizName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.welcome_txt);
        iv = (ImageView) findViewById(R.id.splash_image);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.transition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.quizz_selection, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        mstart = (Button) findViewById(R.id.Start_button);
        mstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizzpage();
            }
        });

    }


    public void openQuizzpage () {
        Intent in = new Intent(MainActivity.this, quizz_page.class);
        in.putExtra("Quiz", quizName);
        startActivity(in);
        Log.d(TAG,"quizname sent to Quizz Page Activity");
        Log.d(TAG,"quizname is: " +"\""+quizName+".json"+"\"");

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "In Spinner ONItemSelect");
        quizName = parent.getItemAtPosition(position).toString();
        Log.d(TAG,"quizname is: " +quizName);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()_start_activity called");
    }

    public void onResume(){
        super.onResume();
        Log.d(TAG, "onResume()_start_activity called");
    }

    public void onPause(){
        super.onPause();
        Log.d(TAG, "onPause()_start_activity called");
    }


    public void onStop(){
        super.onStop();
        Log.d(TAG, "onStop()_start_activity called");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy()_start_activity called");
    }
}
