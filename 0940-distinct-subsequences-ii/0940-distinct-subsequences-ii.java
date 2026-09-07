class Solution {
    static final int M = 1000000007;

    void add(int[] x, int y) {
        x[0] += y;
        if (x[0] >= M) {
            x[0] -= M;
        }
    }

    void dec(int[] x, int y) {
        x[0] -= y;
        if (x[0] < 0) {
            x[0] += M;
        }
    }

    public int distinctSubseqII(String S) {
        int[] last = new int[26];
        int[] r = {1};

        for (int i = 0; i < S.length(); i++) {
            int c = S.charAt(i) - 'a';

            int p = r[0];

            add(r, r[0]);
            dec(r, last[c]);

            last[c] = p;
        }

        dec(r, 1);
        return r[0];
    }
}