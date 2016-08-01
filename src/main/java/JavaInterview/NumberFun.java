package main.java.JavaInterview;

import java.util.Collections;
import java.util.List;
import java.util.Map;
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


}
