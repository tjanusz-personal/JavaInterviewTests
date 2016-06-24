package main.java.JavaInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjanusz929 on 6/22/16.
 */
public class MixedNumberInterviewQuestions {

    public List<Integer> getFibonacciSeriesUpTo(int stoppingValue) {
        List<Integer> theSeries = new ArrayList<Integer>();
        if (stoppingValue > 0) {
            theSeries.add(new Integer(1));
            theSeries.add(new Integer(1));
        }

        int fib1 = 1;
        int fib2 = 2;
        int currentValue = 3;
        while (currentValue < stoppingValue)
        {
            theSeries.add(new Integer(fib2));
            currentValue = fib1 + fib2;
            fib1 = fib2;
            fib2 = currentValue;
        }

        return theSeries;
    }

    public boolean isArmstrongNumber(int theNumber)
    {
        String strOfNumber = String.valueOf(theNumber);
        int currentTotal = 0;
        for (int count = 0; count < strOfNumber.length(); count++) {
            int digit = Character.digit(strOfNumber.charAt(count), 10);
            double square = Math.pow(digit, 3);
            currentTotal += square;
        }
        // sum of the cubes of its digits is equal to the number itself.
        // For example, 371 is an Armstrong number since 3**3 + 7**3 + 1**3 = 371.
        return currentTotal == theNumber;
    }

    public List<Integer> getArmstrongNumbersUpTo(int theNumber) {
        List<Integer> validArmstrongNumbers = new ArrayList<>();
        for (int count = 0; count < theNumber; count++) {
            if (isArmstrongNumber(count)) {
                validArmstrongNumbers.add(new Integer(count));
            }
        }
        return validArmstrongNumbers;
    }

    public boolean isNumberPalindrome(int theNumber) {
        String theNumberAsString = String.valueOf(theNumber);
        StringBuffer buffer = new StringBuffer(theNumberAsString).reverse();
        return theNumberAsString.equals(buffer.toString());
    }

    public int calculateFactorial(int theNumber) {
        int total = 1;
        for (int count = 1; count <= theNumber; count++) {
            total *= count;
        }
        return total;
    }

    public int calculateFactorialRec(int theNumber) {
        if (theNumber == 0)
            return 1;

        return theNumber * calculateFactorial(theNumber - 1);
    }

}
