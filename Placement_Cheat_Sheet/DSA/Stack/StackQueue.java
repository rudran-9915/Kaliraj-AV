package DSA.Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class StackQueue {
     Queue<Integer> queue;
     public StackQueue(){
        queue=new LinkedList<>();
     }

     public void push(int data){
        queue.add(data);
        for(int i=1;i<queue.size();i++){
            queue.add(queue.remove());
        }
     }

     public int pop(){
        if(queue.isEmpty()){
           throw new EmptyStackException();
        }
            return queue.remove();
     }

     public int peek(){
        if(queue.isEmpty()){
            throw new EmptyStackException();
        }
        return queue.peek();
     }

     public boolean empty(){
        return queue.isEmpty();
     }


    public static void main(String[] args){
            StackQueue sq = new StackQueue();
            // sq.push(12);
            // sq.push(13);
            // sq.push(14);
            System.out.println(sq.pop());
            System.out.println(sq.peek());
            System.out.println(sq.pop());
            //System.out.println(sq.pop());
            System.out.println(sq.empty());
    }
}
