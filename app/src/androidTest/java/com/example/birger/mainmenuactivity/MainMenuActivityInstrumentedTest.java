package com.example.birger.mainmenuactivity;


import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ListView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.example.birger.mainmenuactivity.R.id.list;
import static junit.framework.Assert.assertEquals;

/**
 * Created by espensteine on 31/01/2017.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest

public class MainMenuActivityInstrumentedTest {

    @Test
    public void testItShowsZeroRows() {
        new MainMenuActivity();

        MainMenuActivity.runOnUiThread(new Runnable() {
            public void run() {
                ArrayList<String> personList = new ArrayList<String>();
            }
        });

        ListView listView = (ListView)MainMenuActivity.findViewById(list);
        assertEquals(0, listView.getChildCount());
    }



}
