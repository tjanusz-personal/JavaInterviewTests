package test.java.JavaInterview;

import main.java.JavaInterview.FizzBuzz;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tjanusz929 on 6/24/16.
 */
public class FizzBuzzTest {

    private FizzBuzz fizzer;

    @Before
    public void setUp() throws Exception {
        fizzer = new FizzBuzz();
    }

    @Test
    public void printFizzBuzzForReturnsFizzForNumbersDivisibleByThree() throws Exception {
        List<Integer> numbersDivisibleByThree = Arrays.asList(3,6,9,12,18,21,24);
        numbersDivisibleByThree.forEach( theNumber -> assertEquals("Fizz", fizzer.printFizzBuzzFor(theNumber)));
    }

    @Test
    public void printFizzBuzzForReturnsBuzzForNumbersDivisibleByFive() throws Exception {
        List<Integer> numbersDivisibleByThree = Arrays.asList(5,10,20,25,35,40);
        numbersDivisibleByThree.forEach( theNumber -> assertEquals("Buzz", fizzer.printFizzBuzzFor(theNumber)));
    }

    @Test
    public void printFizzBuzzForReturnsFizzBuzzForNumbersDivisibleByFifteen() throws Exception {
        List<Integer> numbersDivisibleByThree = Arrays.asList(15,30,45,60,75);
        numbersDivisibleByThree.forEach( theNumber -> assertEquals("FizzBuzz", fizzer.printFizzBuzzFor(theNumber)));
    }

    @Test
    public void printFizzBuzzForReturnsNumberAsStringForNumbersNotDivisibleByThreeFiveOrFifteen() throws Exception {
        List<Integer> numbersDivisibleByThree = Arrays.asList(1,2,4,7,8,11,13,14,16,17,19);
        numbersDivisibleByThree.forEach( theNumber -> assertEquals(String.valueOf(theNumber), fizzer.printFizzBuzzFor(theNumber)));
    }

    @Test
    public void bubbleSortIntsWithoutAPISortsCorrectly() {
        int[] rawArray = new int[] { 9, 1, 7, 3, 2};
        int[] sortedArray = new int[] { 1, 2, 3, 7, 9};
        int[] actualArray = fizzer.bubbleSortIntsWithoutAPI(rawArray);
        assertArrayEquals(sortedArray, actualArray);
    }

    @Test
    public void reverseBubbleSortIntsWithoutAPISortsCorrectly() {
        int[] rawArray = new int[] { 9, 1, 7, 3, 2};
        int[] sortedArray = new int[] { 9, 7, 3, 2, 1};
        int[] actualArray = fizzer.reverseBubbleSortIntsWithoutAPI(rawArray);
        assertArrayEquals(sortedArray, actualArray);
    }

}