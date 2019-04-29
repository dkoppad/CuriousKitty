package edu.pdx.www.curiouskitty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.support.v4.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private TextView tv;
    private ImageView iv;
    private Button mstart;
    private GestureDetectorCompat mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.welcome_txt);
        iv = (ImageView) findViewById(R.id.splash_image);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.transition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);


        this.mGestureDetector = new GestureDetectorCompat(this, this);
        mGestureDetector.setOnDoubleTapListener(this);

        mstart = (Button) findViewById(R.id.Start_button);
        mstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizzpage();
            }
        });

    }


        // Gesture Detector


        @Override
        public boolean onDown (MotionEvent e){
            return true;
        }

        @Override
        public void onShowPress (MotionEvent e){

        }

        @Override
        public boolean onSingleTapUp (MotionEvent e){
            return true;
        }

        @Override
        public boolean onScroll (MotionEvent e1, MotionEvent e2,float distanceX, float distanceY){
            return true;
        }

        @Override
        public void onLongPress (MotionEvent e){

        }

        @Override
        public boolean onFling (MotionEvent e1, MotionEvent e2,float velocityX, float velocityY){
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed (MotionEvent e){
            return true;
        }

        @Override
        public boolean onDoubleTap (MotionEvent e){
            return true;
        }

        @Override
        public boolean onDoubleTapEvent (MotionEvent e){
            return true;
        }


    // End Gesture

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            this.mGestureDetector.onTouchEvent(event);
            return super.onTouchEvent(event);
        }


    public void openQuizzpage () {
        Intent intent_quiz_page = new Intent(this, quizz_page.class);
        startActivity(intent_quiz_page);
    }
}
