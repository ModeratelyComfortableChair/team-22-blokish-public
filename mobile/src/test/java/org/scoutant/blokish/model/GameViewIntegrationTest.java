package org.scoutant.blokish.model;

import android.view.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.scoutant.blokish.UI;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(RobolectricTestRunner.class)
public class GameViewIntegrationTest {

    private GameView gameview;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPieceUIOnTouchEvent() throws Exception {
        UI context = Robolectric.setupActivity(UI.class);

        MotionEvent me = mock(MotionEvent.class);

        gameview = new GameView(context);

        assertTrue(gameview.onTouchEvent(me));
    }

}
