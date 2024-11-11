public class DoublyLinkedList {
    private static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertPos(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            insertFirst(data);
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
            current = current.next;
        }

        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) { 
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void deletePos(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (position == 0) {
            deleteFirst();
            return;
        }

        Node current = head;
        for (int i = 0; i < position; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
            current = current.next;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }
    }

    public void deleteList() {
        head = null;
        tail = null;
    }

    public boolean searchItem(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Insert elements at the beginning and end
        list.insertFirst(10);
        list.insertLast(20);
        list.insertLast(30);
        list.printList();  // 10 <-> 20 <-> 30 <-> null

        // Insert element at position 1
        list.insertPos(15, 1);
        list.printList();  // 10 <-> 15 <-> 20 <-> 30 <-> null

        // Search for an item
        System.out.println(list.searchItem(15));  // true
        System.out.println(list.searchItem(100)); // false

        // Delete the first and last elements
        list.deleteFirst();
        list.printList();  // 15 <-> 20 <-> 30 <-> null
        list.deleteLast();
        list.printList();  // 15 <-> 20 <-> null

        // Delete at a specific position
        list.deletePos(1);
        list.printList();  // 15 <-> null

        // Delete the entire list
        list.deleteList();
        list.printList();  // List is empty.
    }
}
