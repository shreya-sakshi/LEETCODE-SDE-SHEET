import java.util.*;

class Solution {

    class DSU {

        int[] parent;
        int[] size;

        DSU(int n) {

            parent = new int[n];
            size = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findUPar(int node) {

            if(node == parent[node]) {
                return node;
            }

            parent[node] = findUPar(parent[node]);

            return parent[node];
        }

        void unionBySize(int u, int v) {

            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            if(ulp_u == ulp_v)
                return;

            if(size[ulp_u] < size[ulp_v]) {

                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];

            } else {

                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }
        }
    }

    private boolean isValid(
            int row,
            int col,
            int n,
            int m) {

        return row >= 0 &&
               row < n &&
               col >= 0 &&
               col < m;
    }

    public List<Integer> numOfIslands(
                int n,
                int m,
                int[][] operators) {

        DSU ds = new DSU(n * m);

        int[][] vis = new int[n][m];

        List<Integer> ans = new ArrayList<>();

        int count = 0;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for(int i = 0; i < operators.length; i++) {

            int row = operators[i][0];
            int col = operators[i][1];

            if(vis[row][col] == 1) {

                ans.add(count);
                continue;
            }

            vis[row][col] = 1;

            count++;

            for(int ind = 0; ind < 4; ind++) {

                int adjrow = row + dr[ind];
                int adjcol = col + dc[ind];

                if(isValid(adjrow, adjcol, n, m)) {

                    if(vis[adjrow][adjcol] == 1) {

                        int nodeNo =
                                row * m + col;

                        int adjNodeNo =
                                adjrow * m + adjcol;

                        if(ds.findUPar(nodeNo)
                                !=
                           ds.findUPar(adjNodeNo)) {

                            count--;

                            ds.unionBySize(
                                    nodeNo,
                                    adjNodeNo);
                        }
                    }
                }
            }

            ans.add(count);
        }

        return ans;
    }
}


-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//This code is solving the **Number of Islands II** problem using **Disjoint Set Union (DSU/Union-Find)**. Every operator adds land to a grid, and after each addition, the code records the current number of islands.

Let's go through it **line by line**.

***

## Helper Function

```java
private boolean isValid(int adjr, int adjc, int n, int m) {
    return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
}
```

### What it does

Checks whether a neighboring cell lies inside the grid boundaries.

Example:

For a `3 x 4` grid:

```java
isValid(2,3,3,4) => true
isValid(-1,2,3,4) => false
isValid(3,1,3,4) => false
```

***

# Main Function

```java
public List<Integer> numOfIslands(int n, int m, int[][] operators) {
```

* `n` = number of rows
* `m` = number of columns
* `operators` = positions where land will be added one by one

Returns a list containing island count after every operation.

***

```java
DisjointSet ds = new DisjointSet(n * m);
```

Creates a DSU structure for all cells.

If grid is:

```text
0 1 2
3 4 5
6 7 8
```

Each cell is treated as a node.

Total nodes = `n*m`.

***

```java
int[][] vis = new int[n][m];
```

Visited matrix.

Initially all cells are water (`0`).

Example:

```text
0 0 0
0 0 0
0 0 0
```

***

```java
int cnt = 0;
```

Tracks current number of islands.

***

```java
List<Integer> ans = new ArrayList<>();
```

Stores answer after each operation.

***

```java
int len = operators.length;
```

Total operations.

***

## Process Every Operation

```java
for(int i = 0; i < len; i++) {
```

Iterate through all land additions.

***

```java
int row = operators[i][0];
int col = operators[i][1];
```

Get coordinates where land is added.

Example:

```java
operators[i] = {2,1}
```

then

```java
row = 2
col = 1
```

***

## Duplicate Land Check

```java
if(vis[row][col] == 1) {
    ans.add(cnt);
    continue;
}
```

If land already exists there:

* island count remains same
* add current count to answer
* skip remaining work

Example:

Adding `(1,1)` twice.

***

## Mark New Land

```java
vis[row][col] = 1;
```

Water → Land

***

```java
cnt++;
```

Initially assume this new land forms a brand-new island.

Example:

Before

```text
1 0
0 0
```

Add `(1,1)`

```text
1 0
0 1
```

Now islands increase by 1.

***

## Direction Arrays

```java
int dr[] = {-1, 0, 1, 0};
int dc[] = {0, 1, 0, -1};
```

Represents:

```text
Up    (-1, 0)
Right ( 0, 1)
Down  ( 1, 0)
Left  ( 0,-1)
```

Used to explore neighbors.

***

## Check All 4 Neighbors

```java
for(int ind = 0; ind < 4; ind++) {
```

Loop over four directions.

***

```java
int adjr = row + dr[ind];
int adjc = col + dc[ind];
```

Neighbor coordinates.

Example:

Current cell:

```text
(2,3)
```

For Up:

```java
adjr = 1
adjc = 3
```

***

## Boundary Check

```java
if(isValid(adjr, adjc, n, m)) {
```

Ensure neighbor is inside grid.

***

## Check If Neighbor is Land

```java
if(vis[adjr][adjc] == 1) {
```

Only land neighbors matter.

Water neighbors do not form connections.

***

## Convert Cell to Node Numbers

### Current Cell

```java
int nodeNo = row * m + col;
```

Converts 2D cell to 1D node.

Example (`m = 4`)

```text
(0,0) -> 0
(0,1) -> 1
(1,0) -> 4
(2,2) -> 10
```

Formula:

```java
row * m + col
```

***

### Neighbor Cell

```java
int adjNodeNo = adjr * m + adjc;
```

Same conversion for neighbor.

***

## Check Connected Components

```java
if(ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
```

Check whether current land and neighbor land belong to different islands.

Example:

Before:

```text
1 0
0 1
```

Two separate islands.

Their parents will be different.

***

## Islands Merge

```java
cnt--;
```

Since two islands become one island.

Example:

Before:

```text
1 0
0 1
```

Island count = 2

After connecting:

```text
1 1
0 1
```

Island count = 1

So decrement.

***

## Union Operation

```java
ds.unionBySize(nodeNo, adjNodeNo);
```

Merge the two components in DSU.

After union both cells share same ultimate parent.

***

### Closing Braces

These just close the nested `if` and `for` blocks.

***

## Store Current Island Count

```java
ans.add(cnt);
```

After processing all neighbors, store the final island count.

Example:

```java
ans = [1,1,2,3]
```

***

## Return Result

```java
return ans;
```

Returns island count after every operation.

***

# Example Walkthrough

Suppose:

```java
n = 3, m = 3

operators = {
    {0,0},
    {0,1},
    {1,2},
    {2,1},
    {1,1}
};
```

### Step 1

Add `(0,0)`

```text
1 0 0
0 0 0
0 0 0
```

Islands = 1

Answer:

```java
[1]
```

***

### Step 2

Add `(0,1)`

```text
1 1 0
0 0 0
0 0 0
```

It touches `(0,0)`.

Initially:

```java
cnt = 2
```

Union happens:

```java
cnt--
```

Final:

```java
cnt = 1
```

Answer:

```java
[1,1]
```

***

### Step 3

Add `(1,2)`

```text
1 1 0
0 0 1
0 0 0
```

New island.

```java
cnt = 2
```

Answer:

```java
[1,1,2]
```

***

### Step 4

Add `(2,1)`

```text
1 1 0
0 0 1
0 1 0
```

New island.

```java
cnt = 3
```

Answer:

```java
[1,1,2,3]
```

***

### Step 5

Add `(1,1)`

```text
1 1 0
0 1 1
0 1 0
```

This cell connects:

* `(0,1)`
* `(1,2)`
* `(2,1)`

Initially:

```java
cnt = 4
```

Union with 3 separate islands:

```java
cnt = 3
cnt = 2
cnt = 1
```

Final answer:

```java
[1,1,2,3,1]
```

***

### Core Idea

1. Every new land initially creates a new island (`cnt++`).
2. Check its 4 neighbors.
3. If a neighbor is land and belongs to a different component:
   * Merge using DSU.
   * Reduce island count (`cnt--`).
4. After every operation, store `cnt`.

Interview Explanation (30 seconds)

Every new land cell is considered a new island, so I increment the island count. Then I check all four neighbors. 
If a neighboring cell is already land and belongs to a different DSU component, I union them and decrement the 
island count because two islands have merged into one. To use DSU, I convert each grid cell (row, col) into a unique 
node number using row * m + col. This gives an efficient complexity of nearly O(k) for k operations due to path compression and union by size.

This makes the solution very efficient: **O(k × 4 × α(nm)) ≈ O(k)**, where `k` is the number of operators and `α` is the inverse Ackermann function (almost constant).
//
