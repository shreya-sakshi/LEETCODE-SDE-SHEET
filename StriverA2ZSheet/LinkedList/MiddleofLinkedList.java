package LinkedList;

public class MiddleofLinkedList 
{
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

 public static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null  && fast.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

        int [] arr = {12,5,6,8};

        Node head = covertArr2LL(arr);
        //insert at first
        // head = insertHead(head, 100);
        //insert at last
        head = middleNode(head);
        
        print(head);


    }


}