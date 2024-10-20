package Problems;

import java.util.*;

public class paren{
    public static void main(String[] args) {
        String str = "(({}))";
        Stack<Character> st = new Stack<>();
        
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.isEmpty()) {
                    System.out.println("False");
                    return;
                }
                char top = st.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    System.out.println("False");
                    return;
                }
            }
        }
        System.out.println(st.isEmpty());
    }
}
