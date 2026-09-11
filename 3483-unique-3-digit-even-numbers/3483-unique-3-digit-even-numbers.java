class Solution {
    public int totalNumbers(int[] digits) {
        int[] v = new int[10];

        for (int x : digits) {
            v[x]++;
        }

        int r = 0;

        for (int i = 0; i < 10; i += 2) {
            if (v[i] == 0) continue;

            v[i]--;

            for (int j = 1; j < 10; j++) {
                if (v[j] == 0) continue;

                v[j]--;

                for (int x : v) {
                    if (x > 0) {
                        r++;
                    }
                }

                v[j]++;
            }

            v[i]++;
        }

        return r;
    }
}