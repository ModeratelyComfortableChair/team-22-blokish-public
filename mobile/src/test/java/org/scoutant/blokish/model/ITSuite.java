package org.scoutant.blokish.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.scoutant.blokish.view.PieceUIIntegrationTest;
import org.scoutant.blokish.view.UIIntegrationTest;

@RunWith(Suite.class)

//Unit Test Classes Organized by Dependency Level
@Suite.SuiteClasses({
        //Level 2
        PieceIntegrationTest.class,
        //Level 3
        MoveIntegrationTest.class,
        PieceUIIntegrationTest.class,
        BoardIntegrationTest.class,
        //Level 4
        GameIntegrationTest.class,
        //Level 5
        AIIntegrationTest.class,
        //Level 6
        //GameViewIntegration.class,
        //Level 7
        UIIntegrationTest.class
})

public class ITSuite {


}
