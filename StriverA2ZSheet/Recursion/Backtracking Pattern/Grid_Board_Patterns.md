# Grid / Board Backtracking Pattern

## Core Idea

Explore a grid or board by making a move, recursing, then undoing it. Prune the moment
a placement/path becomes invalid. Classic for word search and N-Queens.

---

## Recognition Questions

1. Search for a word/path across grid cells?
2. Place items on a board with constraints (queens, sudoku)?
3. Need to mark/unmark visited during exploration?

If YES -> grid/board backtracking.

## Green Flags

- "word search", "exist in grid"
- "N-Queens", "sudoku solver"

---

## Templates

**Word Search (DFS + backtrack)**

```java
boolean dfs(char[][] b, String w, int i, int j, int k) {
    if (k == w.length()) return true;
    if (i < 0 || j < 0 || i >= b.length || j >= b[0].length || b[i][j] != w.charAt(k))
        return false;
    char tmp = b[i][j];
    b[i][j] = '#';                       // mark visited
    boolean found = dfs(b, w, i+1, j, k+1) || dfs(b, w, i-1, j, k+1)
                 || dfs(b, w, i, j+1, k+1) || dfs(b, w, i, j-1, k+1);
    b[i][j] = tmp;                       // restore
    return found;
}
```

**N-Queens (column/diagonal sets)**

```java
void solve(int row, int n, Set<Integer> cols, Set<Integer> diag, Set<Integer> anti, ...) {
    if (row == n) { record(); return; }
    for (int col = 0; col < n; col++) {
        if (cols.contains(col) || diag.contains(row-col) || anti.contains(row+col)) continue;
        // choose
        cols.add(col); diag.add(row-col); anti.add(row+col);
        solve(row+1, n, cols, diag, anti, ...);
        // un-choose
        cols.remove(col); diag.remove(row-col); anti.remove(row+col);
    }
}
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 79 | Word Search | Medium | https://leetcode.com/problems/word-search/ |
| 212 | Word Search II | Hard | https://leetcode.com/problems/word-search-ii/ |
| 51 | N-Queens | Hard | https://leetcode.com/problems/n-queens/ |
| 37 | Sudoku Solver | Hard | https://leetcode.com/problems/sudoku-solver/ |
| 22 | Generate Parentheses | Medium | https://leetcode.com/problems/generate-parentheses/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Word Search | Amazon, Meta, Microsoft, Bloomberg |
| Word Search II | Amazon, Google, Meta (Trie + backtracking) |
| N-Queens | Amazon, Google, Adobe |
| Generate Parentheses | Amazon, Meta, Google, Uber |

**FAANG focus:** Word Search and Generate Parentheses are common; Word Search II pairs
backtracking with a Trie (see the Tries notes).
