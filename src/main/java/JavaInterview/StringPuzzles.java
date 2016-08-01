package main.java.JavaInterview;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by tjanusz929 on 7/28/16.
 */
public class StringPuzzles {

    public boolean isAnagram(String firstString, String secondString) {
        if (firstString == null || secondString == null) {
            return false;
        }
        char [] sortedFirstAr = firstString.toUpperCase().toCharArray();
        Arrays.sort(sortedFirstAr);
        String sortedFirst = new String(sortedFirstAr);

        char [] sortedSecondAr = secondString.toUpperCase().toCharArray();
        Arrays.sort(sortedSecondAr);
        String sortedSecond = new String(sortedSecondAr);
        return sortedFirst.equalsIgnoreCase(sortedSecond);
    }

    public boolean isAnagram2(String firstString, String secondString) {
        if (firstString == null || secondString == null) {
            return false;
        }
        String sortedFirst = firstString.toUpperCase().chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        String sortedSecond = secondString.toUpperCase().chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        return sortedFirst.equalsIgnoreCase(sortedSecond);
    }

}
