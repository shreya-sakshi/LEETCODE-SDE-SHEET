package LinkedList;
public class InsertkthelementinLL 
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

    public static Node insertk(Node head , int el , int k)
    {
        if(head == null)
        {
            if(k==1)
            {
                return new Node(el);
            }
            else{
                return head;
            }
        }
        if(k==1)
        {
            Node temp = new Node(el , head);
            return temp;

        }
        int cnt=0; 
        Node temp = head;

        while(temp != null)
        {
            cnt++;
            if(cnt == k-1)
            {
                // Node x = new Node(el);
                // x.next = temp.next;
                Node x = new Node(el, temp.next);
                temp.next = x;
                break;
            }
            temp=temp.next;
        }
        return head;
    }

    public static Node insertbeforevalue(Node head , int el , int val)
    {
        if(head == null)
        {
            return null;
        }
        if(head.data == val)
        {
            return new Node(el , head);
        }
        Node temp = head;

        while(temp.next != null)
        {
            if(temp.next.data == val)
            {
                // Node x = new Node(el);
                // x.next = temp.next;
                Node x = new Node(el, temp.next);
                temp.next = x;
                break;
            }
            temp=temp.next;
        }
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

    public static int lengthofLL(Node head)
    {
        int cnt= 0;
        Node temp = head;
        while(temp != null)
        {
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    public static int searchinLL(Node head, int val)
    {
         Node temp = head;
        while(temp != null)
        {
            if(temp.data == val) return 1;
            temp = temp.next;
        }
        return 0;
          
    }

    public static void main(String[] args) {

        int [] arr = {12,5,8,7};

        Node head = covertArr2LL(arr);
        head = insertk(head, 100,12);
        print(head);

        System.out.println(lengthofLL(head));

        System.out.println(searchinLL(head,5));

        //traverse in linkedlist
        // Node temp = head;
        // while(temp != null)
        // {
        //     System.out.print(temp.data+"->");
        //     temp = temp.next;
        // }


    }


}


