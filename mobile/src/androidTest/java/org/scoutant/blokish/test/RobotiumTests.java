package org.scoutant.blokish.test;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import org.scoutant.blokish.*;
import org.scoutant.blokish.model.Square;


public class RobotiumTests extends
        ActivityInstrumentationTestCase2<UI> {

    private Solo solo;
    private UI ui;


    public RobotiumTests() {
        super(UI.class);
    }

    public void setUp() throws Exception {
        super.setUp();

    }


    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testDragFeature() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());

        solo.waitForActivity("UI", 2000);
        ui = (UI) getActivity();

        PieceUI piece = ui.game.findPiece(0, "I5");

        int[] start=new int[2];
        int[] end=new int[2];

        piece.getLocationOnScreen(start);

        float startX=(float)start[0]+ piece.getWidth()/2;
        float startY =(float)start[1]+ piece.getHeight()-1;


        float endX = 0;
        float endY = 0;

        for(Square s: ui.game.game.boards.get(0).seeds()){
            endX = s.i*ui.game.size + ui.game.size/4;
            endY = s.j*ui.game.size + ui.game.size/4;

            break;
        }

        System.out.println("Starting Location: "+startX +" " + startY);
        solo.drag(startX, endX, startY, endY, 200);
        solo.assertCurrentActivity("UI Supposed to Launch", UI.class);

        piece.getLocationOnScreen(end);

        assertNotSame("X Position of piece must be different", start[0], end[0]);
        assertNotSame("X Position of piece must be different", start[1], end[1]);

    }
}