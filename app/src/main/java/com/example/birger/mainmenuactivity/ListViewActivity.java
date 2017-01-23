package com.example.birger.mainmenuactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ArrayList<String> personList;
    private static String TAG = "logger";
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //Referencest
        personList = (ArrayList<String>) getIntent().getSerializableExtra("personList");
        ListView listView = (ListView) findViewById(R.id.list);

        //Adapter to list the names in listView layout
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1,(ArrayList) personList);
        listView.setAdapter(adapter);

        //Names in the list are clickable and shows picture
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
