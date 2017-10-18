package com.udacity.gradle.builditbigger.free;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class PaidTester {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    // Test that the asynctask returns a string
    @Test
    public void checksEmptyResponse() {
        try{
            new EndpointsAsyncTask(mActivityTestRule.getActivity(), new EndpointsAsyncTask.JokeCallback() {
                @Override
                public void showJoke(String result) {
                    assertTrue(result, result.length() > 0);
                }
            }, false).execute().get();
        }catch(Exception iex){
            fail("Some error occurred in the test");
        }

    }
}
