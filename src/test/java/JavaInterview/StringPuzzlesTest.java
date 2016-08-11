package test.java.JavaInterview;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import main.java.JavaInterview.StringPuzzles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Test
    public void findDupCharsReturnsEmptyListOnNullOrEmptyString() {
        List<Character> expectedList = new ArrayList<Character>();
        List<Character> actualList = puzzles.findDupChars(null);
        assertArrayEquals(expectedList.toArray(), actualList.toArray());
        actualList = puzzles.findDupChars("");
        assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    @Test
    public void findDupCharsReturnsDuplicateCharsAsList() {
        List<Character> expectedList = new ArrayList<Character>(Arrays.asList('S'));
        List<Character> actual = puzzles.findDupChars("StreamS");
        assertArrayEquals(expectedList.toArray(), actual.toArray());
    }

    @Test
    public void findDupCharsReturnsDuplicateCharsWithListContainingMultipleDuplicates() {
        List<Character> expectedList = new ArrayList<Character>() { {
            add('S');
            add('T');
        }};
        List<Character> actual = puzzles.findDupChars("StreamTS");
        assertArrayEquals(expectedList.toArray(), actual.toArray());
    }

    @Test
    public void findDupCharsReturnsDuplicateCharsContainingSpaces() {
        List<Character> expectedList = new ArrayList<Character>() { {
            add(' ');
            add('T');
        }};
        List<Character> actual = puzzles.findDupChars("S tream T");
        assertArrayEquals(expectedList.toArray(), actual.toArray());
    }

    @Test
    public void findDupChars2ReturnsDuplicateCharsAsList() {
        List<Character> expectedList = new ArrayList<Character>(Arrays.asList('S'));
        List<Character> actual = puzzles.findDupChars2("StreamS");
        assertArrayEquals(expectedList.toArray(), actual.toArray());
    }

    @Test
    public void findDupChars2ReturnsDuplicateCharsWithListContainingMultipleDuplicates() {
        List<Character> expectedList = new ArrayList<Character>() { {
            add('S');
            add('T');
        }};
        List<Character> actual = puzzles.findDupChars2("StreamTS");
        assertArrayEquals(expectedList.toArray(), actual.toArray());
    }

    @Test
    public void stringAsStreamOfCharacters() {
        String theString = "helloworld";
        Stream<Character> charStream = theString.chars().mapToObj(x -> (char) x);
        Map<Character, Long> theMap = charStream.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        assertEquals(7, theMap.keySet().size());
        assertEquals(new Long(3), theMap.get('l'));
        assertEquals(new Long(2), theMap.get('o'));
    }

}