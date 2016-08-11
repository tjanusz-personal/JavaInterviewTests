package main.java.JavaInterview;

import com.oracle.webservices.internal.api.message.BasePropertySet;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class NumberFun {

    public Integer findDuplicate(List<Integer> listOfInts) {
        Map<Integer,Long> mapOfOccurrences = listOfInts.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Map.Entry> dups = mapOfOccurrences.entrySet().stream().filter(x -> x.getValue().equals(new Long(2)))
                .collect(Collectors.toList());
        if (dups.isEmpty()) {
            return null;
        }
        return (Integer) dups.get(0).getKey();
    }

    public Integer findDuplicate2(List<Integer> listOfInts) {
        Collections.sort(listOfInts);
        Integer prevValue = new Integer(0);
        for (Integer item : listOfInts) {
            if (item.equals(prevValue)) {
                return item;
            }
            prevValue = item;
        }
        return null;
    }

    public Integer reverseNumber(Integer theNumber) {
        String strNum = theNumber.toString();
        StringBuilder buffer = new StringBuilder();
        for (int pos = strNum.length() - 1; pos >= 0; pos--) {
            buffer.append(strNum.charAt(pos));
        }
        return Integer.valueOf(buffer.toString());
    }


    public boolean isPerfectNumber(int theNumber) {
        int total = 0;
        for (int i = 1; i <= theNumber/2; i++) {
            if (theNumber % i == 0) {
                total+= i;
            }
        }
        if (total == theNumber) {
            return true;
        }
        return false;
    }

    public List<Integer> findTopTwoNumbersInList(List<Integer> theList) {
        List<Integer> topTwoList = new ArrayList<Integer>();
        if (theList == null || theList.isEmpty()) {
            return topTwoList;
        }

        Integer topNumber = 0;
        Integer secondNumber = 0;

        for (Integer theValue : theList) {
            if (theValue > topNumber) {
                secondNumber = topNumber;
                topNumber = theValue;
                continue;
            } else if (theValue > secondNumber) {
                secondNumber = theValue;
                continue;
            }
        }

        topTwoList.add(topNumber);
        topTwoList.add(secondNumber);
        return topTwoList;
    }

    public Map<String, Integer> sortMapByValue(Map<String, Integer> theMap) {
        if (theMap == null) {
            return null;
        }

        // sort descending
        Comparator<Map.Entry<String, Integer>> theComparator = (theEntry, theEntry2) -> {
            return theEntry2.getValue().compareTo(theEntry.getValue());
        };

        // Need LinkedHashMap to keep ordering of the keys
        Map<String, Integer> resultMap = theMap.entrySet().stream().sorted(theComparator)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return resultMap;
    }

    public Map<String, Integer> sortMapByValueUsingComparator(Map<String, Integer> theMap) {
        if (theMap == null) {
            return null;
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(theMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                });
        Map<String, Integer> resultMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> theEntry : entryList) {
            resultMap.put(theEntry.getKey(), theEntry.getValue());
        }
        return resultMap;
    }

    public long sumOfPrimesUpTo(int totalNumberOfPrimes) {
        long total = 0;
        long primeCount = 0;

        for (int counter = 1; primeCount < totalNumberOfPrimes; counter++) {
            if (isPrimeNumber(counter)) {
                total += counter;
                primeCount++;
            }
        }
        return total;
    }

    public boolean isPrimeNumber(int theNumber) {
        if (theNumber == 1 || theNumber == 2) return true;
        if (theNumber % 2 == 0) return false;
        for (int count = 2; count < theNumber; count++) {
            if (theNumber % count == 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> returnDistinctOnly(List<Integer> theIntList)
    {
        Set<Integer> theSet = theIntList.stream().collect(Collectors.toSet());
        return new ArrayList<Integer>(theSet);
    }

}
