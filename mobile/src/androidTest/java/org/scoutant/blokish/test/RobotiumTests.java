package org.scoutant.blokish.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.robotium.solo.Solo;

import org.scoutant.blokish.*;
import org.scoutant.blokish.R;
import org.scoutant.blokish.model.Square;

import cucumber.api.java.en.Given;


public class RobotiumTests extends
        ActivityInstrumentationTestCase2<UI> {

    private Solo solo;
    private UI ui;
    private final String FIRST_PIECE_TYPE = "I5";
    private final int COLOR = 0;


    public RobotiumTests() {
        super(UI.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());


    }


    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    private int[][] dragFirstPieceToCorner(){

        solo.waitForActivity("UI", 2000);
        ui = (UI) getActivity();

        PieceUI piece = ui.game.findPiece(0, FIRST_PIECE_TYPE);

        int[][] result = new int[2][2];

        int[] start=new int[2];
        int[] end=new int[2];

        piece.getLocationOnScreen(start);

        float startX=(float)start[0]+ piece.getWidth()/2;
        float startY =(float)start[1]+ piece.getHeight()-1;


        float endX = 0;
        float endY = 0;

        for(Square s: ui.game.game.boards.get(0).seeds()){
            endX = s.i*ui.game.size + ui.game.size/4;
            endY = s.j*ui.game.size + 6*ui.game.size;

            break;
        }

        System.out.println("Starting Location: "+startX +" " + startY);
        solo.drag(startX, endX, startY, endY, 200);
        solo.assertCurrentActivity("UI Supposed to Launch", UI.class);

        piece.getLocationOnScreen(end);
        result[0] = start;
        result[1] = end;
        return result;
    }

    private void confirmPiece(){
        int[] position = {10, 10};
        int width = 0;
        for (int i=0; i<ui.game.getChildCount(); i++) {
            View v = ui.game.getChildAt(i);
            if (v instanceof ButtonsView) {

                ButtonsView myButtonView = (ButtonsView) v;
                myButtonView.ok.getLocationOnScreen(position);
                width = myButtonView.ok.getWidth();
                System.out.println("Found Button= "+(position[0] + width/2) +" " + (position[1] + width/2));
                solo.clickOnScreen(position[0] + width/2, position[1] + width/2);
                break;
            }


        }
    }
    private void cancelPiece(){
        int[] position = {10, 10};
        int width = 0;
        for (int i=0; i<ui.game.getChildCount(); i++) {
            View v = ui.game.getChildAt(i);
            if (v instanceof ButtonsView) {

                ButtonsView myButtonView = (ButtonsView) v;
                myButtonView.ok.getLocationOnScreen(position);
                width = myButtonView.ok.getWidth();
                position[0] =  ui.game.size*20 - (position[0] + width/2);
                System.out.println("Found Button= "+(position[0] + width/2) +" " + (position[1] + width/2));
                solo.clickOnScreen(position[0], position[1] + width/2);
                break;
            }


        }
    }

    public void testDragFeature(){

        int result[][] = dragFirstPieceToCorner();
        try {
            Thread.sleep(2000);
        } catch (Exception e){

        }
        cancelPiece();
        try {
            Thread.sleep(2000);
        } catch (Exception e){

        }
        assertNotSame("X Position of piece must be different", result[0][0], result[1][0]);
        assertNotSame("X Position of piece must be different", result[0][1], result[1][1]);

    }

    /*
    //Check to see if player can still play the piece. If not, then the test is successful.
    public void testConfirmFirstPiece(){
        dragFirstPieceToCorner();
        confirmPiece();

    }
    //Check to see if player can still play the piece. If not, then the test is successful.
    public void testCancelFirstPiece(){
        dragFirstPieceToCorner();
        confirmPiece();

    }*/
}