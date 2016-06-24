package main.java.JavaInterview;

import java.util.stream.Collectors;

/**
 * Created by tjanusz929 on 6/22/16.
 */
public class StringReplacer {

    public String replaceFrom(String stringToReplace, char charToReplace)
    {
        if (stringToReplace == null) {
            return null;
        }
        if (stringToReplace.isEmpty()) {
            return "";
        }
        return stringToReplace.replaceAll(String.valueOf(charToReplace), "");
    }

    public String replaceFromUsingStream(String stringToReplace, char charToReplace)
    {
        if (stringToReplace == null) {
            return null;
        }

        return stringToReplace.codePoints().filter( ch -> ch != charToReplace)
                .collect(StringBuilder::new,
                    StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
}
