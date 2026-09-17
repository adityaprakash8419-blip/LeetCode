import java.util.*;

class Solution {

    void better(int[] x, int y) {
        if (x[0] < 0 || x[0] > y) {
            x[0] = y;
        }
    }

    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        HashMap<Integer, Integer> have = new HashMap<>();
        int[] dp = new int[n + 1];

        have.put(0, 0);
        dp[0] = -1;

        int r = -1;
        int s = 0;

        for (int i = 1; i <= n; i++) {
            s += arr[i - 1];

            dp[i] = dp[i - 1];

            if (have.containsKey(s - target)) {
                int index = have.get(s - target);
                int len = i - index;

                int[] temp = {dp[i]};
                better(temp, len);
                dp[i] = temp[0];

                if (dp[index] >= 0) {
                    int[] temp2 = {r};
                    better(temp2, dp[index] + len);
                    r = temp2[0];
                }
            }

            have.put(s, i);
        }

        return r;
    }
}