package wordPattern;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();

        assertTrue(solution.wordPattern("abba","dog cat cat dog"));
        assertFalse(solution.wordPattern("abba", "dog cat cat fish"));
        assertFalse(solution.wordPattern("abba", "dog dog dog dog"));
        assertFalse(solution.wordPattern("aaaa", "dog cat cat dog"));
    }

}