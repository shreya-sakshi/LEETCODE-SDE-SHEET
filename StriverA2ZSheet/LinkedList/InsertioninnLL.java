package LinkedList;
public class InsertioninnLL 
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

    public static Node insertHead(Node head , int val)
    {
        if(head == null)
        {
            return new Node(val);
        }
        else
        {
            return new Node(val,head);
        }
        // Node temp = new Node(val ,head);
        // return temp;
    }

    public static Node insertTail(Node head , int val)
    {
        if(head == null)
        {
            return new Node(val);
        }
        Node temp = head;
        while(temp.next != null)
        {
            temp=temp.next;
        }

        Node newNode = new Node(val);
        temp.next = newNode;

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

        int [] arr = {12,5,6,8};

        Node head = covertArr2LL(arr);
        //insert at first
        // head = insertHead(head, 100);
        //insert at last
        head = insertTail(head, 10);
        print(head);


    }


}


