package org.scoutant.blokish.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.robotium.solo.Solo;

import org.scoutant.blokish.*;
import org.scoutant.blokish.R;
import org.scoutant.blokish.model.Square;

import java.util.Arrays;

import cucumber.api.java.en.Given;


public class RobotiumTests extends
        ActivityInstrumentationTestCase2<UI> {

    private Solo solo;
    private UI ui;
    //Piece string tags found in Board.java
    private static final String FIRST_PIECE_TYPE = "I5"; //Vertical Line (Top Left 1st piece available)
    //TODO: decide piece type
    private static final String SECOND_PIECE_TYPE = "N5"; //Vertical Line (Top Left 1st piece available)
    private static final String THIRD_PIECE_TYPE = "L5"; // Backwards L (Bottom Left 1st piece available)
    private static final int COLOR = 0; //Red

    public RobotiumTests(){
        super(UI.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
        ui = (UI) getActivity();
    }


    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    /** TEST
     *  Tests Scenario #X ,Feature: Drag Block Placement
     */
    public void testDragFeature(){

        int result[][] = dragPieceToCorner(FIRST_PIECE_TYPE, COLOR);
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

    /** TEST --DONE
     *  Tests Scenario #12, Feature:  Update Game Score
     *  "Successfully add block to the board and update my score"
     */
    public void testScoreUpdate(){
        TextView redTab = ui.game.tabs[0]; //holds view containing red player's score
        
        int preUpdateScore = 0;
        if(!redTab.getText().toString().isEmpty()){ //score stored as string, initially empty string
            preUpdateScore = Integer.parseInt(redTab.getText().toString());
        }

        int[][] moveResult = dragPieceToCorner(FIRST_PIECE_TYPE, COLOR);
        System.out.println("Move locations: \t"+Arrays.deepToString(moveResult)); //ToDO validate result of moving inital piece
        confirmPiece();
        solo.sleep(2000); // 2 seconds to ensure ui updated

        int postUpdateScore = 0;
        if(!redTab.getText().toString().isEmpty()){
            postUpdateScore = Integer.parseInt(redTab.getText().toString());
        } 

        assertEquals(5, postUpdateScore - preUpdateScore); //I.e. score increased by 5
    }


     /*TODO: Implement assertion
    //Check to see if player can still play the piece. If not, then the test is successful.
    public void testConfirmFirstPiece(){
        dragPieceToCorner(FIRST_PIECE_TYPE, COLOR);
        confirmPiece();

    }
    //Check to see if player can still play the piece. If not, then the test is successful.
    public void testCancelFirstPiece(){
        dragPieceToCorner(FIRST_PIECE_TYPE, COLOR);
        cancelPiece();

    }*/

    //HELPERS: -----------------------------------------------------------------------------------------

    /** Helper
     *  Drags the specified piece upper left seed
     *  Assumes either new game or only first move (First piece to upperLeft)
     *  Assumes screen hasn't been altered beforehand
     *  Assumes Red player
     * @param type string representing code for the piece to be moved
     * @param colour int representing colour of board to operate on.
     * @return  int[0] before = array of pixel locations before piece was moved, I.e. before[0] = old X, before[1] = old Y
     *          int[1] after = array of pixel locations after piece was moved, I.e. after[1] = new X, after[1] = new Y
     */
    private int[][] dragPieceToCorner(String type, int colour){

        solo.waitForActivity("UI", 2000);

        PieceUI piece = ui.game.findPiece(COLOR, type);

        int[][] result = new int[2][2];

        int[] start=new int[2];
        int[] end=new int[2];

        /* Writes into provided array the pixel location associated to the pieceUI        
         * E.g. start[0] = x coordinate of left side of piece
         *      start[1] = y coordinate of top of piece
         */
        piece.getLocationOnScreen(start);

        float startX=(float)start[0]+ piece.getWidth()/2;
        float startY =(float)start[1]+ piece.getHeight()-1;


        float endX = 0; //drag requires float
        float endY = 0;

        //Note: in a new game the seeds() will return 1 Seed, the initial move
        for(Square s: ui.game.game.boards.get(colour).seeds()){
            endX = s.i*ui.game.size + ui.game.size/4;
            endY = s.j*ui.game.size + 6*ui.game.size;

            break;
        }
        if(type.equals(SECOND_PIECE_TYPE)){
            endX += 2*ui.game.size;
            endY -= ui.game.size;
        }

        //System.out.println("Starting Location: "+startX +" " + startY);
        solo.drag(startX, endX, startY, endY, 100);
        //solo.assertCurrentActivity("UI Supposed to Launch", UI.class);

        piece.getLocationOnScreen(end);
        result[0] = start;
        result[1] = end;
        return result;
    }

    private void setupGame(){
        dragPieceToCorner(FIRST_PIECE_TYPE, COLOR);
        solo.sleep(100);
        confirmPiece();
        solo.sleep(100);
        dragPieceToCorner(SECOND_PIECE_TYPE, COLOR);
        confirmPiece();
    }

    /** Helper
     *  Will attempt to click the location where the confirm placement button is
     */
    private void confirmPiece(){
        int[] position = {10, 10};
        int width = 0;

        ButtonsView myButtonView = findButtonView();
        if(myButtonView == null){
            assertNotNull(myButtonView);
        }

        myButtonView.ok.getLocationOnScreen(position);
        width = myButtonView.ok.getWidth();
        System.out.println("Found Button= "+(position[0] + width/2) +" " + (position[1] + width/2));
        solo.clickOnScreen(position[0] + width/2, position[1] + width/2);
    }
    /** Helper
     *  Find the Approve&Cancel ButtonView
     * @return ButtonView containing the Approve and Cancel buttons
     * Note, might return null!
     */
    private ButtonsView findButtonView() {
        ButtonsView myButtonView = null;
        for (int i=0; i<ui.game.getChildCount(); i++) {
            View v = ui.game.getChildAt(i);
            if (v instanceof ButtonsView) {
                myButtonView = (ButtonsView) v;
                break;
            }
        }
        return myButtonView;
    }

    /** Helper
     *  Will attempt to click the location where the cancel placement button is
     */
    private void cancelPiece(){
        int[] position = {10, 10};
        int width = 0;

        ButtonsView myButtonView = findButtonView();
        if(myButtonView == null){
            assertNotNull(myButtonView);
        }

        myButtonView.ok.getLocationOnScreen(position);
        width = myButtonView.ok.getWidth();
        position[0] =  ui.game.size*20 - (position[0] + width/2);
        System.out.println("Found Button= "+(position[0] + width/2) +" " + (position[1] + width/2));
        solo.clickOnScreen(position[0], position[1] + width/2);
    }
}