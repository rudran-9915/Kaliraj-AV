package practices;

public class Main {
    public static void main(String[] args) {
        LL ll = new LL();
        ll.insertFirst(1);
        ll.insertFirst(2);
        ll.insertFirst(3);
        ll.insertLast(8);
        ll.insert(5,0);
        ll.insert(999,3);
        ll.display();
        System.out.println(ll.deleteFisrt());
        System.out.println(ll.deleteLast());
        ll.display();
        System.out.println(ll.delete(2));
        System.out.println(ll.find(999));
        ll.display();
    }
}
