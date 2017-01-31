package com.example.birger.mainmenuactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

public class MainMenuActivity extends AppCompatActivity {

    private static final String TAG ="LOGG:";
    ArrayList<String> personList;
    static final int ADD_NEW_PERSON = 1;
    SharedPreferences prefs = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences("MainMenuActivity", 0);

        if (prefs.getBoolean("firstrun", true) && !prefs.contains("nameArray")) {
            Intent intent = new Intent(this, FirstRunAdd.class);
            startActivityForResult(intent, ADD_NEW_PERSON);
            prefs.edit().putBoolean("firstrun", false).commit();
        }

        if(prefs.contains("nameArray")) {
            SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
            String namesString = sharedPref.getString("nameArray", null);
            String[] namesArray = namesString.split(",");
            personList = new ArrayList<>(Arrays.asList(namesArray));
        } else {
            personList = new ArrayList<>();
        }
    }

/*   @Override
    protected void onResume() {
        super.onResume();

        prefs = getSharedPreferences("MainMenuActivity", Context.MODE_PRIVATE);

        if (prefs.getBoolean("firstrun", true) && !prefs.contains("nameArray")) {
            Intent intent = new Intent(this, FirstRunAdd.class);
            startActivityForResult(intent, ADD_NEW_PERSON);
            prefs.edit().putBoolean("firstrun", false).commit();
        }
    }

    */

    //From menu, when clicking buttons go to one of these activities
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
                if(name.trim().isEmpty()) {
                    Log.i(TAG, "Name empty.");
                } else {
                    personList.add(name);
                }
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences sharedpref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < personList.size(); i++) {
            sb.append(personList.get(i)).append(",");
        }
        editor.putString("nameArray", sb.toString());
        editor.commit();
        Log.i(TAG, "her");
    }

    public void quit(View view){
        finish();
    }
}
