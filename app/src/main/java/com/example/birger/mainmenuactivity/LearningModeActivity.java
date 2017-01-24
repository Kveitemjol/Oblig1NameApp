package com.example.birger.mainmenuactivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class LearningModeActivity extends AppCompatActivity {

    private static final String TAG = "LOGG: ";
    ArrayList<String> personList;
    Bitmap bmp;
    Button next;
    ImageView imageView;
    EditText editText;
    int antallRiktige;
    int antallFeil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_mode);

        //References
        personList = (ArrayList<String>) getIntent().getSerializableExtra("personList");
        imageView = (ImageView) findViewById(R.id.imageView_learningMode);
        editText = (EditText) findViewById(R.id.editText_guessName);
        next = (Button) findViewById(R.id.btnNext);

        next.setText("Start");
        editText.setVisibility(View.INVISIBLE);

        antallFeil = 0;
        antallRiktige = 0;

        //Start the quiz when clicking "Start" button
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                game();
            }
        });
    }

    //Play quiz
    private void game(){

        Random r = new Random();
        int randomInt = r.nextInt(personList.size());
        editText.setText("");
        next.setText("Next");
        editText.setVisibility(View.VISIBLE);

        String name = personList.get(randomInt);
        String text = editText.getText().toString();

        //Get data from file/internally to display image
        try {
            FileInputStream is = this.openFileInput(name);
            bmp = BitmapFactory.decodeStream(is);
            imageView.setImageBitmap(bmp);
            is.close();
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Finner ikke filen");
        } catch (IOException e) {
            Log.e(TAG, "IO Feil");
        }

        if(text.toLowerCase().equals(name.toLowerCase())){
            antallRiktige++;
        } else {
            antallFeil++;
        }
    }

    //Show result when quitting the quiz
    public void toResult (View view) {
        Intent intent = new Intent(this, Result.class);
        intent.putExtra("right", antallRiktige);
        intent.putExtra("wrong", antallFeil);
        startActivity(intent);
        finish();
    }
}