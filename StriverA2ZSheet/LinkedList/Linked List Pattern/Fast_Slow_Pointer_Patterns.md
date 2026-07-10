# Fast & Slow Pointer (Floyd) Pattern

## Core Idea

Two pointers moving at different speeds. Fast moves 2x; when it reaches the end, slow
is at the middle. If there's a cycle, they meet inside it.

---

## Recognition Questions

1. Detect a cycle? Find where it starts?
2. Find the middle node in one pass?
3. Find nth node from the end?

If YES -> fast/slow pointers.

## Green Flags

- "cycle", "loop", "does it repeat"
- "middle of the linked list"
- "nth node from end"

---

## Templates

**Cycle Detection + Entry Point**

```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow == fast) {                 // cycle found
        ListNode p = head;
        while (p != slow) { p = p.next; slow = slow.next; }
        return p;                       // cycle start
    }
}
return null;                            // no cycle
```

**Find Middle**

```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
return slow;                            // middle (2nd of two for even length)
```

**Remove Nth From End (gap of n)**

```java
ListNode dummy = new ListNode(0); dummy.next = head;
ListNode fast = dummy, slow = dummy;
for (int i = 0; i < n; i++) fast = fast.next;
while (fast.next != null) { fast = fast.next; slow = slow.next; }
slow.next = slow.next.next;
return dummy.next;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 141 | Linked List Cycle | Easy | https://leetcode.com/problems/linked-list-cycle/ |
| 142 | Linked List Cycle II | Medium | https://leetcode.com/problems/linked-list-cycle-ii/ |
| 876 | Middle of the Linked List | Easy | https://leetcode.com/problems/middle-of-the-linked-list/ |
| 19 | Remove Nth Node From End of List | Medium | https://leetcode.com/problems/remove-nth-node-from-end-of-list/ |
| 287 | Find the Duplicate Number | Medium | https://leetcode.com/problems/find-the-duplicate-number/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Linked List Cycle | Amazon, Meta, Microsoft, Bloomberg |
| Remove Nth Node From End | Amazon, Meta, Google |
| Find the Duplicate Number | Amazon, Google, Meta (Floyd on array) |

**FAANG focus:** Cycle detection and Find the Duplicate Number (Floyd applied to an array)
are common; know why the "reset one pointer to head" step finds the cycle start.
