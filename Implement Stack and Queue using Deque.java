// Java program to implement stack and queue using Deque
public class DequeExample {

    // Class for a node of deque
    class DQueNode {
        int value;
        DQueNode next;
        DQueNode prev;
    }

    // Implementation of deque class
    class Deque {
        // Pointers to head and tail of deque
        private DQueNode head;
        private DQueNode tail;

        // Constructor
        public Deque() {
            head = tail = null;
        }

        // If list is empty
        boolean isEmpty() {
            return head == null;
        }

        // Count the number of nodes in list
        int size() {
            // If list is not empty
            if (!isEmpty()) {
                DQueNode temp = head;
                int len = 0;

                while (temp != null) {
                    len++;
                    temp = temp.next;
                }
                return len;
            }
            return 0;
        }

        // Insert at the first position
        void insertFirst(int element) {
            // Allocating a node of DQueNode type
            DQueNode temp = new DQueNode();
            temp.value = element;

            // If the element is the first element
            if (head == null) {
                head = tail = temp;
                temp.next = temp.prev = null;
            } else {
                head.prev = temp;
                temp.next = head;
                temp.prev = null;
                head = temp;
            }
        }

        // Insert at the last position of deque
        void insertLast(int element) {
            // Allocating a node of DQueNode type
            DQueNode temp = new DQueNode();
            temp.value = element;

            // If element is the first element
            if (head == null) {
                head = tail = temp;
                temp.next = temp.prev = null;
            } else {
                tail.next = temp;
                temp.next = null;
                temp.prev = tail;
                tail = temp;
            }
        }

        // Remove element at the first position
        void removeFirst() {
            // If list is not empty
            if (!isEmpty()) {
                DQueNode temp = head;
                head = head.next;
                head.prev = null;
            } else {
                System.out.print("List is Empty");
            }
        }

        // Remove element at the last position
        void removeLast() {
            // If list is not empty
            if (!isEmpty()) {
                DQueNode temp = tail;
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                }
            } else {
                System.out.print("List is Empty");
            }
        }

        // Displays the elements in deque
        void display() {
            // If list is not empty
            if (!isEmpty()) {
                DQueNode temp = head;
                while (temp != null) {
                    System.out.print(temp.value + " ");
                    temp = temp.next;
                }
            } else {
                System.out.print("List is Empty");
            }
        }
    }

    // Class to implement stack using Deque
    class Stack {
        Deque d = new Deque();

        // Push to push element at the top of stack
        // using insert at last function of deque
        public void push(int element) {
            d.insertLast(element);
        }

        // Returns size
        public int size() {
            return d.size();
        }

        // Pop to remove element at the top of stack
        // using remove at last function of deque
        public void pop() {
            d.removeLast();
        }

        // Display
        public void display() {
            d.display();
        }
    }

    // Class to implement queue using deque
    class Queue {
        Deque d = new Deque();

        // Enqueue to insert element at last
        // using insert at last function of deque
        public void enqueue(int element) {
            d.insertLast(element);
        }

        // Dequeue to remove element from the first
        // using remove at first function of deque
        public void dequeue() {
            d.removeFirst();
        }

        // Display
        public void display() {
            d.display();
        }

        // Size
        public int size() {
            return d.size();
        }
    }

    // Driver Code
    public static void main(String[] args) {
        DequeExample dequeExample = new DequeExample();

        // Object of Stack
        DequeExample.Stack stk = dequeExample.new Stack();

        // Push 7 and 8 at the top of stack
        stk.push(7);
        stk.push(8);
        System.out.print("Stack: ");
        stk.display();

        // For a new line
        System.out.println();

        // Pop an element
        stk.pop();
        System.out.print("Stack: ");
        stk.display();

        // For a new line
        System.out.println();

        // Object of Queue
        DequeExample.Queue que = dequeExample.new Queue();

        // Insert 12 and 13 in queue
        que.enqueue(12);
        que.enqueue(13);
        System.out.print("Queue: ");
        que.display();

        // New line
        System.out.println();

        // Delete an element from queue
        que.dequeue();
        System.out.print("Queue: ");
        que.display();

        // New line
        System.out.println();
        System.out.println("Size of stack is " +
                stk
