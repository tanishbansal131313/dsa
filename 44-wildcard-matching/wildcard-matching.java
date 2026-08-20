class Solution {
    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // Empty string can only match a pattern consisting of '*'
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                // Normal character or '?'
                if (pChar == sChar || pChar == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // '*' can:
                // 1. Match zero characters
                // 2. Match one or more characters
                else if (pChar == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
