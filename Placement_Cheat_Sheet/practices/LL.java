package practices;

public class LL{
    private Node head;
    private Node tail;
    private int size;
    public LL(){
        this.size=0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size+=1;
    }

    public void insertLast(int val){
        if(head==null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next=node;
        tail=node;
        size++;
    }

    public void insert(int val,int index){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next=node;
        size++;
    }

    public int deleteFisrt(){
        int val = head.value;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        if(size<=1){
            return deleteFisrt();
        }
        int val = tail.value;
        Node secondLastNode = get(size-2);
        tail=secondLastNode;
        tail.next=null;
        return val;
    }

    public int delete(int index){
       if(index==0){
        return deleteFisrt();
       }
       if(index==size-1){
        return deleteLast();
       }
       Node prev = get(index-1);
       int value = prev.next.value;
       prev.next=prev.next.next;
       return value;

    }
    public Node get(int index){
        Node temp = head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }
    public boolean find(int element){
        Node temp=head;
        while(temp!=null){
            if(temp.value==element){
                return true;
            }
          temp=temp.next;
        }
        return false;
    }
     public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp=temp.next;
        }
        System.out.println("End");
     }

    private class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value=value;
        }
        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }
}