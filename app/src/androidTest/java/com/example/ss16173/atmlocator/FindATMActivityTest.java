package com.example.ss16173.atmlocator;

import android.content.Intent;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.ss16173.atmlocator.findatm.view.FindATMActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by susmita on 2/11/2018.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class FindATMActivityTest {

    @Rule
    public ActivityTestRule<FindATMActivity> findATMActivityActivityTestRule =
            new ActivityTestRule<FindATMActivity>(FindATMActivity.class, true, false);


    @Before
    public void setUp() {
        Intent intent = new Intent();
        findATMActivityActivityTestRule.launchActivity(intent);
    }


    @Test
    public void testFindATMButton() {
        onView(withId(R.id.findAtmButton)).check(matches(isDisplayed()));
        onView(withId(R.id.findAtmButton)).check(matches(isClickable()));
        onView(withId(R.id.findAtmButton)).check(matches(withText(getInstrumentation().getTargetContext().getResources().getString(R.string.find_atm_button))));
    }

    @After
    public void tearDown() {

    }
}
