class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int countred = 0;
        int countwhite = 0;
        int countblue = 0;

        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                countred++;
            } else if (nums[i] == 1) {
                countwhite++;
            } else {
                countblue++;
            }
        }

        
        int index = 0;

        for (int i = 0; i < countred; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < countwhite; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < countblue; i++) {
            nums[index++] = 2;
        }
    }
}