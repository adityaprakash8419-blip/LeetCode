class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        ArrayList<Integer>[] all = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            all[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {

            // Odd length palindrome
            for (int x = i, y = i;
                 x >= 0 && y < n && s.charAt(x) == s.charAt(y);
                 x--, y++) {

                if (y - x + 1 >= k) {
                    all[y].add(x);
                }
            }

            // Even length palindrome
            for (int x = i - 1, y = i;
                 x >= 0 && y < n && s.charAt(x) == s.charAt(y);
                 x--, y++) {

                if (y - x + 1 >= k) {
                    all[y].add(x);
                }
            }
        }

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];

            for (int j : all[i - 1]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        return dp[n];
    }
}