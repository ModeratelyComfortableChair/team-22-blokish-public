/*
 * This file was automatically generated by EvoSuite
 * Fri Oct 26 18:30:34 GMT 2018
 */

package org.scoutant.blokish.model;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import org.scoutant.blokish.model.AI;
import org.scoutant.blokish.model.Board;
import org.scoutant.blokish.model.Game;
import org.scoutant.blokish.model.Move;
import org.scoutant.blokish.model.Piece;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class AI_ESTest extends AI_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Game game0 = new Game();
      AI aI0 = new AI(game0);
      Board board0 = new Board(1);
      Piece piece0 = board0.findPieceByType("I3");
      aI0.overlaps(2131558402, piece0, 5, (-1037));
      assertEquals(3, aI0.adaptedLevel);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Game game0 = new Game();
      AI aI0 = new AI(game0);
      Board board0 = new Board(20);
      Piece piece0 = board0.findPieceByType("I3");
      boolean boolean0 = aI0.overlaps(20, piece0, 1786, 20);
      assertFalse(boolean0);
      assertEquals(3, aI0.adaptedLevel);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Game game0 = new Game();
      AI aI0 = new AI(game0);
      Board board0 = new Board(20);
      Piece piece0 = board0.findPieceByType("I3");
      boolean boolean0 = aI0.overlaps(20, piece0, (-772), (-772));
      assertFalse(boolean0);
      assertEquals(3, aI0.adaptedLevel);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Game game0 = new Game();
      AI aI0 = new AI(game0);
      Board board0 = new Board(1);
      Piece piece0 = board0.findPieceByType("I3");
      boolean boolean0 = aI0.overlaps(20, piece0, 2, 20);
      assertFalse(boolean0);
      assertEquals(3, aI0.adaptedLevel);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Game game0 = new Game();
      AI aI0 = new AI(game0);
      Board board0 = new Board(20);
      Piece piece0 = board0.findPieceByType("I3");
      Move move0 = new Move(piece0, 3, 20);
      // Undeclared exception!
      try { 
        aI0.chainingScore(3, move0);
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // android/util/Log
         //
         verifyException("org.scoutant.blokish.model.AI", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Game game0 = new Game();
      AI aI0 = new AI(game0);
      Board board0 = new Board(20);
      Piece piece0 = board0.findPieceByType("I3");
      Move move0 = new Move(piece0, 1, 0, 21);
      // Undeclared exception!
      try { 
        aI0.chainingScore(3, move0);
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // android/util/Log
         //
         verifyException("org.scoutant.blokish.model.AI", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Game game0 = new Game();
      AI aI0 = new AI(game0);
      Board board0 = new Board(20);
      Piece piece0 = board0.findPieceByType("I3");
      Move move0 = new Move(piece0, 1, 0, 21);
      move0.i = (-1);
      // Undeclared exception!
      try { 
        aI0.chainingScore(3, move0);
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // android/util/Log
         //
         verifyException("org.scoutant.blokish.model.AI", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Game game0 = new Game();
      AI aI0 = new AI(game0);
      Board board0 = new Board(20);
      Piece piece0 = board0.findPieceByType("I3");
      Move move0 = new Move(piece0, 809, 124);
      // Undeclared exception!
      try { 
        aI0.chainingScore(2, move0);
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // android/util/Log
         //
         verifyException("org.scoutant.blokish.model.AI", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Game game0 = new Game();
      AI aI0 = new AI(game0);
      // Undeclared exception!
      try { 
        aI0.think(3, 3);
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // android/util/Log
         //
         verifyException("org.scoutant.blokish.model.AI", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Game game0 = new Game();
      LinkedList<Board> linkedList0 = new LinkedList<Board>();
      game0.boards = (List<Board>) linkedList0;
      AI aI0 = new AI(game0);
      Board board0 = new Board(220);
      linkedList0.add(board0);
      aI0.hasMove(0);
      assertEquals(3, aI0.adaptedLevel);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Game game0 = new Game();
      AI aI0 = new AI(game0);
      // Undeclared exception!
      try { 
        aI0.hasMove(0);
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // android/util/Log
         //
         verifyException("org.scoutant.blokish.model.AI", e);
      }
  }
}
