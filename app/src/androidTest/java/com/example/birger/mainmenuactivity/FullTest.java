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
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class FullTest {

    @Rule
    public ActivityTestRule<MainMenuActivity> mActivityTestRule = new ActivityTestRule<>(MainMenuActivity.class);

    @Test
    public void fullTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn_skipStep), withText("Skip!"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btnNames), withText("Show names"),
                        withParent(allOf(withId(R.id.activity_main_menu),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(android.R.id.text1), withText("Rudi"),
                        childAtPosition(
                                allOf(withId(R.id.list),
                                        withParent(withId(R.id.activity_list_view))),
                                0),
                        isDisplayed()));
        appCompatTextView.perform(click());

        pressBack();

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.button), withText("Home"),
                        withParent(allOf(withId(R.id.activity_list_view),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btnPics), withText("Show pictures"),
                        withParent(allOf(withId(R.id.activity_main_menu),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction imageView = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.gridView),
                                withParent(withId(R.id.activity_gallery))),
                        1),
                        isDisplayed()));
        imageView.perform(click());

        pressBack();

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btnHome), withText("Home"),
                        withParent(allOf(withId(R.id.activity_gallery),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btnQuiz), withText("Start quiz"),
                        withParent(allOf(withId(R.id.activity_main_menu),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.btnNext), withText("Start"),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(withId(R.id.activity_learning_mode)))),
                        isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.btnQuit), withText("Quit"),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(withId(R.id.activity_learning_mode)))),
                        isDisplayed()));
        appCompatButton8.perform(click());

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.result_homeButton), withText("Home"),
                        withParent(allOf(withId(R.id.activity_result),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton9.perform(click());

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.btnAddPerson), withText("Add new person"),
                        withParent(allOf(withId(R.id.activity_main_menu),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton10.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editText_Name),
                        withParent(allOf(withId(R.id.activity_add_new_person),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editText_Name),
                        withParent(allOf(withId(R.id.activity_add_new_person),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("NameTest"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editText_Name), withText("NameTest"),
                        withParent(allOf(withId(R.id.activity_add_new_person),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatEditText3.perform(pressImeActionButton());

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.button2), withText("Home"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(withId(R.id.activity_add_new_person)))),
                        isDisplayed()));
        appCompatButton11.perform(click());

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
