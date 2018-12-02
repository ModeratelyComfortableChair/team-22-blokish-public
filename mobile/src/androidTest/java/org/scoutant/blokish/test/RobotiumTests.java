package org.scoutant.blokish.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.TextView;

import com.robotium.solo.Solo;

import org.scoutant.blokish.ButtonsView;
import org.scoutant.blokish.PieceUI;
import org.scoutant.blokish.UI;
import org.scoutant.blokish.model.Square;

import java.util.Arrays;


public class RobotiumTests extends ActivityInstrumentationTestCase2<UI> {

    private Solo solo;
    private UI ui;
    //Piece string tags found in Board.java
    private static final String FIRST_PIECE_TYPE = "I5"; //Vertical Line (Top Left 1st piece available)

    private static final String SECOND_PIECE_TYPE = "N5";
    private static final String THIRD_PIECE_TYPE = "L5"; // Backwards L (Bottom Left 1st piece available)
//    private static final String FOURTH_PIECE_TYPE = "T5";
//    private static final String FIFTH_PIECE_TYPE = "U5";
    private static final String FOURTH_PIECE_TYPE = "Z5";
    private static final String FIFTH_PIECE_TYPE = "Y5";
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
        solo.sleep(1000);

        solo.getCurrentActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ui.newgame();   //prepare a new game for next test case, if any
            }
        });
        solo.finishOpenedActivities();
        super.tearDown();
    }

    /** TEST -DONE
     *  Tests Scenario #1 ,Feature: Drag Block Placement
     */
    public void testDragFeature() {

        int result[][] = dragPieceToCorner(FIRST_PIECE_TYPE, COLOR);

        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }

        ButtonsView confirmButton = findButtonView();

        boolean confirmVisible = false;

        if (confirmButton != null) {
            if (confirmButton.getVisibility() == View.VISIBLE && confirmButton.isShown()) {
                confirmVisible = true;
            }
        }

        assertEquals(true, confirmVisible);
    }

    /** TEST --Done
     *  Tests Scenario #3 ,Feature: Approve Block Placement
     */
    public void testInvalidPlacementWrongStartingCorner() {
        dragPieceToCorner(FIRST_PIECE_TYPE,1);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }

        ButtonsView confirmButton = findButtonView();
        boolean confirmClickable = confirmButton.isClickable();

        assertEquals(false, confirmClickable);
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


    /** TEST --DONE
     *  Tests Scenario #2, Feature:  Approve Block Placement
     *  "For first round, I confirm a piece placed in my corner"
     */
    public void testConfirmPieceInUpperLeftCornerDuringFirstRound(){
        dragPieceToCorner(FIRST_PIECE_TYPE, COLOR);
        solo.sleep(100);
        confirmPiece();
        solo.sleep(2000);
        //the size of the list of available red pieces becomes 20 which means that the piece has been placed on the board
        assertEquals(20,ui.game.game.boards.get(COLOR).pieces.size());
    }

    /** TEST --DONE
     *  Tests Scenario #4, Feature:  Cancel Block Placement
     *  "For first round, I cancel a piece placed in my corner"
     */
    public void testCancelPieceInUpperLeftCornerDuringFirstRound(){
        dragPieceToCorner(FIRST_PIECE_TYPE, COLOR);
        solo.sleep(100);
        cancelPiece();
        //the size of the list of available red pieces is still 21 which means that the piece has not been placed on the board
        assertEquals(21,ui.game.game.boards.get(COLOR).pieces.size());
    }

    /** TEST --DONE
     *  Tests Scenario #5, Feature:  Cancel Block Placement
     *  "For first round, I cancel a piece placed not in my corner"
     */
    public void testCancelPieceInUpperRightCornerDuringFirstRound(){
        dragPieceToCorner(FIRST_PIECE_TYPE, 1);
        solo.sleep(100);
        cancelPiece();
        //the size of the list of available red pieces is still 21 which means that the piece has not been placed on the board
        assertEquals(21,ui.game.game.boards.get(COLOR).pieces.size());
    }

    /** TEST --DONE
     *  Tests Scenario #6, Feature: Confirm Block Placement
     *  "For non first round, I confirm a piece which meets with the corner of another of my pieces, and isn’t on another piece or at the side of another piece"
     */
    public void testValidConfirmPieceInUpperLeftCornerDuringNonFirstRound(){
        setupGame();
        //the size of the list of available red pieces becomes 19 which means that the second piece has been placed on the board
        assertEquals(19,ui.game.game.boards.get(COLOR).pieces.size());
    }

    /** TEST --DONE
     *  Tests Scenario #6, Feature: Cancel Block Placement
     *  "For non first round, I confirm a piece which meets with the corner of another of my pieces, and isn’t on another piece or at the side of another piece"
     */
    public void testCancelPiece_WhichMeetsWithAnotherCorner_InUpperLeftCornerDuringNonFirstRound(){
        dragPieceToCorner(FIRST_PIECE_TYPE, COLOR);
        solo.sleep(100);
        confirmPiece();
        dragPieceToCorner(SECOND_PIECE_TYPE, COLOR);
        cancelPiece();

        //the size of the list of available red pieces is still 20 which means that the second piece has not been placed on the board
        assertEquals(20,ui.game.game.boards.get(COLOR).pieces.size());
    }

    /** TEST --DONE
     *  Tests New Scenario #13, Feature: Confirm Block Placement
     *  "For non first round, I confirm a piece which has a side that lines up on another piece of my pieces"
     */
    public void testInvalidConfirm_SideLineUpProblem_PieceInUpperLeftCornerDuringNonFirstRound(){
        dragPieceToCorner(FIRST_PIECE_TYPE, COLOR);
        solo.sleep(100);
        confirmPiece();
        dragPieceToCorner(THIRD_PIECE_TYPE, COLOR);

        ButtonsView confirmButton = findButtonView();
        boolean confirmClickable = confirmButton.isClickable();

        assertEquals(false, confirmClickable);
    }

    /** TEST --DONE
     *  Tests New Scenario #14, Feature: Confirm Block Placement
     *  "For non first round, I confirm a piece which does not meet with the any of the corners of another piece of my pieces"
     */
    public void test11InvalidConfirm_DoesNotMeetCornerProblem_PieceInUpperLeftCornerDuringNonFirstRound(){
        dragPieceToCorner(FIRST_PIECE_TYPE, COLOR);
        solo.sleep(100);
        confirmPiece();
        dragPieceToCorner(FOURTH_PIECE_TYPE, COLOR);

        ButtonsView confirmButton = findButtonView();
        boolean confirmClickable = confirmButton.isClickable();

        assertEquals(false, confirmClickable);
    }


    /** TEST --DONE
     *  Tests New Scenario #15, Feature: Confirm Block Placement
     *  "For non first round, I confirm a piece which is on top of another piece of my pieces"
     */
    public void test12InvalidConfirm_IsOnTopProblem_PieceInUpperLeftCornerDuringNonFirstRound(){
        dragPieceToCorner(FIRST_PIECE_TYPE, COLOR);
        solo.sleep(100);
        confirmPiece();
        dragPieceToCorner(FIFTH_PIECE_TYPE, COLOR);

        ButtonsView confirmButton = findButtonView();
        boolean confirmClickable = confirmButton.isClickable();

        assertEquals(false, confirmClickable);
    }


    /** TEST --DONE
     *  Tests New Scenario #16, Feature: Cancel Block Placement
     *  "For non first round, I cancel a piece which has a side that lines up on another piece of my pieces"
     */
    public void testCancel_SideLineUpProblem_PieceInUpperLeftCornerDuringNonFirstRound(){
        dragPieceToCorner(FIRST_PIECE_TYPE, COLOR);
        solo.sleep(100);
        confirmPiece();
        dragPieceToCorner(THIRD_PIECE_TYPE, COLOR);
        cancelPiece();

        //the size of the list of available red pieces is still 20 which means that the second piece has not been placed on the board
        assertEquals(20,ui.game.game.boards.get(COLOR).pieces.size());
    }


    /** TEST --DONE
     *  Tests New Scenario #17, Feature: Cancel Block Placement
     *  "For non first round, I cancel a piece which does not meet any of the corners of another piece of my pieces"
     */
    public void testCancel111_DoesNotMeetCornerProblem_PieceInUpperLeftCornerDuringNonFirstRound(){
        dragPieceToCorner(FIRST_PIECE_TYPE, COLOR);
        solo.sleep(100);
        confirmPiece();
        dragPieceToCorner(FOURTH_PIECE_TYPE, COLOR);
        cancelPiece();

        //the size of the list of available red pieces is still 20 which means that the second piece has not been placed on the board
        assertEquals(20,ui.game.game.boards.get(COLOR).pieces.size());
    }


    /** TEST --DONE
     *  Tests New Scenario #18, Feature: Cancel Block Placement
     *  "For non first round, I cancel a piece which is on top of another piece of my pieces"
     */
    public void testCancel112_IsOnTopProblem_PieceInUpperLeftCornerDuringNonFirstRound(){
        dragPieceToCorner(FIRST_PIECE_TYPE, COLOR);
        solo.sleep(100);
        confirmPiece();
        dragPieceToCorner(FIFTH_PIECE_TYPE, COLOR);
        cancelPiece();

        //the size of the list of available red pieces is still 20 which means that the second piece has not been placed on the board
        assertEquals(20,ui.game.game.boards.get(COLOR).pieces.size());
    }

    //HELPERS: -----------------------------------------------------------------------------------------

    /** Helper
     *  Drags the specified piece to specified seed
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
        if(type.equals(THIRD_PIECE_TYPE)){
//            endX += 2*ui.game.size;
            endY -= 2*ui.game.size;
        }

        if(type.equals(FOURTH_PIECE_TYPE)){
//            endX += 2*ui.game.size;
            endY += 2*ui.game.size;
        }

        if(type.equals(FIFTH_PIECE_TYPE)){
//            endX -= ui.game.size;
            endY -= 2*ui.game.size;
        }

        //System.out.println("Starting Location: "+startX +" " + startY);
        solo.drag(startX, endX, startY, endY, 100);
        //solo.assertCurrentActivity("UI Supposed to Launch", UI.class);

        piece.getLocationOnScreen(end);
        result[0] = start;
        result[1] = end;
        return result;
    }

    /** HELPER
     *  Sets up a game with I5 in top Left, N5 after
     */
    private void setupGame(){
        dragPieceToCorner(FIRST_PIECE_TYPE, COLOR);
        solo.sleep(100);
        confirmPiece();
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
        solo.sleep(200);
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
        solo.sleep(200);
    }
}