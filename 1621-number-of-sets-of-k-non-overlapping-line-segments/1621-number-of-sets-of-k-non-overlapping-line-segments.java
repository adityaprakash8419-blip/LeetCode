class Solution {
    final int M = 1000000007;

    void add(int[] x, int y) {
        x[0] += y;
        if (x[0] >= M) {
            x[0] -= M;
        }
    }

    public int numberOfSets(int n, int k) {
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int j = 1; j <= k; j++) {
            int s = 1;

            for (int i = j + 1; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];

                int[] temp = {dp[j][i]};
                add(temp, s);
                dp[j][i] = temp[0];

                s += dp[j - 1][i];
                if (s >= M) {
                    s -= M;
                }
            }
        }

        return dp[k][n];
    }
}