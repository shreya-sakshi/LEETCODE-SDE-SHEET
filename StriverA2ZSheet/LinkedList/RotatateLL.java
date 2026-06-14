package LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RotatateLL {

    public class ListNode
    {
        int data;
        ListNode next;

        public ListNode(int data)
        {
            this.data = data;
            this.next = null;
        }

        public ListNode(int data, ListNode next) 
        {
            this.data = data;
            this.next = next;
        }
    }
    public ListNode rotateLL(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode tail = head; 
        int len =1;
        while(tail.next != null)
        {
            tail = tail.next;
            len++;
        }

        if(k % len == 0) return head;

        k = k % len ;
        tail.next = head ;

        ListNode newLastNode = finLastNode( head , len-k );

         head = newLastNode.next;
         newLastNode.next = null;

         return head;
        
    }

    private ListNode finLastNode(ListNode temp , int k )
    {
        int cnt =1;

        while(temp!=null)
        {
            if(cnt == k) return temp;
            cnt++;
            temp = temp.next;
        }
        return temp;
    }
}
