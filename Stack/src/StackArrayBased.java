public class StackArrayBased {

    private int maxSize = 0 ;
    private int[] stackArr ;
    private int top ;
    private int topElement ;
    private int poopedElement ;

    // Constructor
    public StackArrayBased(int size) {
        maxSize = size ;
        stackArr = new int[maxSize] ;
        top = -1 ;
    }

    // Stack is Empty
    public boolean isEmpty(){
        return top == -1 ;
    }

    // Stack is Full
    public boolean isFull(){
        return top == maxSize-1 ;
    }

    // Push Element
    public void push(int element){
        if( !isFull() ){
            top += 1 ;
            stackArr[top] = element ;
        }else{
            System.out.println("Stack is Full !");
        }
    }

    // Pop Top Element
    public void pop(){
        if( !isEmpty() ){
            poopedElement = stackArr[top] ;
            top -= 1 ;
        }else{
            poopedElement = -1 ;
            System.out.println("Stack is Empty !");
        }
    }
    
    // Top Element
    public int peekElement(){
        if( !isEmpty() ){
            topElement = stackArr[top] ;
        }else{
            topElement = -1 ;
            System.out.println("Stack is Empty !");
        }
        return topElement ;
    }
    // Delete Stack
    public void deleteStack() {
        stackArr = null; 
        top = -1;
        System.out.println("Stack is deleted.");
    }

    // Print Stack
    public void print() {
        if( !isEmpty() ){
            int curr = top ;
            System.out.println("-----------------");
            while( curr != -1 ){
                System.out.println("|\t" + stackArr[curr] + "\t|");
                curr -= 1 ;
            }
            System.out.println("-----------------");
        }else{
            System.out.println("Stack is Empty !");
        }
    }

    // Main Code
    public static void main(String[] args) throws Exception {
        StackArrayBased stack = new StackArrayBased(10);
        stack.pop();
        System.out.println(stack.poopedElement);
        stack.print();
        stack.push(10);
        stack.push(20);
        stack.push(40);
        stack.print();
        System.out.println(stack.peekElement());
        System.out.println(stack.poopedElement);
        stack.pop();
        System.out.println(stack.poopedElement);
    }
}
