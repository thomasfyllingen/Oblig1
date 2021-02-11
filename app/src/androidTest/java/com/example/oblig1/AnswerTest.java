package com.example.oblig1;

import android.app.Activity;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class AnswerTest {
    @Rule
    public ActivityScenarioRule<QuizActivity> qActivity = new ActivityScenarioRule<>(QuizActivity.class);

    @Before
    public void Navigate(){
        onView(withId(R.id.quizButton1)).perform(click());
    }

    @Test
    public void testWrongAnswer() {
        onView(withId(R.id.svarEditText1)).perform(typeText("Baby"), closeSoftKeyboard());
        onView(withId(R.id.answerButton)).perform(click());
        onView(withId(R.id.poengTextView1)).check(matches(withText("0")));
        onView(withId(R.id.resultatTextView1)).check(matches(withText("1")));
    }
    @Test
    public void testRightAnswer(){
        
    }
}
