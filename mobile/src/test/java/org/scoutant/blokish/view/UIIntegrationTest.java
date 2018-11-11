package org.scoutant.blokish.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.Display;
import android.view.MenuItem;
import android.view.WindowManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.scoutant.blokish.UI;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ContextCompat.class)
public class UIIntegrationTest {

//    @Mock
//    private ContextCompat contextCompat;

//    @Mock
//    private Context context;

    @Mock
    private Context context;

    @Mock
    private Context mockApplicationContext;

    @Mock
    private Display display;

    @Mock
    private WindowManager windowManager;

    @Test
    public void testCreateNewGame(){
//        contextCompat = mock(ContextCompat.class);
//        context = mock(Context.class);

        when(context.getApplicationContext()).thenReturn(mockApplicationContext);
        when(context.getSystemService(Context.WINDOW_SERVICE)).thenReturn(windowManager);
        when(windowManager.getDefaultDisplay()).thenReturn(display);

        PowerMockito.mockStatic(ContextCompat.class);
//        PowerMockito.when(ContextCompat.getDrawable(any(Context.class), anyInt())).thenReturn(drawable);
        PowerMockito.when(ContextCompat.getColor(any(Context.class), anyInt())).thenReturn(2);

        UI ui = new UI();
        MenuItem menuItem = Mockito.mock(MenuItem.class);
        Mockito.when(menuItem.getItemId()).thenReturn(ui.getMenuItemReplay());
        ui.onOptionsItemSelected(menuItem);
        assertNotNull(ui.game);
    }
}
