package test.java.JavaInterview;

import main.java.JavaInterview.StringReplacer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tjanusz929 on 6/22/16.
 */
public class StringReplacerTest {

    private StringReplacer replacer;

    @Before
    public void Setup() {
        replacer = new StringReplacer();
    }

    @Test
    public void replaceFromReturnsEmptyStringWhenPassedEmptyString() throws Exception {
        assertEquals("", replacer.replaceFrom("", 'c'));
    }

    @Test
    public void replaceFromReturnsNullWhenPassedNullString() {
        assertNull(replacer.replaceFrom(null, 'c'));
    }

    @Test
    public void replaceFromReturnsStringWithCharacterRemovedMatchingOnlyOnCase()
    {
        assertEquals("hell wrld", replacer.replaceFrom("hello world", 'o'));
        assertEquals("hello world", replacer.replaceFrom("hello world", 'O'));
    }

    @Test
    public void replaceFromReturnsOriginalStringWhenPassNullCharacter() {
        assertEquals("hello world", replacer.replaceFrom("hello world", '\0'));
    }

    @Test
    public void replaceFromUsingStreamReturnsEmptyStringWhenPassedEmptyString() throws Exception {
        assertEquals("", replacer.replaceFromUsingStream("", 'c'));
    }

    @Test
    public void replaceFromUsingStreamReturnsNullWhenPassedNullString() {
        assertNull(replacer.replaceFromUsingStream(null, 'c'));
    }

    @Test
    public void replaceFromUsingStreamReturnsStringWithCharacterRemovedMatchingOnlyOnCase()
    {
        assertEquals("hell wrld", replacer.replaceFromUsingStream("hello world", 'o'));
        assertEquals("hello world", replacer.replaceFromUsingStream("hello world", 'O'));
    }

    @Test
    public void replaceFromUsingStreamReturnsOriginalStringWhenPassNullCharacter() {
        assertEquals("hello world", replacer.replaceFromUsingStream("hello world", '\0'));
    }


}