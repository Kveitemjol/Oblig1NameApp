package com.example.birger.mainmenuactivity;

import android.app.Instrumentation;
import android.content.SharedPreferences;
import android.widget.Button;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


/**
 * Created by espensteine on 31/01/2017.
 */
public class MainMenuActivityTest {

    ArrayList<String> personList = new ArrayList<String>();
    static final int ADD_NEW_PERSON = 1;
    SharedPreferences prefs = null;

    @Test
    public void onCreate() throws Exception {
        assertTrue(personList.isEmpty());
    }

    @Test
    public void onResume() throws Exception {
    }

    @Test
    public void toNameList() throws Exception {

    }

    @Test
    public void toGallery() throws Exception {

    }

    @Test
    public void toQuiz() throws Exception {

    }

    @Test
    public void toAddPerson() throws Exception {

    }

    int requestCode;
    @Test
    public void onActivityResult() throws Exception {
        assertTrue(requestCode == ADD_NEW_PERSON);
    }

    @Test
    public void onStop() throws Exception {
        assertTrue(personList.contains(','));
    }

    @Test
    public void quit() throws Exception {

    }

}