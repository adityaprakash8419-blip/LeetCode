class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Integer> seats = new HashMap<>();

        for (int[] v : reservedSeats) {
            seats.put(v[0], seats.getOrDefault(v[0], 0) | (1 << (v[1] - 1)));
        }

        int r = n * 2;

        for (Map.Entry<Integer, Integer> p : seats.entrySet()) {
            int can = 0;
            int mask = p.getValue();

            if (((mask >> 1) & 0xf) == 0) {
                can++;
            }

            if (((mask >> 5) & 0xf) == 0) {
                can++;
            }

            if (can == 0) {
                if (((mask >> 3) & 0xf) == 0) {
                    can = 1;
                }
            }

            r += can - 2;
        }

        return r;
    }
}