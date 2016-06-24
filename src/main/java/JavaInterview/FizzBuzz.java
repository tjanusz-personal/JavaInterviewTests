package main.java.JavaInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjanusz929 on 6/24/16.
 */
public class FizzBuzz {

    public String printFizzBuzzFor(int theNumber)
    {
        if (theNumber % 15 == 0) {
            return "FizzBuzz";
        } else if (theNumber % 3 == 0) {
            return "Fizz";
        } else if (theNumber % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(theNumber);
    }

    public int[] bubbleSortIntsWithoutAPI(int[] theIntArray) {
        for (int outerLoop = 0; outerLoop < theIntArray.length - 1; outerLoop++)
        {
            for (int innerLoop = 1; innerLoop < theIntArray.length - outerLoop; innerLoop++)
            {
                if (theIntArray[innerLoop - 1] > theIntArray[innerLoop]) {
                    int tempHolder = theIntArray[innerLoop];
                    theIntArray[innerLoop] = theIntArray[innerLoop - 1];
                    theIntArray[innerLoop - 1] = tempHolder;
                }
            }
        }
        return theIntArray;
    }

    public int[] reverseBubbleSortIntsWithoutAPI(int[] theIntArray) {
        for (int outerLoop = 0; outerLoop < theIntArray.length - 1; outerLoop++)
        {
            for (int innerLoop = 1; innerLoop < theIntArray.length - outerLoop; innerLoop++)
            {
                if (theIntArray[innerLoop - 1] < theIntArray[innerLoop]) {
                    int tempHolder = theIntArray[innerLoop];
                    theIntArray[innerLoop] = theIntArray[innerLoop - 1];
                    theIntArray[innerLoop - 1] = tempHolder;
                }
            }
        }
        return theIntArray;
    }


}
