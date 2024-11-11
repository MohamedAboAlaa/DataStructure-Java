public class StackLinkedListBased {

    // Node class
    private class Node {
        int data;    
        Node next; 
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top ;
    private Node topElement ;
    private Node poopedElement ;

    // Constructor
    public StackLinkedListBased() {
        top = null ;
    }

    // Stack is Empty
    public boolean isEmpty(){
        return top == null ;
    }

    // Push Element
    public void push(int eleData){
        Node newNode = new Node(eleData);
        newNode.next = top ;
        top = newNode ;
    }

    // Pop Top Element
    public void pop(){
        if( !isEmpty() ){
            poopedElement = top ;
            top = top.next ;
            System.out.println("Popped Element : " + poopedElement.data);
        }else{
            poopedElement = null ;
            System.out.println("Stack is Empty !");
        }
    }
    
    // Top Element
    public void peekElement(){
        if( !isEmpty() ){
            topElement = top ;
            System.out.println("Top Element : " + topElement.data);
        }else{
            topElement = null ;
            System.out.println("Stack is Empty !");
        }
    }
    // Delete Stack
    public void deleteStack() {
        top = null;
        System.out.println("Stack is deleted.");
    }

    // Print Stack
    public void print() {
        if( !isEmpty() ){
            Node curr = new Node(0) ;
            curr = top ;
            System.out.println("-----------------");
            while( curr != null ){
                System.out.println("|\t" + curr.data + "\t|");
                curr = curr.next  ;
            }
            System.out.println("-----------------");
        }else{
            System.out.println("Stack is Empty !");
        }
    }

    // Main Code
    public static void main(String[] args) throws Exception {
        StackLinkedListBased stack = new StackLinkedListBased();
        stack.peekElement();
        stack.push(10);
        stack.push(30);
        stack.push(40);
        stack.push(70);
        stack.print();
        stack.pop();
        stack.push(80);
        stack.print();
        stack.deleteStack();
        stack.print();
    }
}
