package main.java.JavaInterview;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public List<Character> findDupChars2(String theString) {
        List<Character> dups = new ArrayList<Character>();
        if (theString == null || theString.isEmpty()) {
            return dups;
        }
        Map<Character,Long> charMap = new HashMap<Character,Long>();
        // loop through characters and add to map (counting each occurrence)
        for (Character theChar: theString.toUpperCase().toCharArray())
        {
            Long currCount = 1L;
            if (charMap.containsKey(theChar)) {
                currCount = charMap.get(theChar);
                currCount++;
            }
            charMap.put(theChar,currCount);
        }

        // Keys with value > 1 then means character has duplicates
        BiConsumer<Character, Long> theDups = (x,y) -> {
            if (y > 1) dups.add(x);
        };
        charMap.forEach(theDups);
        return dups;
    }

    public List<Character> findDupChars(String theString) {
        List<Character> duplicateCharacterList = new ArrayList<Character>();
        if (theString == null || theString.isEmpty()) {
            return duplicateCharacterList;
        }
        // turn string into Stream of Characters
        Stream<Character> charStream = theString.toUpperCase().chars().mapToObj(x -> (char) x);
        // Collect all characters but group by character and count
        Map<Character, Long> mapOfChars = charStream.collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        // Add only the ones with more than one entry
        BiConsumer<Character, Long> theDups = (x,y) -> {
            if (y > 1) duplicateCharacterList.add(x);
        };
        mapOfChars.forEach( theDups );
        return duplicateCharacterList;
    }

}
