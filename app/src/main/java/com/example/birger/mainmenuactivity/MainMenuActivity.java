package com.example.birger.mainmenuactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainMenuActivity extends AppCompatActivity {

    ArrayList<String> personList;
    static final int ADD_NEW_PERSON = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personList = new ArrayList<>();
    }

    //From menu, when clicking buttons go to one of these methods
    public void toNameList(View v) {
        Intent intent = new Intent(this, ListViewActivity.class);
        intent.putExtra("personList", personList);
        startActivity(intent);
    }
    public void toGallery(View v) {
        Intent intent = new Intent(this, GalleryActivity.class);
        intent.putExtra("personList", personList);
        startActivity(intent);
    }

    public void toQuiz(View v) {
        Intent intent = new Intent(this, LearningModeActivity.class);
        intent.putExtra("personList", personList);
        startActivity(intent);
    }

    //startActivityForResult to receive a result from an activity
    public void toAddPerson(View v) {
        Intent intent = new Intent(this, AddNewPerson.class);
        startActivityForResult(intent, ADD_NEW_PERSON);
    }

    //Calls onActivityResult when addNewPerson is done and adds new name to the ArrayList
    @Override
    protected  void onActivityResult (int requestCode, int resultCode, Intent data) {
        //Check which request we're responding to
        if (requestCode == ADD_NEW_PERSON) {
            //Be sure the request was successfull
            if(resultCode == RESULT_OK) {
                //Bundle to get data that has been passed
                Bundle extras = data.getExtras();
                String name = (String) extras.get("name");
                personList.add(name);
            }
        }
    }
}
