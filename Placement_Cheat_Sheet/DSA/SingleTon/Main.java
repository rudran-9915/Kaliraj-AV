package DSA.SingleTon;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi i am running...");
        // singleTon st = new singleTon();
        // singleTon st2 = new singleTon();

        singleTon st = singleTon.getInstance();
        singleTon st2 = singleTon.getInstance();

        System.out.println(st);
        System.out.println(st2);
    }
}
