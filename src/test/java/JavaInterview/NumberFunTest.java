package test.java.JavaInterview;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import main.java.JavaInterview.NumberFun;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class NumberFunTest {

    private NumberFun numberFun;

    @Before
    public void Setup() {
        numberFun = new NumberFun();
    }

    @Test
    public void findDuplicateFindsDuplicateIntegerInList() throws Exception {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,6);
        assertEquals(new Integer(6), numberFun.findDuplicate(integerList));
    }

    @Test
    public void findDuplicateReturnsNullIfNoDupFound() throws Exception {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        assertNull(numberFun.findDuplicate(integerList));
    }

    @Test
    public void findDuplicate2FindsDuplicateIntegerInList() throws Exception {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,6);
        assertEquals(new Integer(6), numberFun.findDuplicate2(integerList));
    }

    @Test
    public void findDuplicate2FindsDuplicateIntegerInList2() throws Exception {
        List<Integer> integerList = Arrays.asList(1,1,2,3,4,5,6,7,8,9,10,6);
        assertEquals(new Integer(1), numberFun.findDuplicate2(integerList));
    }

    @Test
    public void findDuplicate2ReturnsNullIfNoDupFound() throws Exception {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        assertNull(numberFun.findDuplicate2(integerList));
    }

    @Test
    @Parameters({
            "112, 211",
            "300, 003",
            "52345, 54325",
            "699, 996"
    })
    public void reverseNumberReturnsNumberReversed(String theNum, String expected) {
        assertEquals(new Integer(expected), numberFun.reverseNumber(new Integer(theNum)));
    }


    @Test
    @Parameters({
            "6",
            "28"
    })
    public void isPerfectNumberReturnsTrue(int theNumber) {
        // number that is half the sum of all its positive divisors
        assertTrue(numberFun.isPerfectNumber(theNumber));
    }

    @Test
    @Parameters({
            "5",
            "7"
    })
    public void isPerfectNumberReturnsFalse(int theNumber) {
        // number that is half the sum of all its positive divisors
        assertFalse(numberFun.isPerfectNumber(theNumber));
    }

    @Test
    public void findTopTwoNumbersInListReturnsTopTwoNumbersForListWithMoreThanOneValue() {
        List<Integer> integerList = Arrays.asList(1,3,2,10);
        List<Integer> actualTopTwoList =  numberFun.findTopTwoNumbersInList(integerList);
        assertEquals(new Integer(10), actualTopTwoList.get(0));
        assertEquals(new Integer(3), actualTopTwoList.get(1));
    }

    @Test
    public void findTopTwoNumbersInListReturnsTopNumberAndZeroForListWithOnlyOneValue() {
        List<Integer> integerList = Arrays.asList(10);
        List<Integer> actualTopTwoList =  numberFun.findTopTwoNumbersInList(integerList);
        assertEquals(new Integer(10), actualTopTwoList.get(0));
        assertEquals(new Integer(0), actualTopTwoList.get(1));
    }

    @Test
    public void findTopTwoNumbersInListReturnsEmptyListWhenPassedEmptyList() {
        List<Integer> integerList = new ArrayList<Integer>();
        List<Integer> actualTopTwoList =  numberFun.findTopTwoNumbersInList(integerList);
        assertTrue(actualTopTwoList.isEmpty());
    }

    @Test
    public void findTopTwoNumbersInListReturnsEmptyListWhenPassedNull() {
        List<Integer> actualTopTwoList =  numberFun.findTopTwoNumbersInList(null);
        assertTrue(actualTopTwoList.isEmpty());
    }

    @Test
    public void findTopTwoNumbersInListReturnsTopTwoNumbersForListWithMoreThanOneValue2() {
        List<Integer> integerList = Arrays.asList(1,300,2,100);
        List<Integer> actualTopTwoList =  numberFun.findTopTwoNumbersInList(integerList);
        assertEquals(new Integer(300), actualTopTwoList.get(0));
        assertEquals(new Integer(100), actualTopTwoList.get(1));
    }

    @Test
    public void sortMapByValueSortsMapCorrectly() {
        Map<String, Integer> theMap = new HashMap<String, Integer>() { {
            put("SecondItem", new Integer(500));
            put("ThirdItem", new Integer(100));
            put("FirstItem", new Integer(1000));
        }};
        Map<String, Integer> resultMap = numberFun.sortMapByValue(theMap);
        String[] sortedKeys = resultMap.keySet().toArray(new String[resultMap.keySet().size()]);
        String[] expectedKeys = new String[] { "FirstItem", "SecondItem", "ThirdItem"};
        assertArrayEquals(expectedKeys, sortedKeys);
        assertEquals(new Integer(1000), resultMap.get("FirstItem"));
    }

    @Test
    public void sortMapByValueUsingComparatorSortsMapCorrectly() {
        Map<String, Integer> theMap = new HashMap<String, Integer>() { {
            put("SecondItem", new Integer(500));
            put("ThirdItem", new Integer(100));
            put("FirstItem", new Integer(1000));
        }};
        Map<String, Integer> resultMap = numberFun.sortMapByValueUsingComparator(theMap);
        String[] sortedKeys = resultMap.keySet().toArray(new String[resultMap.keySet().size()]);
        String[] expectedKeys = new String[] { "FirstItem", "SecondItem", "ThirdItem"};
        assertArrayEquals(expectedKeys, sortedKeys);
    }

    @Test
    @Parameters({
            "3, 6",
            "4, 11",
            "5, 18",
            "6, 29",
            "100, 23593"
    })
    public void sumOfPrimesUpToReturnsCorrectTotal(String numberOfPrimes, String theTotal) {
        Long expectedValue = new Long(theTotal);
        assertEquals(expectedValue, new Long(numberFun.sumOfPrimesUpTo(Integer.valueOf(numberOfPrimes))));
    }


    @Test
    @Parameters({
            "1",
            "2",
            "3",
            "5",
            "11"
    })
    public void isPrimeNumberReturnsTrueForSimplePrimes(String primeNumber) {
        assertTrue(numberFun.isPrimeNumber(Integer.valueOf(primeNumber)));
    }

    @Test
    @Parameters({
            "4",
            "6",
            "12",
            "21",
            "35"
    })
    public void isPrimeNumberReturnsFalseForSimplePrimes(String primeNumber) {
        assertFalse(numberFun.isPrimeNumber(Integer.valueOf(primeNumber)));
    }

    @Test
    public void returnDistinctOnlyReturnsUniqueList() {
        List<Integer> theNumbers = Arrays.asList(1,3,2,4,3,2,3,5);
        List<Integer> theExpectedList = Arrays.asList(1,2,3,4,5);
        assertArrayEquals(theExpectedList.toArray(), theExpectedList.toArray());
    }


}