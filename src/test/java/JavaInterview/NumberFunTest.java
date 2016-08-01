package test.java.JavaInterview;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import main.java.JavaInterview.NumberFun;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

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


}