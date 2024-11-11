
# Stack Data Structure Concept

A **Stack** is a linear data structure that follows the Last In, First Out (LIFO) principle, meaning the last element added to the stack is the first one to be removed. It can be visualized as a stack of plates where you can only add or remove plates from the top.

Stacks are essential in many computer science applications due to their simplicity and efficiency. They are used in scenarios where the order of operations needs to be preserved, such as in function calls, expression evaluation, and many other recursive problems.
## Types of Stack Data Structures

### 1. **Stack Based on Array**
![image](https://github.com/user-attachments/assets/d3a2ee3b-39f6-442f-bb4d-4b953d80ea78)


In an array-based stack, the elements are stored in a contiguous block of memory, and the stack operations (push, pop) work with indices of the array. This implementation provides constant time complexity, O(1), for both push and pop operations, but it is limited by the size of the array.

In a singly linked list, traversal is only possible in one direction, from the head (first node) to the tail (last node).

### 2. **Stack Based on Linked List**
![image](https://github.com/user-attachments/assets/70df9542-d5f1-4859-a7dc-9027ab31180d)


A linked-list-based stack, unlike an array-based stack, uses a dynamic structure where each element (node) is linked to the next. The stack operations are performed at the top of the list (head of the list in a singly linked list). This approach allows for dynamic memory allocation, as the stack grows or shrinks as needed.

---

## Operations on Stack

The primary operations on a stack include:

- **Push**: Adds an element to the top of the stack. In array-based stacks, this is done by incrementing the top index, while in linked list-based stacks, a new node is added to the head.
- **Pop**: Removes the top element from the stack. In an array-based stack, the top element is replaced by the next element. In a linked list, the head node is removed and the next node becomes the top.
- **Delete**: Deletes the entire stack, freeing up any memory used. This is an optional operation depending on the implementation.

These operations provide flexibility and efficiency for various algorithms and tasks in programming.

---

## Stack Usage in Real Life and Software

Stacks are used in many real-world applications, including:

### 1. **Expression Evaluation**
Stacks are used to evaluate arithmetic expressions in postfix or prefix notation. They help store intermediate results while traversing the expression.

### 2. **Undo/Redo Mechanisms**
In software applications like text editors, stacks are used to keep track of operations so that users can undo or redo their actions.

### 3. **Function Call Management**
In programming, the call stack keeps track of function calls. When a function is called, it is added to the stack, and when it completes, it is popped off.

### 4. **Depth-First Search (DFS) in Graphs**
Stacks are used in graph traversal algorithms like DFS to keep track of nodes that need to be explored next.

### 5. **Routing Algorithms in Networking**
In computer networks, linked lists are used to manage routing tables. Routers often maintain lists of possible routes, and these lists are dynamically updated as the network topology changes.

### 6. **Backtracking Algorithms**
Many problems, such as solving mazes or puzzles, require backtracking, which can be efficiently implemented using stacks to remember the steps taken.

---

## Code Implementation and Demo

This repository provides two different implementations of stacks: one based on arrays and the other based on linked lists.

The following sections describe the implementation and usage of each stack type.

---

## 1. Stack Based on Array (StackArrayBased.java)

This implementation uses an array to store stack elements. The main operations (push, pop, peek, etc.) are carried out using indices.

### Example Usage:
```java
StackArrayBased stack1 = new StackArrayBased(10);
stack1.push(10);
stack1.push(20);
stack1.print();
stack1.pop();
stack1.print();
```

---

## 2. Stack Based on Linked List (StackLinkedListBased.java)

This implementation uses a linked list to store stack elements. Each element is a node containing data and a reference to the next node.

### Example Usage:
```java
StackLinkedListBased stack2 = new StackLinkedListBased();
stack2.push(10);
stack2.push(30);
stack2.print();
stack2.pop();
stack2.print();
```

---

## Conclusion

Stacks are a versatile and fundamental data structure used across a wide range of applications in computer science. The two common implementations, based on arrays and linked lists, each have their strengths: array-based stacks are efficient in terms of access speed and memory usage, while linked-list-based stacks offer dynamic sizing and flexibility.

By understanding the stack data structure and its applications, you can design efficient algorithms for problems involving recursion, backtracking, and expression evaluation.

---
## Clone the Repository and Access the LinkedList Directory

You can clone the entire repository and access the `Stack` directory by following these steps:

1. **Clone the Repository**:
   Open your terminal or command prompt and run the following command to clone the entire repository:

   ```bash
   git clone https://github.com/MohamedAboAlaa/DataStructure-Java.git
2. **Navigate to the Stack Directory**:
   ```bash
   cd DataStructure-Java/Stack
