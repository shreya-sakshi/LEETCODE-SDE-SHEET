class Solution {

    // Function to find the shortest distance between every pair of vertices
    public void shortestDistance(int[][] matrix) {

        int n = matrix.length;

        // Floyd-Warshall Algorithm
        for (int k = 0; k < n; k++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    // If path i->k or k->j doesn't exist
                    if (matrix[i][k] == -1 || matrix[k][j] == -1) {
                        continue;
                    }

                    // If no direct path exists from i to j
                    if (matrix[i][j] == -1) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }

                    // Update with shorter path if available
                    else {
                        matrix[i][j] = Math.min(
                            matrix[i][j],
                            matrix[i][k] + matrix[k][j]
                        );
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {0, 2, -1, -1},
            {1, 0, 3, -1},
            {-1, -1, 0, -1},
            {3, 5, 4, 0}
        };

        Solution sol = new Solution();

        sol.shortestDistance(matrix);

        System.out.println("The shortest distance matrix is:");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
