import java.util.*;

class Tuple {
    int distance;
    int row;
    int col;

    public Tuple(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        // Min Heap based on effort
        PriorityQueue<Tuple> pq =
                new PriorityQueue<>((x, y) -> x.distance - y.distance);

        // dist[i][j] = minimum effort required to reach cell (i,j)
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }

        // Source cell
        dist[0][0] = 0;
        pq.offer(new Tuple(0, 0, 0));

        // Up, Right, Down, Left
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {

            Tuple curr = pq.poll();

            int effort = curr.distance;
            int row = curr.row;
            int col = curr.col;

            // Destination reached
            if (row == n - 1 && col == m - 1) {
                return effort;
            }

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {

                int newRow = row + dr[i];
                int newCol = col + dc[i];

                // Valid cell check
                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < m) {

                    // Difference between current cell and neighbour
                    int heightDiff =
                            Math.abs(
                                heights[row][col]
                                - heights[newRow][newCol]
                            );

                    // Maximum effort seen so far on this path
                    int newEffort =
                            Math.max(effort, heightDiff);

                    // Relaxation
                    if (newEffort < dist[newRow][newCol]) {

                        dist[newRow][newCol] = newEffort;

                        pq.offer(
                            new Tuple(
                                newEffort,
                                newRow,
                                newCol
                            )
                        );
                    }
                }
            }
        }

        return 0;
    }
}
