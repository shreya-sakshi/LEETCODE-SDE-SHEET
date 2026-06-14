package LinkedList;

public class ReverseLLInGroupOfGivenSizeK {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Reverse in K group
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) return head;

        ListNode temp = head;
        ListNode prevNode = null;

        while (temp != null) {

            // Step 1: Find kth node
            ListNode kthNode = findKthNode(temp, k);

            // If less than k nodes left → stop
            if (kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }

            // Step 2: Store next group start
            ListNode nextNode = kthNode.next;

            // Break connection
            kthNode.next = null;

            // Step 3: Reverse current group
            ListNode reversedHead = reverse(temp);

            // Step 4: Connect with previous part
            if (temp == head) {
                head = reversedHead;
            } else {
                prevNode.next = reversedHead;
            }

            // Step 5: Move pointers forward
            prevNode = temp;     // temp becomes tail after reverse
            temp = nextNode;     // move to next group
        }

        return head;
    }

    // Helper to find kth node from current position
    // private ListNode findKthNode(ListNode head, int k) {

    //     k = k - 1;

    //     while (head != null && k > 0) {
    //         head = head.next;
    //         k--;
    //     }

    //     return head;
    // }

     private ListNode findKthNode(ListNode head , int k )
    {
        int cnt =1;

        while(head!=null)
        {
            if(cnt == k) return head;
            cnt++;
            head = head.next;
        }
        return head;
    }

    // Standard reverse function
    private ListNode reverse(ListNode head) {

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    // Utility to print list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Test the implementation
    public static void main(String[] args) {

        ReverseLLInGroupOfGivenSizeK sol = new ReverseLLInGroupOfGivenSizeK();

        // Create list: 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        int k = 3;

        System.out.println("Original List:");
        printList(head);

        head = sol.reverseKGroup(head, k);

        System.out.println("After Reversing in K Group:");
        printList(head);
    }
}