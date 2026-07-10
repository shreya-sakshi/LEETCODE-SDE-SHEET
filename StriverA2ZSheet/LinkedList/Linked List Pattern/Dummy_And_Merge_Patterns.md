# Dummy Head & Merge Pattern

## Core Idea

A dummy (sentinel) head removes edge cases when the real head might change. A tail
pointer appends nodes cleanly. Used for merging, adding numbers, and node removal.

---

## Recognition Questions

1. Building/merging a new list where the head may change?
2. Add two numbers represented as lists?
3. Remove nodes / delete duplicates?

If YES -> dummy head.

## Green Flags

- "merge two sorted lists", "merge k sorted lists"
- "add two numbers"
- "remove duplicates / elements"

---

## Templates

**Merge Two Sorted Lists**

```java
ListNode dummy = new ListNode(0), tail = dummy;
while (a != null && b != null) {
    if (a.val <= b.val) { tail.next = a; a = a.next; }
    else               { tail.next = b; b = b.next; }
    tail = tail.next;
}
tail.next = (a != null) ? a : b;
return dummy.next;
```

**Add Two Numbers**

```java
ListNode dummy = new ListNode(0), tail = dummy;
int carry = 0;
while (a != null || b != null || carry != 0) {
    int sum = carry;
    if (a != null) { sum += a.val; a = a.next; }
    if (b != null) { sum += b.val; b = b.next; }
    carry = sum / 10;
    tail.next = new ListNode(sum % 10);
    tail = tail.next;
}
return dummy.next;
```

**Merge k Lists** — use a `PriorityQueue<ListNode>` by `val`, poll min, push its next.

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 21 | Merge Two Sorted Lists | Easy | https://leetcode.com/problems/merge-two-sorted-lists/ |
| 2 | Add Two Numbers | Medium | https://leetcode.com/problems/add-two-numbers/ |
| 23 | Merge k Sorted Lists | Hard | https://leetcode.com/problems/merge-k-sorted-lists/ |
| 203 | Remove Linked List Elements | Easy | https://leetcode.com/problems/remove-linked-list-elements/ |
| 138 | Copy List with Random Pointer | Medium | https://leetcode.com/problems/copy-list-with-random-pointer/ |
| 146 | LRU Cache | Medium | https://leetcode.com/problems/lru-cache/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Merge Two Sorted Lists | Amazon, Meta, Microsoft, Apple |
| Add Two Numbers | Amazon, Meta, Microsoft, Bloomberg |
| Merge k Sorted Lists | Amazon, Google, Meta, Uber |
| LRU Cache | Amazon, Meta, Google, Microsoft (extremely frequent) |
| Copy List with Random Pointer | Amazon, Meta, Microsoft |

**FAANG focus:** LRU Cache (hashmap + doubly linked list) and Merge k Sorted Lists are
top-tier; Copy List with Random Pointer is a common Amazon/Meta question.
