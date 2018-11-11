package org.scoutant.blokish.model;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveIntegrationTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Test
    public void moveTestToString(){
        Piece newPiece = new Piece(1, 4, "square", 4, 2);
        Move move = new Move(newPiece, 1, 2, 200);
        String returnedString = move.toString();
        assertEquals(returnedString, "1:square:1:2:200");
    }

}
