package com.example.vi.login;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.vi.login.login.LoginPageActivity;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by taufiqotulfaidah on 8/31/16.
 */

@RunWith(AndroidJUnit4.class)
public class LoginPageActivityEspressoTest {

    @Rule
    public ActivityTestRule<LoginPageActivity> loginPage =
            new ActivityTestRule<LoginPageActivity>(LoginPageActivity.class);

    @Test
    public void tes1() throws Exception{
        String user = "Alloha";

        onView(withId(R.id.et_username)).perform(typeText(user), ViewActions.closeSoftKeyboard());

        //onView(withId(R.id.et_password)).perform(typeText("password"), ViewActions.closeSoftKeyboard());

        //onView(withId(R.id.btn_login)).perform(click());

    }

    @Test
    public void tes2(){
        String pass = "password";

        onView(withId(R.id.et_password)).perform(typeText(pass));
    }

    @Test
    public void tesClick(){

        onView(withId(R.id.btn_login)).perform(click());
    }




}
