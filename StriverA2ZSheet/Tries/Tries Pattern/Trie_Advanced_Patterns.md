# Advanced Trie (Wildcard & Grid Search) Pattern

## Core Idea

Extend a Trie with wildcard matching (DFS over children on `.`) or drive a grid word
search from a Trie so all words are matched in one traversal.

---

## Recognition Questions

1. Search words with `.` wildcards?
2. Find ALL dictionary words present in a grid?
3. Need to prune search using shared prefixes?

If YES -> advanced Trie.

## Green Flags

- "add and search word", "wildcard '.'"
- "word search II" (grid + dictionary)

---

## Templates

**Word Dictionary with `.` (DFS)**

```java
boolean dfs(String word, int i, TrieNode node) {
    if (node == null) return false;
    if (i == word.length()) return node.isEnd;
    char c = word.charAt(i);
    if (c == '.') {
        for (TrieNode child : node.children)
            if (child != null && dfs(word, i + 1, child)) return true;
        return false;
    }
    return dfs(word, i + 1, node.children[c - 'a']);
}
```

**Word Search II (grid DFS guided by Trie)**

```java
// Build a Trie of all words, then DFS each cell; only continue down the grid
// while the current path exists in the Trie. Mark node.word when a word ends.
void dfs(char[][] board, int r, int c, TrieNode node, List<String> res) {
    char ch = board[r][c];
    if (ch == '#' || node.children[ch - 'a'] == null) return;
    node = node.children[ch - 'a'];
    if (node.word != null) { res.add(node.word); node.word = null; } // dedupe
    board[r][c] = '#';
    for (int[] d : new int[][]{{0,1},{0,-1},{1,0},{-1,0}}) {
        int nr = r + d[0], nc = c + d[1];
        if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length)
            dfs(board, nr, nc, node, res);
    }
    board[r][c] = ch;
}
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 211 | Design Add and Search Words Data Structure | Medium | https://leetcode.com/problems/design-add-and-search-words-data-structure/ |
| 212 | Word Search II | Hard | https://leetcode.com/problems/word-search-ii/ |
| 421 | Maximum XOR of Two Numbers in an Array | Medium | https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/ |
| 336 | Palindrome Pairs | Hard | https://leetcode.com/problems/palindrome-pairs/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Add and Search Words | Amazon, Meta, Google |
| Word Search II | Amazon, Google, Meta, Microsoft |
| Maximum XOR of Two Numbers | Amazon, Google (bitwise Trie) |

**FAANG focus:** Word Search II (Trie + backtracking) is the canonical hard Trie
question; Maximum XOR uses a binary Trie — a nice advanced twist.
