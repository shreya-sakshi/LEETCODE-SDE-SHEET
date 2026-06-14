package LinkedList;

public class RemoveKthElement 
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

    public static Node removek(Node head , int k)
    {
        if(head == null) return head;
        if(k==1)
        {
            Node temp = head;
            head = head.next;
            return head;
        }
        int cnt = 0;
        Node temp = head;
        Node prev = null;

        while ( temp != null)
        {
           cnt++;
           if(cnt == k)
           {
             prev.next = prev.next.next;
             break;
           }
           prev = temp;
           temp = temp.next ; 
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

    public static void main(String[] args) {

        int [] arr = {12,5,6,8};

        Node head = covertArr2LL(arr);
        head = removek(head, 1);
        print(head);


    }


}

