package org.scoutant.blokish.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.Display;
import android.view.WindowManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.scoutant.blokish.PieceUI;
import org.scoutant.blokish.UI;
import org.scoutant.blokish.model.GameView;
import org.scoutant.blokish.model.Piece;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ContextCompat.class, GameView.class, UI.class})
public class PieceUIIntegrationTest {

    @Mock
    private Context context;

    @Mock
    private Context mockApplicationContext;

    @Mock
    private Display display;

    @Mock
    private WindowManager windowManager;

    @Mock
    private Drawable drawable;

    @Mock
    private ContextCompat contextCompat;

    @Mock
    private GameView gameView;

    @Test
    public void pieceUITestToString() throws Exception {
        when(context.getApplicationContext()).thenReturn(mockApplicationContext);
        when(context.getSystemService(Context.WINDOW_SERVICE)).thenReturn(windowManager);
        when(windowManager.getDefaultDisplay()).thenReturn(display);
        PowerMockito.mockStatic(GameView.class);

        Piece newPiece = new Piece(1, 4, "square", 4, 2);
        PowerMockito.mockStatic(ContextCompat.class);
        PowerMockito.when(ContextCompat.getDrawable(any(Context.class), anyInt())).thenReturn(drawable);
        PieceUI newPieceUI = new PieceUI(context, newPiece, 1, 1);

        String returnedString = newPieceUI.toString();
        assertEquals(returnedString, "<PieceUI> : (1, 1) ; " + newPiece);

    }

}
