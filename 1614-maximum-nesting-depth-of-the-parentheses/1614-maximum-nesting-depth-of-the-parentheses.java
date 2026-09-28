class Solution {
    public int maxDepth(String s) {
        int d = 0, m = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                m = Math.max(m, ++d);
            } else if (c == ')') {
                --d;
            }
        }

        return m;
    }
}