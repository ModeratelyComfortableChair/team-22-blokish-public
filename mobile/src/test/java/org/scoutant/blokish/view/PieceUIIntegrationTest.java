package org.scoutant.blokish.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.Display;
import android.view.WindowManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.scoutant.blokish.PieceUI;
import org.scoutant.blokish.model.Piece;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ContextCompat.class)
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

    @Before
    public void setUp(){
        context = mock(Context.class);
        drawable = mock(Drawable.class);
        contextCompat = mock(ContextCompat.class);
        mockApplicationContext = mock(Context.class);
        display = mock(Display.class);
        windowManager = mock(WindowManager.class);
    }




    @Test
    public void pieceUITestToString(){
        when(context.getApplicationContext()).thenReturn(mockApplicationContext);
        when(context.getSystemService(Context.WINDOW_SERVICE)).thenReturn(windowManager);
        when(windowManager.getDefaultDisplay()).thenReturn(display);
        Piece newPiece = new Piece(1, 4, "square", 4, 2);
        PowerMockito.mockStatic(ContextCompat.class);
//        BDDMockito.given(ContextCompat.getDrawable(any(Context.class), anyInt())).willReturn(drawable);
        PowerMockito.when(ContextCompat.getDrawable(any(Context.class), anyInt())).thenReturn(drawable);
        PieceUI newPieceUI = new PieceUI(context, newPiece, 1, 1);

        String returnedString = newPieceUI.toString();
        assertEquals(returnedString, "<PieceUI> : (1,1) ; " + newPiece);

    }

}
