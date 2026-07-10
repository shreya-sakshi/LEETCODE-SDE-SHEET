# Linked List Reversal Pattern

## Core Idea

Re-point `next` pointers using three references (prev, cur, next). Foundation for
reverse-in-groups, reorder, and palindrome checks.

---

## Recognition Questions

1. Reverse the whole list or a sublist?
2. Reverse in groups of k?
3. Reorder / check palindrome (needs reversed half)?

If YES -> reversal pattern.

## Green Flags

- "reverse linked list"
- "reverse nodes in k-group"
- "reorder list", "palindrome linked list"

---

## Templates

**Reverse (iterative)** — see master file.

**Reverse in k-Group**

```java
ListNode reverseKGroup(ListNode head, int k) {
    ListNode node = head;
    for (int i = 0; i < k; i++) {
        if (node == null) return head;   // fewer than k left -> keep as is
        node = node.next;
    }
    ListNode prev = reverseKGroup(node, k);   // reverse the rest first
    ListNode cur = head;
    for (int i = 0; i < k; i++) {
        ListNode next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
    }
    return prev;
}
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 206 | Reverse Linked List | Easy | https://leetcode.com/problems/reverse-linked-list/ |
| 92 | Reverse Linked List II | Medium | https://leetcode.com/problems/reverse-linked-list-ii/ |
| 25 | Reverse Nodes in k-Group | Hard | https://leetcode.com/problems/reverse-nodes-in-k-group/ |
| 234 | Palindrome Linked List | Easy | https://leetcode.com/problems/palindrome-linked-list/ |
| 143 | Reorder List | Medium | https://leetcode.com/problems/reorder-list/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Reverse Linked List | Amazon, Meta, Microsoft, Apple (near-universal) |
| Reorder List | Amazon, Meta, Google |
| Reverse Nodes in k-Group | Amazon, Meta, Google, Microsoft |

**FAANG focus:** Reverse Linked List is the classic warmup; Reverse Nodes in k-Group
(hard) and Reorder List are common follow-ups.
