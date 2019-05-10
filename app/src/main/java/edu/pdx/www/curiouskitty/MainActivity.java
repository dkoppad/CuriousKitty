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

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.welcome_txt);
        // image view for the curious kitty app animation
        iv = (ImageView) findViewById(R.id.splash_image);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.transition);
        //strating the animation for both textview and the imageview
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);

        /**
         * Spinner button to give user the option to take quizz from three different topics
         */
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

    /**
     * openQuizzpage: Opens the quizz page activity and passes the chosen quizz from the Main page activity
     * to the Quiz page activity
     */
    public void openQuizzpage () {
        Intent in = new Intent(MainActivity.this, quizz_page.class);
        // passes the drop down option chosen
        in.putExtra("Quiz", quizName);
        startActivity(in);
        Log.d(TAG,"quizname sent to Quizz Page Activity");
        Log.d(TAG,"quizname is: " +"\""+quizName+".json"+"\"");

    }

    /**
     *
     * @param parent : parent is the spinner instance
     * @param position : gives the position of the choice made from the spinner (drop down Selection)
     *
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "In Spinner ONItemSelect");
        quizName = parent.getItemAtPosition(position).toString();
        Log.d(TAG,"quizname is: " +quizName);
    }

    /**
     * Methods to debug/Observe for all lifecycle of the APP using logcat
     *
     */

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
