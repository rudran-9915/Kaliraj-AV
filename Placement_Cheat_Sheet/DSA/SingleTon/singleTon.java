package DSA.SingleTon;

public class singleTon {

    private static singleTon instance = new singleTon();

    private singleTon(){

    }
    public static singleTon getInstance(){
        return instance;
    }

}
