package textJustification;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem desc: https://leetcode.com/problems/text-justification/#/description
 *
 * Submission details: https://leetcode.com/submissions/detail/98681676/
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int inRowCharCounts = 0;
        List<String> inRow = new ArrayList<>();

        for (String word : words) {
            int rowLengthWithMinimumSpaces = inRowCharCounts + word.length() + Math.max(inRow.size() - 1, 0);

            if (rowLengthWithMinimumSpaces >= maxWidth) {
                if (inRow.size() == 1) {
                    result.add(leftJustified(inRow, maxWidth, inRowCharCounts));
                } else if (inRow.size() > 0) {
                    result.add(justify(inRow, maxWidth, inRowCharCounts));
                }
                inRowCharCounts = 0;
                inRow = new ArrayList<>();
            }

            inRow.add(word);
            inRowCharCounts += word.length();
        }

        if (inRow.size() != 0) {
            result.add(leftJustified(inRow, maxWidth, inRowCharCounts));
        }
        return result;
    }

    private String leftJustified(List<String> row, int maxWidth, int rowLettersCount) {
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<row.size(); i++) {
            String word = row.get(i);
            builder.append(word);
            if (i != (row.size() - 1)) {
                appendSpace(builder, 1);
            }
        }
        appendSpace(builder, maxWidth - rowLettersCount - Math.max(row.size() - 1, 0));
        return builder.toString();
    }

    private String justify(List<String> row, int maxWidth, int rowLettersCount) {
        int perWordSpaces = (maxWidth - rowLettersCount) / (Math.max(row.size() - 1, 1));
        int rem = (maxWidth - rowLettersCount) % (Math.max(row.size() - 1, 1));
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<row.size(); i++) {
            String word = row.get(i);
            builder.append(word);
            if (i != row.size() - 1) {
                appendSpace(builder, perWordSpaces);
                if (rem > 0) {
                    appendSpace(builder, 1);
                    rem--;
                }
            }
        }
        return builder.toString();
    }

    private void appendSpace(StringBuilder builder, int count) {
        for (int i=0; i< count; i++) {
            builder.append(" ");
        }
    }

}