import java.util.List;
import java.util.HashSet;
class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        for(int i=0;i<nums.size();i++){
            HashSet<Integer>set = new HashSet<>();
            int count= 0;
            for(int j=i;j<nums.size();j++){
                set.add(nums.get(j));
                count = set.size();
                ans = ans+count*count;
            }
        }
        return ans;

        
    }
}