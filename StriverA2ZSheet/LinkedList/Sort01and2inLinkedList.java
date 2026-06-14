package LinkedList;

public class Sort01and2inLinkedList {
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

    public static Node sortzeroonetwoinLL(Node head) {
        if(head == null || head.next == null)
        {
            return head;
        }

        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        Node temp = head;

        while(temp != null)
        {
            if(temp.data == 0)
            {
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data == 1)
            {
                one.next = temp;
                one = one.next;
            }
            else 
            {
                two.next = temp;
                two = two.next;
            }

            temp=temp.next;
        }

        zero.next= (oneHead.next != null)?(oneHead.next):(twoHead.next);
        one.next = (twoHead.next != null)?(twoHead.next): null;
        two.next = null;

        Node newHead = zeroHead.next;

        return newHead;

        
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

        int [] arr = {1,0,2,1,0,2,1};

        Node head = covertArr2LL(arr);
        //insert at first
        // head = insertHead(head, 100);
        //insert at last
        head = sortzeroonetwoinLL(head);
        
        print(head);


    }
}
