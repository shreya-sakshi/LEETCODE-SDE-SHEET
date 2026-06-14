package LinkedList;

public class DeleteMiddleNodeInLL {

    // ✅ Single Node class
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // ✅ Convert array to linked list
    public static Node convertArr2LL(int[] arr) {
        Node head = null;
        Node tail = null;

        for (int i = 0; i < arr.length; i++) {
            if (head == null) {
                head = new Node(arr[i]);
                tail = head;
            } else {
                tail.next = new Node(arr[i]);
                tail = tail.next;
            }
        }
        return head;
    }

    // ✅ Delete middle node (slow–fast pointer)
    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null)
            return null;

        Node slow = head;
        Node fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // delete middle
        slow.next = slow.next.next;

        return head;
    }

    // ✅ Print linked list
    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ✅ MAIN METHOD
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        Node head = convertArr2LL(arr);
        System.out.print("Original List: ");
        print(head);

        head = deleteMiddle(head);
        System.out.print("After Deleting Middle: ");
        print(head);
    }
}
