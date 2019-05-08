package edu.pdx.www.curiouskitty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private static final String TAG = "Cheat Page:";
    private TextView tv;
    private String cheatAns;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        tv = (TextView) findViewById(R.id.cheat_text_view_1);

        cheatAns= getIntent().getExtras().getString("Cheat");
        Log.d(TAG, "cheat: " + cheatAns );
        tv.setText(cheatAns);

    }


}
