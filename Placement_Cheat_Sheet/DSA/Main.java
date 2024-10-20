package DSA;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(13);
        list.insertFirst(14);
        list.insertFirst(15);
        list.insertLast(12);
        list.insert(100, 2);
        list.display();
        System.out.println(list.deleteFirst());
        System.out.println(list.deleteLast());
        list.display();



    }
}
