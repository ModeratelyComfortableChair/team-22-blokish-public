package org.scoutant.blokish.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import java.util.List;

public class GameIntegrationTest {

    public static final String tag = "sc";
    Game game;
    Piece L4;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception { //ONCE
    }

    @Before
    public void setUp() throws Exception { //BEFORE EVERY TEST
        game = new Game();
        L4 = new Piece(0, 3, "L4", 4, 2).add(0,-1).add(0,0).add(0,1).add(1,1);
    }

    @Test
    public void testBoard_reset(){
        List<Board> originalBoards = game.boards;
        game.reset();
        assertTrue(originalBoards.equals(game.boards));
    }

    @Test
    public void testMove_historize(){
        Move move = new Move(L4, 0, 0);
        game.historize(move);
        assertEquals(game.moves.get(0),move);
    }



}
