package com.example.oblig1;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.icu.text.IDNA;
import android.net.Uri;

import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImageTest {

    @Rule
    public ActivityScenarioRule<InfoActivity> iActivity = new ActivityScenarioRule<>(InfoActivity.class);

    @Before
    public void setUp() {
        Intents.init();
    }


    @After
    public void tearDown() {
        Intents.release();
    }


    @Test
    public void AddImages(){
        InfoActivity IA = getActivity(iActivity);
        List<Image> imageList = IA.imageList;
        int size = imageList.size();
        onView(withId(R.id.addButton)).perform(click());

        Intent resultData = new Intent();

        Uri uri = Uri.parse("android.resource://com.example.oblig1/drawable/" + R.drawable.kiwi);
        resultData.setData(uri);

        Instrumentation.ActivityResult result =
                new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        intending(not(isInternal())).respondWith(result);
        onView(withId(R.id.ChooseButton)).perform(click());
        onView(withId(R.id.editTextName1)).perform(typeText("Kiwi"), closeSoftKeyboard());
        onView(withId(R.id.SubmitButton)).perform(click());
        onView(withId(R.id.imageButton)).perform(click());
        int sizeAfteradd = imageList.size();
        assertEquals(size + 1, sizeAfteradd);

    }

    @Test
    public void DeleteImages(){
        InfoActivity IA = getActivity(iActivity);
        List<Image> imageList = IA.imageList;
        int size = imageList.size();
        onView(withId(R.id.toDelete)).perform(click());
        onView(withId(R.id.deleteNameText)).perform(typeText("Kiwi"),closeSoftKeyboard());
        onView(withId(R.id.DeleteButton)).perform(click());
        int sizeAfterDelete = imageList.size();
        assertEquals(size - 1, sizeAfterDelete);
    }
    private InfoActivity getActivity(ActivityScenarioRule<InfoActivity> activityScenarioRule) {
        AtomicReference<InfoActivity> activityRef = new AtomicReference<>();
        activityScenarioRule.getScenario().onActivity(activityRef::set);
        return activityRef.get();
    }
}
