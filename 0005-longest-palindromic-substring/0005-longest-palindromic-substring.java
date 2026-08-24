class Solution {
    public String longestPalindrome(String s) {
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            String a = expand(s, i, i);
            String b = expand(s, i, i + 1);

            if (a.length() > ans.length()) {
                ans = a;
            }

            if (b.length() > ans.length()) {
                ans = b;
            }
        }

        return ans;
    }

    public String expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() &&
               s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}