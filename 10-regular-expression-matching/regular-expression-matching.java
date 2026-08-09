class Solution {

    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {

        memo = new Boolean[s.length() + 1][p.length() + 1];

        return match(s, p, 0, 0);
    }

    private boolean match(String s, String p, int i, int j) {

        // Already calculated
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        // Pattern finished
        if (j == p.length()) {
            return i == s.length();
        }

        // Check if current characters match
        boolean firstMatch =
                i < s.length() &&
                (s.charAt(i) == p.charAt(j) ||
                 p.charAt(j) == '.');

        boolean result;

        // Check for '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            // Option 1: use zero occurrences
            // Option 2: use one or more occurrences
            result =
                match(s, p, i, j + 2) ||
                (firstMatch && match(s, p, i + 1, j));

        } else {

            // Normal character or '.'
            result =
                firstMatch &&
                match(s, p, i + 1, j + 1);
        }

        memo[i][j] = result;

        return result;
    }
}