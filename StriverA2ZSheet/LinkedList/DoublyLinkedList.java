package LinkedList;
class Node
{
        int data;
        Node next;
        Node back;

        public Node(int data1, Node next1, Node back1) 
        {
            this.data = data1;
            this.next = next1;
            this.back = back1;
        }

        public Node(int data1)
        {
            this.data = data1;
            this.next = null;
            this.back = null;
        }

};
public class DoublyLinkedList {
    public static Node covertArr2DLL(int [] arr)
    {
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1;i<arr.length;i++)
        {
            Node temp = new Node(arr[i],null,prev);
            prev.next = temp;
            prev = temp;

        }
        return head;
    }

    public static Node DeleteHeadOfDLL(Node head)
    {
        if(head == null || head.next == null )
        {
            return null;
        }
        Node prev = head;
        head = head.next;

        head.back = null;
        prev.next = null;

        return head;
    }


    public static Node DeleteTailOfDLL(Node head)
    {
        if(head == null || head.next == null )
        {
            return null;
        }
        Node tail = head;

        while(tail.next != null)
        {
            tail= tail.next;
        }
        Node newtail = tail.back;
        newtail.next = null;
        tail.back = null;

        return head;
    }

    public static Node removekthelementinDDLL(Node head , int k)
    {
        if(head == null )
        {
            return null;
        }
        int cnt=0;
        Node kNode = head;
        while(kNode != null)
        {
            cnt++;
            if(cnt == k ) break;
            kNode = kNode.next;
        }
        Node prev = kNode.back;
        Node front = kNode.next;

        if(prev == null && front == null)
        {
            return null;
        }
        else if(prev == null)
        {
           return DeleteHeadOfDLL(head);
        }
        else if(front == null)
        {
            return DeleteTailOfDLL(head);
        }
        
        prev.next = front;
        front.back = prev;

        kNode.back = null;
        kNode.next = null;

        return head;


    }

    public static void deleteNode(Node temp)
    {
        Node prev = temp.back;
        Node front = temp.next;

        if(front == null)
        {
            prev.next = null;
            temp.back=null;

            return;
        }
        prev.next = front;
        front.back = prev;

        temp.next = temp.back = null;

    }

    public static Node insertbeforeHead(Node head, int val)
    {
        Node newHead = new Node(val,head,null);
        head.back = newHead;
         
        return newHead;
    }

    public static Node insertbeforeTail(Node head, int val)
    {

        if(head.next == null)
        {
            return insertbeforeHead(head, val);
        }

        Node tail = head;
        while(tail.next != null)
        {
            tail = tail.next;
        }

        Node prev = tail.back;
        Node newNode = new Node(val,tail,prev);
        prev.next = newNode;
        tail.back = newNode;

        return head;

    }

    public static Node insertBeforekthElement(Node head , int k , int val)
    {
        if(k==1)
        {
            return insertbeforeHead(head, val);
        }
        Node temp = head;
        int cnt =0;
        while(temp != null)
        {
            cnt++;
            if(cnt == k) break;
            temp = temp.next;

        }
        Node prev = temp.back;
        Node newNode = new Node(val,temp,prev);
        prev.next = newNode;
        temp.back = newNode;
        return head;

    }

    public static void print(Node head){
        while(head!=null)
        {
              System.out.print(head.data+" ");
              head=head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int [] arr = {12,5,8,7};

        Node head = covertArr2DLL(arr);
        // head = DeleteHeadOfDLL(head);
        // head = removekthelementinDDLL(head,3);
        // deleteNode(head.next.next);
        // head= insertbeforeHead(head, 2);
        head= insertbeforeTail(head, 4);
        head = insertBeforekthElement(head, 3, 100);
        // head = DeleteTailOfDLL(head);
        print(head);

    }
}
