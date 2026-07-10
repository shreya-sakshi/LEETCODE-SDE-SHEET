# Matrix Manipulation Pattern

## Core Idea

Transform a matrix in place using index math: transpose then reverse to rotate, walk
shrinking boundaries for spiral, and use marker rows/cols to avoid extra space.

---

## Recognition Questions

1. Rotate the image 90 degrees in place?
2. Return elements in spiral order?
3. Set entire row/column to zero on a hit?

If YES -> matrix manipulation.

## Green Flags

- "rotate image", "spiral order"
- "set matrix zeroes", "transpose"

---

## Templates

**Rotate 90° clockwise (transpose + reverse rows)**

```java
int n = m.length;
for (int i = 0; i < n; i++)                      // transpose
    for (int j = i + 1; j < n; j++) {
        int t = m[i][j]; m[i][j] = m[j][i]; m[j][i] = t;
    }
for (int i = 0; i < n; i++)                      // reverse each row
    for (int l = 0, r = n - 1; l < r; l++, r--) {
        int t = m[i][l]; m[i][l] = m[i][r]; m[i][r] = t;
    }
```

**Spiral Order (shrinking boundaries)**

```java
List<Integer> res = new ArrayList<>();
int top = 0, bottom = m.length - 1, left = 0, right = m[0].length - 1;
while (top <= bottom && left <= right) {
    for (int j = left; j <= right; j++) res.add(m[top][j]);      top++;
    for (int i = top; i <= bottom; i++) res.add(m[i][right]);    right--;
    if (top <= bottom) { for (int j = right; j >= left; j--) res.add(m[bottom][j]); bottom--; }
    if (left <= right) { for (int i = bottom; i >= top; i--) res.add(m[i][left]); left++; }
}
return res;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 48 | Rotate Image | Medium | https://leetcode.com/problems/rotate-image/ |
| 54 | Spiral Matrix | Medium | https://leetcode.com/problems/spiral-matrix/ |
| 73 | Set Matrix Zeroes | Medium | https://leetcode.com/problems/set-matrix-zeroes/ |
| 289 | Game of Life | Medium | https://leetcode.com/problems/game-of-life/ |
| 59 | Spiral Matrix II | Medium | https://leetcode.com/problems/spiral-matrix-ii/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Rotate Image | Amazon, Meta, Microsoft, Apple |
| Spiral Matrix | Amazon, Meta, Google, Microsoft |
| Set Matrix Zeroes | Amazon, Microsoft, Meta |
| Game of Life | Amazon, Google, Dropbox |

**FAANG focus:** Spiral Matrix and Rotate Image are very common; know the in-place O(1)
space trick for Set Matrix Zeroes.
