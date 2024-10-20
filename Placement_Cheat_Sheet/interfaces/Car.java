package interfaces;

public class Car implements Brake,Car {

    public void brake(){
        System.out.println("break");
    }
    public void start(){
        System.out.println("Start the Car...");
    }
    public void stop(){
        System.out.println("Stop the Car...");
    }
    public void acc(){
        System.out.println("Accelerating the Car...");
    }
    
}
