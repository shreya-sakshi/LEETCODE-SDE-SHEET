package LinkedList;

public  class RemoveNthNode {
    public static class ListNode 
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode covertArr2LL(int [] arr)
    {
        ListNode head = null;
        ListNode tail = null;
        for(int i=0;i<arr.length;i++)
        {
            if(head == null)
            {
                head = new ListNode(arr[i]);
                tail = head;
            }
            else
            {
                tail.next = new ListNode(arr[i]);
                tail = tail.next;
            }
        }
        return head;
    }

    public static  ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode fast = head;
        ListNode slow = head;

        for(int i = 0 ;i < n ; i ++)
        {
            fast = fast.next;
        }

        if(fast == null) return head.next;

        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode delNode = slow.next;
        slow.next = slow.next.next ;

        return head;
        
    }

    public static void print(ListNode head){
        ListNode temp = head;
        while(temp!=null)
        {
              System.out.print(temp.val+"->");
              temp=temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        int [] arr = {1,2,3,4,5};

        ListNode head = covertArr2LL(arr);
        //insert at first
        // head = insertHead(head, 100);
        //insert at last
        head = removeNthFromEnd(head, 2);
        
        print(head);


    }
    
}
