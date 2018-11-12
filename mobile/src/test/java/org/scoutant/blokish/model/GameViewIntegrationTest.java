package org.scoutant.blokish.model;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.WindowManager;

import android.widget.ImageButton;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.scoutant.blokish.ButtonsView;
import org.scoutant.blokish.UI;

import static junit.framework.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ContextCompat.class, ButtonsView.class, GameView.class})
public class GameViewIntegrationTest {

    @Mock
    private UI context;

    @Mock
    private Context mockApplicationContext;

    @Mock
    private Display display;

    @Mock
    private DisplayMetrics metrics;

    @Mock
    private WindowManager windowManager;

    @Mock
    private LayoutInflater inflater;

    @Mock
    private UI mockUI;

    private GameView gameview;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPieceUIOnTouchEvent() throws Exception {
        Display display = mock(Display.class);
        doAnswer( new Answer() {
            public Point answer(InvocationOnMock invocation){
                Point arg0 = invocation.getArgument(0);
                arg0.x = 200;
                arg0.y = 400;
                return arg0;
            }
        }).when(display).getSize(any(Point.class));

        when(context.getApplicationContext()).thenReturn(mockApplicationContext);
        when(context.getSystemService(Context.WINDOW_SERVICE)).thenReturn(windowManager);
        when(context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).thenReturn(inflater);
        when(windowManager.getDefaultDisplay()).thenReturn(display);

        PowerMockito.mockStatic(ContextCompat.class);
        PowerMockito.when(ContextCompat.getDrawable(any(Context.class), anyInt())).thenReturn(new ColorDrawable());

        ButtonsView mockButtonsView = mock(ButtonsView.class);
        ImageButton mockImageButton = mock(ImageButton.class);
        when(mockButtonsView.getOk()).thenReturn(mockImageButton);
        whenNew(ButtonsView.class).withAnyArguments().thenReturn(mockButtonsView);

        gameview = new GameView(context);

        assertFalse(gameview.onTouchEvent(null));
    }

    @Test
    public void testGamePlay() throws Exception {

    }
}
