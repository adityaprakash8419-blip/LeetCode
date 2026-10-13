import java.util.*;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

        int n = arr.length;
        long r = 0;
        int x = 0, y = n - 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                r -= 1L * arr[x] * arr[x];
                x++;
            } else {
                r += 1L * arr[y] * arr[y];
                y--;
            }
        }

        return r;
    }
}