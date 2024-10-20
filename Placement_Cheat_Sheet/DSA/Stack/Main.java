package DSA.Stack;

public class Main {
    public static void main(String[] args){
        stackll st = new stackll();
        st.push(10);
        st.push(15);
        st.push(20);
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        
    }
}
