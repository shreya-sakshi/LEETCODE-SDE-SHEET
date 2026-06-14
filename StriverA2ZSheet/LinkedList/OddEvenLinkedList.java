package LinkedList;

public class OddEvenLinkedList {
    public static class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) 
        {
            this.data = data;
            this.next = next;
        }
    }
    public static Node covertArr2LL(int [] arr)
    {
        Node head = null;
        Node tail = null;
        for(int i=0;i<arr.length;i++)
        {
            if(head == null)
            {
                head = new Node(arr[i]);
                tail = head;
            }
            else
            {
                tail.next = new Node(arr[i]);
                tail = tail.next;
            }
        }
        return head;
    }
    
    public static Node oddEvenList(Node head) {
        if(head == null || head.next == null ) return head;
        Node odd = head;
        Node even = head.next;
        Node evenhead=head.next;

        while(even != null && even.next != null )
        {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even=even.next;
        }
        odd.next = evenhead;

        return head;
    }

    public static void print(Node head){
        Node temp = head;
        while(temp!=null)
        {
              System.out.print(temp.data+"->");
              temp=temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        int [] arr = {1,2,3,4,5};

        Node head = covertArr2LL(arr);
        //insert at first
        // head = insertHead(head, 100);
        //insert at last
        head = oddEvenList(head);
        
        print(head);


    }
}
