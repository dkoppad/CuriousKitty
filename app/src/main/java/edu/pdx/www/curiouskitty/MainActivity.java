package edu.pdx.www.curiouskitty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;
    private Button mstart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.welcome_txt);
        iv = (ImageView) findViewById(R.id.splash_image);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.transition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);

        mstart = (Button) findViewById(R.id.Start_button);
        mstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizzpage();
            }
        });

    }

    public void openQuizzpage () {
        Intent intent_quiz_page = new Intent(this, quizz_page.class);
        startActivity(intent_quiz_page);
    }
}
