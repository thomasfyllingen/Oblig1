package com.example.oblig1;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.net.Uri;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ImageTest {
    @Rule
    public IntentsTestRule<InfoActivity> testRule = new IntentsTestRule<>(InfoActivity.class);
    @Rule
    public ActivityScenarioRule<InfoActivity> iActivity = new ActivityScenarioRule<>(InfoActivity.class);




    @Test
    public void testImages(){
        InfoActivity IA = getActivity(iActivity);
        List<Image> imageList = IA.imageList;
        int size = imageList.size();
        onView(withId(R.id.addButton)).perform(click());
        //onView(withId(R.id.ChooseButton)).perform(click());
        Intent resultData = new Intent();
        //Image image = new Image(("drawable-v24\\kiwi.png"),"apple" );
        String image = "drawable-v24\\kiwi.png";
        resultData.putExtra("image", image);
        Instrumentation.ActivityResult result =
                new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        intending(toPackage(UploadPhoto.class.getName())).respondWith(result);

        onView(withId(R.id.editTextName1)).perform(typeText("Kiwi"), closeSoftKeyboard());
        onView(withId(R.id.SubmitButton)).perform(click());
        int sizeAfteradd = imageList.size();
        assertTrue(size + 1 == sizeAfteradd);

    }
    private InfoActivity getActivity(ActivityScenarioRule<InfoActivity> activityScenarioRule) {
        AtomicReference<InfoActivity> activityRef = new AtomicReference<>();
        activityScenarioRule.getScenario().onActivity(activityRef::set);
        return activityRef.get();
    }
}
