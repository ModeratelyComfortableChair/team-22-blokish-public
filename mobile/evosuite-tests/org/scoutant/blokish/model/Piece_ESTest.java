/*
 * This file was automatically generated by EvoSuite
 * Fri Oct 26 19:12:32 GMT 2018
 */

package org.scoutant.blokish.model;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.evosuite.runtime.EvoAssertions.verifyException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true)
public class Piece_ESTest extends Piece_ESTest_scaffolding {

    @Test(timeout = 4000)
    public void test_PieceColorUndefined_DivisionByZero() throws Throwable {
        Piece piece0 = new Piece(0, "", (-1467), 0);
        piece0.squares((-2831));
        piece0.getValue((-1467), 0);
        // Undeclared exception!
        try {
            piece0.flip();
            fail("Expecting exception: ArithmeticException");
        } catch (ArithmeticException e) {
            // division by zero
            verifyException("org.scoutant.blokish.model.Piece", e);
        }
    }

    @Test(timeout = 4000)
    public void test_PieceDoesNotEqualString() throws Throwable {
        Piece piece0 = new Piece(0, 3, "tDbS5$=U]hZ7S", 0, 0);
        piece0.size = 3;
        piece0.clone();
        piece0.type = "tDbS5$=U]hZ7S";
        piece0.squares((-980));

        // Undeclared exception!
        try {
            piece0.equals("sc");
            fail("Expecting exception: ClassCastException");

        } catch (ClassCastException e) {
            // java.lang.String cannot be cast to org.scoutant.blokish.model.Piece
            verifyException("org.scoutant.blokish.model.Piece", e);
        }
    }

    @Test(timeout = 4000)
    public void test_ClonedPieceEqualsOriginalPiece() throws Throwable {
        Piece piece0 = new Piece(0, 3, "tDbS5$=U]hZ7S", 0, 0);
        Piece piece1 = piece0.clone();
        assertTrue(piece0.equals(piece1));
    }

    @Test(timeout = 100000)
    public void test_CorrectRValueAfterRotate() throws Throwable {
        int int0 = (-1);
        Piece piece0 = new Piece(4, 2788, ") ", 2788, (-1));
        // Undeclared exception!
        piece0.rotate((-1));
        assertEquals(1, piece0.getR());
    }

    @Test(timeout = 100000)
    public void test_CorrectFValueAfterFlip() throws Throwable {
        Piece piece0 = new Piece(2755, "", 2755, 1740);
//      Piece piece0 = new Piece(10, "", 2755, 1740);
        Piece piece1 = piece0.add(1, (-1));
        // Undeclared exception!
        piece1.flip();
        assertEquals(1, piece1.getF());

    }

    @Test(timeout = 4000)
    public void test_PieceToString() throws Throwable {
        Piece piece0 = new Piece(10, 10, "", 1, 0);
        List<Square> list0 = piece0.seeds();
        String string0 = piece0.toString();
        assertEquals("\n0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0\n0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0\n0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0\n0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0\n0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0\n0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0\n0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0\n0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0\n0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0\n0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0\n", string0);
    }

    @Test(timeout = 4000)
    public void test_PieceSeedsAndSquaresListsAreEqual() throws Throwable {
        Piece piece0 = new Piece(10, 10, "", 1, 0);
        List<Square> list0 = piece0.seeds();

        piece0.size = 1;
        piece0.toLabel();
        List<Square> list1 = piece0.squares();
        assertTrue(list1.equals((Object) list0));
    }

    @Test(timeout = 4000)
    public void test_AddNullSquare() throws Throwable {
        Piece piece0 = new Piece(0, "", 0, 0);
        piece0.squares(0);
        piece0.rotations = 1270;
        piece0.crosses(0, 0);
        // Undeclared exception!
        try {
            piece0.add((Square) null);
            fail("Expecting exception: NullPointerException");
        } catch (NullPointerException e) {
            verifyException("org.scoutant.blokish.model.Piece", e);
        }
    }

    @Test(timeout = 4000)
    public void test_OverlapingPieces() throws Throwable {
        Piece piece0 = new Piece(0, 0, "16*|Dgb?%", 0, 0);
        Piece piece1 = new Piece(0, "16*|Dgb?%", 0, 0);
        assertFalse(piece0.overlaps(piece1, 0, 0));
    }

    @Test(timeout = 4000)
    public void test_FlipPieceHavingZeroFilps_DivisionByZero() throws Throwable {
        Piece piece0 = new Piece(2, "", 0, 0);
        Piece piece1 = piece0.clone();
        piece1.toString();
        piece0.reset(piece1);
        piece0.reset(piece1);
        piece0.flips = 0;
        piece0.toString();
        piece0.squares();
        piece0.reset();
        piece0.rotations = 0;
        // Undeclared exception!
        try {
            piece0.flip();
            fail("Expecting exception: ArithmeticException");
        } catch (ArithmeticException e) {
            // division by zero
            verifyException("org.scoutant.blokish.model.Piece", e);
        }
    }

    @Test(timeout = 4000)
    public void test_PieceTouchesSpecificCoordinate() throws Throwable {
        Piece piece0 = new Piece(0, "ocu}I&^v&", 0, 0);
        piece0.isValue(0, 0);
        boolean boolean0 = piece0.touches(0, 10);
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test_PieceSerialize() throws Throwable {
        Piece piece0 = new Piece(0, "ocu}I&^v&", 0, 0);
        String string0 = Piece.serialize(piece0);
        assertEquals("0:ocu}I&^v&", string0);
    }

    @Test(timeout = 4000)
    public void test_PiecePropertiesCorrectUponPieceInstantiation() throws Throwable {
        Piece piece0 = new Piece(3, "", 1359, 0);
        assertEquals(1359, piece0.rotations);
        assertEquals(0, piece0.flips);
        assertEquals(0, piece0.color);
        assertEquals(0, piece0.count);
        assertEquals(3, piece0.size);
        assertEquals("", piece0.toLabel());
    }

    @Test(timeout = 4000)
    public void test_NegativePieceSize() throws Throwable {
        Piece piece0 = null;
        try {
            piece0 = new Piece((-4093), "org.scoutant.blokish.model.Piece", 10, 10);
            fail("Expecting exception: NegativeArraySizeException");

        } catch (NegativeArraySizeException e) {
            verifyException("org.scoutant.blokish.model.Piece", e);
        }
    }

    @Test(timeout = 4000)
    public void test_RotatePieceHavingZeroRotationsAndSize_DivisionByZero() throws Throwable {
        Piece piece0 = new Piece(0, 0, ",", 0, 0);
        // Undeclared exception!
        try {
            piece0.rotate(0);
            fail("Expecting exception: ArithmeticException");

        } catch (ArithmeticException e) {
            // division by zero
            verifyException("org.scoutant.blokish.model.Piece", e);
        }
    }

    @Test(timeout = 4000)
    public void test_RotateClonedPieceHavingZeroRotationsAndSize_DivisionByZero() throws Throwable {
        Piece piece0 = new Piece(0, 0, "", 0, 0);
        Piece piece1 = piece0.clone();
        // Undeclared exception!
        try {
            piece1.rotate(0);
            fail("Expecting exception: ArithmeticException");

        } catch (ArithmeticException e) {
            // division by zero
            verifyException("org.scoutant.blokish.model.Piece", e);
        }
    }

    @Test(timeout = 4000)
    public void test_RotateClonedPieceHavingZeroRotations_DivisionByZero() throws Throwable {
        Piece piece0 = new Piece(1, 2, "", 0, 1);
        Piece piece1 = piece0.clone();
        piece0.color = (-287);
        // Undeclared exception!
        try {
            piece1.rotate(2);
            fail("Expecting exception: ArithmeticException");

        } catch (ArithmeticException e) {
            // division by zero
            verifyException("org.scoutant.blokish.model.Piece", e);
        }
    }

    @Test(timeout = 4000)
    public void test_AddSquareAtCoordinateGreaterThanPieceSize() throws Throwable {
        Piece piece0 = new Piece(3, 0, "@Z>y`O;8P\")9", 1, 1406);
        Piece.serialize(piece0);
        Square square0 = new Square(1, 0);
        // Undeclared exception!
        try {
            piece0.add(square0);
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            verifyException("org.scoutant.blokish.model.Piece", e);
        }
    }

    @Test(timeout = 4000)
    public void test_SquareXCoordinateDoesNotFitInPiece() throws Throwable {
        int int0 = 0;
        Piece piece0 = new Piece(0, 0, ";e559RNc\"dE +", 0, 0);
        // Undeclared exception!
        try {
            piece0.add(2, 0);
            fail("Expecting exception: IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            verifyException("org.scoutant.blokish.model.Piece", e);
        }
    }

    @Test(timeout = 4000)
    public void test_SquareYCoordinateDoesNotFitInPiece() throws Throwable {
        Piece piece0 = new Piece(1, 1, "[SySE7f5", 0, 1);
        // Undeclared exception!
        try {
            piece0.add(0, 1);
            fail("Expecting exception: IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            verifyException("org.scoutant.blokish.model.Piece", e);
        }
    }

    @Test(timeout = 4000)
    public void test_SquareXCoordinateNegativeRelativeToPiece() throws Throwable {
        Piece piece0 = new Piece(1, 1, "2n", 1, 1);
        piece0.rotations = 1145;
        piece0.flip();
        Piece piece1 = piece0.rotate(0);
        piece1.flips = 1067;
        piece0.toString();
        piece1.seeds();
        piece0.overlaps(piece1, 1145, 1);
        Piece piece2 = piece0.flip();
        Piece.serialize(piece2);
        piece2.squares();
        Piece piece3 = piece0.rotate(1);
        piece0.squares(0);
        piece2.reset();
        piece1.flips = 0;
        piece3.reset();
        piece1.seeds();
        Square square0 = new Square(1, 0);
        square0.j = 834;
        // Undeclared exception!
        try {
            piece3.add((-3719), 0);
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            verifyException("org.scoutant.blokish.model.Piece", e);
        }
    }

    @Test(timeout = 4000)
    public void test_SquareYCoordinateNegativeRelativeToPiece() throws Throwable {
        Piece piece0 = new Piece(343, 4, " [exmRD!z", 343, 0);
        piece0.seeds();
        piece0.touches(343, 1918);
        piece0.clone();
        Piece piece1 = piece0.rotate(4);
        piece1.toString();
        piece0.overlaps(piece1, 0, 0);
        piece0.seeds();
        piece0.squares(1918);
        Square square0 = new Square(0, (-1361));
        // Undeclared exception!
        try {
            piece1.add(square0);
            fail("Expecting exception: IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            verifyException("org.scoutant.blokish.model.Piece", e);
        }
    }

    @Test(timeout = 4000)
    public void test_SquareXCoordinateNegativeRelativeToPieceHavingSizeZero() throws Throwable {
        Piece piece0 = new Piece(0, 0, "", (-3518), (-1));
        piece0.type = ") ";
        Piece piece1 = piece0.rotate(0);
        piece0.clone();
        Square square0 = new Square((-1), 0);
        // Undeclared exception!
        try {
            piece1.add(square0);
            fail("Expecting exception: IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            verifyException("org.scoutant.blokish.model.Piece", e);
        }
    }

}
