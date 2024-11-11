public class LinkedList {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
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
        current.next = newNode;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
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

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
    }

    public void deleteList() {
        head = null;
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

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertFirst(10);
        list.insertFirst(20);
        list.insertLast(30);
        list.insertPos(25, 2);
        list.printList();  // 20 -> 10 -> 25 -> 30 -> null

        list.deletePos(2);
        list.printList();  // 20 -> 10 -> 30 -> null

        list.deletePos(0);
        list.printList();  // 10 -> 30 -> null

        list.deletePos(1);
        list.printList();  // 10 -> null
    }
}
