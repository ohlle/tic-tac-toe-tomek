package com.codejam;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TTTTCheckerTest {

    @Test
    public void testXWonRow() {
        List<String> input = Arrays.asList(
                "XXXT",
                "....",
                "OO..",
                "....");
        String expected = "X won";

        String output = new TTTTChecker().check(input);
        assertEquals(expected, output);
    }

    @Test
    public void testOWonColumn() {
        List<String> input = Arrays.asList(
                "OOXX",
                "OXXX",
                "OX.T",
                "O..O");
        String expected = "O won";

        String output = new TTTTChecker().check(input);
        assertEquals(expected, output);
    }

    @Test
    public void testOWonDiagonally() {
        List<String> input = Arrays.asList(
                "XXXO",
                "..O.",
                ".O..",
                "T...");
        String expected = "O won";

        String output = new TTTTChecker().check(input);
        assertEquals(expected, output);
    }

    @Test
    public void testDraw() {
        List<String> input = Arrays.asList(
                "XOXT",
                "XXOO",
                "OXOX",
                "XXOO");
        String expected = "Draw";

        String output = new TTTTChecker().check(input);
        assertEquals(expected, output);
    }

    @Test
    public void testNotCompleted() {
        List<String> input = Arrays.asList(
                "XOX.",
                "OX..",
                "....",
                "....");
        String expected = "Game has not completed";

        String output = new TTTTChecker().check(input);
        assertEquals(expected, output);
    }

    @Test
    public void testWrongNumberOfLines() {
        List<String> input = Arrays.asList(
                "XOX.",
                "OX..",
                "....");
        try {
            new TTTTChecker().check(input);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException iae) {
            //Ignore
        }
    }

    @Test
    public void testWrongNumberOfCharacters() {
        List<String> input = Arrays.asList(
                "XOX",
                "OX..",
                "....",
                "....");
        try {
            new TTTTChecker().check(input);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException iae) {
            //Ignore
        }
    }

    @Test
    public void testIllegalCharacter() {
        List<String> input = Arrays.asList(
                "XOXY",
                "OX..",
                "....",
                "....");
        try {
            new TTTTChecker().check(input);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException iae) {
            //Ignore
        }
    }
}
