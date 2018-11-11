package org.scoutant.blokish.view;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.view.MenuItem;
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
        UI ui = spy(UI.class);

        PowerMockito.whenNew(GameView.class).withArguments(any(Context.class)).thenReturn(gameView);
        PowerMockito.mockStatic(ContextCompat.class);
        PowerMockito.mockStatic(AppCompatDelegate.class);
        PowerMockito.when(AppCompatDelegate.create(any(Activity.class), any(AppCompatCallback.class))).thenReturn(appCompatDelegate);
        PowerMockito.when(ContextCompat.getColor(any(Context.class), anyInt())).thenReturn(2);

        doNothing().when(frameLayout).addView(gameView);
        when(ui.findViewById(R.id.container)).thenReturn(frameLayout);
        when(ui.findViewById(R.id.drawer_layout)).thenReturn(drawerLayout);
        doNothing().when(navigationView).setNavigationItemSelectedListener(ui);
        when(ui.findViewById(R.id.nav_view)).thenReturn(navigationView);

        ui.newgame();
        assertNotNull(ui.game);
    }
}
