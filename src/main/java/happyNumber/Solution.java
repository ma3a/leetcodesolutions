package happyNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem desc: https://leetcode.com/problems/happy-number/#/description
 * Submission details: https://leetcode.com/submissions/detail/98863111/
 * <p>
 * There was a better way of doing check infinite loops, through slow fast iterator
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> loopDetector = new HashSet<>();

        while (true) {
            n = getSquaredDigitSum(n);
            if (n == 1) {
                return true;
            }
            if (!loopDetector.add(n)) {
                return false;
            }
        }
    }

    protected int getSquaredDigitSum(int num) {
        int sum = 0;

        int residual = num % 10;
        sum += residual * residual;

        while (residual != num) {
            num = (num - residual) / 10;
            residual = num % 10;
            sum += residual * residual;
        }
        return sum;
    }
}
