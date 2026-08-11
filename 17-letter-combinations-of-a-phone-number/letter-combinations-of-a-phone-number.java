import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] phone = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };

        StringBuilder current = new StringBuilder();

        backtrack(digits, 0, current, result, phone);

        return result;
    }

    private void backtrack(
        String digits,
        int index,
        StringBuilder current,
        List<String> result,
        String[] phone
    ) {

        // All digits processed
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for current digit
        int digit = digits.charAt(index) - '0';

        String letters = phone[digit];

        // Try every possible letter
        for (char c : letters.toCharArray()) {

            // Choose
            current.append(c);

            // Explore
            backtrack(
                digits,
                index + 1,
                current,
                result,
                phone
            );

            // Undo choice (backtrack)
            current.deleteCharAt(current.length() - 1);
        }
    }
}