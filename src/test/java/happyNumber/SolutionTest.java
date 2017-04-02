package happyNumber;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertTrue(solution.isHappy(19));
        assertFalse(solution.isHappy(2));
    }

}