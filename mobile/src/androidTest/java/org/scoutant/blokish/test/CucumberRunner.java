package org.scoutant.blokish.test;
import android.test.ActivityInstrumentationTestCase2;
import com.robotium.solo.Solo;
import org.scoutant.blokish.UI;

/*
    Class will act as UI/System Level test Suite
    Will call corresponding tests from the "****"BlockCucumber.java files
 */

public class CucumberRunner extends ActivityInstrumentationTestCase2<UI> {

    private Solo solo;

    private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "org.scoutant.blokish.UI";
    private static Class<?> launcherActivityClass;

    static {
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public CucumberRunner() throws ClassNotFoundException {
        super((Class<UI>) launcherActivityClass);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        getActivity().finish();
        super.tearDown();
    }


}
