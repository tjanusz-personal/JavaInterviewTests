package test.java.JavaInterview;

import main.java.JavaInterview.MixedNumberInterviewQuestions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MixedNumberInterviewQuestionsTest {
    private MixedNumberInterviewQuestions series;

    @Before
    public void Setup()
    {
        series = new MixedNumberInterviewQuestions();
    }

    @Test
    public void getFibonacciSeriesUpToReturnsCorrectSeriesUpTo20() {
        List<Integer> expectedList = Arrays.asList(1,1,2,3,5,8,13);
        List<Integer> actualList = series.getFibonacciSeriesUpTo(20);
        assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    @Test
    public void getFibonacciSeriesUpToReturnsEmptyListWhenInvokedWith0() {
        List<Integer> expectedList = new ArrayList<Integer>();
        List<Integer> actualList = series.getFibonacciSeriesUpTo(0);
        assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    @Test
    public void getFibonacciSeriesUpToReturnsListWithOnlyOnesWhenInvokedWith1() {
        List<Integer> expectedList = Arrays.asList(1,1);
        List<Integer> actualList = series.getFibonacciSeriesUpTo(1);
        assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    @Test
    public void isArmstrongNumberReturnsTrueFor371() {
        assertTrue(series.isArmstrongNumber(371));
    }

    @Test
    public void isArmstrongNumberReturnsFalseForInvalidNumbers() {
        List<Integer> ints = Arrays.asList(2,11,21);
        ints.forEach( invalidValue -> assertFalse(series.isArmstrongNumber(invalidValue)));
    }

    @Test
    public void isArmstrongNumberReturnsTrueForValidNumbersUpTo999() {
        List<Integer> ints = Arrays.asList(0,1,153,370,371,407);
        ints.forEach( invalidValue -> assertTrue(series.isArmstrongNumber(invalidValue)));
    }

    @Test
    public void getArmstrongNumbersUpTo999() {
        List<Integer> expectedValues = Arrays.asList(0,1,153,370,371,407);
        List<Integer> actualValues = series.getArmstrongNumbersUpTo(999);
        assertArrayEquals(expectedValues.toArray(), actualValues.toArray());
    }

    @Test
    public void isNumberPalindromeReturnsTrueScenarios() {
        List<Integer> validPlaindromeNumbers = Arrays.asList(111, 121, 131, 232, 222, 4554);
        validPlaindromeNumbers.forEach(validPalindrome -> assertTrue(series.isNumberPalindrome(validPalindrome)));
    }

    @Test
    public void isNumberPalindromeReturnsFalseScenarios() {
        List<Integer> validPlaindromeNumbers = Arrays.asList(110, 122, 331, 221, 322, 4564);
        validPlaindromeNumbers.forEach(validPalindrome -> assertFalse(series.isNumberPalindrome(validPalindrome)));
    }

    @Test
    public void calculateFactorialReturnsCorrectResults() {
        assertEquals(6, series.calculateFactorial(3));
    }

    @Test
    public void calculateFactorialReturnsCorrectResultsForFive() {
        assertEquals(120, series.calculateFactorial(5));
    }

    @Test
    public void calculateFactorialRecReturnsCorrectResults() {
        assertEquals(6, series.calculateFactorialRec(3));
    }

    @Test
    public void calculateFactorialRecReturnsCorrectResultsForFive() {
        assertEquals(120, series.calculateFactorialRec(5));
    }

}