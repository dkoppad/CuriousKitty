package edu.pdx.www.curiouskitty;

import android.content.Intent;
import android.util.Log;

import android.widget.Button;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class quizz_page extends AppCompatActivity {
    private static final String TAG = "QUIZZ_PAGE";

    private RadioButton moption1;
    private RadioButton moption2;
    private RadioButton moption3;
    private RadioButton moption4;
    private Button mCheatButton;

    private TextView mQuestionTextView;
    public RadioGroup mRadioGroup;
    public RadioButton mRadioButton;

    List<Question> questionItems;
    int mCurrentIndex = 0;
    int correct = 0, wrong = 0;
    private String filename;

    private static final String KEY_INDEX = "index";
    private static final String KEY_CHEATER_STATUS = "key_status";
    private static final String KEY_CORRECT_ANSWER_STATUS = "0";
    private static final String KEY_WRONG_ANSWER_STATUS = "0";



    //FileInputStream stream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quizz_page);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view_1);
        moption1 = (RadioButton) findViewById(R.id.option1);
        moption2 = (RadioButton) findViewById(R.id.option2);
        moption3 = (RadioButton) findViewById(R.id.option3);
        moption4 = (RadioButton) findViewById(R.id.option4);
        mCheatButton = (Button) findViewById(R.id.cheat_button);

        mRadioGroup = findViewById(R.id.radio_group_id);

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
            wrong = savedInstanceState.getInt(KEY_CORRECT_ANSWER_STATUS, 0);
            correct = savedInstanceState.getInt(KEY_WRONG_ANSWER_STATUS, 0);
        }


        //get all the questions
        loadAllQuestions();

        //shuffle the questions
        Collections.shuffle(questionItems);

        //load first question
        setScreen(mCurrentIndex);

        moption1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //check if this is the correct answer
                    if (questionItems.get(mCurrentIndex).getMoption1()
                            .equals(questionItems.get(mCurrentIndex).getManswer())) {
                        correct++;
                        Toast.makeText(quizz_page.this,
                                R.string.correct_toast,
                                Toast.LENGTH_SHORT).show();
                    } else {
                        wrong++;
                        Toast.makeText(quizz_page.this,
                                R.string.incorrect_toast,
                                Toast.LENGTH_SHORT).show();

                    }
                    // load next question invariable of correct or wrong ans
                    mCurrentIndex++;
                    if (mCurrentIndex < questionItems.size()) {
                        setScreen(mCurrentIndex);
                    } else if (mCurrentIndex >= questionItems.size()) {
                        openScorepage();
                    }

                }
            });

            moption2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //check if this is the correct answer
                    if (questionItems.get(mCurrentIndex).getMoption2()
                            .equals(questionItems.get(mCurrentIndex).getManswer())) {
                        correct++;
                        Toast.makeText(quizz_page.this,
                                R.string.correct_toast,
                                Toast.LENGTH_SHORT).show();
                    } else {
                        wrong++;
                        Toast.makeText(quizz_page.this,
                                R.string.incorrect_toast,
                                Toast.LENGTH_SHORT).show();

                    }
                    mCurrentIndex++;
                    if (mCurrentIndex < questionItems.size()) {
                        setScreen(mCurrentIndex);
                    } else if (mCurrentIndex >= questionItems.size()) {
                        openScorepage();
                    }

                }
            });

            moption3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //check if this is the correct answer
                    if (questionItems.get(mCurrentIndex).getMoption3()
                            .equals(questionItems.get(mCurrentIndex).getManswer())) {
                        correct++;
                        Toast.makeText(quizz_page.this,
                                R.string.correct_toast,
                                Toast.LENGTH_SHORT).show();
                    } else {
                        wrong++;
                        Toast.makeText(quizz_page.this,
                                R.string.incorrect_toast,
                                Toast.LENGTH_SHORT).show();

                    }
                    mCurrentIndex++;
                    if (mCurrentIndex < questionItems.size()) {
                        setScreen(mCurrentIndex);
                    } else if (mCurrentIndex >= questionItems.size()) {
                        openScorepage();
                    }

                }
            });

            moption4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //check if this is the correct answer
                    if (questionItems.get(mCurrentIndex).getMoption4()
                            .equals(questionItems.get(mCurrentIndex).getManswer())) {
                        correct++;
                        Toast.makeText(quizz_page.this,
                                R.string.correct_toast,
                                Toast.LENGTH_SHORT).show();
                    } else {
                        wrong++;
                        Toast.makeText(quizz_page.this,
                                R.string.incorrect_toast,
                                Toast.LENGTH_SHORT).show();

                    }
                    mCurrentIndex++;
                    if (mCurrentIndex < questionItems.size()) {
                        setScreen(mCurrentIndex);
                    } else if (mCurrentIndex >= questionItems.size()) {
                        openScorepage();
                    }

                }
            });


            mCheatButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openCheatpage();
                    Toast.makeText(quizz_page.this,
                            R.string.cheat_toast,
                            Toast.LENGTH_SHORT).show();
                }
            });


    }



    // Radio Group ID assignment
    public void checkButton(View v) {
        int radioID = mRadioGroup.getCheckedRadioButtonId();
        mRadioButton = findViewById(radioID);
        Log.d(TAG,"radio id"+mRadioButton);

    }

    // set the questions to screen

    private void setScreen(int number) {
        if (mCurrentIndex < questionItems.size()) {
            mQuestionTextView.setText(questionItems.get(number).getQuestion());
            moption1.setText(questionItems.get(number).getMoption1());
            moption2.setText(questionItems.get(number).getMoption2());
            moption3.setText(questionItems.get(number).getMoption3());
            moption4.setText(questionItems.get(number).getMoption4());
            Log.d(TAG,"index: "+number);
            Log.d(TAG,"correct: "+correct);
            Log.d(TAG,"wrong: "+wrong);
        }



    }

    /**
     *
     * loadAllQuestions: receives input from the loadJSONfromAssets in a string named jsonStr
     * In jsonStr the string "questions" is searched and the key Value pairs are stored in the
     * object quiz. All the key:values pairs are looped and the questionm answer, choices are extracted.
     */

    // Make a list with all Questions
    private String loadAllQuestions() {
        questionItems = new ArrayList<>();
        String[] option = new String[10];
        String jsonStr = null;

        // Storing the input from the Main Activity page in filename variable
        filename = getIntent().getExtras().getString("Quiz");
        Log.d(TAG, "FileName: " + filename);

        // load all the questions into JSON string based on the choice of selection in the Mian activity page
        switch (filename) {
            case "Environment":
                jsonStr = loadJSONFromAsset("Environment.json");
                //Log.d(TAG, "JSON String 1 " + jsonStr);
                break;
            case "How well do you know India":
                jsonStr = loadJSONFromAsset("How well do you know India.json");
                //Log.d(TAG, "JSON String 2" + jsonStr);
                break;
            case "How well do you know US":
                jsonStr = loadJSONFromAsset("How well do you know US.json");
                //Log.d(TAG, "JSON String 3" + jsonStr);
                break;

        }

        if (jsonStr != null) {
            // load all the data into list questions
            try {
                JSONObject jsonOb = new JSONObject(jsonStr);
                JSONObject quiz = jsonOb.getJSONObject("questions");
                Log.d(TAG,"JSON Object "+ jsonOb);
                JSONArray questionsArray = quiz.getJSONArray("quizitems");
                //Log.d(TAG,"Questionslist "+ questionsArray);
                for (int i = 0; i < questionsArray.length(); i++) {
                    JSONObject quest = questionsArray.getJSONObject(i);
                    //Log.d(TAG,"JSON question Object "+ quest);
                    String questionString = quest.getString("questiontext");
                    //Log.d(TAG,"question: "+ questionString);
                    String answerString = quest.getString("answertext");
                    //Log.d(TAG,"Answer: "+ answerString);
                    // creating another array to store the choices
                    JSONArray choices = quest.getJSONArray("choices");
                    Log.d(TAG, "Choices: " + choices);
                    // Storing the choices with index
                    option[1] = choices.getString(0);
                    option[2] = choices.getString(1);
                    option[3] = choices.getString(2);
                    option[4] = choices.getString(3);
                    // passing question, answer and the options to the Questions class
                    questionItems.add(new Question(
                            questionString,
                            answerString,
                            option[1],
                            option[2],
                            option[3],
                            option[4]
                    ));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return null;
    }


    //Based on the user selection from the Main activity page the Json file is laded from assets:
        //load the JSON file from assets folder
        private String loadJSONFromAsset (String file){
            String json =  "";
            try {
                // opens the file from the assets folder in the project
                InputStream is = getAssets().open((file));
                int size = is.available();
                //values from the file are read in an inputstream and stored in buffer and read here
                Log.d(TAG, "size value is " + size);
                byte[] buffer = new byte[size];
                //Reading the buffer
                is.read(buffer);
                //close the file
                is.close();
                //store the contents of the file in json string
                json = new String(buffer, "UTF-8");
                //Log.d(TAG,"json is "+ json);
            } catch (IOException e) {
                e.printStackTrace();
                Log.d(TAG, "file not found");

            }

            return json;
        }

    // intend to open the cheat page if the user wants ot cheat and see the answer.

    public void openCheatpage () {
        String answer = null;
        answer = questionItems.get(mCurrentIndex).getManswer();
        Intent in = new Intent(this, CheatActivity.class);
        in.putExtra("Cheat", answer);
        startActivity(in);
        //Log.d(TAG,"answer sent to Cheat Activity");
        //Log.d(TAG,"cheat ans is: "+answer);

    }

    // intend to open the score page after the user has looped through all the questions in the current quizz
    //passes the correct and wrong counter values
    public void openScorepage () {
        Intent in = new Intent(this, ScoreActivity.class);
        in.putExtra("Score_correct", correct);
        in.putExtra("Score_wrong", wrong);
        startActivity(in);
        Log.d(TAG,"Score sent to Score Activity");
        Log.d(TAG,"correct: "+correct);
        Log.d(TAG,"wrong: "+wrong);


    }

    /**
     * Methods to debug/Observe for all lifecycle of the APP using logcat
     *
     */

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

    /**
     *
     * @param savedInstanceState : to save the status of the activity in case of configuration change.
     *                           Stores the current index of the question.
     *                           Stores the no of correct and wrong answers to keep up the score of the game.
     */

    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState called");
        //pairing the instance var with key
        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
        savedInstanceState.putInt(KEY_CORRECT_ANSWER_STATUS,correct);
        savedInstanceState.putInt(KEY_WRONG_ANSWER_STATUS,wrong);
    }

}


