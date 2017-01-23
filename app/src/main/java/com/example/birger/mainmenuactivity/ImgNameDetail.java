package com.example.birger.mainmenuactivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImgNameDetail extends AppCompatActivity {

    private static final String TAG = "logger";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_name_detail);

        //References
        Bitmap bmp;
        TextView textViewName = (TextView) findViewById(R.id.textView_ImageDetail);
        ImageView imageView = (ImageView) findViewById(R.id.imageView_ImageDetail);
        String name = (String) getIntent().getStringExtra("name");

        textViewName.setText(name);

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

    }
}