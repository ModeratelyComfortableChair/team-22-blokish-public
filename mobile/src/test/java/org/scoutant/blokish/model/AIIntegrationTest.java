package org.scoutant.blokish.model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class AIIntegrationTest {

    private AI ai;

    private Game game;

    @Before
    public void setUp(){
        game = new Game();
    }

    @Test
    public void testGame_HasMove() {
        ai = new AI(game);
        ai.hasMove(0);
        assertFalse(game.boards.get(0).over);
    }

}
