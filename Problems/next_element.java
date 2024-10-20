package Problems;

import java.util.*;

public class next_element {
    public static void main(String[] args){
        int arr[] ={4,7,3,4,8,1};
        int res[] = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            if(!st.empty()){
                while(!st.empty() && st.peek()<=arr[i]){
                    st.pop();
                }
            }
            if(st.empty()){
                res[i]=-1;
            }else{
                res[i]=st.peek();
            }
            st.push(arr[i]);
        }
        System.out.println(Arrays.toString(res));
    }
}
