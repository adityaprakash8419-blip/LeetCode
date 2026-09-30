class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] r = new int[n];

        int a = 0, b = 0;

        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                if (a < b) {
                    ++a;
                } else {
                    ++b;
                    r[i] = 1;
                }
            } else {
                if (a > b) {
                    --a;
                } else {
                    --b;
                    r[i] = 1;
                }
            }
        }

        return r;
    }
}