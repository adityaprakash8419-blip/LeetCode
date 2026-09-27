class Solution {

    String dfs(String s, int[] from) {
        String r = "";

        for (; from[0] < s.length(); from[0]++) {

            if (s.charAt(from[0]) == '(') {
                from[0]++;

                String temp = dfs(s, from);

                StringBuilder sb = new StringBuilder(temp);
                sb.reverse();

                r += sb.toString();

            } else if (s.charAt(from[0]) == ')') {
                break;

            } else {
                r += s.charAt(from[0]);
            }
        }

        return r;
    }

    public String reverseParentheses(String s) {
        int[] from = {0};
        return dfs(s, from);
    }
}