# Heap Scheduling & Merge Pattern

## Core Idea

Use a heap to always pull the next item by priority: merge K sorted streams, schedule
tasks by frequency/deadline, or simulate processing order.

---

## Recognition Questions

1. Merge K sorted lists/arrays?
2. Schedule tasks with cooldown / by frequency?
3. Repeatedly pick the current best/most-frequent?

If YES -> heap-driven scheduling/merge.

## Green Flags

- "merge k sorted lists"
- "task scheduler", "reorganize string"
- "minimum cost to connect / meeting rooms II"

---

## Templates

**Merge K Sorted Lists**

```java
PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
for (ListNode l : lists) if (l != null) pq.offer(l);
ListNode dummy = new ListNode(0), tail = dummy;
while (!pq.isEmpty()) {
    ListNode n = pq.poll();
    tail.next = n; tail = n;
    if (n.next != null) pq.offer(n.next);
}
return dummy.next;
```

**Task Scheduler (greedy with counts)** — put highest-frequency task first, fill
cooldown gaps with next-frequent tasks (max-heap of counts).

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 23 | Merge k Sorted Lists | Hard | https://leetcode.com/problems/merge-k-sorted-lists/ |
| 621 | Task Scheduler | Medium | https://leetcode.com/problems/task-scheduler/ |
| 355 | Design Twitter | Medium | https://leetcode.com/problems/design-twitter/ |
| 767 | Reorganize String | Medium | https://leetcode.com/problems/reorganize-string/ |
| 1046 | Last Stone Weight | Easy | https://leetcode.com/problems/last-stone-weight/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Merge k Sorted Lists | Amazon, Google, Meta, Uber |
| Task Scheduler | Amazon (very frequent), Meta, Google |
| Design Twitter | Amazon, Twitter, Meta |
| Reorganize String | Amazon, Google, Meta |

**FAANG focus:** Task Scheduler is a heavily-asked Amazon greedy+heap problem; Merge k
Sorted Lists is a universal hard.
