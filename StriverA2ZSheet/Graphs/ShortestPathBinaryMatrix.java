import java.util.*;

class tuple {

    // Distance from source
    int first;

    // Row number
    int second;

    // Column number
    int third;

    tuple(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}

class shortestPathBinaryMatrix {

    int shortestPath(int[][] grid,
                     int[] source,
                     int[] destination) {

        // If source and destination are same

        if (source[0] == destination[0] &&
            source[1] == destination[1]) {

            return 0;
        }

        // BFS Queue

        Queue<tuple> q = new LinkedList<>();

        // Number of rows

        int n = grid.length;

        // Number of columns

        int m = grid[0].length;

        // Distance matrix

        int[][] dist = new int[n][m];

        // Initialize each cell distance as INF

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                dist[i][j] = (int) 1e9;
            }
        }

        // Source distance = 0

        dist[source[0]][source[1]] = 0;

        // Push source into queue

        q.add(
            new tuple(
                0,          // distance
                source[0],  // row
                source[1]   // column
            )
        );

        /*
            Directions

                UP
              (-1,0)

        LEFT(0,-1)   RIGHT(0,1)

              (1,0)
              DOWN
        */

        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};

        // BFS starts

        while (!q.isEmpty()) {

            tuple it = q.peek();

            q.remove();

            int dis = it.first;
            int r = it.second;
            int c = it.third;

            // Visit 4 directions

            for (int i = 0; i < 4; i++) {

                int newr = r + dr[i];
                int newc = c + dc[i];

                // Check whether cell is valid

                if (newr >= 0 &&
                    newr < n &&
                    newc >= 0 &&
                    newc < m &&

                    // Cell should be open

                    grid[newr][newc] == 1 &&

                    // Found shorter path

                    dis + 1 < dist[newr][newc]) {

                    // Update distance

                    dist[newr][newc] = dis + 1;

                    // Destination reached

                    if (newr == destination[0] &&
                        newc == destination[1]) {

                        return dis + 1;
                    }

                    // Push neighbour into queue

                    q.add(
                        new tuple(
                            dis + 1,
                            newr,
                            newc
                        )
                    );
                }
            }
        }

        // Destination not reachable

        return -1;
    }
}
