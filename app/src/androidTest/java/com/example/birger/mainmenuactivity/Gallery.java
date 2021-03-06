package com.example.birger.mainmenuactivity;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Gallery {

    @Rule
    public ActivityTestRule<MainMenuActivity> mActivityTestRule = new ActivityTestRule<>(MainMenuActivity.class);

    @Test
    public void gallery() {

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn_skipStep), withText("Skip!"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btnPics), withText("Show pictures"),
                        withParent(allOf(withId(R.id.activity_main_menu),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction imageView = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.gridView),
                                withParent(withId(R.id.activity_gallery))),
                        1),
                        isDisplayed()));
        imageView.perform(click());

        pressBack();

        ViewInteraction imageView2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.gridView),
                                withParent(withId(R.id.activity_gallery))),
                        0),
                        isDisplayed()));
        imageView2.perform(click());

        pressBack();

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btnHome), withText("Home"),
                        withParent(allOf(withId(R.id.activity_gallery),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton3.perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
