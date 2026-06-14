package LinkedList;
 /// Definition for singly-linked list.
 class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

 public class Solution{
    public ListNode reverseList(ListNode head) {
          ListNode temp = head ;
          ListNode prev = null;

          while(temp!= null)
          {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
          }

          return prev;
        
    }
 }
}