package com.example.birger.mainmenuactivity;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Quiz {

    @Rule
    public ActivityTestRule<MainMenuActivity> mActivityTestRule = new ActivityTestRule<>(MainMenuActivity.class);

    @Test
    public void quiz() {

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btnQuiz), withText("Start quiz"),
                        withParent(allOf(withId(R.id.activity_main_menu),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btnNext), withText("Start"),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(withId(R.id.activity_learning_mode)))),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btnNext), withText("Next"),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(withId(R.id.activity_learning_mode)))),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btnNext), withText("Next"),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(withId(R.id.activity_learning_mode)))),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btnNext), withText("Next"),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(withId(R.id.activity_learning_mode)))),
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.btnQuit), withText("Quit"),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(withId(R.id.activity_learning_mode)))),
                        isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.result_homeButton), withText("Home"),
                        withParent(allOf(withId(R.id.activity_result),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton8.perform(click());

    }

}
