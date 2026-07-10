# Trie Implementation Pattern

## Core Idea

Store words character-by-character in a 26-way (or map) tree. Shared prefixes share
nodes, so prefix queries are O(length) regardless of dictionary size.

---

## Recognition Questions

1. Insert words and later query exact word / prefix?
2. Autocomplete / "startsWith"?
3. Many words, repeated prefix lookups?

If YES -> build a Trie.

## Green Flags

- "implement trie", "prefix tree"
- "starts with", "autocomplete"

---

## Template (Implement Trie 208)

```java
class Trie {
    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) return null;
            node = node.children[i];
        }
        return node;
    }
}
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 208 | Implement Trie (Prefix Tree) | Medium | https://leetcode.com/problems/implement-trie-prefix-tree/ |
| 1268 | Search Suggestions System | Medium | https://leetcode.com/problems/search-suggestions-system/ |
| 648 | Replace Words | Medium | https://leetcode.com/problems/replace-words/ |
| 720 | Longest Word in Dictionary | Medium | https://leetcode.com/problems/longest-word-in-dictionary/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Implement Trie | Amazon, Google, Microsoft, Meta |
| Search Suggestions System | Amazon (very frequent), Google |
| Replace Words | Amazon, Google |

**FAANG focus:** Search Suggestions System is a heavily-asked Amazon question built
directly on Trie + prefix traversal.
