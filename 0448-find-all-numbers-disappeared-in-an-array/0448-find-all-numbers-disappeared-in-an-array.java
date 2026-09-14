import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        int[] freq = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (freq[i] == 0) {
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        Solution obj = new Solution();

        List<Integer> result = obj.findDisappearedNumbers(nums);

        System.out.println(result);
    }
}