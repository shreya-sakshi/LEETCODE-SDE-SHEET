import java.io.*;
import java.util.*;

/*
 * ============================================================
 * DISJOINT SET (UNION-FIND) with PATH COMPRESSION + UNION BY RANK
 * ============================================================
 * Purpose: Efficiently answer two questions on a group of items:
 *   1) Are item A and item B in the same group?      -> findUPar()
 *   2) Merge the group containing A with the group
 *      containing B.                                 -> unionByRank()
 *
 * Real-world uses: friend circles / social networks,
 * detecting cycles in a graph, Kruskal's Minimum
 * Spanning Tree algorithm, network connectivity.
 * ============================================================
 */

class DisjointSet {

    // rank[i]   = an estimate of the "height" of the tree rooted at i
    //             (used to keep trees flat / balanced)
    // parent[i] = the parent pointer of node i
    //             (if parent[i] == i, then i is a ROOT / ultimate parent)
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    // ------------------------------------------------------------
    // CONSTRUCTOR: build n nodes, each in its OWN separate group
    // ------------------------------------------------------------
    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0);       // every node starts with rank 0
            parent.add(i);     // every node starts as its own parent (its own root)
        }
    }

    // ------------------------------------------------------------
    // FIND ULTIMATE PARENT (a.k.a. "find the root/leader of the group")
    // Uses PATH COMPRESSION: while climbing up to find the root,
    // rewire every visited node to point DIRECTLY at the root.
    // This makes future lookups much faster.
    // ------------------------------------------------------------
    public int findUPar(int node) {
        // Base case: if a node is its own parent, it IS the root
        if (node == parent.get(node)) {
            return node;
        }

        // Recursive case: climb up to find the real root
        int ulp = findUPar(parent.get(node));

        // PATH COMPRESSION: point this node directly at the root
        // so we don't have to climb the whole chain again next time
        parent.set(node, ulp);

        return parent.get(node);
    }

    // ------------------------------------------------------------
    // UNION BY RANK: merge the groups containing u and v
    // Always attach the SMALLER (lower-rank) tree under the
    // BIGGER (higher-rank) tree's root, to keep things flat.
    // ------------------------------------------------------------
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);   // root of u's group
        int ulp_v = findUPar(v);   // root of v's group

        // Already in the same group -> nothing to do
        if (ulp_u == ulp_v) return;

        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            // u's tree is shorter -> attach it under v's root
            parent.set(ulp_u, ulp_v);

        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            // v's tree is shorter -> attach it under u's root
            parent.set(ulp_v, ulp_u);

        } else {
            // Equal rank -> arbitrarily attach v's root under u's root
            parent.set(ulp_v, ulp_u);
            // ...and since u's tree just got taller, bump its rank
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }
}

// ================================================================
// MAIN CLASS: demo / test the DisjointSet above
// ================================================================
class Main {
    public static void main(String[] args) {

        // Create 7 nodes: 0,1,2,3,4,5,6 (each its own group initially)
        DisjointSet ds = new DisjointSet(7);

        // Build up some groups
        ds.unionByRank(1, 2);   // group: {1,2}
        ds.unionByRank(2, 3);   // group: {1,2,3}
        ds.unionByRank(4, 5);   // group: {4,5}
        ds.unionByRank(6, 7);   // group: {6,7}   (NOTE: 7 is out of bounds for n=7, see note below)
        ds.unionByRank(5, 6);   // group: {4,5,6,7}

        // Check: are 3 and 7 in the same group?
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");   // <-- this prints first (they're in different groups)
        }

        // Now merge the two groups together
        ds.unionByRank(3, 7);

        // Check again: are 3 and 7 in the same group NOW?
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");        // <-- this prints now (merged!)
        } else {
            System.out.println("Not Same");
        }
    }
}

/*
 * NOTE ON BOUNDS:
 * DisjointSet(7) creates valid node indices 0 through 6.
 * The demo code uses node "7", which is technically out of range
 * for a 0-indexed set of size 7. In practice, many people create
 * DisjointSet(n+1) when they want to use 1-indexed nodes 1..n.
 * Keep this in mind if you reuse this code with different sizes.
 */
