package org.scoutant.blokish.ui;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.SmallTest;

import com.robotium.solo.Solo;

import org.scoutant.blokish.PieceUI;
import org.scoutant.blokish.R;
import org.scoutant.blokish.UI;

public class RobotiumTest extends ActivityInstrumentationTestCase2<UI> {
    private Solo solo;
    private UI ui;

    private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "org.scoutant.blokish.UI";

    private static Class<?> launcherActivityClass;

    static {
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public RobotiumTest() throws ClassNotFoundException {
        super((Class<UI>) launcherActivityClass);
    }

    private String participantName;
    private String testParticipantName = "TestParticipant";

    @Override
    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation());
        ui = (UI) getActivity();
    }

    @LargeTest
    public void testFailApprove(){ //TODO: RENAME
//        solo.clickOnImage(R.drawable.blokish_2_pieces);
//        solo.getView(R.drawable.red);
//        solo.clickOnView();
        PieceUI piece = ui.game.findPiece(R.drawable.red, "square");
        solo.clickLongOnView(piece);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }
}