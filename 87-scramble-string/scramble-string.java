class Solution {

    String s1;
    String s2;
    Boolean[][][] memo;

    public boolean isScramble(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        this.s1 = s1;
        this.s2 = s2;

        int n = s1.length();

        memo = new Boolean[n][n][n + 1];

        return solve(0, 0, n);
    }

    private boolean solve(int i, int j, int len) {

        // Already calculated
        if (memo[i][j][len] != null) {
            return memo[i][j][len];
        }

        // Same substring
        if (s1.substring(i, i + len)
             .equals(s2.substring(j, j + len))) {

            return memo[i][j][len] = true;
        }

        // Check character frequencies
        int[] count = new int[26];

        for (int k = 0; k < len; k++) {
            count[s1.charAt(i + k) - 'a']++;
            count[s2.charAt(j + k) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return memo[i][j][len] = false;
            }
        }

        // Try every possible split
        for (int split = 1; split < len; split++) {

            // Case 1: Don't swap
            boolean noSwap =
                solve(i, j, split) &&
                solve(i + split, j + split, len - split);

            if (noSwap) {
                return memo[i][j][len] = true;
            }

            // Case 2: Swap
            boolean swap =
                solve(i, j + len - split, split) &&
                solve(i + split, j, len - split);

            if (swap) {
                return memo[i][j][len] = true;
            }
        }

        return memo[i][j][len] = false;
    }
}