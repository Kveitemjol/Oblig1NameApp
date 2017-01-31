package com.example.birger.mainmenuactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FirstRunAdd extends AppCompatActivity {

    private static final String TAG = "LOGG: ";
    private EditText editTextName;
    private ImageView mImageViewFirst;
    private Bitmap imageBitmap;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    SharedPreferences shp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_run_add);

        editTextName = (EditText) findViewById(R.id.editText_first);
        mImageViewFirst = (ImageView) findViewById(R.id.imageView_FirstNewPerson);

        shp = getSharedPreferences("com.example.birger.FirstRunAdd", MODE_PRIVATE);
        shp.edit();
    }


    public void addPerson (View view) {
        String name = editTextName.getText().toString();

        //Write information internally
        try {
            FileOutputStream stream = openFileOutput(name, Context.MODE_PRIVATE);
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

            stream.close();
            imageBitmap.recycle();

        }
        catch (FileNotFoundException e) {
            Log.e(TAG, "Finner ikke filen");
        }
        catch (IOException e) {
            Log.e(TAG, "IO Feil");
        }

        Intent result = new Intent(this, MainMenuActivity.class);
        result.putExtra("name", name);
        setResult(Activity.RESULT_OK, result);

        finish();
    }

    //Take photo with camera
    public void dispatchTakePictureIntent(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }




}
