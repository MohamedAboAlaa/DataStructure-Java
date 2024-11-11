public class DoubleEndedLinkedList {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int listLength = 0 ;

    public DoubleEndedLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        listLength += 1 ;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        listLength += 1 ;
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
        current.next = newNode;
        
        if (newNode.next == null) {
            tail = newNode;
        }
        listLength += 1 ;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        if (head == null) { 
            tail = null;
        }
        listLength -= 1 ;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) { 
            head = tail = null;
            return;
        }

        Node current = head;
        while (current.next != tail) { 
            current = current.next;
        }
        current.next = null;
        tail = current;
        listLength -= 1 ;
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
        for (int i = 0; i < position - 1; i++) {
            if (current == null || current.next == null) {
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
            current = current.next;
        }

        if (current.next == null) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }

        current.next = current.next.next;

        if (current.next == null) {
            tail = current;
        }
        listLength -= 1 ;
    }

    public void deleteList() {
        head = null;
        tail = null;
        listLength = 0 ;
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
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int getLength() {
        return listLength ;
    }

    public static void main(String[] args) {
        DoubleEndedLinkedList list = new DoubleEndedLinkedList();

        list.insertFirst(10);
        list.insertLast(20);
        list.insertLast(30);
        list.printList();  // 10 -> 20 -> 30 -> null

        list.insertPos(15, 1);
        list.printList();  // 10 -> 15 -> 20 -> 30 -> null

        System.out.println(list.searchItem(15));  // true
        System.out.println(list.searchItem(100)); // false

        list.deleteFirst();
        list.printList();  // 15 -> 20 -> 30 -> null
        list.deleteLast();
        list.printList();  // 15 -> 20 -> null

        list.deletePos(1);
        list.printList();  // 15 -> null

        System.out.println(list.getLength());
        list.deleteList();
        list.printList();  // List is empty.
        System.out.println(list.getLength());
    }
}