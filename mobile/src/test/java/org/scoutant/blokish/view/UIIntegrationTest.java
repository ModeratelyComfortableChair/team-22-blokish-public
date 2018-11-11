package org.scoutant.blokish.view;

import android.view.MenuItem;

import org.junit.Test;
import org.mockito.Mockito;
import org.scoutant.blokish.UI;
import static org.junit.Assert.assertNotNull;

public class UIIntegrationTest {

    @Test
    public void testCreateNewGame(){
        UI ui = new UI();
        MenuItem menuItem = Mockito.mock(MenuItem.class);
        Mockito.when(menuItem.getItemId()).thenReturn(ui.getMenuItemReplay());
        ui.onOptionsItemSelected(menuItem);
        assertNotNull(ui.game);
    }
}
