package com.example.birger.mainmenuactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    ArrayList<String> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        //References
        personList = (ArrayList<String>) getIntent().getSerializableExtra("personList");
        GridView grid = (GridView) findViewById(R.id.gridView);

        grid.setAdapter(new ImageAdapter(this, personList));

        //Clickable image in the Gallery
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ImgNameDetail.class);
                intent.putExtra("name", personList.get(position));
                startActivity(intent);
            }
        });
    }

    //Home button
    public void toHome (View view) {
        finish();
    }
}