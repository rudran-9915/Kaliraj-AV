package DSA.Queue;

import java.util.*;

public class QueueStack {

    Stack<Integer> ip;
    Stack<Integer> op;

    public QueueStack(){
        ip = new Stack<>();
        op = new Stack<>();
    }

    public void push(int data){
        ip.push(data);
    }
    
    public int pop(){
        peek();
        return op.pop();
    }
    public int peek(){
        if(op.empty()){
            while(!ip.empty()){
                op.push(ip.pop());
            }
        }
        return op.peek();
    }

    public boolean empty(){
        return ip.empty() && op.empty();
    }
    public static void main(String [] args){
            QueueStack qs = new QueueStack();
            qs.push(19);
            qs.push(20);
            qs.push(21);
            System.out.println(qs.pop());
            System.out.println(qs.pop());
            System.out.println(qs.peek());
            System.out.println(qs.pop());
            System.out.println(qs.empty());
    }
}
