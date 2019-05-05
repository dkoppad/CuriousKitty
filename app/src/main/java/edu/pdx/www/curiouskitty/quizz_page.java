package edu.pdx.www.curiouskitty;

import android.widget.Button;
import android.view.View;
import android.widget.RadioButton;
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

    private RadioButton moption1;
    private RadioButton moption2;
    private RadioButton moption3;
    private RadioButton moption4;
    private Button mCheatButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    List <Question> questionItems;
    int mCurrentIndex = 0;
    int correct = 0, wrong =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz_page);

        mQuestionTextView =
        moption1 = (RadioButton) findViewById(R.id.option1);
        moption2 = (RadioButton) findViewById(R.id.option2);
        moption3 = (RadioButton) findViewById(R.id.option3);
        moption4 = (RadioButton) findViewById(R.id.option4);
        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mNextButton = (Button) findViewById(R.id.next_button);

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
                if (questionItems.get(mCurrentIndex).getManswer()
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
                if (mCurrentIndex < questionItems.size() - 1) {
                    mCurrentIndex++;
                    setScreen(mCurrentIndex);
                }
            }
        });

        moption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if this is the correct answer
                if (questionItems.get(mCurrentIndex).getManswer()
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
                if (mCurrentIndex < questionItems.size() - 1) {
                    mCurrentIndex++;
                    setScreen(mCurrentIndex);
                }
            }
        });

        moption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if this is the correct answer
                if (questionItems.get(mCurrentIndex).getManswer()
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
                if (mCurrentIndex < questionItems.size() - 1) {
                    mCurrentIndex++;
                    setScreen(mCurrentIndex);
                }
            }
        });

        moption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if this is the correct answer
                if (questionItems.get(mCurrentIndex).getManswer()
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
                if (mCurrentIndex < questionItems.size() - 1) {
                    mCurrentIndex++;
                    setScreen(mCurrentIndex);
                }
            }
        });
/*
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentIndex < questionItems.size() - 1) {
                    mCurrentIndex++;
                    setScreen(mCurrentIndex);
                }
            }
        }); */

        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(quizz_page.this,
                        R.string.cheat_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
    // set the questions to screen

    private void setScreen(int number){
        mQuestionTextView.setText(questionItems.get(number).getQuestion());
        moption1.setText(questionItems.get(number).getMoption1());
        moption2.setText(questionItems.get(number).getMoption1());
        moption3.setText(questionItems.get(number).getMoption1());
        moption4.setText(questionItems.get(number).getMoption1());

    }

    // Make a list with all Questions
    private void loadAllQuestions(){
        questionItems = new ArrayList<>();
        String [] option = new String[10];
        // load all the questions into JSON string
        String jsonStr = loadJSONFromAsset("quizz_1");
        // load all the data into list
        try {
            JSONObject jsonOb = new JSONObject(jsonStr);
            JSONArray questions = jsonOb.getJSONArray("quizitems");
            for (int i = 0; i < questions.length(); i++){
                JSONObject quest = questions.getJSONObject(i);

                String questionString = quest.getString("questiontext");
                String answerString = quest.getString("answertext");

                JSONArray choices = quest.getJSONArray("choices");

                for (int j = 0; j<choices.length(); j++) {
                    option[j] = choices.getString(j);
                }
                questionItems.add(new Question(
                        questionString,
                        answerString,
                        option
                ));
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }


    //load the JSON file from assets folder
    private String loadJSONFromAsset (String file) {
        String json = "";
        try {
            InputStream is = getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return json;
    }

}
