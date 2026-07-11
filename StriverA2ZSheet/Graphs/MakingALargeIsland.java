import java.util.*;

class Solution {

    public int largestIsland(int[][] grid) {

        // Grid size
        int n = grid.length;

        // DSU for all cells
        // Total nodes = n*n
        DisjointSet ds = new DisjointSet(n * n);

        // Directions
        int[] dr = {-1, 0, 1, 0}; // Up Left Down Right
        int[] dc = {0, -1, 0, 1};

        // ==================================================
        // STEP 1 : CONNECT ALL EXISTING ISLANDS
        // ==================================================

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {

                // Ignore water
                if (grid[row][col] == 0)
                    continue;

                // Check all 4 directions
                for (int i = 0; i < 4; i++) {

                    int newr = row + dr[i];
                    int newc = col + dc[i];

                    // If neighbour is valid and land
                    if (isValid(newr, newc, n)
                            && grid[newr][newc] == 1) {

                        // Convert cell into DSU node
                        int nodeNo = row * n + col;

                        // Convert neighbour into DSU node
                        int adjNodeNo = newr * n + newc;

                        // Merge both islands
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        // Stores answer
        int mx = 0;

        // ==================================================
        // STEP 2 : TRY CHANGING EVERY 0 INTO 1
        // ==================================================

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {

                // Ignore land cells
                if (grid[row][col] == 1)
                    continue;

                // Stores unique neighbouring islands
                HashSet<Integer> components = new HashSet<>();

                // Check all 4 neighbours
                for (int i = 0; i < 4; i++) {

                    int newr = row + dr[i];
                    int newc = col + dc[i];

                    if (isValid(newr, newc, n)
                            && grid[newr][newc] == 1) {

                        // Get parent of neighbouring island
                        int parent =
                                ds.findUPar(newr * n + newc);

                        components.add(parent);
                    }
                }

                int sizeTotal = 0;

                // Add sizes of all unique islands
                for (Integer parent : components) {
                    sizeTotal += ds.size.get(parent);
                }

                // +1 because current 0 becomes 1
                mx = Math.max(mx, sizeTotal + 1);
            }
        }

        // ==================================================
        // STEP 3 : HANDLE ALL-1s CASE
        // ==================================================

        for (int cellNo = 0; cellNo < n * n; cellNo++) {

            mx = Math.max(
                    mx,
                    ds.size.get(
                            ds.findUPar(cellNo)
                    )
            );
        }

        return mx;
    }

    // Check boundary
    boolean isValid(int row, int col, int n) {

        return row >= 0
                && row < n
                && col >= 0
                && col < n;
    }
}


// ==================================================
// DISJOINT SET
// ==================================================
class DisjointSet {

    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {

        for (int i = 0; i < n; i++) {

            // Initially everyone is its own parent

            parent.add(i);

            // Every component size = 1

            size.add(1);
        }
    }

    // Find Ultimate Parent
    public int findUPar(int node) {

        // Root node found

        if (node == parent.get(node))
            return node;

        // Path Compression

        int ulp =
                findUPar(parent.get(node));

        parent.set(node, ulp);

        return parent.get(node);
    }

    // Union By Size
    public void unionBySize(int u, int v) {

        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        // Already in same component

        if (ulp_u == ulp_v)
            return;

        // Attach smaller tree below larger tree

        if (size.get(ulp_u) < size.get(ulp_v)) {

            parent.set(ulp_u, ulp_v);

            size.set(
                    ulp_v,
                    size.get(ulp_u)
                            + size.get(ulp_v)
            );

        } else {

            parent.set(ulp_v, ulp_u);

            size.set(
                    ulp_u,
                    size.get(ulp_u)
                            + size.get(ulp_v)
            );
        }
    }
}

-----------------------------------------------------------------------------------------------------------------------------------------------------------------

  This code is solving the "Making A Large Island" problem using a Disjoint Set (Union-Find) data structure.
High-Level Idea
Given an n x n grid containing 0s and 1s:

1 = land
0 = water

You can change at most one 0 into 1.
Goal: find the largest possible island size after the change.

Step 1: Build Connected Components of Existing Islands
Javaint n = grid.length;DisjointSet ds = new DisjointSet(n * n);Show more lines

Get the grid size.
Create a Union-Find structure having n*n nodes.
Every cell is treated as a node.

Mapping Formula
JavanodeNo = row * n + colShow more lines
Example for a 3×3 grid:
0 1 2
3 4 5
6 7 8


Outer Traversal
Javafor(int row = 0; row < n; row++) {    for(int col = 0; col < n; col++) {Show more lines
Visit every cell.

Skip Water Cells
Javaif(grid[row][col] == 0) continue;Show more lines
Only land cells participate in island formation.

Direction Arrays
Javaint dr[] = {-1, 0, 1, 0};int dc[] = {0, -1, 0, 1};Show more lines
Represent:
Up    (-1, 0)
Left  (0, -1)
Down  (1, 0)
Right (0, 1)


Visit All 4 Neighbors
Javafor(int ind = 0; ind < 4; ind++) {Show more lines
Loop through the four directions.

Compute Neighbor Coordinates
Javaint newr = row + dr[ind];int newc = col + dc[ind];Show more lines
Example:
row=2,col=3

UP => (1,3)
LEFT => (2,2)
DOWN => (3,3)
RIGHT => (2,4)


Check Bounds + Land
Javaif(isValid(newr, newc, n) && grid[newr][newc] == 1) {Show more lines
Ensure:

Neighbor lies inside grid.
Neighbor is land.


Convert Cells to Node Numbers
Javaint nodeNo = row * n + col;int adjNodeNo = newr * n + newc;Show more lines
Example:
For 4×4 grid:
(1,2) -> 1*4+2 = 6
(1,3) -> 1*4+3 = 7


Union the Two Land Cells
Javads.unionBySize(nodeNo, adjNodeNo);Show more lines
Merge both cells into the same connected component (same island).
After Step-1, every island has:

One ultimate parent.
A stored size.


Step 2: Try Converting Every 0 to 1
Javaint mx = 0;Show more lines
Stores maximum island size found.

Traverse Again
Javafor(int row = 0; row < n; row++) {    for(int col = 0; col < n; col++) {Show more lines
Check every cell.

Skip Existing Land
Javaif(grid[row][col] == 1) continue;Show more lines
Only interested in water cells because those are candidates for conversion.

Prepare Directions
Javaint dr[] = {-1, 0, 1, 0};int dc[] = {0, -1, 0, 1};Show more lines
Again look at four neighbors.

Store Unique Neighbor Components
JavaHashSet<Integer> components = new HashSet<>();Show more lines
Why HashSet?
Imagine:
1 1
1 0

The 0 touches the same island from multiple sides.
Without HashSet:
size + size + size

would overcount.
HashSet keeps unique parents only.

Check Four Neighbors
Javafor(int ind = 0; ind < 4; ind++) {Show more lines

Get Neighbor Position
Javaint newr = row + dr[ind];int newc = col + dc[ind];Show more lines

Valid Neighbor?
Javaif(isValid(newr, newc, n)) {Show more lines
Stay within bounds.

If Neighbor Is Land
Javaif(grid[newr][newc] == 1) {Show more lines
We can connect to that island.

Find Ultimate Parent
Javacomponents.add(    ds.findUPar(newr * n + newc));Show more lines
Store the island representative.
Example:
Island A size=5
Island B size=3

store:
{parentA,parentB}


Sum Sizes of Unique Islands
Javaint sizeTotal = 0;Show more lines

Javafor(Integer parents : components) {    sizeTotal += ds.size.get(parents);}Show more lines
Suppose:
Island A size = 4
Island B size = 3
Island C size = 2

Then:
sizeTotal = 4 + 3 + 2 = 9


Add Current Cell
Javamx = Math.max(mx, sizeTotal + 1);Show more lines
The +1 is for converting the current 0 into 1.
Example:
4 + 3 + 2 + 1 = 10

Update maximum.

Final Edge Case
What if grid already contains only 1s?
Example:
1 1
1 1

Then Step-2 never updates properly because there is no 0.

Handle That
Javafor(int cellNo = 0; cellNo < n * n; cellNo++) {Show more lines
Check every node.

Get Component Size
Javamx = Math.max(        mx,        ds.size.get(ds.findUPar(cellNo))     );Show more lines
Find the largest existing island size.
For the above example:
size = 4
mx = 4


Return Answer
Javareturn mx;Show more lines
Return the largest possible island size.

Example Walkthrough
Grid:
Plain Text1 00 1Show more lines
After Step-1:
Island A = size 1
Island B = size 1

Checking (0,1):
Neighbors:
left  -> Island A
down  -> Island B

sizeTotal = 1 + 1 = 2
+ current cell = 3

Result:
Plain Text1 10 1Show more lines
Largest island size = 3

Time Complexity
Step 1 (Union):
Plain TextO(n² * 4) Show more lines
Step 2 (Check every 0):
Plain TextO(n² * 4) Show more lines
Union-Find operations are nearly constant:
Plain TextO(α(n))Show more lines
So overall:
Plain TextTime  : O(n²)Space : O(n²)Show more lines
This is why Union-Find is used—it efficiently tracks island sizes and lets us quickly determine the size obtained by flipping any 0 to 1.
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Revision in One Sentence
Build islands using DSU where eaxh island is 1→ For each 0 collect unique neighboring island parents → Sum their sizes + 1 → Take maximum → Handle all 1 grid using the final loop.
