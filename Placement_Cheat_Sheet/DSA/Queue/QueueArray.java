package DSA.Queue;

public class QueueArray {
    private int arr[];
    private int front, rear, count, maxSize;

    public QueueArray() {
        this(16); 
    }

    public QueueArray(int maxSize) {
        arr = new int[maxSize];
        front = 0;
        rear = 0;
        count = 0;
        this.maxSize = maxSize;
    }

    
    public void push(int data) {
        if (count == maxSize) {
            throw new IllegalStateException("Queue is full");
        }
        arr[rear] = data; 
        rear = (rear + 1) % maxSize;
        count++;
        if (front == -1) { 
            front = 0;
        }
    }

   
    public int pop() {
        if (count == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        int x = arr[front]; 
        front = (front + 1) % maxSize; 
        count--;
        return x;
    }

   
    public int top() {
        if (count == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return arr[front]; 
    }

    
    public int size() {
        return count; 
    }

    public static void main(String[] args) {
        QueueArray qa = new QueueArray();
        qa.push(12);
        qa.push(13);
        qa.push(14);
        System.out.println(qa.pop()); 
        System.out.println(qa.top());    
        System.out.println(qa.size());   
    }
}
