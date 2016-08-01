package test.java.JavaInterview;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import main.java.JavaInterview.StringPuzzles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class StringPuzzlesTest {

    private StringPuzzles puzzles;

    @Before
    public void Setup() {
        puzzles = new StringPuzzles();
    }

    @Test
    @Parameters({
            "TEST, test",
            "TESToneTest, testTestOne",
            "TEST This, This test",
            "TEST, estt",
            "TEST, ttes",
            "TEST ,  test"
    })
    public void isAnagramReturnsTrueForSimpleString(String firstString, String secondString) {
        assertTrue(puzzles.isAnagram(firstString, secondString));
    }

    @Test
    @Parameters({
            "TEST, tes",
            "TES T, test",
            "TEST, t e s t",
            "TEST, "
    })
    public void isAnagramReturnsFalseForSimpleString(String firstString, String secondString) {
        assertFalse(puzzles.isAnagram(firstString, secondString));
    }

    @Test
    @Parameters({
            "TEST, test",
            "TESToneTest, testTestOne",
            "TEST This, This test",
            "TEST, estt",
            "TEST, ttes",
            "TEST ,  test"
    })
    public void isAnagram2ReturnsTrueForSimpleString(String firstString, String secondString) {
        assertTrue(puzzles.isAnagram2(firstString, secondString));
    }

    @Test
    @Parameters({
            "TEST, tes",
            "TES T, test",
            "TEST, t e s t",
            "TEST, "
    })
    public void isAnagram2ReturnsFalseForSimpleString(String firstString, String secondString) {
        assertFalse(puzzles.isAnagram2(firstString, secondString));
    }

    @Test
    public void isAnagram2ReturnsFalseForNullValues() {
        assertFalse(puzzles.isAnagram2("TEST", null));
        assertFalse(puzzles.isAnagram2(null, "test"));
        assertFalse(puzzles.isAnagram2(null, null));
    }

}