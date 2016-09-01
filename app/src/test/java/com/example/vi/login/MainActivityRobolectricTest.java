package com.example.vi.login;

/*

import android.os.Build;*/

import android.os.Build;
import android.widget.EditText;

import com.example.vi.login.adddata.MainActivity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by taufiqotulfaidah on 9/1/16.
 */

@Config(constants = BuildConfig.class,
        sdk = Build.VERSION_CODES.LOLLIPOP_MR1,
        packageName =BuildConfig.APPLICATION_ID)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityRobolectricTest {

    private MainActivity mainActivity;

    @Before
    public void setup(){
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        //mainActivity = Robolectric.buildActivity(MainActivity.class).get();
    }

    @Test
    public void tesUI() throws Exception{
        EditText etName = (EditText)mainActivity.findViewById(R.id.etFullname);
        //Assert.assertTrue(true);
        assertNotNull(etName);

        etName.setText("Tes username");
    }

}
