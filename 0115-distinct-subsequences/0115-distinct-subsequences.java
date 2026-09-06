class Solution {
    public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int MOD = 1000000007;

        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;

            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];

                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                    dp[i][j] %= MOD;
                }
            }
        }

        return dp[m][n];
    }
}