package DSA.MultiThreading;

public class MultiThread {
    public static void main(String[] args) {
    for(int i=0;i<=2;i++){
       MultiThreadThing mything = new MultiThreadThing(i);
       Thread myThread = new Thread(mything);
       myThread.start();
    }
    throw new RuntimeException();
    }
    
}
