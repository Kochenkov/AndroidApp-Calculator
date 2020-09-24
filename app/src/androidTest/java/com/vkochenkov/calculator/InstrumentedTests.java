package com.vkochenkov.calculator;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class InstrumentedTests {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkInputAllDigits() {
        //when
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnThree)).perform(click());
        onView(withId(R.id.btnFour)).perform(click());
        onView(withId(R.id.btnFive)).perform(click());
        onView(withId(R.id.btnSix)).perform(click());
        onView(withId(R.id.btnSeven)).perform(click());
        onView(withId(R.id.btnEight)).perform(click());
        onView(withId(R.id.btnNine)).perform(click());
        onView(withId(R.id.btnZero)).perform(click());
        onView(withId(R.id.btnPoint)).perform(click());
        //then
        onView(allOf(withId(R.id.tvMain), withText("1234567890."))).check(matches(isDisplayed()));
    }

    @Test
    public void checkAddingOp() {
        //when
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());

        //then
        onView(allOf(withId(R.id.tvMain), withText("23.0"))).check(matches(isDisplayed()));
    }

    @Test
    public void checkSubtractionOp() {
        //when
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnMinus)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());

        //then
        onView(allOf(withId(R.id.tvMain), withText("-21.0"))).check(matches(isDisplayed()));
    }

    @Test
    public void checkMultiplicationOp() {
        //when
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnMultiply)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());

        //then
        onView(allOf(withId(R.id.tvMain), withText("4.0"))).check(matches(isDisplayed()));
    }

    @Test
    public void checkDivisionOp() {
        //when
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnDivision)).perform(click());
        onView(withId(R.id.btnThree)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());

        //then
        onView(allOf(withId(R.id.tvMain), withText("7.3333335"))).check(matches(isDisplayed()));
    }

    @Test
    public void checkZeroDivisionOp() {
        //when
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnDivision)).perform(click());
        onView(withId(R.id.btnZero)).perform(click());
        onView(withId(R.id.btnEqual)).perform(click());

        //then
        onView(allOf(withId(R.id.tvMain), withText("Infinity"))).check(matches(isDisplayed()));
    }
}