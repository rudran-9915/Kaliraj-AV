package Problems;

public class Main {
    public static void main(String[] args) {
        sll ll = new sll();
        ll.InsertF(1);
        ll.InsertF(2);
        ll.InsertF(3);
        ll.InsertL(4);
        ll.InsertM(5, 3);
        ll.InsertL(3);
        ll.InsertL(2);
        ll.InsertL(1);
        ll.InsertL(5);
        

        ll.display();
        System.out.println(ll.findM());
        ll.reverseStack();
        ll.display();
        ll.findLoop();
      
    }
}
