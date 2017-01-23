package com.example.birger.mainmenuactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //References
        TextView rightText = (TextView) findViewById(R.id.text_right);
        TextView wrongText = (TextView) findViewById(R.id.text_wrong);
        int right = getIntent().getIntExtra("right", 0);
        int wrong = getIntent().getIntExtra("wrong", 0);

        //Information about quiz results
        rightText.setText("Right guesses = " + Integer.toString(right));
        wrongText.setText("Wrong guesses = " + Integer.toString(wrong));
    }

    //Home button
    public void toHome(View view){
        finish();
    }
}
