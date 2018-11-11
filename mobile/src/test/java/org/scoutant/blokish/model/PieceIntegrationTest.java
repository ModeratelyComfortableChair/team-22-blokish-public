package org.scoutant.blokish.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PieceIntegrationTest {

    @Test
    public void testClonePiece(){
        Piece piece = new Piece(3, "I3", 2, 1);
        Piece clonedPiece = piece.clone();
        assertEquals(3,piece.size);
        assertEquals(2,piece.rotations);
        assertEquals(1,piece.flips);
        assertEquals("I3",piece.type);

    }
}
