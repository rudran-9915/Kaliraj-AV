package DSA.MultiThreading;

public class MultiThreadThing implements Runnable{

    private int ThreadNumber;

    public MultiThreadThing(int ThreadNumber){
        this.ThreadNumber = ThreadNumber;
    }

   @Override
   public void run(){
        for(int i=1;i<=5;i++){
            System.out.println(i+" From the Thread"+ThreadNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

        }
   }
}
