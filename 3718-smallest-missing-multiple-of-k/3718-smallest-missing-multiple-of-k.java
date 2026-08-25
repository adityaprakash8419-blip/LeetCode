class Solution {
    public int missingMultiple(int[] nums, int k) {
        for (int mul = k; ; mul += k) {
            boolean found = false;

            for (int num : nums) {
                if (num == mul) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return mul;
            }
        }
    }
}