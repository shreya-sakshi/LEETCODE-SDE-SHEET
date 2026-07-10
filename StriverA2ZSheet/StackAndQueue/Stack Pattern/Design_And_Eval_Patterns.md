# Stack Design & Expression Evaluation Pattern

## Core Idea

Use auxiliary stacks to support O(1) queries (min-stack) or to evaluate expressions
in postfix/infix form.

---

## Recognition Questions

1. Design a stack with O(1) getMin/getMax?
2. Evaluate Reverse Polish Notation / basic calculator?
3. Implement queue using stacks (or vice versa)?

If YES -> design / evaluation stack.

## Green Flags

- "min stack", "get minimum in O(1)"
- "evaluate reverse polish notation"
- "basic calculator"

---

## Templates

**Min Stack (pair each value with current min)**

```java
Deque<int[]> st = new ArrayDeque<>();   // {value, minSoFar}
void push(int x) {
    int min = st.isEmpty() ? x : Math.min(x, st.peek()[1]);
    st.push(new int[]{x, min});
}
void pop() { st.pop(); }
int top() { return st.peek()[0]; }
int getMin() { return st.peek()[1]; }
```

**Evaluate RPN**

```java
Deque<Integer> st = new ArrayDeque<>();
for (String t : tokens) {
    switch (t) {
        case "+": st.push(st.pop() + st.pop()); break;
        case "*": st.push(st.pop() * st.pop()); break;
        case "-": { int b = st.pop(), a = st.pop(); st.push(a - b); } break;
        case "/": { int b = st.pop(), a = st.pop(); st.push(a / b); } break;
        default: st.push(Integer.parseInt(t));
    }
}
return st.pop();
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 155 | Min Stack | Medium | https://leetcode.com/problems/min-stack/ |
| 150 | Evaluate Reverse Polish Notation | Medium | https://leetcode.com/problems/evaluate-reverse-polish-notation/ |
| 232 | Implement Queue using Stacks | Easy | https://leetcode.com/problems/implement-queue-using-stacks/ |
| 224 | Basic Calculator | Hard | https://leetcode.com/problems/basic-calculator/ |
| 682 | Baseball Game | Easy | https://leetcode.com/problems/baseball-game/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Min Stack | Amazon, Meta, Google, Bloomberg |
| Evaluate Reverse Polish Notation | Amazon, LinkedIn, Meta |
| Basic Calculator | Google, Meta, Amazon |

**FAANG focus:** Min Stack is a very common design question; Basic Calculator (hard) is
a Google/Meta favorite for parsing with a stack.
