package org.scoutant.blokish.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import org.scoutant.blokish.UI;


public class RobotiumTests extends
        ActivityInstrumentationTestCase2<UI> {

    private Solo solo;

    public RobotiumTests() {
        super(UI.class);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }


    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testActivity() throws Exception{
        solo.assertCurrentActivity("UI Supposed to Launch", UI.class);
    }
}