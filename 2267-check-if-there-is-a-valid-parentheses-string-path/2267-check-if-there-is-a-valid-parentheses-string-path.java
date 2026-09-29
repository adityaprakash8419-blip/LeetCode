class Solution {

    void update(int[][] dp1, int[][] dp2, int x, int y, int v) {
        if (dp1[x][y] < 0) {
            dp1[x][y] = dp2[x][y] = v;
        } else if (v > dp2[x][y]) {
            dp2[x][y] = v;
        } else if (v < dp1[x][y]) {
            dp1[x][y] = v;
        }
    }

    void update(int[][] dp1, int[][] dp2, char[][] g,
                int x, int y, int ox, int oy) {

        if (dp1[ox][oy] < 0) {
            return;
        }

        if (g[x][y] == '(') {
            update(dp1, dp2, x, y, dp1[ox][oy] + 1);
            update(dp1, dp2, x, y, dp2[ox][oy] + 1);
        } else {
            if (dp2[ox][oy] >= 1) {
                if (dp1[ox][oy] >= 1) {
                    update(dp1, dp2, x, y, dp1[ox][oy] - 1);
                }
                update(dp1, dp2, x, y, dp2[ox][oy] - 1);
            }
        }
    }

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == ')' ||
            grid[m - 1][n - 1] == '(' ||
            ((m + n) & 1) == 0) {
            return false;
        }

        int[][] dp1 = new int[m][n];
        int[][] dp2 = new int[m][n];

        for (int i = 0; i < m; i++) {
            java.util.Arrays.fill(dp1[i], -1);
            java.util.Arrays.fill(dp2[i], -1);
        }

        dp1[0][0] = 1;
        dp2[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = (i == 0 ? 1 : 0); j < n; j++) {

                if (i > 0) {
                    update(dp1, dp2, grid, i, j, i - 1, j);
                }

                if (j > 0) {
                    update(dp1, dp2, grid, i, j, i, j - 1);
                }
            }
        }

        return dp1[m - 1][n - 1] == 0;
    }
}