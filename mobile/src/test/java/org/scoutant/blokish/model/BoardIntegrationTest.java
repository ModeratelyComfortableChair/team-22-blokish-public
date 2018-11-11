package org.scoutant.blokish.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardIntegrationTest {

    Board board;
    final int COLOUR = 0;

    @Before
    public void testSetup(){
        board = new Board(COLOUR);
    }

    @Test
    public void testPieceSetup(){
        Piece pieceX5 = new Piece(COLOUR, 3, "X5", 1, 1).add(0,0).add(-1,0).add(0,-1).add(1,0).add(0,1);
        Piece pX5 = board.findPieceByType("X5");
        assertEquals(pieceX5, pX5);

    }
}
