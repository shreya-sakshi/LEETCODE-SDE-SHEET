# Monotonic Stack Pattern

## Core Idea

Keep the stack increasing or decreasing. When the incoming element breaks the order,
pop — each popped element just found its "next greater/smaller". Amortised O(n).

---

## Recognition Questions

1. Need next/previous greater or smaller element?
2. "How many days until warmer", "stock span"?
3. Largest rectangle / trapping using boundaries?

If YES -> monotonic stack.

## Green Flags

- "next greater element", "daily temperatures"
- "largest rectangle in histogram"
- "stock span"

---

## Templates

**Daily Temperatures (indices, decreasing stack)**

```java
int[] res = new int[T.length];
Deque<Integer> st = new ArrayDeque<>();      // indices, temps decreasing
for (int i = 0; i < T.length; i++) {
    while (!st.isEmpty() && T[i] > T[st.peek()]) {
        int j = st.pop();
        res[j] = i - j;                       // days until warmer
    }
    st.push(i);
}
return res;
```

**Largest Rectangle in Histogram**

```java
Deque<Integer> st = new ArrayDeque<>();
int best = 0, n = h.length;
for (int i = 0; i <= n; i++) {
    int cur = (i == n) ? 0 : h[i];
    while (!st.isEmpty() && h[st.peek()] >= cur) {
        int height = h[st.pop()];
        int width = st.isEmpty() ? i : i - st.peek() - 1;
        best = Math.max(best, height * width);
    }
    st.push(i);
}
return best;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 739 | Daily Temperatures | Medium | https://leetcode.com/problems/daily-temperatures/ |
| 496 | Next Greater Element I | Easy | https://leetcode.com/problems/next-greater-element-i/ |
| 503 | Next Greater Element II | Medium | https://leetcode.com/problems/next-greater-element-ii/ |
| 84 | Largest Rectangle in Histogram | Hard | https://leetcode.com/problems/largest-rectangle-in-histogram/ |
| 85 | Maximal Rectangle | Hard | https://leetcode.com/problems/maximal-rectangle/ |
| 901 | Online Stock Span | Medium | https://leetcode.com/problems/online-stock-span/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Daily Temperatures | Amazon, Meta, Google |
| Largest Rectangle in Histogram | Amazon, Google, Meta, Microsoft |
| Next Greater Element II | Amazon, Bloomberg |

**FAANG focus:** Largest Rectangle in Histogram (hard) is a top monotonic-stack test;
Daily Temperatures is the standard medium warmup.
