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
    private static String TAG = "LOGG: ";
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //References
        personList = (ArrayList<String>) getIntent().getSerializableExtra("personList");
        ListView listView = (ListView) findViewById(R.id.list);

        //Adapter that pulls content from the array and converts each item result into a view that's placed into the list
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1,(ArrayList) personList);
        listView.setAdapter(adapter);

        //Names in the list are clickable, pass intent with the personList data. Starts the ImgNameDetail activity
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
