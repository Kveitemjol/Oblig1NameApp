package com.example.birger.mainmenuactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import java.util.ArrayList;

public class AddNewPerson extends AppCompatActivity {

    private EditText editText_name;
    private static final String TAG = "LOGG: ";
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView mImageView;
    private Bitmap imageBitmap;
    String pName;
    //ArrayList<String> personList = (ArrayList<String>) getIntent().getSerializableExtra("personList");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_person);

        //References
        mImageView = (ImageView) findViewById(R.id.imageView_NewPerson);
        editText_name = (EditText) findViewById(R.id.editText_Name);
    }

    //Method for built-in-pictures (Doesn't work??)
/*
    public void addBuiltInPersons(String name, Bitmap imgUser) {
        pName = name;
        imageBitmap = imgUser;

        //Write information internally
        try {
            FileOutputStream stream = this.openFileOutput(pName, Context.MODE_PRIVATE);
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

        personList.add(pName);

    }

    */

    //Add person with image and name
    public void addPerson (View view) {
        String name = editText_name.getText().toString();

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

    //Home button
    public void toHome (View view) {
        finish();
    }

    //Take photo with camera
    public void dispatchTakePictureIntent(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    //onActivityResult when startActivityForResult for camera intent has ended
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }
}