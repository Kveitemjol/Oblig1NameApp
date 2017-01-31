package com.example.birger.mainmenuactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

public class MainMenuActivity extends AppCompatActivity {

    private static final String TAG = "logger";
    String filename = "names";

    ArrayList<String> personList;
    static final int ADD_NEW_PERSON = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSharedPreferences("MainMenuActivity", 0).contains("nameArray")) {
            SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
            String namesString = sharedPref.getString("nameArray", null);
            String [] namesArray = namesString.split(",");
            personList = new ArrayList<String>(Arrays.asList(namesArray));
        } else {
            personList = new ArrayList<String>();
        }
    }

    //For adding owner of app when the app is started for the first time,
    //does not work properly yet
    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
        if(!previouslyStarted) {
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
            edit.commit();
            //showHelp();
        }
    }

    //From menu, when clicking buttons go to one of these methods
    public void toNameList(View v) {
        Intent intent = new Intent(this, ListViewActivity.class);
        intent.putExtra("personList", personList);
        startActivity(intent);
    }

    //start gallery activity
    public void toGallery(View v) {
        Intent intent = new Intent(this, GalleryActivity.class);
        intent.putExtra("personList", personList);
        startActivity(intent);
    }

    //start Quiz activity
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

    //when quiting activity
    public void quit(View view){
        finish();
    }
}
