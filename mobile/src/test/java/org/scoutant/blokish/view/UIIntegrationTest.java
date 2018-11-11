package org.scoutant.blokish.view;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.view.Display;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.scoutant.blokish.R;
import org.scoutant.blokish.UI;
import org.scoutant.blokish.model.GameView;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ContextCompat.class, UI.class, AppCompatActivity.class, AppCompatDelegate.class})
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

    @Mock
    private GameView gameView;

    @Mock
    private AppCompatDelegate appCompatDelegate;

    @Mock
    private FrameLayout frameLayout;

    @Mock
    private DrawerLayout drawerLayout;

    @Mock
    private NavigationView navigationView;

    @Mock
    private MenuItem menuItem;

    @Test
    public void testCreateNewGame() throws Exception {
//        contextCompat = mock(ContextCompat.class);
//        context = mock(Context.class);

//        UI ui = new UI();
        UI ui = spy(UI.class);





//        when(context.getApplicationContext()).thenReturn(mockApplicationContext);
//        when(context.getSystemService(Context.WINDOW_SERVICE)).thenReturn(windowManager);

//        when(ui.getApplicationContext()).thenReturn(mockApplicationContext);
//        when(ui.getSystemService(Context.WINDOW_SERVICE)).thenReturn(windowManager);
//        when(windowManager.getDefaultDisplay()).thenReturn(display);


//        when(any(GameView.class).getSize()).thenReturn(4);

        PowerMockito.whenNew(GameView.class).withArguments(any(Context.class)).thenReturn(gameView);
        PowerMockito.mockStatic(ContextCompat.class);
        PowerMockito.mockStatic(AppCompatDelegate.class);
        PowerMockito.when(AppCompatDelegate.create(any(Activity.class), any(AppCompatCallback.class))).thenReturn(appCompatDelegate);
//        PowerMockito.when(ContextCompat.getDrawable(any(Context.class), anyInt())).thenReturn(drawable);
        PowerMockito.when(ContextCompat.getColor(any(Context.class), anyInt())).thenReturn(2);


        doNothing().when(frameLayout).addView(gameView);
        when(ui.findViewById(R.id.container)).thenReturn(frameLayout);
        when(ui.findViewById(R.id.drawer_layout)).thenReturn(drawerLayout);
        doNothing().when(navigationView).setNavigationItemSelectedListener(ui);
        when(ui.findViewById(R.id.nav_view)).thenReturn(navigationView);


//        MenuItem menuItem = Mockito.mock(MenuItem.class);
//        when(menuItem.getItemId()).thenReturn(ui.getMenuItemReplay());
//        ui.onOptionsItemSelected(menuItem);


//        Method newGameMethod = ui.getClass().getDeclaredMethod("newgame");
//        newGameMethod.setAccessible(true);
//        newGameMethod.invoke(ui);
        ui.newgame();
        assertNotNull(ui.game);
    }
}
