package DSA.Stack;

import java.util.EmptyStackException;

public class stackll {
    Node top;
    int length;
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data; 
        }
    }

    public stackll(){
        top=null;
        length=0;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public int length(){
        return length;
    }

    public void push(int data){
        Node temp = new Node(data);
        temp.next=top;
        top=temp;
        length++;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int res = top.data;
        top=top.next;
        length--;
        return res;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }
}
