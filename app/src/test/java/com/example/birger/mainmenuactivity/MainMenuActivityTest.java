package com.example.birger.mainmenuactivity;

import android.os.Bundle;
import android.view.View;

import com.example.birger.mainmenuactivity.MainMenuActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static android.support.test.espresso.*;

/**
 * Created by espensteine on 31/01/2017.
 */
public class MainMenuActivityTest {

    ArrayList<String> personList = new ArrayList<String>();

    @Test
    public void onCreate() throws Exception {
        assertTrue(personList.isEmpty());
    }

    @Test
    public void onResume() throws Exception {
    }

    @Test
    public void toNameList() throws Exception {
        View view =
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

    @Test
    public void onActivityResult() throws Exception {

    }

    @Test
    public void onStop() throws Exception {

    }

    @Test
    public void quit() throws Exception {
        //assertThat(finish(), is true);
    }

}