class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                if (count > 1) {
                    ans.append(c);
                }
            } else {
                count--;
                if (count > 0) {
                    ans.append(c);
                }
            }
        }

        return ans.toString();
    }
}