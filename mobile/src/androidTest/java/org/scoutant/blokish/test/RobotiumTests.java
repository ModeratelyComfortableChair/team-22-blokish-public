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

    /**
     *  Tests Scenario #1: “For any round, I drag a piece to any position on the board."
     *  Feature #1: Drag Block onto Board
     */
    public void testDragBlockOntoBoard_AnyRound() {

        int result[][] = dragPieceToSpecificLocation(FIRST_PIECE_TYPE, COLOR);

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

    /**
     *  Tests Scenario #2: “During the first round, I confirm a piece placed at the sole valid position on the board, the top-left corner.”
     *  Feature #2:  Approve Block Placement
     */
    public void testConfirmPieceInMyCorner_FirstRound(){    //my corner is the upper-left corner
        addFirstPieceToBoard();
        solo.sleep(2000);
        //the size of the list of available red pieces should become 20, which means that the piece has been placed on the board
        assertEquals(20,ui.game.game.boards.get(COLOR).pieces.size());
    }

    /**
     *  Tests Scenario #3: “During the first round, I attempt to confirm a piece which is not placed at the top let corner.”
     *  Feature #3: Approve Block Placement
     */
    public void testConfirmPieceNotInMyCorner_FirstRound() {    //the piece is moved to the upper-right corner, an invalid position
        dragPieceToSpecificLocation(FIRST_PIECE_TYPE,1);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }

        ButtonsView confirmButton = findButtonView();
        boolean confirmClickable = confirmButton.isClickable();

        //the confirm button should not be clickable, since this is the first round and the piece is not placed in my corner
        assertEquals(false, confirmClickable);
    }

    /**
     *  Tests Scenario #4: "During any round past the first, I attempt to confirm a piece placed on top of an existing piece.”
     *  Feature #2: Confirm Block Placement
     */
    public void testConfirmInvalidPiecePlacement_IsOnTopOfAnotherPieceViolation_NonFirstRound(){
        addFirstPieceToBoard();
        dragPieceToSpecificLocation(FIFTH_PIECE_TYPE, COLOR);

        ButtonsView confirmButton = findButtonView();
        boolean confirmClickable = confirmButton.isClickable();

        //the confirm button should not be clickable, because the piece is placed in at an invalid position on the board
        assertEquals(false, confirmClickable);
    }

    /**
     *  Tests Scenario #5: "During any round past the first, I attempt to confirm a piece whose one of its sides lines up against the side of another piece of my pieces."
     *  Feature #2: Confirm Block Placement
     */
    public void testConfirmInvalidPiecePlacement_SideLineUpWithAnotherPieceViolation_NonFirstRound(){
        addFirstPieceToBoard();
        dragPieceToSpecificLocation(THIRD_PIECE_TYPE, COLOR);

        ButtonsView confirmButton = findButtonView();
        boolean confirmClickable = confirmButton.isClickable();
        //the confirm button should not be clickable, because the piece is placed in at an invalid position on the board
        assertEquals(false, confirmClickable);
    }

    /**
     *  Tests Scenario #6: "During any round past the first, I confirm a piece placed on the board such that the piece connects by corner to another piece of my pieces, and does not share any sides with it or rest on top of another existing piece.”
     *  Feature #2: Confirm Block Placement
     */
    public void testConfirmValidPiecePlacement_NonFirstRound(){
        addFirstPieceToBoard();
        dragPieceToSpecificLocation(SECOND_PIECE_TYPE, COLOR);
        confirmPiece();
        //the size of the list of available red pieces should become 19, which means that the second piece has been placed on the board
        assertEquals(19,ui.game.game.boards.get(COLOR).pieces.size());
    }

    /**
     *  Tests Scenario #7: "During any round past the firs, I attempt to confirm a piece which does not connect by corner to another piece of my pieces."
     *  Feature #3: Confirm Block Placement
     */
    public void testConfirmInvalidPiecePlacement_DoesNotMeetWithAnyCornerViolation_NonFirstRound(){
        addFirstPieceToBoard();
        dragPieceToSpecificLocation(FOURTH_PIECE_TYPE, COLOR);

        ButtonsView confirmButton = findButtonView();
        boolean confirmClickable = confirmButton.isClickable();

        //the confirm button should not be clickable, because the piece does not meet with the any of the corners of another piece of my pieces
        assertEquals(false, confirmClickable);
    }

    /**
     *  Tests Scenario #8: “During the first round, I cancel a piece placed at the sole valid position, the top-left corner.”
     *  Feature #3: Cancel Block Placement
     */
    public void testCancelPieceInMyCorner_FirstRound(){
        dragPieceToSpecificLocation(FIRST_PIECE_TYPE, COLOR);
        solo.sleep(100);
        cancelPiece();
        //the size of the list of available red pieces should still be 21, which means that the piece has not been placed on the board
        assertEquals(21,ui.game.game.boards.get(COLOR).pieces.size());
    }

    /**
     *  Tests Scenario #9: "During the first round, I cancel a piece placed at the top-right corner (an invalid position)."
     *  Feature #3: Cancel Block Placement
     */
    public void testCancelPieceNotInMyCorner_FirstRound(){
        dragPieceToSpecificLocation(FIRST_PIECE_TYPE, 1);
        solo.sleep(100);
        cancelPiece();
        //the size of the list of available red pieces should still be 21, which means that the piece has not been placed on the board
        assertEquals(21,ui.game.game.boards.get(COLOR).pieces.size());
    }

    /**
     *  Tests Scenario #10: "During any round past the first, I cancel a piece which connects by corner to another piece of my pieces, and isn’t on or at the side of another piece of my pieces (a valid position)"
     *  Feature #3: Cancel Block Placement
     */
    public void testCancelValidPiecePlacement_NonFirstRound(){
        addFirstPieceToBoard();
        dragPieceToSpecificLocation(SECOND_PIECE_TYPE, COLOR);
        cancelPiece();

        //the size of the list of available red pieces should still be 20, which means that the second piece has not been placed on the board
        assertEquals(20,ui.game.game.boards.get(COLOR).pieces.size());
    }

    /**
     *  Tests Scenario #11: "During any round past the first, I cancel a piece which is on top of another piece."
     *  Feature #3: Cancel Block Placement
     */
    public void testCancelInvalidPiecePlacement_IsOnTopOfAnotherPieceViolation_NonFirstRound(){
        addFirstPieceToBoard();
        dragPieceToSpecificLocation(FIFTH_PIECE_TYPE, COLOR);
        cancelPiece();

        //the size of the list of available red pieces should still be 20, which means that the second piece has not been placed on the board
        assertEquals(20,ui.game.game.boards.get(COLOR).pieces.size());
    }

    /**
     *  Tests Scenario #12: "During any round past the first, I cancel a piece which has a side that lines up against the side of another piece of my pieces.”
     *  Feature #3: Cancel Block Placement
     */
    public void testCancelInvalidPiecePlacement_SideLineUpWithAnotherPieceViolation_NonFirstRound(){
        addFirstPieceToBoard();
        dragPieceToSpecificLocation(THIRD_PIECE_TYPE, COLOR);
        cancelPiece();

        //the size of the list of available red pieces should still be 20, which means that the second piece has not been placed on the board
        assertEquals(20,ui.game.game.boards.get(COLOR).pieces.size());
    }

    /**
     *  Tests Scenario #13: "During any round past the first, I cancel a piece which does not connect by corner to another piece of my pieces."
     *  Feature #3: Cancel Block Placement
     */
    public void testCancelInvalidPiecePlacement_DoesNotMeetWithAnyCornerViolation_NonFirstRound(){
        addFirstPieceToBoard();
        dragPieceToSpecificLocation(FOURTH_PIECE_TYPE, COLOR);
        cancelPiece();

        //the size of the list of available red pieces should still be 20, which means that the second piece has not been placed on the board
        assertEquals(20,ui.game.game.boards.get(COLOR).pieces.size());
    }

    /**
     * Tests Scenario #14: "During an ongoing game, I confirm the placement of one of my own pieces and my score gets increased by the number of squares in that placed piece accordingly."
     * Feature #4: Update Game Score
     */
    public void testScoreUpdate_AnyRound(){
        TextView redTab = ui.game.tabs[0]; //holds view containing red player's score

        int preUpdateScore = 0;
        if(!redTab.getText().toString().isEmpty()){ //score stored as string, initially empty string
            preUpdateScore = Integer.parseInt(redTab.getText().toString());
        }

        int[][] moveResult = dragPieceToSpecificLocation(FIRST_PIECE_TYPE, COLOR);
        System.out.println("Move locations: \t"+Arrays.deepToString(moveResult)); //ToDO validate result of moving inital piece
        confirmPiece();
        solo.sleep(2000); // 2 seconds to ensure ui updated

        int postUpdateScore = 0;
        if(!redTab.getText().toString().isEmpty()){
            postUpdateScore = Integer.parseInt(redTab.getText().toString());
        }

        //my score should get increased by 5
        assertEquals(5, postUpdateScore - preUpdateScore);
    }




    //HELPERS: -----------------------------------------------------------------------------------------

    /** Helper
     *  Drags the piece to a specific location depending on piece type
     *  Assumes Red player
     * @param type string representing code for the piece to be moved
     * @param colour int representing colour of board to operate on.
     * @return  int[0] before = array of pixel locations before piece was moved, I.e. before[0] = old X, before[1] = old Y
     *          int[1] after = array of pixel locations after piece was moved, I.e. after[1] = new X, after[1] = new Y
     */
    private int[][] dragPieceToSpecificLocation(String type, int colour){

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
            endY -= 2*ui.game.size;
        }

        if(type.equals(FOURTH_PIECE_TYPE)){
            endY += 2*ui.game.size;
        }

        if(type.equals(FIFTH_PIECE_TYPE)){
            endY -= 2*ui.game.size;
        }

        //System.out.println("Starting Location: "+startX +" " + startY);
        solo.drag(startX, endX, startY, endY, 100);

        piece.getLocationOnScreen(end);
        result[0] = start;
        result[1] = end;
        return result;
    }

    private void addFirstPieceToBoard(){
        dragPieceToSpecificLocation(FIRST_PIECE_TYPE, COLOR);
        solo.sleep(100);
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