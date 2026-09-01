import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int[][] id = new int[m][n];

        for (int[] row : id) {
            Arrays.fill(row, -1);
        }

        int x = -1, y = -1;
        int p = 0;

        // Find S and assign IDs to L
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (classroom[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                } 
                else if (classroom[i].charAt(j) == 'L') {
                    id[i][j] = p++;
                }
            }
        }

        // No litter
        if (p == 0) {
            return 0;
        }

        int out = (1 << p) - 1;

        // save[x][y][energy][mask]
        int[][][][] save =
                new int[m][n][energy + 1][out + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int e = 0; e <= energy; e++) {
                    Arrays.fill(save[i][j][e], -1);
                }
            }
        }

        save[x][y][energy][out] = 0;

        Queue<int[]> q = new LinkedList<>();

        // {x, y, currentEnergy, mask}
        q.offer(new int[]{x, y, energy, out});

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int cx = curr[0];
            int cy = curr[1];
            int now = curr[2];
            int mask = curr[3];

            if (mask == 0) {
                return save[cx][cy][now][mask];
            }

            int step = save[cx][cy][now][mask] + 1;

            // Moving costs 1 energy
            now--;

            if (now < 0) {
                continue;
            }

            for (int i = 0; i < 4; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // Outside grid or wall
                if (nx < 0 || nx >= m ||
                    ny < 0 || ny >= n ||
                    classroom[nx].charAt(ny) == 'X') {
                    continue;
                }

                // Recharge
                int newEnergy;

                if (classroom[nx].charAt(ny) == 'R') {
                    newEnergy = energy;
                } else {
                    newEnergy = now;
                }

                // Collect litter
                int newMask = mask;

                if (classroom[nx].charAt(ny) == 'L') {

                    int bit = 1 << id[nx][ny];

                    if ((mask & bit) != 0) {
                        newMask = mask ^ bit;
                    }
                }

                // Visit state only once
                if (save[nx][ny][newEnergy][newMask] == -1) {

                    save[nx][ny][newEnergy][newMask] = step;

                    q.offer(new int[]{
                            nx,
                            ny,
                            newEnergy,
                            newMask
                    });
                }
            }
        }

        return -1;
    }
}