class Solution {
    public int lengthOfLongestSubstring(String s) {
        int freq[] = new int[128];
        int st = 0;
        int end = 0;
        int ans = 0;
        while(end < s.length()){
            freq[s.charAt(end)]++;
             while(st <= end && freq[s.charAt(end)]>=2){    
                freq[s.charAt(st)]--;
                st++;
             }
            ans = Math.max(ans , end-st+1);
            end++;  
        }
        return ans;
    }
}