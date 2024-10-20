package DSA.Stack;

public class StackArray {
    int size =10000;
    int arr[] = new int[size];
    int top=-1;

    public void push(int data){
        if(top==size-1){
            System.out.println("Overflow");
            return;
        }
        top++;
        arr[top]=data;
    }

    public int pop(){
        if(top==-1){
            System.out.println("Under flow");
            return 0;
        }
        int x = arr[top];
        top--;
        return x;
    }

    public int peek(){
        if(top==-1){
            System.out.println("Under flow");
            return 0;
        }
        return arr[top];
    }
    public int size(){
        return top+1;
    }
    public boolean isEmpty(){
        return top==-1;
    }

    public static void main(String[] args){
        StackArray sa = new StackArray();
        // sa.push(12);
        // sa.push(13);
        // sa.push(14);
        System.out.println(sa.pop());
        System.out.println(sa.peek());
        System.out.println(sa.size());
    }
}
