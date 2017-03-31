package textJustification;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        List<String> expected = Arrays.asList(
            "This    is    an",
            "example  of text",
            "justification.  ");

        String[] list = {"This", "is", "an", "example", "of", "text", "justification."};
        assertEquals(expected, solution.fullJustify(list, 16));
    }

    @Test
    public void hiddenTest() {
        Solution solution = new Solution();
        List<String> expected = Arrays.asList(
                "Listen","to    ","many, ","speak ","to   a","few.  ");

        String[] list = {"Listen","to","many,","speak","to","a","few."};
        assertEquals(expected, solution.fullJustify(list, 6));
    }

    @Test
    public void hiddenTest2() {
        Solution solution = new Solution();
        List<String> expected = Arrays.asList("What must be","shall be.   ");

        String[] list = {"What","must","be","shall","be."};
        assertEquals(expected, solution.fullJustify(list, 12));
    }

    @Test
    public void hiddenTest3() {

        Solution solution = new Solution();
        List<String> expected = Arrays.asList("Here   is   an","example     of","text          ","justification.");

        String[] list = {"Here","is","an","example","of","text","justification."};
        assertEquals(expected, solution.fullJustify(list, 14));
    }

    @Test
    public void emptyWords() {
        Solution solution = new Solution();
        List<String> expected = Arrays.asList("");

        String[] list = {""};
        assertEquals(expected, solution.fullJustify(list, 0));
    }

}