package linear_ds.java;

// Node class
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        next = null;
    }
}
	// Method class
class Methods {
    static Node head = null;
    static int count = 0;
    // Insert at beginning
    public static void insertAtBeg(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        count++;
    }
    // Insert at end
    public static void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        count++;
    }
    // Insert at specific position (1-based)
    public static void insertAtPosition(int data, int position) {
        if (position < 1 || position > count + 1) {
            System.out.println("Invalid position. Current list size: " + count);
            return;
        }

        if (position == 1) {
            insertAtBeg(data);
            return;
        }
        if (position == count + 1) {
            insertAtEnd(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        count++;
    }
    // Display list
    public static void display() {
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
        System.out.println("List length: " + count);
    }
}
// Main class
public class SingleLinkedList extends Methods {
    public static void main(String[] args) {
        insertAtBeg(50);
        insertAtBeg(40);
        insertAtBeg(30);
        insertAtBeg(20);
        insertAtBeg(10);
        display();
        insertAtPosition(5, 1);
        insertAtPosition(15, 3);
        insertAtPosition(60, 8);
        display();
    }

}


