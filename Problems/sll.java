package Problems;

import java.util.Stack;

public class sll {
    Node head;
    Node tail;
    int size;
    private class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
        }
        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }
    }
    public sll(){
        size=0;
    }

    public void InsertF(int data){
        Node newnode = new Node(data);
        newnode.next=head;
        head=newnode;
        if(tail==null){
            tail=head;
        }
        size++;
    }

    public void InsertM(int data,int index){
        if(index==0){
            InsertF(data);
            return;
        }
        if(index==size){
            InsertL(data);
            return;
        }
        Node temp = head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        Node newnode = new Node(data,temp.next);
        temp.next=newnode;
        size++;
    }

    public void InsertL(int data){
        if(head==null){
            InsertF(data);
            return;
        }
        Node newnode = new Node(data);
        tail.next=newnode;
        tail=newnode;
        tail.next=null;
        size++;  
    }

    public int deleteF(){
        int val = head.data;
        head = head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return val;
    }

    public int deleteL(){
        if(size<=1){
            return deleteF();
        }
        Node sl = get(size-2);
        int val = tail.data;
        tail=sl;
        sl.next=null;
        size--;
        return val;
    }

    public Node get(int index){
        Node temp = head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ->");
            temp=temp.next;
        }
        System.out.print(" End");
        System.out.println();
    }

    public Node findMiddle(){
        if(head==null){
            return null;
        }
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null && slow!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public int findM(){
        Node findMid = findMiddle();
        if(findMiddle()!=null){
        return findMid.data;}
        else{
            throw new IllegalStateException("list is empty");
        }
    }

    public Node reverse(){
        Node temp  = head;
        Node prev = null;
        while(temp!=null){
            Node front = temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
     return prev;
    }

    public void reverseStack(){
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while(temp!=null){
            st.push(temp.data);
            temp=temp.next;
        }
        temp = head;
        while(temp!=null){
             temp.data=st.pop();
             temp=temp.next;
        }
    }

    public void display(Node node){
        Node temp = node;
        while(temp!=null){
            System.out.print(temp.data+" ->");
            temp=temp.next;
        }
        System.out.print(" End");
        System.out.println();
    }

        public void findLoop(){
            Node slow = head;
            Node fast = head;
            while(fast!=null && fast.next!=null && slow!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast){
                    System.out.println("Loop detected");
                    return;
                }
            }
            System.out.println("Loop not detected");
        }
}
