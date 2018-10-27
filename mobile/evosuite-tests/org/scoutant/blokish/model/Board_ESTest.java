/*
 * This file was automatically generated by EvoSuite
 * Fri Oct 26 19:13:35 GMT 2018
 */

package org.scoutant.blokish.model;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import org.scoutant.blokish.model.Board;
import org.scoutant.blokish.model.Piece;
import org.scoutant.blokish.model.Square;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Board_ESTest extends Board_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Board board0 = new Board(0);
      List<Square> list0 = board0.seeds();
      assertEquals(20, board0.size);
      assertEquals(1, list0.size());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Board board0 = new Board((-2525));
      List<Square> list0 = board0.seeds();
      assertEquals(0, list0.size());
      assertEquals(20, board0.size);
      assertEquals((-2525), board0.color);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Board board0 = new Board(0);
      String string0 = board0.toString(4);
      assertEquals("1 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0\n0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0\n0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0\n0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0\n", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Board board0 = new Board(18);
      Piece piece0 = board0.findPieceByType("I4");
      board0.add(piece0, 1, 4);
      boolean boolean0 = board0.onseed(piece0, 2, 1);
      assertEquals(4, board0.score);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Board board0 = new Board((-291));
      Piece piece0 = board0.findPieceByType("I4");
      boolean boolean0 = board0.onseed(piece0, 0, 4);
      assertEquals((-291), piece0.color);
      assertFalse(boolean0);
      assertEquals((-291), board0.color);
      assertEquals(4, piece0.count);
      assertEquals(20, board0.size);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Board board0 = new Board((-291));
      Piece piece0 = board0.findPieceByType("I4");
      boolean boolean0 = board0.fits((-1982977861), piece0, 0, 0);
      assertFalse(boolean0);
      assertEquals((-291), board0.color);
      assertEquals((-291), piece0.color);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Board board0 = new Board((-1375));
      Piece piece0 = new Piece(3, "%Z<j~Pt\"BiF`zA9", 21, 220);
      boolean boolean0 = board0.fits((-1375), piece0, 3, (-218));
      assertEquals((-1375), board0.color);
      assertEquals(20, board0.size);
      assertFalse(boolean0);
      assertFalse(board0.over);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Board board0 = new Board(0);
      Piece piece0 = new Piece(521, 20, "sc", 2465, 0);
      board0.fits(20, piece0, 2465, 521);
      assertEquals(20, board0.size);
      assertFalse(board0.over);
      assertEquals(0, board0.color);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Board board0 = new Board((-194));
      Piece piece0 = new Piece(21, "sc", 0, 0);
      boolean boolean0 = board0.fits(0, piece0, (-194), 0);
      assertEquals((-194), board0.color);
      assertFalse(boolean0);
      assertEquals(20, board0.size);
      assertFalse(board0.over);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Board board0 = new Board(0);
      boolean boolean0 = board0.fits(1, (Piece) null, 0, 2461);
      assertEquals(0, board0.color);
      assertFalse(boolean0);
      assertEquals(20, board0.size);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Board board0 = new Board((-1188));
      Piece piece0 = new Piece(1, "", 2, 1);
      boolean boolean0 = board0.fits((-2739), piece0, 2, 0);
      assertFalse(board0.over);
      assertEquals(20, board0.size);
      assertEquals((-1188), board0.color);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Board board0 = new Board(18);
      Piece piece0 = board0.findPieceByType("I4");
      board0.add(piece0, 1, 4);
      boolean boolean0 = board0.overlaps(18, piece0, 1, 1);
      assertEquals(4, board0.score);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Board board0 = new Board(0);
      Piece piece0 = new Piece(521, 20, "sc", 2465, 0);
      Piece piece1 = piece0.add(0, 0);
      board0.overlaps(0, piece1, 0, (-168356400));
      assertFalse(board0.over);
      assertEquals(20, board0.size);
      assertEquals(0, board0.color);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Board board0 = new Board(0);
      Piece piece0 = new Piece(521, 20, "sc", 2465, 0);
      Piece piece1 = piece0.add(0, 0);
      boolean boolean0 = board0.overlaps(0, piece1, 0, 1);
      assertEquals(0, board0.color);
      assertFalse(board0.over);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Board board0 = new Board(5010);
      Square square0 = new Square(20, 5010, 5010);
      boolean boolean0 = board0.outside(square0, (-1), 20);
      assertEquals(20, board0.size);
      assertTrue(boolean0);
      assertEquals(5010, board0.color);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Board board0 = new Board(71);
      Square square0 = new Square(71, 0, 20);
      board0.outside(square0, 71, 340);
      assertEquals(20, board0.size);
      assertFalse(board0.over);
      assertEquals(71, board0.color);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Board board0 = new Board((-289));
      Square square0 = new Square(5, 5);
      boolean boolean0 = board0.outside(square0, (-278), 5);
      assertTrue(boolean0);
      assertEquals(20, board0.size);
      assertFalse(board0.over);
      assertEquals((-289), board0.color);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Board board0 = new Board((-291));
      Square square0 = new Square(5, 5);
      boolean boolean0 = board0.outside(square0, 0, 4);
      assertFalse(board0.over);
      assertFalse(boolean0);
      assertEquals((-291), board0.color);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Board board0 = new Board(1);
      Piece piece0 = board0.findPieceByType("I4");
      board0.add(piece0, 1, 4);
      int int0 = board0.scoreSeedsIfAdding(piece0, 1, 7);
      assertEquals(4, board0.score);
      assertEquals(5, int0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Board board0 = new Board((-289));
      Piece piece0 = new Piece(0, 45, ".*UV=`iV$D.Vy^", 0, 10);
      board0.add(piece0, 0, (-1222));
      assertFalse(board0.over);
      assertEquals(20, board0.size);
      assertEquals((-289), board0.color);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Board board0 = new Board(1);
      Piece piece0 = board0.findPieceByType("I4");
      board0.add(piece0, (-1220), (-1220));
      assertEquals(4, board0.score);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Board board0 = new Board(18);
      Piece piece0 = board0.findPieceByType("I4");
      board0.add(piece0, 1, 18);
      assertEquals(4, board0.score);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Board board0 = new Board(173);
      Piece piece0 = board0.findPieceByType("O4");
      board0.add(piece0, 929, 1);
      assertEquals(4, board0.score);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Board board0 = new Board((-289));
      Piece piece0 = board0.findPieceByType("");
      assertFalse(board0.over);
      assertEquals((-289), board0.color);
      assertEquals(20, board0.size);
      assertNull(piece0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Board board0 = new Board((-289));
      Piece piece0 = board0.findPieceByType("I4");
      assertNotNull(piece0);
      
      boolean boolean0 = board0.onseed(piece0, (-1222), 95);
      assertFalse(board0.over);
      assertEquals((-289), piece0.color);
      assertEquals(20, board0.size);
      assertEquals((-289), board0.color);
      assertEquals(4, piece0.count);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Board board0 = new Board(3);
      assertEquals(3, board0.color);
      assertEquals(20, board0.size);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Board board0 = new Board(2);
      assertFalse(board0.over);
      assertEquals(20, board0.size);
      assertEquals(2, board0.color);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Board board0 = new Board(1);
      Piece piece0 = board0.findPieceByType("I4");
      board0.add(piece0, 1, 1);
      board0.add(piece0, 1, 4);
      assertEquals(8, board0.score);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Board board0 = new Board(0);
      Square square0 = new Square(0, (-2338), 0);
      boolean boolean0 = board0.outside(square0, 0, 0);
      assertEquals(0, board0.color);
      assertEquals(20, board0.size);
      assertFalse(board0.over);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Board board0 = new Board((-1293));
      board0.toString();
      assertEquals((-1293), board0.color);
      assertEquals(20, board0.size);
      assertFalse(board0.over);
  }
}