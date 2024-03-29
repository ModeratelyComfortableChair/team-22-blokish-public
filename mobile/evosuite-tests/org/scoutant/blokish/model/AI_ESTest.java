/*
 * This file was automatically generated by EvoSuite
 * Fri Oct 26 19:15:03 GMT 2018
 */

package org.scoutant.blokish.model;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.evosuite.runtime.EvoAssertions.verifyException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class AI_ESTest extends AI_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test_AiAdaptedLevelSet()  throws Throwable  {
      Game game0 = new Game();
      AI aI0 = new AI(game0);
      Piece piece0 = new Piece(20, "sc", 3, 3);
      Square square0 = new Square(0, (-1539));
      square0.j = 3;
      Piece piece1 = piece0.add(square0);
      aI0.overlaps(20, piece1, 3, 0);
      assertEquals(3, aI0.adaptedLevel);
  }

  @Test(timeout = 4000)
  public void test_NoOverlap_LargeCoordinate()  throws Throwable  {
      Game game0 = new Game();
      AI aI0 = new AI(game0);
      Piece piece0 = new Piece(13, "sc", 15, 13);
      Square square0 = new Square(3, 0);
      piece0.add(square0);
      boolean boolean0 = aI0.overlaps(13, piece0, 392, 1875);
      assertEquals(3, aI0.adaptedLevel);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test_NoOverlap_NegativeJCoordinate()  throws Throwable  {
      Game game0 = new Game();
      AI aI0 = new AI(game0);
      Piece piece0 = new Piece(20, "sc", 3, 3);
      Square square0 = new Square(3, 20);
      square0.j = 3;
      piece0.add(square0);
      boolean boolean0 = aI0.overlaps(0, piece0, 11, (-1551));
      assertEquals(3, aI0.adaptedLevel);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test_NoOverlap()  throws Throwable  {
      Game game0 = new Game();
      Piece piece0 = new Piece(20, "Q\",B5ed));`P", 20, 5);
      Move move0 = new Move(piece0, 20, 3, 1);
      AI aI0 = new AI(game0);
      Piece piece1 = move0.ghost.add(0, 1);
      boolean boolean0 = aI0.overlaps(20, piece1, 1, 20);
      assertFalse(boolean0);
      assertEquals(3, aI0.adaptedLevel);
  }

  @Test(timeout = 4000)
  public void test_NoOverlap_NegativeICoordinate()  throws Throwable  {
      AI aI0 = new AI((Game) null);
      Piece piece0 = new Piece(4, "Y5", 2131558403, 3);
      Piece piece1 = piece0.flip();
      Piece piece2 = piece1.rotate(2346);
      Piece piece3 = piece2.add(0, 0);
      boolean boolean0 = aI0.overlaps(2131558400, piece3, (-2311), 1);
      assertFalse(boolean0);
      assertEquals(3, aI0.adaptedLevel);
  }

  @Test(timeout = 4000)
  public void test_ChainingScoreException_NegativeJMove()  throws Throwable  {
      Game game0 = new Game();
      Piece piece0 = new Piece(20, 20, "sc", 20, 20);
      Move move0 = new Move(piece0, 20, 20);
      AI aI0 = new AI(game0);
      piece0.add((-7), 1);
      move0.j = (-2311);
      // Undeclared exception!
      try { 
        aI0.chainingScore(1, move0);
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         verifyException("org.scoutant.blokish.model.AI", e);
      }
  }

  @Test(timeout = 4000)
  public void test_ChainingScoreException_MoveWithScore()  throws Throwable  {
      Game game0 = new Game();
      Piece piece0 = new Piece(20, 20, "sc", 20, 20);
      Move move0 = new Move(piece0, 20, 20, 20);
      AI aI0 = new AI(game0);
      piece0.add((-7), 1);
      // Undeclared exception!
      try { 
        aI0.chainingScore(1, move0);
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         verifyException("org.scoutant.blokish.model.AI", e);
      }
  }

  @Test(timeout = 4000)
  public void test_ChainingScoreException_ZeroXCoordinate()  throws Throwable  {
      Game game0 = new Game();
      Piece piece0 = new Piece(20, 20, "sc", 20, 20);
      Move move0 = new Move(piece0, 20, 20, 20);
      AI aI0 = new AI(game0);
      piece0.add(0, 1);
      // Undeclared exception!
      try { 
        aI0.chainingScore(1, move0);
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         verifyException("org.scoutant.blokish.model.AI", e);
      }
  }

  @Test(timeout = 4000)
  public void test_ChainingScoreException_NegativeIMove()  throws Throwable  {
      Game game0 = new Game();
      Piece piece0 = new Piece(20, 20, "sc", 20, 20);
      Move move0 = new Move(piece0, 20, 20, 20);
      AI aI0 = new AI(game0);
      piece0.add(0, 1);
      move0.i = (-545);
      // Undeclared exception!
      try { 
        aI0.chainingScore(1, move0);
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         verifyException("org.scoutant.blokish.model.AI", e);
      }
  }

  @Test(timeout = 4000)
  public void test_ChainingScoreException_MoveNoScore()  throws Throwable  {
      Game game0 = new Game();
      Piece piece0 = new Piece(20, 20, "sc", 20, 20);
      Move move0 = new Move(piece0, 20, 0);
      AI aI0 = new AI(game0);
      piece0.add((-7), 1);
      // Undeclared exception!
      try { 
        aI0.chainingScore(1, move0);
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         verifyException("org.scoutant.blokish.model.AI", e);
      }
  }

  @Test(timeout = 4000)
  public void test_ThinkException_NegativeLevel()  throws Throwable  {
      Game game0 = new Game();
      AI aI0 = new AI(game0);
      // Undeclared exception!
      try {
        aI0.think(3, (-3046));
        fail("Expecting exception: NoClassDefFoundError");

      } catch(NoClassDefFoundError e) {
         verifyException("org.scoutant.blokish.model.AI", e);
      }
  }
}
