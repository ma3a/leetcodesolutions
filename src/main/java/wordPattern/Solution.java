package wordPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem desc: https://leetcode.com/problems/word-pattern/#/description
 *
 * Submission details: https://leetcode.com/submissions/detail/98574447/
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> patternToWordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Character letterPattern = pattern.charAt(i);
            if (!patternToWordMap.containsKey(letterPattern) && !patternToWordMap.containsValue(word)) {
                patternToWordMap.put(letterPattern, word);
            }

            String expected = patternToWordMap.get(letterPattern);
            if (!word.equals(expected)) {
                return false;
            }
        }
        return true;
    }
}
