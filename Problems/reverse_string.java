package Problems;
import java.util.*;
public class reverse_string {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to be reversed: ");   
        String str = sc.nextLine();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++){
            st.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            sb.append(st.pop());
        }
        sc.close();
        System.out.println(sb.toString());
     }
}
