package ru.geekbrains.converter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static org.junit.Assert.assertEquals;

/**
 * Created by vmoro on 19.08.2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ConvertActivityTest {

    private String mStringToBetyped;

    @Rule
    public ActivityTestRule<ConvertActivity> mActivityRule = new ActivityTestRule<>(
            ConvertActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        mStringToBetyped = "5";
    }

    @Test
    public void ConvertActivity_toFahrenheitButton_Test() {
        // Type text and then press the button.
        onView(withId(R.id.celsiusValue))
                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.toFahrenheitButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.celsiusValue))
                .check(matches(withText(mStringToBetyped)));

        onView(withId(R.id.fahrenheitValue))
                .check(matches(withText("41.00"))); // формат вывода два знака после запятой

    }

    @Test
    public void AppContext_Test() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("ru.geekbrains.converter", appContext.getPackageName());
    }

}
