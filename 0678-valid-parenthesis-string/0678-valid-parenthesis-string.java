class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } 
            else if (c == ')') {
                low--;
                high--;
            } 
            else {
                low--;   // * as )
                high++;  // * as (
            }

            if (high < 0) return false;
            if (low < 0) low = 0;
        }

        return low == 0;
    }
}